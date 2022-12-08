import java.util.Scanner;
import java.util.ArrayList;

public class GoFish {
    public static void main(String[] args){
        System.out.println("Welcome to Go Fish");
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter the number of players");
        int numPlayers = scnr.nextInt();
        scnr.nextLine();
        int numCards = 7;
        if(numPlayers > 3){
            numCards = 5;
        }
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 1; i <= numPlayers; i++){
            System.out.println("Enter the name for Player "+i);
            String name = scnr.nextLine();
            Player player = new Player(name);
            System.out.print("You have the following cards: ");
            for(int z = 0; z < numCards; z++){
                Card card = deck.getCard();
                player.addCard(card);
                card.print();
                System.out.print(", ");
            }
            players.add(player);
            System.out.println();
            System.out.println("Press enter to confirm");
            scnr.nextLine();
            for(int x = 0; x < 100; x++){
                System.out.println();
            }
        }
        // turn
        ArrayList<String> matches = new ArrayList<>();
        while(!gameOver(deck, players)) {
            for (int i = 0; i < numPlayers; i++) {
                Player player = players.get(i);
                boolean done = false;
                while (!done) {
                    System.out.println("----------------------");
                    System.out.println("Current cards on table:");
                    if(matches.size() == 0){
                        System.out.println("None");
                    }else{
                        for(int m = 0; m < matches.size(); m++){
                            System.out.println(matches.get(m));
                        }
                    }
                    System.out.println("It is " + player.getName() + "'s turn");
                    System.out.println("Enter the number of the player do you want to ask?");
                    for (int z = 0; z < numPlayers; z++) {
                        if (z != i) {
                            System.out.println(z + 1 + ". " + players.get(z).getName());
                        }
                    }
                    Player playerToAsk = players.get(scnr.nextInt()-1);
                    System.out.println("What rank do you want to see if they have?");
                    System.out.println("(Enter 11 for jack, 12 for queen, 13 for king, 14 for ace)");
                    int rank = scnr.nextInt();
                    scnr.nextLine();
                    ArrayList<Card> cardsWithRank = playerToAsk.findCardsWithRank(rank);
                    if (cardsWithRank.size() > 0) {
                        System.out.print("You got the following cards: ");
                        for (int x = 0; x < cardsWithRank.size(); x++) {
                            player.addCard(cardsWithRank.get(x));
                            cardsWithRank.get(x).print();
                            System.out.print(", ");
                        }
                        System.out.println();
                        if (player.hasAll4(rank)) {
                            System.out.println(player.getName()+" has all 4!");
                            String r = ""+rank;
                            if(rank == 1){
                                r = "Hearts";
                            }else if(rank == 2){
                                r = "Spades";
                            }else if(rank == 3){
                                r = "Clubs";
                            }
                            matches.add(player.getName()+" has 4 of "+r);
                        }
                    } else {
                        System.out.println("Go fish! A card is being drawn");
                        Card newCard = deck.getCard();
                        player.addCard(newCard);
                        System.out.println("Press enter to see what card you got");
                        scnr.nextLine();
                        System.out.print("You got a ");
                        newCard.print();
                        System.out.println();
                        if (newCard.getRank() == rank) {
                            System.out.println("You get another turn!");
                        } else {
                            System.out.println("Press enter to continue");
                            scnr.nextLine();
                            for (int x = 0; x < 100; x++) {
                                System.out.println();
                            }
                            done = true;
                        }
                    }
                }
            }
        }
        int mostMatches = 0;
        Player highestPlayer = null;
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).amountOfMatches() > mostMatches){
                highestPlayer = players.get(i);
                mostMatches = players.get(i).amountOfMatches();
            }
        }
        System.out.println(highestPlayer.getName()+" is the winner!");
    }
    public static boolean gameOver(Deck deck, ArrayList<Player> players){
        if(deck.isEmpty()){
            return true;
        }
        for(int i = 0; i < players.size(); i++){
            if(!players.get(i).hasCardsLeft()){
                return true;
            }
        }
        return false;
    }
}
