import javax.swing.*;
import java.awt.*;

public class ShowComponents {


    public static void ShowPButtonSelection(Grid grid)
    {
        int counter = 0;
        for (Component c: grid.getContentPane().getComponents())
        {

            if(c instanceof JButton)
            {
                counter++;
                if(counter == 41 && !grid.search(1))//41,42,43
                {
                    JButton temp = (JButton) c;
                    temp.setVisible(true);
                    grid.setVisible(true);
                }

                if(counter == 42 && !grid.search(2))//41,42,43
                {
                    JButton temp = (JButton) c;
                    temp.setVisible(true);
                    grid.setVisible(true);
                }

                if(counter == 43 && !grid.search(3))//41,42,43
                {
                    JButton temp = (JButton) c;
                    temp.setVisible(true);
                    grid.setVisible(true);
                }
            }
        }
    }

    public static void ShowCardSelection(Grid grid)
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
                    temp.setVisible(true);
                    grid.setVisible(true);
                }
            }
        }
    }


}
