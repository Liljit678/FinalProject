import java.util.ArrayList;
public class Player {
    private String name;
    private ArrayList<Card> cards;
    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<Card>();
    }
    public void addCard(Card card){
        this.cards.add(card);
    }
    public String getName(){
        return name;
    }
    public ArrayList<Card> findCardsWithRank(int rank){
        ArrayList<Card> cardsWithRank = new ArrayList<Card>();
        ArrayList<Card> newCards = new ArrayList<Card>();
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getRank() == rank){
                cardsWithRank.add(cards.get(i));
            }else{
                newCards.add(cards.get(i));
            }
        }
        this.cards = newCards;
        return cardsWithRank;
    }
    public boolean hasAll4(int rank){
        int count = 0;
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getRank() == rank){
                count++;
            }
        }
        if(count == 4){
            return true;
        }else{
            return false;
        }
    }
    public boolean hasCardsLeft(){
        boolean cardsLeft = false;
        for(int i = 0; i < cards.size(); i++){
            if(!hasAll4(cards.get(i).getRank())){
                cardsLeft = true;
            }
        }
        return cardsLeft;
    }
    public int amountOfMatches(){
        int count = 0;
        for(int i = 2; i < 15; i++){
            if(hasAll4(i)){
                count++;
            }
        }
        return count;
    }
}
