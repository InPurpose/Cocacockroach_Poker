import java.util.ArrayList;

public class Deck {
    private ArrayList<CardType> DeckOfCards;
    private int size = 64;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.print();
    }

    public void print()
    {
        for (int i = 0; i < size; i++) {
            System.out.print(DeckOfCards.get(i) + " ");
            if((i+9) % 8 ==0)
                System.out.println();
        }
    }

    public Deck()
    {
        NewDeck();
        shuffle();
    }

    public void shuffle()
    {
        for (int i = 0; i < 100; i++) {
            int left = (int)((Math.random()) * 64);
            int right = (int)((Math.random()) * 64);

            CardType temp = DeckOfCards.get(left);
            DeckOfCards.set(left,DeckOfCards.get(right));
            DeckOfCards.set(right,temp);
        }
    }

    public void NewDeck()
    {
        System.out.println("A new deck is created");
        DeckOfCards = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                DeckOfCards.add(CardType.IndexToType(i));
            }
        }
    }

    public CardType getNextCard()
    {
        if(DeckOfCards.isEmpty()) {
            NewDeck();
        }

        CardType temp =  DeckOfCards.get(0);
        DeckOfCards.remove(0);
        return temp;


    }

    public static void PassOut(ArrayList<Players> players ,Deck deck)
    {

        for (int i = 0; i < 4; i++) {
            players.add(new Players());
        }
        players.get(0).setAIMode(false);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 16; j++) {
                players.get(i).addHand(deck.getNextCard());
            }
//            players.get(i).print();
        }
    }
}
