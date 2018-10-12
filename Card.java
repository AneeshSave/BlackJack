import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Objects;
import java.lang.Thread;


// Baba -
// spell check
// one class - one responsibility:
// Add more classes
// 

// Baba- No need to store CardValue for each card object. It should be derived from the CardName [2-9 = 2-9; JQK = 10; A=1/11]
public class Card {
  
  int cardsLeft =51;
  int cardValue;
  int insultsLeft;
  String cardFullName;
  String cardSuit;
  String cardName;  
  int insultDivider=1; // Baba - spkchk
  int whichInsult;
  ArrayList<Card> cardsInTheDeck = new ArrayList<Card>();
  ArrayList<String> cardPrintKeyTerms = new ArrayList<String>();
  ArrayList<String> cardPrintPhrases = new ArrayList<String>();
  ArrayList<String> listOfDealerInsults = new ArrayList<String>();
  
// Baba - no need for such trivial comment  
// Baba - for parameters, use 'p' instead of 'temp'
  
//Makes the object, with the three parameters for each card with its's value
  
  public Card(String tempCardName, String tempCardSuit, Integer value) {
    // Baba - make it clean - first assign all params and then go on with other logic.
    cardValue = value;
    cardName = tempCardName;
    cardFullName = cardName + " of " + tempCardSuit;
    cardSuit = tempCardSuit;
  }
  //public void howManyDecks(int numberOfDecks){
    //cardsLeft = (numberOfDecks*52)-1;
 // }  
  
  //returns the suit of the card
  public String getCardSuit(){
    return cardSuit;
  }
  
  //returns the value of the card
  public int getCardValue( ) {
    return cardValue;
  }
  
  //returns the 'first name' of the card
  public String getCardName(){
    return cardName;
  }
  
  //returns the full name of the card
  public String getCardFullName(){
    return cardFullName;
  }
  
  //stores the Deck array for itself
  public void cardArrayInitialize(ArrayList<Card> tempDeckOfCards){
    cardsInTheDeck=tempDeckOfCards;
  }
  
  public void keyTermsInitialize(ArrayList<String> tempCardPrintKeyTerms,ArrayList<String> tempCardPrintPhrases){
  cardPrintKeyTerms = tempCardPrintKeyTerms;
  cardPrintPhrases = tempCardPrintPhrases;
  }
  
  public void dealerInsultInitialize(ArrayList<String> tempdealerinsults){
  listOfDealerInsults = tempdealerinsults;
  insultsLeft = listOfDealerInsults.size();
  for(int i = 0;i<insultsLeft;i++){
    if(Objects.equals(listOfDealerInsults.get(i).charAt(0),'*')){
  insultDivider = i;
  }
    else{}
  }
  }

  public void dealerLoseDialog(ArrayList<Card> myHand){
    if(calculateHandTotal(myHand)< 21){
    int whichInsult = (0 + (int)(Math.random() * ((insultDivider-1) - 0) + 1));
    insultDivider--;
    insultsLeft--;
    }
else if(calculateHandTotal(myHand)>21){
    int whichInsult = ((insultDivider+1) + (int)(Math.random() * ((insultsLeft) - (insultDivider+1)) + 1));
    insultsLeft--;
    }
    System.out.println(listOfDealerInsults.get(whichInsult));
   listOfDealerInsults.remove(whichInsult);
  } 
  //Finds a random Card Class object from the deck, and removes it from the deck, and returns that card  
  
//Baba - call it drawCard() .. as it implies that you take the top card and remove it from Deck.
  public Card drawCard(){
    int cardOut = (0 + (int)(Math.random() * ((cardsLeft - 0) + 1)));
    
    // Baba - do you need a variable for cardsLeft? why not use .size()? .. a variable will always need to be in sync with actual data.
    cardsLeft--;
    // Baba - you are getting the Card from arrayList three times.. not efficient/cluttery.. get object out once and then use it.
   Card chosenCard = new Card(cardsInTheDeck.get(cardOut).getCardName(), cardsInTheDeck.get(cardOut).getCardSuit(), cardsInTheDeck.get(cardOut).getCardValue());
   // Baba - why do you even have to do a New() ? what happened to original card you took out from Deck? you are loosing objects
   cardsInTheDeck.remove(cardOut);
   return chosenCard;
  } 
  
  //returns the total sum of the cards in the players hand
  public static int calculateHandTotal(ArrayList<Card> handOfCards){
    int tempHandTotal = 0;
    int numberOfAces =0;
    // Baba - ask Dada for efficient way to iterate
    for(int i = 0; i < handOfCards.size(); i++){
      tempHandTotal += handOfCards.get(i).getCardValue();
      if(handOfCards.get(i).getCardValue()==11){
        numberOfAces++;
    }
    } 
    while(tempHandTotal>21 && numberOfAces>0){
      tempHandTotal = tempHandTotal - 10;
      numberOfAces--;
    }
    return tempHandTotal;
  }
  
