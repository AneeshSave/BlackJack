import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
  
  int cardsleft=51;
  
  int cardVal;
  
  String cardFullName;
  
  String cardSuit2;
  String cardName2;
  
  //ArrayList<Deck> alreadyDrawnCards= new ArrayList<Deck>(); 
  
  ArrayList<Deck> cardsInTheDeck= new ArrayList<Deck>();
  
  public Deck(String cardName, String cardSuit, Integer value) {
    
    cardVal = value;
    cardName2=cardName;
    cardFullName=cardName+" of "+cardSuit;
    cardSuit2=cardSuit;
  }
  
  public String getCardSuit(){
    return cardSuit2;
  }
  
  public int getCardVal( ) {
    return cardVal;
  }
  
    public String getCardName(){
    return cardName2;
  }
    public String getCardFullName(){
      return cardFullName;
    }
  
    public void cardArrayInitialize(ArrayList<Deck> deckOfCards){
    cardsInTheDeck=deckOfCards;
  }
  
  public Deck randomCardRemove(){
   int cardOut= (0 + (int)(Math.random() * ((cardsleft - 0) + 1)));
   cardsleft--;
   Deck alreadychosen= new Deck(cardsInTheDeck.get(cardOut).getCardName(),cardsInTheDeck.get(cardOut).getCardSuit(),cardsInTheDeck.get(cardOut).getCardVal());
    cardsInTheDeck.remove(cardOut);
    return alreadychosen;
  }
  
  public static int calcTotal(ArrayList<Deck> cardlisttocalculate){
  int tempTotal=0;
      for(int i=0;i<cardlisttocalculate.size();i++){
 tempTotal+=cardlisttocalculate.get(i).getCardVal();
      }
  return tempTotal;
  }
  public Deck(){}
  
  public static void main(String []args) {
  Scanner sc = new Scanner(System.in);
    String[] tempCardNameList = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    ArrayList<String> cardNameList =  new ArrayList<String>();
    Collections.addAll(cardNameList,tempCardNameList);    
    
    String[] tempCardSuitList = {"Hearts","Diamonds","Clubs","Spades"};
    ArrayList<String> cardSuitList = new ArrayList<String>();
    Collections.addAll(cardSuitList,tempCardSuitList);
    
    int[] tempCardValueList = {1,2,3,4,5,6,7,8,9,10,10,10,10};
    ArrayList<Integer> cardValueList = new ArrayList<Integer>();
    for(int i=0;i<(tempCardValueList.length);i++){
    cardValueList.add(tempCardValueList[i]);
    }
    
    
    ArrayList<Deck> deckOfCards =new ArrayList<Deck>();
    
    for(int ii=0;ii<=12;ii++){
      for(int iii=0;iii<=3;iii++){
        deckOfCards.add(new Deck(cardNameList.get(ii),cardSuitList.get(iii),cardValueList.get(ii)));
      }
    }
    Deck alreadychosenhere= new Deck();
    
    alreadychosenhere.cardArrayInitialize(deckOfCards);
    ArrayList<Deck> listofchosen = new ArrayList<Deck>();
    
    //for(int iiii=0;iiii<50;iiii++){
    //Deck hellothere=(alreadychosenhere.randomCardRemove());
    //listofchosen.add(hellothere);
    //}
    
    //for(int iiii=0;iiii<50;iiii++){
     // System.out.println(listofchosen.get(iiii).getCardFullName());
   // }
    
    ArrayList<Deck> myCards = new ArrayList<Deck>();
    ArrayList<Deck> dealerCards = new ArrayList<Deck>();
    
   // Deck cardChosen;// = alreadychosenhere.randomCardRemove();
    //dealerCards.add(cardChosen);
    dealerCards.add(alreadychosenhere.randomCardRemove());
    
    /*
     dealercards.addrandomToarray();
     
    dealerCards.add(alreadychosenhere.randomCardRemove();
         
     
     */
    
    
   // cardChosen = 
    myCards.add(alreadychosenhere.randomCardRemove());
   // cardChosen = alreadychosenhere.randomCardRemove();
    dealerCards.add(alreadychosenhere.randomCardRemove());
   // cardChosen = alreadychosenhere.randomCardRemove();
    myCards.add(alreadychosenhere.randomCardRemove());
    System.out.println("[???] ["+ dealerCards.get(1).getCardFullName()+"]");
    for(int i=0;i<myCards.size();i++){
    System.out.print("["+myCards.get(i).getCardFullName()+"]");
    }
    System.out.print("\n");
    int whattodo = sc.nextInt();
    
    while(whattodo==4){
    //cardChosen = alreadychosenhere.randomCardRemove();
    myCards.add(alreadychosenhere.randomCardRemove());
    System.out.println("[???] ["+ dealerCards.get(1).getCardFullName()+"]");
    for(int i=0;i<myCards.size();i++){
    System.out.print("["+myCards.get(i).getCardFullName()+"]");
    
    }
    System.out.print("\n");
    whattodo = sc.nextInt();
    }
    int mytotal=0;
    int dealtotal=0;
    if(whattodo==5){
      dealtotal=(calcTotal(dealerCards));
      mytotal=(calcTotal(myCards));
    }
    while(dealtotal<16){
  //    cardChosen = alreadychosenhere.randomCardRemove();
    dealerCards.add(alreadychosenhere.randomCardRemove());
    dealtotal=0;
    for(int i=0;i<dealerCards.size();i++){
        dealtotal+=dealerCards.get(i).getCardVal();
    }
    }
    for(int i=0;i<dealerCards.size();i++){
    System.out.print("["+dealerCards.get(i).getCardFullName()+"]");
    }
    System.out.println("   --> "+dealtotal);
    
    for(int i=0;i<myCards.size();i++){
    System.out.print("["+myCards.get(i).getCardFullName()+"]");
    }
    System.out.println("   --> "+mytotal);
      
      if(dealtotal>21 && mytotal<=21 || dealtotal<=21 && mytotal<=21 && mytotal>dealtotal || dealtotal<=21 && dealtotal==mytotal){
        System.out.println("you won");
      }
      else{
        System.out.println("You Lost");
      }

  }
  }


