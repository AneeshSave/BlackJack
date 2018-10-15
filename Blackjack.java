import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;
import java.util.Objects;
import java.lang.Thread;

public class Blackjack{
  
  private final String name;
  private final int value;
  private final String pName;
  private final ArrayList<Card> cards;
  
  public static class Card{
    
    private final String name;
    private final int value;
    
    public Card(String name, Integer value){
      this.name = name;
      this.value = value;
    }    
  }
  
  public static Card draw(ArrayList<Blackjack.Card> deck){
    Random rand = new Random();
    int pickACard =rand.nextInt(deck.size());
    Blackjack.Card randomCard = deck.get(pickACard);
    deck.remove(pickACard);
    return randomCard;
  }
  
  public static class Player{
    
    private final String pName;
    private final ArrayList<Card> cards;
    private int playerTotal = 0;
    
    public Player(String pName, ArrayList<Blackjack.Card> cards){
      this.pName = pName;
      this.cards = cards;
      
    }
    
    public int getTotal(){
      for(int numOfCards = 0; numOfCards <= cards.size() - 1; numOfCards++){
        playerTotal+=cards.get(numOfCards).value;
      }
      
      return playerTotal;
      
    }
    
  }
  public static void printCards(Player player){
    try{
      Thread.sleep(5);
      
    }catch(InterruptedException e) {}
  }

  
  
  private Blackjack(Card card, Player player){
    name = card.name;
    value = card.value;
    pName = player.pName;
    cards = player.cards;
    
    
  }
  
  public static void main (String [] args){
    
    //Making a Card of 52 regular Cards
    Scanner sc = new Scanner(System.in);
    String[] tempCardNameList = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    ArrayList<String> cardNameList =  new ArrayList<String>();
    Collections.addAll(cardNameList,tempCardNameList);    
    
    String[] tempCardSuitList = {"Hearts","Diamonds","Clubs","Spades"};
    ArrayList<String> cardSuitList = new ArrayList<String>();
    Collections.addAll(cardSuitList,tempCardSuitList);
    
    int[] tempCardValueList = {11,2,3,4,5,6,7,8,9,10,10,10,10};
    ArrayList<Integer> cardValueList = new ArrayList<Integer>();
    for(int i=0;i<(tempCardValueList.length);i++){
      cardValueList.add(tempCardValueList[i]);
    }
    
    ArrayList<Blackjack.Card> deck =new ArrayList<Blackjack.Card>();
    
    for(int ii=0;ii<=12;ii++){
      for(int iii=0;iii<=3;iii++){
        deck.add(new Blackjack.Card(cardNameList.get(ii) + " of " + cardSuitList.get(iii),cardValueList.get(ii)));
      }
    }
    
    
    //String[] tempPlayerNames = {"Dealer","You", "Com 1", "Com 2", "Com 3"};
    //ArrayList<String> playerNames =  new ArrayList<String>();
    //Collections.addAll(playerNames, tempPlayerNames);    
    
    
    //REPLACE ALL THIS WITH SOMETHING NOT DUMB
    ArrayList<ArrayList<Blackjack.Card>> tempPlayerCards = new ArrayList<ArrayList<Blackjack.Card>>();
    ArrayList<Blackjack.Card> dealerHand = new ArrayList<Blackjack.Card>();
    ArrayList<Blackjack.Card> youHand = new ArrayList<Blackjack.Card>();
    ArrayList<Blackjack.Card> com1Hand = new ArrayList<Blackjack.Card>();
    ArrayList<Blackjack.Card> com2Hand = new ArrayList<Blackjack.Card>();
    ArrayList<Blackjack.Card> com3Hand = new ArrayList<Blackjack.Card>();
    
    Blackjack.Player dealer = new Blackjack.Player("Dealer", dealerHand);
    Blackjack.Player you = new Blackjack.Player("You", youHand);
    Blackjack.Player com1 = new Blackjack.Player("Com 1", com1Hand);    
    Blackjack.Player com2 = new Blackjack.Player("Com 2", com2Hand);    
    Blackjack.Player com3 = new Blackjack.Player("Com 3", com3Hand);
    
    ArrayList<Blackjack.Player> players = new ArrayList<Blackjack.Player>();
    
    players.add(dealer);
    players.add(you);
    players.add(com1);
    players.add(com2);
    players.add(com3);
    
    
    //The Visible Gameplay:
    
    
  }
}


