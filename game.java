/*
10-31-2019
CSCE 111
UIN : 828000939
Team members :    oualid zaari
                  Brad Delia
                  Nathan Robinson
                  Jiayang Zhao

ASSIGNEMENT : CARDS GAME PROJECT
*/

import java.util.ArrayList; // imports arraylist
import java.util.*; // imports scanner
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;

class game{ // creates a class
  public static int startGame(){ // start method
    int a = 1;

    System.out.println("");
    System.out.println("");
    System.out.println("Welcome to the Bachelor!!!!");
    System.out.println("Before our card game really gets going let's go over some rules!");
    System.out.println("=================================================================");
    System.out.println("First, the objective of this game is to play all of the cards in your hand");
    System.out.println("The player to empty their hand first will be declared the winner");
    System.out.println("");
    System.out.println("The game will begin with each of the four players being dealt 5 cards");
    System.out.println("Once that is done, the top card from the draw pile will be flipped over");
    System.out.println("");
    System.out.println("Player 1 will have to play a card that either matches that card's suit or rank");
    System.out.println("If player 1 does not have a card that matches either the suit or rank, then they will take one from the draw pile");
    System.out.println("Player 2 will go next, trying to do the same thing... followed by player 3 and then you!");
    System.out.println("");
    System.out.println("Now ");
    System.out.println("");
    System.out.println("There are a few more special rules you need to know: ");
    System.out.println("");
    System.out.println("The first rule is the Roses rule!");
    System.out.println("When a player plays a Ace or Queen, each player must play a card from the pile");
    System.out.println("The player with the lowest card loses and must draw an additional 2 cards!");
    System.out.println("");
    System.out.println("The second rule is the Love & Money rule!");
    System.out.println("In this game, the diamond suit and heart suit are one and the same and will be referred to as the red suite!");
    System.out.println("");
    System.out.println("The third rule is the Roses rule!");
    System.out.println("If a player plays a Jack or a King, every player must check their hand to make sure they have a card in the red");
    System.out.println("If they do not, they will have their turn skipped!");
    System.out.println("");
    System.out.println("The fourth rule is the Baggage rule!");
    System.out.println("For each game there will be a limit to the number of cards a player can have in their hand");
    System.out.println("The user player will be able to decide this limit at the start of the game");
    System.out.println("If a player ever exceeds the card limit with their hand, they may choose cards to discard until they reach the limit");
    System.out.println("");
    System.out.println("The last rule is that if a player is unable to play a matching card to the pile,");
    System.out.println("They must draw a card from the pile, and their turn will be skipped");
    System.out.println("");
    System.out.println("Now we can begin The Bachelor!!! ");

    return a;

  }//end method
  public static ArrayList<String> buildDeck(int s) { // method that builds deck of cards, calls int s -(52)
    ArrayList<String> d = new ArrayList<String>(); // new arraylist called d
      String[] suit = { "S", "C", "R" , "R" }; // an array containing each suit of card
      String[] number = { "A", "2", "3", "4", "5", "6", "7", "8", "9",
                        "T", "J", "Q", "K" }; // array containing each card number type
      for (int i = 0 ; i <number.length ; i++ ) { // goes through all numbers
        for (int j = 0 ; j < suit.length ; j++ ) { // goes through all the suits
          d.add(number[i] + suit[j]); // combines the suits and numbers to make 52 cards, adds it to the arrayList
        }// end for
      }//end for
    return d; // returns the array list d

  }//end build

