import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Players {
    private Map<CardType, Integer> OnTable = new HashMap<>();;
    private Map<CardType, Integer> Hand = new HashMap<>();;//<key,value>
    private boolean AImode = true;

    public static void main(String[] args) {
        ArrayList<Players> players = new ArrayList<>();
        Deck deck = new Deck();
        for (int i = 0; i < 4; i++) {
            players.add(new Players());

        }

        players.get(0).addTable(CardType.TOAD);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 16; j++) {
                players.get(i).addHand(deck.getNextCard());

            }
            players.get(i).print();
        }

    }

    public void setAIMode(boolean AImode) {
        this.AImode = AImode;
    }

    public boolean isAImode() {
        return AImode;
    }

    public Players()
    {
        for (int i = 0; i < 8; i++)
        {
            OnTable.put(CardType.IndexToType(i),0);
            Hand.put(CardType.IndexToType(i),0);
        }
    }

    public void print()
    {
        for (int i = 0; i < 8; i++) {
            System.out.print(OnTable.get(CardType.IndexToType(i)) + " ");
            System.out.println(Hand.get(CardType.IndexToType(i)));
        }
        System.out.println("=======");
    }

    public void addHand(CardType cardType)
    {
        Hand.put(cardType,Hand.get(cardType) + 1 );
    }

    public void useCard(CardType cardType)
    {
        if(Hand.get(cardType) > 0)
            Hand.put(cardType,Hand.get(cardType) - 1 );
    }

    public int getHand(CardType cardType)
    {
        if(cardType == null)
            return -1;
        return Hand.get(cardType);
    }

    public int getCardOnTable(CardType cardType)
    {
        if(OnTable.get(cardType) == null)
            return -1;
        return OnTable.get(cardType);
    }

    public void addTable(CardType cardType)
    {
        OnTable.put(cardType,OnTable.get(cardType) + 1 );
    }


    public void myTurn(Grid grid)
    {
        if(AImode)
        {
            int temp = (int)((Math.random()) * 8);
            while(Hand.get(CardType.IndexToType(temp)) == 0)
            {
                temp = (int)((Math.random()) * 8);
            }

            if(Hand.get(CardType.IndexToType(temp)) > 0)
            {
                grid.setReal(CardType.IndexToType(temp));
                int Guess = (int)((Math.random()) * 8);
                grid.setTell(CardType.IndexToType(Guess));
//                System.out.println("Tell player " + CardType.IndexToType(temp));

                return;
            }



        }
    }
    public boolean myChoice()
    {
        if(AImode)
        {
            int temp = (int)((Math.random()) * 8);
            if(temp % 2 == 1)
                return true;
            else
                return false;
        }
        return false;
    }
}
