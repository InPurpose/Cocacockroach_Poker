import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Update {
    public static void updateCardType(Grid grid,ArrayList<Players> players)
    {
        int counter = 0;
        for (Component c: grid.getContentPane().getComponents())
        {
            if(c instanceof Card)
            {
                Card temp = (Card) c;
                if(counter < 32)
                {
                    updateTable(temp,players,counter);
                }

                if(counter >=32 && counter < 40)
                {
                    updateHand(temp,players.get(0),counter%32);
                }

                counter++;

            }
        }

    }

    public static void updateSelection(Grid grid)
    {
        int counter1 = 0;
        int counter2 = 0;
        for (Component c: grid.getContentPane().getComponents())
        {
            if(c instanceof Card)
            {
                Card temp = (Card) c;

                if(counter1 == 48)
                {
//                    System.out.println(temp.getType());
                    temp.setVisible(true);
                    if(grid.getTell() != null)
                    {
                        temp.setType(grid.getTell());
                    }
                    else
                    {
                        System.out.println("Null");
                    }
                }
                counter1++;
            }
            if(c instanceof JButton)
            {
                if(counter2 > 50 && counter2 < 54)
                {
                    JButton temp = (JButton) c;
                    temp.setVisible(true);
                    grid.setVisible(true);
                }
                counter2++;
            }
        }
    }

    public static void updateHand(Card card,Players player1,int index)
    {

        int number = player1.getHand(CardType.IndexToType(index));

        card.setFront(true);
        if(number == 0)
            card.setFront(false);
        else
        {
            if(number > 1)
                card.setText(String.valueOf(number));
            else
                card.setText("");
        }
        card.setType(CardType.IndexToType(index));
    }

    public static void updateTable(Card card, ArrayList<Players> players, int counter)
    {
//        int number = players.get(counter /8 ).getHand(CardType.IndexToType(counter % 8));

        int number = players.get(counter /8 ).getCardOnTable(CardType.IndexToType(counter % 8));

//        System.out.print(number + " ");
        card.setFront(true);

        if(number == 0)
            card.setFront(false);
        else
        {
            if(number > 1)
                card.setText(String.valueOf(number));
        }
        card.setType(CardType.IndexToType(counter % 8));
    }


}