  public static ArrayList<String> deal(ArrayList<String> p1, ArrayList<String> p2,
        ArrayList<String> p3, ArrayList<String> p4, ArrayList<String> d){ // method that deals a card from cardDeck to each player
        Collections.shuffle(d);// built in function that shuffles the deck
        int size = d.size(); // size int is the size of the card deck, so 52 rn
        for (int i = 0 ; i < 5 ;i++ ) {
          p1.add(d.get(0));// p1 gets 5 cards
          d.remove(0);//5 cards taken from the deck
          p2.add(d.get(0));//p2 gets 5 cards
          d.remove(0);//5 taken from the deck
          p3.add(d.get(0));//p3 gets 5 cards
          d.remove(0);//5 taken from the deck
          p4.add(d.get(0));//p4 gets 5 cards
          d.remove(0);//5 taken from the deck
      } // end for

      // System.out.println("Here are Player one's cards: ");
      // System.out.println(p1);
      // System.out.println("Here are Player two's cards: ");
      // System.out.println(p2);
      // System.out.println("Here are Player three's cards: ");
      // System.out.println(p3);
      System.out.println("Here are your cards: ");
      System.out.println(p4);

      return d;
  }// end deal

  public static String restCards(ArrayList<String> remCards){ // takes top card from CardDeck
    String add = remCards.get(0); //gets the top card from the return of deal method, which is cards not dealt to players
      remCards.remove(0); // removes that card from the deck

      return add; // returns that card as a single card
  }

  public static String computerTurn(ArrayList<String> cardDeck,ArrayList<String> computer, String tC){
    for (int i = 0; i < computer.size() ; i++ ) {
      String tempCard = computer.get(i); // tempCard gets a card
        if (tempCard.charAt(0) == tC.charAt(0)) { // checks if that cards number/rank is equal to that of the current card in play
            tC = computer.get(computer.indexOf(tempCard)); // if yes, then that card becomes the top card for the game
            computer.remove(computer.indexOf(tempCard));// and that card gets removed from the players hand
            return tC; // that new top card is returned to the main
          }// end if
        else if (tempCard.charAt(tempCard.length() - 1) == tC.charAt(tC.length() - 1)) {// checks if that cards suit matches that of the current card in play
            tC = computer.get(computer.indexOf(tempCard));// if yes, then that card becomes the top card for the game
            computer.remove(computer.indexOf(tempCard));// and that card gets removed from the players hand
            return tC;// and that card gets removed from the players hand
          }// End else If
    }// end for
    String addCard = restCards(cardDeck); // add card is the next card from those not dealt
    computer.add(addCard);// if player doent have a card that matches number or suit

    return tC;
  }

  public static String playerTurn(ArrayList<String> cardDeck,ArrayList<String> player1, String tC){
    Scanner input = new Scanner(System.in);

    System.out.println("Now it's your turn! Good luck!! ");
    System.out.println("Here is your hand: ");
    System.out.println(player1);//prints the users hand.. is playerYou in most other places throughout
    System.out.println("The top card right now is the " + tC);
    System.out.println("Please select a card to play. Or, type in \"add\" ");

    String userCard = input.nextLine(); //userCard is what the player types in
    String addCard = "";

    while (true){
      if (userCard.charAt(0) == tC.charAt(0)) {// checks if that cards number/rank is equal to that of the current card in play
          System.out.println(userCard); // prints out users card
          System.out.println(player1.indexOf(userCard));
          tC = player1.get(player1.indexOf(userCard));// if yes, then that card becomes the top card for the game
          player1.remove(player1.indexOf(userCard)); // that card is removed from the player's hand
          return tC; // returns that card to the main as topCard
        }// end if
      else if (userCard.charAt(userCard.length() - 1) == tC.charAt(tC.length() - 1)) {// checks if that cards suit matches that of the current card in play
          tC = player1.get(player1.indexOf(userCard));// if yes, then that card becomes the top card for the game
          player1.remove(player1.indexOf(userCard));// and that card gets removed from the players hand
          return tC;
        }// End else If
      else if (userCard.contains("ADD") || userCard.contains("add") || userCard.contains("add")) { // sees if user types in add
          addCard = restCards(cardDeck); // if player doesnt have a playable card they must enter add
          player1.add(addCard); // in which case the top card is added to their hand
          System.out.println("");
          System.out.println("Now your hand is: ");
          System.out.println(player1);
          return tC;// returns the topCard that was previously played, bc player couldnt play one
        } //End else If
      else {
          while(!(userCard.charAt(0) == (tC.charAt(0))) && !(userCard.charAt(userCard.length() - 1) == (tC.charAt(tC.length() - 1)))
          && !(userCard.contains("add")|| userCard.contains("add") || userCard.contains("add"))) { // checks if player inputs something wrong
            System.out.println("Error. Please input a playable card or type \"add\" "); // if they do then it says eror
            System.out.println("");
            userCard = input.nextLine();// has player input something else
          }//end while
        }//end else
    }//end while
  }//end method

