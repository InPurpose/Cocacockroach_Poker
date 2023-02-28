import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CockRoachPoker {
    public static void main(String[] args) {
        CockRoachPoker.run();
    }

    public static void run()
    {
        Grid grid = new Grid();//grid is a JFrame

        GridBagConstraints gbc = new GridBagConstraints();//gbc is grid template

        grid.setSize(1200,800);
        grid.setName("CockRoach Poker");
        grid.getContentPane().setLayout(new GridBagLayout());

        ArrayList<Players> players = new ArrayList<>();

        Deck deck = new Deck();

        Deck.PassOut(players ,deck);

        Card ToPlayer1 = new Card(CardType.BACK,0);

        AddComponents.addCardOnTable(grid,gbc);
        AddComponents.addThreeButton(gbc,grid,players);
        AddComponents.addCardSelection(gbc,grid);
        AddComponents.addYNP(grid,gbc);
        gbc.gridx = 4;
        gbc.gridy = 4;
        ToPlayer1.setVisible(false);
        grid.add(ToPlayer1,gbc);
        final boolean debug = false;
        if(debug)
        {
            System.out.println();
            for (int i = 0; i < 5; i++) {
                (players.get(0)).addTable(CardType.TOAD);
            }
        }

        grid.setTell(null);
        grid.setReal(null);

        JButton Announcer = new JButton();
        gbc.gridx = 0;
        gbc.gridy = 0;

        grid.add(Announcer,gbc);
        grid.setVisible(true);

        while(!grid.endGame(players))
        {
            Update.updateCardType(grid,players);
            if(grid.getTurn() == 0)
            {
                if(grid.getReal() != null && grid.getTell() != null)
                {
                    players.get(0).useCard(grid.getReal());
                    grid.PtoA(grid,players,grid.getTurn());
                    grid.addTurn();
                    grid.reset();
                }
            }

            if(grid.getTurn() == 1 || grid.getTurn() == 2)
            {
                grid.AtoA(grid,players,grid.getTurn());

                grid.addTurn();
                grid.reset();
            }

            if(grid.getTurn() == 3)
            {
                if(grid.getReal() == null)
                    grid.AtoP(grid,players,grid.getTurn());

                if(grid.getYnp() == YNP.PASS)
                {
                    ShowComponents.ShowPButtonSelection(grid);
                    if(grid.getTell() != null && grid.getToComputer() != -1)
                    {
                        System.out.println(grid.getTell());
                        grid.passTo(grid,players);
                        grid.addTurn();
                        grid.reset();
                        UnshowComponents.RemovePButtonSelection(grid);
                        ToPlayer1.setVisible(false);
                    }
                }
                if(grid.getYnp() == YNP.YES)
                {
                    if(grid.getReal() != grid.getTell())
                    {
                        players.get(0).addTable(grid.getReal());

                    }
                    else
                    {
                        players.get(3).addTable(grid.getReal());
                    }
                    grid.reset();
                    ToPlayer1.setVisible(false);
                    grid.addTurn();
                }

                if(grid.getYnp() == YNP.NO)
                {
                    if(grid.getReal() == grid.getTell())
                    {
                        players.get(0).addTable(grid.getReal());
                    }
                    else
                    {
                        players.get(3).addTable(grid.getReal());
                    }
                    grid.reset();
                    ToPlayer1.setVisible(false);
                    grid.addTurn();

                }
            }
            Announcer.setText("Player " + (grid.getTurn() + 1 ) + "'s turn" );
        }

        Announcer.setText("Loser is player " + grid.loser);
        Update.updateCardType(grid,players);
    }
}
