import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Discard {

    // not use
    private static int GetIndex(int i, int j)
    {
        if(i == 0)
            return 0;
        if(i == 9 || i == 10)
            return 2;
        if(j == 0)
            return 3;
        if(j == 9)
            return 1;
        return -1;
    }

    public static void addCard(int i, int j, GridBagConstraints gbc, Grid grid, ArrayList<Players> p)
    {
//        for (int i = 0; i < 11; i++) {
//            for (int j = 0; j < 10; j++) {
//                gbc.insets = new Insets(10,0,0,10); // top,left,bottom,right
//
//                if(i == 0 || i == 9 || i == 10)
//                    if(j != 0 && j != 9)
//                        Grid.addCard(i,j,gbc,grid,players);
//
//                if(j == 0 || j == 9)
//                    if(i != 0 && i != 9 && i != 10)
//                        Grid.addCard(i,j,gbc,grid,players);
//
//                gbc.gridx++;
//
//            }
//            gbc.gridy++;
//            gbc.gridx = 0;
//        }

        double rotate = 0;
        int index = GetIndex(i,j);

        if(j == 0)
            rotate = 90;

        if(j == 9)
            rotate = 270;

        Card card = new Card(CardType.BACK,rotate);

        if(j == 0 || j == 9)
        {
            if(p.get(index).getCardOnTable(CardType.IndexToType(i-1)) == 0)
                card.setFront(false);
            else
                card.setText(String.valueOf(p.get(index).getCardOnTable(CardType.IndexToType(i-1))));
            card.setType(CardType.IndexToType(i-1));
        }

        if(i == 0 || i == 9)
        {
            if(p.get(index).getCardOnTable(CardType.IndexToType(j-1)) == 0)
                card.setFront(false);
            else
                card.setText(String.valueOf(p.get(index).getCardOnTable(CardType.IndexToType(j-1))));

            card.setType(CardType.IndexToType(j-1));
        }

        if(i == 10)
        {
            if(p.get(index).getHand(CardType.IndexToType(j-1)) == 0)
                card.setFront(false);
            else
            {
                card.setText(String.valueOf(p.get(index).getHand(CardType.IndexToType(j-1))));


                card.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);

                        ((Card)e.getSource()).setHighlight(true);


                        ShowComponents.ShowPButtonSelection(grid);

                        grid.repaint();

                    }
                });
            }
            card.setType(CardType.IndexToType(j-1));

        }

        grid.add(card,gbc);
        grid.setVisible(true);
    }
}