  public static boolean p1RoseSkip(String topC, ArrayList<String> player1, boolean p1Rose){ // this method checks if P1's turn needs to be skipped
      boolean p1Skip = false; // makes the boolean false, implying, player  will skip turn
        for (int i = 0; i<player1.size() ; ++i) {
          if(player1.get(i).contains("R")){ //checks if any cards have an R in them
            p1Skip = true; // if it does then it will make pSkip equal to true which is returned
          }//end if
        }// end for
      if(p1Skip == true) {// if player has an R card then their turn is not skipped
        System.out.println("Player 1 has an R card");
        }
      else{// if no r card then False is returned
        System.out.println("Player 1 does not have an R card, their next turn is skipped");
        }
        return p1Skip;
      }// end method

  public static boolean p2RoseSkip(String topC, ArrayList<String> player2, boolean p2Rose){// this method checks if P2's turn needs to be skipped
    boolean p2Skip = false;// makes the boolean false, implying, player  will skip turn
      for (int i = 0; i<player2.size() ; ++i) {
        if(player2.get(i).contains("R")){//checks if any cards have an R in them
          p2Skip = true;// if it does then it will make pSkip equal to true which is returned
        }//end if
      }//end for
    if (p2Skip == true) {// if player has an R card then their turn is not skipped
      System.out.println("Player 2 has an R card");
    }
    else {// if no r card then False is returned
      System.out.println("Player 2 does not have an R card, their next turn is skipped");
    }
      return p2Skip;
    }// end method

  public static boolean p3RoseSkip(String topC, ArrayList<String> player3, boolean p3Rose){// this method checks if P3's turn needs to be skipped
    boolean p3Skip = false;// makes the boolean false, implying, player  will skip turn
      for (int i = 0; i < player3.size() ; ++i) {
        if(player3.get(i).contains("R")){//checks if any cards have an R in them
          p3Skip = true;// if it does then it will make pSkip equal to true which is returned
        }// end if
      }// end for
    if (p3Skip == true) {// if player has an R card then their turn is not skipped
      System.out.println("Player 3 has an R card");
     }
    else {// if no r card then False is returned
      System.out.println("Player 3 does not have an R card, their next turn is skipped");
     }
      return p3Skip;
     }// end method

  public static boolean pYRoseSkip(String topC, ArrayList<String> playerYou, boolean pYRose ){// this method checks if P4's turn needs to be skipped
    boolean pYSkip = false;// makes the boolean false, implying, player  will skip turn
      for (int i = 0; i < playerYou.size() ; ++i) {
        if(playerYou.get(i).contains("R")){//checks if any cards have an R in them
          pYSkip = true;// if it does then it will make pSkip equal to true which is returned
        }//end if
      }//end for
     if (pYSkip == true) {// if player has an R card then their turn is not skipped
      System.out.println("You do have an R card");
     }
     else {// if no r card then False is returned
        System.out.println("You dont have an R card, your next turn is skipped");
       }
    return pYSkip;
   }// end method

