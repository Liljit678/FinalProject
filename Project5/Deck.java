import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Card> cards;
    private int currentCard;
    public Deck(){
        this.currentCard = -1;
        this.cards = new ArrayList<Card>();
        for(int i = 0; i < 4; i ++){
            String suit = "Diamonds";
            if(i == 1){
                suit = "Hearts";
            }else if(i == 2){
                suit = "Spades";
            }else if(i == 3){
                suit = "Clubs";
            }
            ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
            while(usedNumbers.size() < 13){
                boolean done = false;
                while(!done){
                    Random rand = new Random();
                    int r = rand.nextInt(13)+2;
                    if(!usedNumbers.contains(r)){
                        usedNumbers.add(r);
                        Card card = new Card(suit, r);
                        cards.add(card);
                        done = true;
                    }
                }
            }
//            for(int r = 2; r < 15; r++){
//                Card card = new Card(suit, r);
//                cards.add(card);
//            }
        }

    }
    public Card getCard(){
        currentCard = currentCard+1;
        return cards.get(currentCard);
    }
    public boolean isEmpty(){
        return currentCard == 51;
    }
}
