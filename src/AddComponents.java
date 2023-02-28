import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

public class AddComponents {
    public static void addCardOnTable(Grid grid,GridBagConstraints gbc)
    {
        gbc.gridy = 9;
        for(gbc.gridx = 1; gbc.gridx < 9; gbc.gridx++)
        {
            Card card = new Card(CardType.IndexToType(gbc.gridx-1),0);
            card.setFront(false);
            card.setVisible(true);
            grid.add(card,gbc);
            grid.setVisible(true);
        }

        gbc.gridx = 9;
        for(gbc.gridy = 1; gbc.gridy < 9; gbc.gridy++)
        {
            Card card = new Card(CardType.IndexToType(gbc.gridy-1),270);
            card.setFront(false);
            card.setVisible(true);
            grid.add(card,gbc);
            grid.setVisible(true);
        }

        gbc.gridy = 0;
        for(gbc.gridx = 1; gbc.gridx < 9; gbc.gridx++)
        {
            Card card = new Card(CardType.IndexToType(gbc.gridx-1),0);
            card.setFront(false);
            card.setVisible(true);
            grid.add(card,gbc);
            grid.setVisible(true);
        }

        gbc.gridx = 0;
        for(gbc.gridy = 1; gbc.gridy < 9; gbc.gridy++)
        {
            Card card = new Card(CardType.IndexToType(gbc.gridy-1),90);
            card.setFront(false);
            card.setVisible(true);
            grid.add(card,gbc);
            grid.setVisible(true);
        }

        gbc.gridy = 10;
        for(gbc.gridx = 1; gbc.gridx < 9; gbc.gridx++)
        {
            Card card = new Card(CardType.IndexToType(gbc.gridx-1),0);
            card.setFront(false);
            card.setVisible(true);

            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    if(((Card)e.getSource()).isFront() && grid.getTurn() == 0)
                    {
                        grid.setReal(((Card)e.getSource()).getType());
                        ShowComponents.ShowPButtonSelection(grid);
                        UnshowComponents.RemoveCardSelection(grid);
                        grid.repaint();
                    }
                }
            });

            grid.add(card,gbc);
            grid.setVisible(true);
        }
    }

    public static void addCardSelection(GridBagConstraints gbc, Grid grid)
    {
        gbc.gridy = 6;
        for (int i = 1; i < 9; i++)
        {
            gbc.gridx = i;
            Card card = new Card(CardType.IndexToType(i-1),0);
            card.setVisible(false);
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    grid.setTell(((Card)e.getSource()).getType());
//                    grid.setShowPlayer1(null);
//                    System.out.println(((Card)e.getSource()).getType());
                    UnshowComponents.RemoveCardSelection(grid);
                }
            });

            grid.add(card,gbc);
            grid.setVisible(true);

        }
    }

    public static void addThreeButton(GridBagConstraints gbc, Grid grid, ArrayList<Players> players)
    {

        AddComponents.addPlayerButton(6,4,gbc,grid,"player 2",1);

        AddComponents.addPlayerButton(4,2,gbc,grid,"player 3",2);
        AddComponents.addPlayerButton(2,4,gbc,grid,"player 4",3);
    }

    public static void addPlayerButton(int x, int y, GridBagConstraints gbc, Grid grid, String t,int index)
    {
        gbc.gridx = x;
        gbc.gridy = y;
        JButton temp = new JButton(t);
        temp.setVisible(false);
        temp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                ShowComponents.ShowCardSelection(grid);
                grid.setToComputer(index);

                UnshowComponents.RemovePButtonSelection(grid);
                grid.repaint();
            }
        });
        grid.add(temp,gbc);
        grid.setVisible(true);
    }

    public static void addYNP(Grid grid,GridBagConstraints gbc)
    {
        gbc.gridy = 8;

        gbc.gridx = 2;
        addYNP(grid,gbc,"Yes");

        gbc.gridx = 4;
        addYNP(grid,gbc,"No");

        gbc.gridx = 6;
        addYNP(grid,gbc,"Pass");
    }

    private static void addYNP(Grid grid,GridBagConstraints gbc,String text)
    {
        JButton temp = new JButton(text);
        temp.setVisible(false);
        temp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                grid.setYnp(YNP.StringToYNP(text));
                UnshowComponents.RemoveCardSelection(grid);

                if(Objects.equals(text, "Pass"))
                {
                    grid.setTell(null);
//                    grid.addGone(1);
//                    grid.addGone(2);
                    grid.printGone();
                    UnshowComponents.RemovePButtonSelection(grid);
                }
                UnshowComponents.removeYNP(grid);
                grid.repaint();
            }
        });
        grid.add(temp,gbc);
        grid.setVisible(true);
    }

}