  public static int convert(String str1){ // EVELYN HELPED WITH THIS... used to convert the strings from fanSuite into workable ints
    try{
      char str = str1.charAt(0); // char str is first part of str1, in this case a card from fanSuite
    if(Character.isDigit(str)){ // if that card's first part is a digit
      return Character.getNumericValue(str);// then it returns it as it is
    }
    else {
      if(Character.compare(str,'K') == 0){return 13;} // if first part is a K(a king card), it returns it as a 13
        else if (Character.compare(str,'Q') == 0) {return 12;} // same for queen, but as 12
        else if (Character.compare(str,'J') == 0) {return 11;} // same for jack, but as 11
        else if(Character.compare(str,'A') == 0) {return 1;}// same for ace, but as 1
        else if (Character.compare(str,'T') == 0){return 10;}// same for 10 card but as 10... had problems bc would be worth 1, not 10, when comparing
      }
    }
    catch(Exception e){ // catch statement
      System.out.println("something went wrong");
      System.exit(1);
      }
      return -1;
    }// end of convert method

    public static String fanSuite(String topCa, ArrayList<String> player1, ArrayList<String> player2,
                                  ArrayList<String> player3, ArrayList<String> playerYou, ArrayList<String> cardDeck, ArrayList<String> reshuffleDeck){ // everyone draws a card, and lowest card has two cards added to their handd
      System.out.println("******A FANTASY SUITE CARD HAS BEEN PLAYED!!******");
      System.out.println("Each player will pick a card from the draw deck!");
      System.out.println("The player that draws the lowest card will have two cards added to their hand!");
      System.out.println("");

      String p1Num = restCards(cardDeck); // card is a new card from draw deck
      reshuffleDeck.add(p1Num);// that card is added to reshuffle deck
      String p2Num = restCards(cardDeck);// card is a new card from draw deck
      reshuffleDeck.add(p2Num);// that card is added to reshuffle deck
      String p3Num = restCards(cardDeck);// card is a new card from draw deck
      reshuffleDeck.add(p3Num);// that card is added to reshuffle deck
      String pYNum = restCards(cardDeck);// card is a new card from draw deck
      reshuffleDeck.add(pYNum);// that card is added to reshuffle deck

      int val1 = convert(p1Num); // converts the string into an int, so that they can be compared
      int val2 = convert(p2Num);// converts the string into an int, so that they can be compared
      int val3 = convert(p3Num);// converts the string into an int, so that they can be compared
      int val4 = convert(pYNum);// converts the string into an int, so that they can be compared

      System.out.println("Player 1 drew the: " + p1Num);// shows what card the player got
      System.out.println("Player 2 drew the: " + p2Num);// shows what card the player got
      System.out.println("Player 3 drew the: " + p3Num);// shows what card the player got
      System.out.println("You drew the: " + pYNum);// shows what card the player got
      System.out.println("");

      int [] cardStart = new int[4]; // int array for the cards in order they are pulled.. so p1,p2,...
      cardStart[0] = val1;//fills spot in array
      cardStart[1] = val2;//fills spot in array
      cardStart[2] = val3;//fills spot in array
      cardStart[3] = val4;//fills spot in array

      int[] cardSort = new int[4];//int array of the RANKED cards that each player had to draw, before sorted
      cardSort[0] = val1;//fills spot in array
      cardSort[1] = val2;//fills spot in array
      cardSort[2] = val3;//fills spot in array
      cardSort[3] = val4;//fills spot in array

      Arrays.sort(cardSort); // sorts cardSOrt from low to high based on int values and string->int conversions from convert method

      int lowCard = cardSort[0]; // lowest card is first card of the sorted deck
      int recIndex = 0;
            for (int i = 0 ; i < 4 ; i++ ) { // goes through each card
              if (cardStart[i] == lowCard) { // Assigns that sorted card with the player who pulled it
                recIndex = i;
                break;
              }
            }

        if (recIndex == 0) { // if the lowest card is player 1's
          System.out.println("player 1 has the low card!");
          player1.add(restCards(cardDeck));// adds a card from the draw pile to player's hand
          player1.add(restCards(cardDeck));// adds a card from the draw pile to player's hand
          System.out.println("two cards were added to their deck!");
          //System.out.println(player1);
        }
        else if (recIndex == 1) {// if the lowest card is player 2's
          System.out.println("player 2 has the low card! ");
          player2.add(restCards(cardDeck));// adds a card from the draw pile to player's hand
          player2.add(restCards(cardDeck));// adds a card from the draw pile to player's hand
          System.out.println("two cards were added to their deck!");
          //System.out.println(player2);
        }
        else if (recIndex == 2 ) {// if the lowest card is player 3's
          System.out.println("player 3 has the low card! ");
          player3.add(restCards(cardDeck));// adds a card from the draw pile to player's hand
          player3.add(restCards(cardDeck));// adds a card from the draw pile to player's hand
          System.out.println("two cards were added to their deck!");
          //System.out.println(player3);
        }
        else if (recIndex == 3) {// if the lowest card is player 4's
          System.out.println("You have the lower card!");
          playerYou.add(restCards(cardDeck));// adds a card from the draw pile to player's hand
          playerYou.add(restCards(cardDeck));// adds a card from the draw pile to player's hand
          System.out.println("two cards were added to your deck!");
          //System.out.println(playerYou);
        }
    return topCa; // returns the topCard

  }// End method

