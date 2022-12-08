public class Card {
    private String suit;
    private int rank;
    public Card(String suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }
    public int getRank(){
        return rank;
    }
    public void print(){
        String val = ""+rank;
        if(rank == 11){
            val = "Jack";
        }else if(rank == 12){
            val = "Queen";
        }else if(rank == 13){
            val = "King";
        }else if(rank == 14){
            val = "Ace";
        }
        System.out.print(val+" of "+suit);
    }
}