/*
 * 
    int cardsleft=51;4
    



/*import java.util.ArrayList;
public class Deck {
   int cardVal;
   String cardFullName;
      public Deck(String cardName, String cardSuit, Integer value) {
      // This constructor has one parameter, name.
        cardVal = value;
        cardFullName=cardName+" of "+cardSuit;
      
   }

   public int getCardVal( ) {
      return cardVal;
   }
   
   public String getCardName(){
     return cardFullName;
   }
   
   
   
   public static void main(String []args) {
      /* Object creation */
  /*   //String[] temporaryCardNameList={"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
     ArrayList<String> cardNameList =  new ArrayList<String>();
    // cardNameList.addAll(temporaryCardNameList);
     
     cardNameList.add("Ace");
     cardNameList.add("2");
     cardNameList.add("3");
     cardNameList.add("4");
     cardNameList.add("5");
     cardNameList.add("6");
     cardNameList.add("7");
     cardNameList.add("8");
     cardNameList.add("9");
     cardNameList.add("10");
     cardNameList.add("Jack");
     cardNameList.add("Queen");
     cardNameList.add("King");
     //*/
     
    // {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    
    /* ArrayList<String> cardSuitList = new ArrayList<String>();
     cardSuitList.add("Hearts");
     cardSuitList.add("Diamonds");
     cardSuitList.add("Clubs");
     cardSuitList.add("Spades");
     
     ArrayList<Integer> cardValueList = new ArrayList<Integer>();
     cardValueList.add(1);
     cardValueList.add(2);
     cardValueList.add(3);
     cardValueList.add(4);
     cardValueList.add(5);
     cardValueList.add(6);
     cardValueList.add(7);
     cardValueList.add(8);
     cardValueList.add(9);
     cardValueList.add(10);
     cardValueList.add(10);
     cardValueList.add(10);
     cardValueList.add(10);
     
      
  
     ArrayList<Deck> deckOfCards =new ArrayList<Deck>();
     for(int ii=0;ii<13;ii++){
       for(int iii=0;iii<4;iii++){
      deckOfCards.add(new Deck(cardNameList.get(ii),cardSuitList.get(iii),cardValueList.get(ii)));
        }
     }
     int cardOut= (0 + (int)(Math.random() * ((51 - 0) + 1)));
     System.out.println(deckOfCards.get(cardOut).getCardName());
     
     System.out.print(deckOfCards.get(cardOut).getCardVal());
      //Deck sevenofhearts = new Deck("Seven","Hearts",7);
     
// Deck jackofclubs = new Deck("Jack","Clubs",11);
//Deck sevenofhearts = new Deck("Seven","Hearts",7);
      /* Call class method to set the cards value */
      /* Call another class method to get the card's value */
      /*jackofclubs.getVal( );
      sevenofhearts.getVal();
      System.out.println("Card Value :" + jackofclubs.cardVal);
      System.out.println("Card Value :" + sevenofhearts.cardVal);


   }
}
*/