    public static void main(String[] args) { // main method
      Scanner input = new Scanner(System.in);// inserts a scanner

      startGame(); // calls startGame, which explains the rules

      int size = 52;// new int of size 52
      ArrayList<String> cardDeck = buildDeck(size); // calls on buildDeck(size), and runs what it says
      ArrayList<String> player1 = new ArrayList<String>();// empty array list for p1
      ArrayList<String> player2 = new ArrayList<String>();//empty array list for p2
      ArrayList<String> player3 = new ArrayList<String>();//empty array list for p3
      ArrayList<String> playerYou = new ArrayList<String>();//empty array list for user
      ArrayList<String> reshuffleDeck = new ArrayList<String>();//empty array list for cards that will be reshuffled

      Collections.shuffle(cardDeck);// shufles cardDeck
      System.out.println(); // prints a space

      cardDeck = deal(player1, player2, player3, playerYou, cardDeck); // deals cards to four players

      String topCard = restCards(cardDeck); // makes topcard the 0 part of Restcards

      int cardLimit ; // initalized cardLimit which will be used for baggage

      System.out.println("What number would you like to be the Baggage limit?"); // asks user
      cardLimit = input.nextInt();//number inputted is max card a user can have

      System.out.println("The first card is the " + topCard +  "\nPlayer 1, go!");//tells what the first card from the draw pile is that p1 has to match with
      System.out.println("");

      boolean p1Rose = false; // skipTurn boolean for player1
      boolean p2Rose = false; // skipTurn boolean for player2
      boolean p3Rose = false; // skipTurn boolean for player2
      boolean pYRose = false; // skipTurn boolean for player2

      while (playerYou.size() > 0 && player1.size() > 0 && player2.size() > 0 && player3.size() > 0 ) { //WHILE every player has at least one card
        if(cardDeck.size() < 6) { // if potentially not enough cards for a players turn, then used cards are reshuffleDeck
          cardDeck = reshuffleDeck;
         }//

        if(p1Rose == true){ // checks if player's turn has to be skipped, if it doesnt then it does this loop
          topCard = computerTurn(cardDeck, player1, topCard);// makes the topcard the topcard returned from computerTurn method
          reshuffleDeck.add(topCard);//adds that card  to the reshuffle pile
            if (topCard.contains("J") || topCard.contains("K")) { // checks if the card just played is a Jack or King. if yes then it calls the PRose methods
              System.out.println("******A ROSE CARD HAS BEEN PLAYED!!******");
              System.out.println("If your hand does not contain an R card,you will be skipped");
                  p2Rose = p2RoseSkip(topCard, player2, p2Rose);
                  p3Rose = p3RoseSkip(topCard, player3, p3Rose);
                  pYRose = pYRoseSkip(topCard, playerYou, pYRose);
                  }// end if

            if (topCard.contains("A") || topCard.contains("Q")) { //Checks if card played is an Ace or queen. If yes then it calls fanSuite method
                System.out.println("Player one played the " + topCard);
                  fanSuite(topCard, player1, player2, player3, playerYou,cardDeck,reshuffleDeck);
                }//end if

            System.out.println("After player 1's turn: ");
            System.out.println("The top card is the: " + topCard); // tells what card they played, or if they added one the card from previous player
              if (player1.size() > cardLimit) {// checks to see if players hand is within the bounds of user inputted baggage value
                while(player1.size() > cardLimit){// if it is greater than the baggage value, then cards are removed until it is within the bounds
                    player1.remove(0);
                  }//end while
              } //end if
            System.out.println("And player 1 has " + player1.size() + " cards in their hand" );
            System.out.println("*****************************");
            System.out.println("");

          }// end of player 1's turn

          p1Rose = true;// returns player's ability to play after their turn is skipped

          if(cardDeck.size() < 6) { // if potentially not enough cards for a players turn, then used cards are reshuffleDeck
            cardDeck = reshuffleDeck;
          }// end if

      if (p2Rose == true) {// checks if player's turn has to be skipped, if it doesnt then it does this loop
       topCard = computerTurn(cardDeck,player2,topCard); // makes the topcard the topcard returned from computerTurn method
       reshuffleDeck.add(topCard); //adds that card  to the reshuffle pile

        if (topCard.contains("J") || topCard.contains("K")) {// checks if the card just played is a Jack or King. if yes then it calls the PRose methods
         System.out.println("******A ROSE CARD HAS BEEN PLAYED!!******");
         System.out.println("If your hand does not contain an R card, you will be skipped");
         p3Rose = p3RoseSkip(topCard, player3, p3Rose);
         pYRose = pYRoseSkip(topCard, playerYou, pYRose);
         p1Rose = p1RoseSkip(topCard, player1, p1Rose);
         //p2Rose = p2RoseSkip(topCard, player2, p2Rose);
       }//end if

        if (topCard.contains("A") || topCard.contains("Q")) { //Checks if card played is an Ace or queen. If yes then it calls fanSuite method
          System.out.println("Player two played the " + topCard);// tells what card they played
            fanSuite(topCard, player1, player2, player3, playerYou,cardDeck,reshuffleDeck);
          }// end if

        System.out.println("After player 2's turn: ");
          if (player2.size() > cardLimit) {// checks to see if players hand is within the bounds of user inputted baggage value
            while(player2.size() > cardLimit){
              player2.remove(0);// if it is greater than the baggage value, then cards are removed until it is within the bounds
            }//end while
          }//end if
          System.out.println("The top card is the " + topCard);
          System.out.println("And player 2 has " + player2.size() + " cards in their hand" );
          System.out.println("*****************************");
          System.out.println("");
        }// end of player 2's turn

        p2Rose = true; // returns player's ability to play after their turn is skipped

        if(cardDeck.size() < 6) {// if potentially not enough cards for a players turn, then used cards are reshuffleDeck
          cardDeck = reshuffleDeck;
      }

      if (p3Rose == true) {// checks if player's turn has to be skipped, if it doesnt then it does this loop
       topCard = computerTurn(cardDeck, player3, topCard);// makes the topcard the topcard returned from computerTurn method
        reshuffleDeck.add(topCard);//adds that card  to the reshuffle pile

        if (topCard.contains("J") || topCard.contains("K")) {// checks if the card just played is a Jack or King. if yes then it calls the PRose methods
          //roses(topCard, player1, player2, player3, playerYou, cardDeck);
          System.out.println("******A ROSE CARD HAS BEEN PLAYED!!******");
          System.out.println("If your hand does not contain an R card, you will be skipped ");
            pYRose = pYRoseSkip(topCard, playerYou, pYRose);
            p1Rose = p1RoseSkip(topCard, player1, p1Rose);
            p2Rose = p2RoseSkip(topCard, player2, p2Rose);
            }// end if

          if (topCard.contains("A") || topCard.contains("Q")) { //Checks if card played is an Ace or queen. If yes then it calls fanSuite method
            System.out.println("Player three played the " + topCard);
              fanSuite(topCard, player1, player2, player3, playerYou, cardDeck,reshuffleDeck);
            }//end if
          System.out.println("After player 3's turn: ");
          System.out.println("The top card is the " + topCard);// tells what card they played
          if (player3.size() > cardLimit) { // checks to see if players hand is within the bounds of user inputted baggage value
            while(player3.size() > cardLimit){
              player3.remove(0); // if it is greater than the baggage value, then cards are removed until it is within the bounds
            }//end while
          }//end if
          System.out.println("And player 3 has " + player3.size() + " cards in their hand");
          System.out.println("*****************************");
          System.out.println(" ");
        }// end of player 3's turn

        p3Rose = true;// returns player's ability to play after their turn is skipped
        if(cardDeck.size() < 6) { // if potentially not enough cards for a players turn, then used cards are reshuffleDeck
          cardDeck = reshuffleDeck;
        }// end if

      if (pYRose == true) {// checks if player's turn has to be skipped, if it doesnt then it does this loop
       topCard = playerTurn(cardDeck, playerYou, topCard); // makes the topcard the topcard returned from playerTurn method
        reshuffleDeck.add(topCard);//adds that card  to the reshuffle pile

          if (topCard.contains("J") || topCard.contains("K")) {// checks if the card just played is a Jack or King. if yes then it calls the PRose methods
           System.out.println("******A ROSE CARD HAS BEEN PLAYED!!******");
           System.out.println("If your hand does not contain an R card, YOU WILL BE skipped");
            p1Rose = p1RoseSkip(topCard, player1, p1Rose);
            p2Rose = p2RoseSkip(topCard, player2, p2Rose);
            p3Rose = p3RoseSkip(topCard, player3, p3Rose);
            //pYRose = pYRoseSkip(topCard, playerYou, pYRose);
              }// end if

          if (topCard.contains("A") || topCard.contains("Q")) {//Checks if card played is an Ace or queen. If yes then it calls fanSuite method
            System.out.println("You played the " + topCard);
              fanSuite(topCard, player1, player2, player3, playerYou, cardDeck,reshuffleDeck);
              }//end if
          System.out.println("");
          if (playerYou.size() > cardLimit) { // // checks to see if players hand is within the bounds of user inputted baggage value
            while(playerYou.size() > cardLimit){
                  playerYou.remove(0); // if it is greater than the baggage value, then cards are removed until it is within the bounds
                  System.out.println("You've removed a card!");
            }
          }
          System.out.println("After your turn: ");
          System.out.println("The top card is the " + topCard);
          System.out.println("And you now have " + playerYou.size() + " cards in your hand. " );
          System.out.println("*****************************");
          System.out.println(" ");
        }
        pYRose = true;// returns player's ability to play after their turn is skipped

      }// ends while all have cards

      while(playerYou.size() == 0 || player1.size() == 0 || player2.size() == 0 || player3.size() == 0 ) { // when somebody plays all their cards it declares winner
       if(playerYou.size()==0){ // if user wins
         System.out.println("Congratulation! You Win!!!");
         break;
       }
       if(player1.size() == 0){ // if p1 wins
         System.out.println("Player1 Wins, Please try next time!");
         break;
       }
       if(player2.size() == 0){ // if p2 wins
         System.out.println("Player2 Wins, Please try next time!");
         break;
       }
       if(player3.size() == 0){ // if p3 wins
         System.out.println("Player3 Wins, Please try next time!");
         break;
       }
   }//end while someone has no cards aka Congratulations loop

  }// end main
}//end class