  public int answer(ArrayList<Card> playerHand){
  Scanner scan = new Scanner(System.in);
  String answer = scan.nextLine().toLowerCase();
  int whichAns = 4;
  
  if(Objects.equals(playerHand.get(0).getCardValue(),playerHand.get(playerHand.size()-1).getCardValue()) && Objects.equals(answer, "split"));
       {
         whichAns = 3;
       }
       if(Objects.equals(answer,"hit") && calculateHandTotal(playerHand)<21){
       whichAns = 2;
       }
       if(Objects.equals(answer,"hold")){
         whichAns = 1;
       }
       return whichAns;
}

  //To be able to call Card Class with the instance without having parameters
  public Card(){}
  
  public Integer Player(ArrayList<ArrayList<Card>> players, Integer playerTotal){
    for(int i =0; i<players.size();i++){
    
    //return ;
  }
    return playerTotal;
  }
  
 // ArrayList<Player> listOfPlayers = new ArrayList<Player>();
  
  //Prints out each players hand
  public void printCards(ArrayList<Card> playersHand, String designation){
   for(int i = 0; i < cardPrintKeyTerms.size(); i++){
      if (Objects.equals(designation, cardPrintKeyTerms.get(i))){
        System.out.print((cardPrintPhrases.get(i)));
      }
    }
    int playersTotal = calculateHandTotal(playersHand);
    String printThisTotal;
    if(playersTotal==21){
      printThisTotal = "BlackJack!";
    }
    else if(playersTotal>21){
      printThisTotal=" Bust! ("+ playersTotal+")";
    }
    else{
      printThisTotal = ""+ playersTotal; 
    }
    int x;
    if(Objects.equals(designation, cardPrintKeyTerms.get(1))){
      x=1;
      printThisTotal=""+playersHand.get(1).getCardValue();
    }
    else{
      x=0;
    }
   try{ 
    for(int i=x;i<playersHand.size();i++){
   
              Thread.sleep(700);
      System.out.print("[" + playersHand.get(i).getCardFullName() + "]");
      
      }
    
    System.out.print("     (" + printThisTotal + ")");
    System.out.print("\n");
    Thread.sleep(1000);
        }catch(InterruptedException e) {}
    }
 
 
 public static void main(String []args) {
   int losingScore = 0;
   
   Scanner sc = new Scanner(System.in);
    //an instance that allows the use of the calculateTotalHand() method
    // Card a = new Card();
    
  //  System.out.println("How Many Decks are we playing with? (Casino's usually use 6)");
    //   int numberOfDecks=sc.nextInt();
   // a.howManyDecks(numberOfDecks);
    
    //All of the stuff the Dealer might say to you
    String[] tempDealerDialog = {"Ah, tough luck.", "Better luck next time pal.","Do you even know how to play? 21!"
      ,"Maybe bet less next time","Don't look at me like that, you lost","Maybe you should have stuck with the machines instead",
      "The losers corner is over there. Make a left, keep walking, and it'll be next to the bathrooms.","Ill take these chips off your hands if you dont mind",
      "Little short, just a little","Another hit wouldn't have hurt","You know what value you have to hit right?","*","Maybe you should change yourself to 'Buster'!","keep this up, and the House will love you forever.",
      "You should not have hit that time.","It seems as if you went a bit over the limit","BUST, HAHA!","I might of hit you TOO HARD that time!",
      "You'll win it back dude."};
    ArrayList<String> dealerDialog = new ArrayList<String>();
    Collections.addAll(dealerDialog,tempDealerDialog);
      
      
      //All of the key words that indicate who is playing, and what to print
      String[] keyTerms = {"dealer","?dealer","user","user2","person1","person2"};
    ArrayList<String> keyTermsList = new ArrayList<String>();
    Collections.addAll(keyTermsList,keyTerms);
    
    //All the names that will appear in front of the cards
    String[] printKeyPhrases = {"Dealer:  ","Dealer:  [???]","You:  ","       ","Player 1:   ","Player 2:   "};
    ArrayList<String> printKeyPhrasesList = new ArrayList<String>();
    Collections.addAll(printKeyPhrasesList,printKeyPhrases);
    
    //All of the card Names put into an Array, and then into an ArrayList
    String[] tempCardNameList = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    ArrayList<String> cardNameList =  new ArrayList<String>();
    Collections.addAll(cardNameList, tempCardNameList);    
    
    //Array of Card suits
    String[] tempCardSuitList = {"Hearts","Diamonds","Clubs","Spades"};
    ArrayList<String> cardSuitList = new ArrayList<String>();
    Collections.addAll(cardSuitList, tempCardSuitList);
    
    //Array of Card Values
    int[] tempCardValueList = {11,2,3,4,5,6,7,8,9,10,10,10,10};
    ArrayList<Integer> cardValueList = new ArrayList<Integer>();
    
    for(int ii = 0; ii < (tempCardValueList.length); ii++){
         cardValueList.add(tempCardValueList[ii]);
       }
       
       //An array that becomes the deck of cards with all card names and values
       ArrayList<Card> deckOfCards = new ArrayList<Card>();
       
       //Adds each object with parameters to the Card Class
    //  for (int iii = 0;iii<=numberOfDecks;iii++){
    for(int i = 0; i <= 12; i++){
      for(int ii = 0; ii <= 3; ii++){
        deckOfCards.add(new Card(cardNameList.get(i), cardSuitList.get(ii), cardValueList.get(i)));
      }
    }
    //  }
    
    
    Card a = new Card();
    //Initializes the array as the deck of cards (From which the method will randomly remove cards)
    a.cardArrayInitialize(deckOfCards);
    a.keyTermsInitialize(keyTermsList,printKeyPhrasesList);
    a.dealerInsultInitialize(dealerDialog);
    
    //Arrays to hold the values of the Dealer, the User, and each consecutive 'Fake' player
    
    while(losingScore>=0){
      ArrayList<Card> myHand = new ArrayList<Card>();
      ArrayList<Card> dealersHand = new ArrayList<Card>();
      ArrayList<Card> cPlayer1Hand = new ArrayList<Card>();
      ArrayList<Card> cPlayer2Hand = new ArrayList<Card>();    
      ArrayList<Card> myHand2 = new ArrayList<Card>();
      String[] tempCommandKeys = {"dealer","person1","person2","user"};
      ArrayList<String> commandKeys = new ArrayList<String>();
      Collections.addAll(commandKeys,tempCommandKeys);
      ArrayList<ArrayList<Card>> allPlayers = new ArrayList<ArrayList<Card>>();
      allPlayers.add(dealersHand);
      allPlayers.add(cPlayer1Hand);
      allPlayers.add(cPlayer2Hand);
      allPlayers.add(myHand);    
//    allPlayers.add(myHand2);
      //Adds two cards to each persons hand
      for(int i =0; i<allPlayers.size();i++){
        allPlayers.get(i).add(a.drawCard());
        allPlayers.get(i).add(a.drawCard());
      }
      
      int dealersTotal=0;
    int player1Total;
    //Prints out the dealers cards and users cards with method
    for(int i =0; i<allPlayers.size();i++){
      a.printCards(allPlayers.get(i),commandKeys.get(i));
            }
    System.out.println("");  
    
    player1Total=(calculateHandTotal(cPlayer1Hand));
     while(player1Total<16){
      cPlayer1Hand.add(a.drawCard());
      player1Total=(calculateHandTotal(cPlayer1Hand));
     }    a.printCards(cPlayer1Hand,"person1");
     
    
    int userInput = a.answer(myHand);
    
    //When the player says hit
    if(userInput==2){
    while(userInput==2){//(Objects.equals(userInput.toLowerCase(),"hit"))){
      myHand.add(a.drawCard()); 
     a.printCards(dealersHand,"?dealer");
    a.printCards(myHand,"user");
    userInput = a.answer(myHand);
    }
    }
    //else{
     //userInput=1;
     //a.dealerLoseDialog(myHand);
     //}
    
    
    int myTotal=0;
    
    //Split
    if(userInput==3){
    myHand2.add(myHand.get(1));
    myHand.remove(1);
   userInput = a.answer(myHand);
    //a.printCards(myHand2,"user2");
    //When the player says hit
    if(userInput==2){
    while(userInput==2){
      myHand.add(a.drawCard()); 
     a.printCards(dealersHand,"?dealer");
    a.printCards(myHand,"user");
    userInput = a.answer(myHand);
    }
    }
 //   else{
  //   userInput=1;
  //   }
    
    if(userInput==1){
      userInput = a.answer(myHand2);
      
      while(userInput==2){
      myHand2.add(a.drawCard()); 
     a.printCards(dealersHand,"?dealer");
    a.printCards(myHand,"user");
    a.printCards(myHand2,"user2");
    userInput = a.answer(myHand2);
    }
    
    
      
    }
    }
    
    //hold
    if(userInput==1){
      dealersTotal=(calculateHandTotal(dealersHand));
      myTotal=(calculateHandTotal(myHand));
    }
    
    //No answer 
    //  if(userInput ==4){}
    if(calculateHandTotal(myHand)>calculateHandTotal(myHand2) && calculateHandTotal(myHand)<=21){
      myTotal=calculateHandTotal(myHand);
    }
    else{
      myTotal=calculateHandTotal(myHand2);
    }
    
    //Dealers turn
    while(dealersTotal<16){
      dealersHand.add(a.drawCard());
      dealersTotal=0;
      dealersTotal=(calculateHandTotal(dealersHand));
    }
    a.printCards(dealersHand,"dealer");
    a.printCards(myHand,"user");
    a.printCards(myHand2,"user2");
    
    if(dealersTotal>21 && myTotal<=21 || dealersTotal<=21 && myTotal<=21 && myTotal>dealersTotal || dealersTotal<=21 && dealersTotal==myTotal){
      System.out.println("you won!");
    }
    else{
      System.out.println("You Lose :(");
      a.dealerLoseDialog(myHand);
      losingScore++;
    }
    System.out.println("Wanna give it another go?");
    userInput = sc.nextInt();
    /*if(Objects.equals(userInput.toLowerCase().charAt(0),'y')){
      System.out.println("Great!, lets go");
    }
    else{
         losingScore=-1;
         System.out.println("Aw, that Sucks, come again please!");
       }
 */
  }
}
}
