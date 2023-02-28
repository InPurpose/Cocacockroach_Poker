import javax.swing.*;
import java.awt.*;

public class UnshowComponents {

    public static void RemovePButtonSelection(Grid grid)
    {
        int counter = 0;
        for (Component c: grid.getContentPane().getComponents())
        {
            if(c instanceof JButton)
            {

                if(counter == 40 || counter == 41 || counter == 42)//12,17,18
                {
                    JButton temp = (JButton) c;
                    temp.setVisible(false);
                    grid.setVisible(true);
                }
                counter++;
            }
        }
    }

    public static void RemoveCardSelection(Grid grid)
    {
        int counter = 0;
        for (Component c: grid.getContentPane().getComponents())
        {
            if(c instanceof JButton)
            {
                counter++;
                if(counter > 43 && counter < 52)//12,17,18
                {
                    JButton temp = (JButton) c;
                    temp.setVisible(false);
                    grid.setVisible(true);
                }
            }
        }
    }

    public static void removeYNP(Grid grid)
    {
        int counter = 0;
        int counter2 = 0;
        for (Component c: grid.getContentPane().getComponents())
        {
            if(c instanceof JButton)
            {
                counter++;

                if(counter > 50 && counter < 55)//12,17,18
                {
                    JButton temp = (JButton) c;
                    temp.setVisible(false);
                    grid.setVisible(true);
                }

            }

            if(c instanceof Card)
            {
                counter2++;
                if(counter2 == 49)
                {
                    Card card = (Card)c;
                    if(grid.getReal() != null)
                        card.setType(grid.getReal());
                }
            }

        }
    }

}
