import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JFrame {

    public int loser;
    private CardType tell;
    private CardType real;
    private YNP ynp = null;
    private ArrayList<Integer> gone = new ArrayList<>();
    private int toComputer = -1;
    private int turn = 0;

    public void printGone()
    {
        System.out.println(gone);
    }

    public void reset()
    {
        setToComputer(-1);
        setYnp(null);
        setTell(null);
        setReal(null);
        clearGone();
    }

    public void AtoA(Grid grid, ArrayList<Players> players,int turn)
    {
        players.get(turn).myTurn(grid);
        players.get(turn).useCard(grid.getReal());

        boolean first = (grid.getReal() == grid.getTell()) && (players.get((turn+1)%4).myChoice());
        boolean second = (grid.getReal() != grid.getTell()) && !(players.get((turn+1)%4).myChoice());
        if(first || second)
        {
            players.get(turn).addTable(grid.getReal());
        }
        else
        {
            players.get((turn+1)%4).addTable(grid.getReal());
        }
    }

    public void PtoA(Grid grid, ArrayList<Players> players,int turn)
    {
        int temp = grid.getToComputer();

        boolean first = (grid.getReal() == grid.getTell()) && (players.get(getToComputer()).myChoice());
        boolean second = (grid.getReal() != grid.getTell()) && !(players.get(getToComputer()).myChoice());
        if(first || second)
        {
            players.get(0).addTable(grid.getReal());
        }
        else
        {
            players.get(grid.getToComputer()).addTable(grid.getReal());
        }
    }

    public void AtoP(Grid grid, ArrayList<Players> players,int turn)
    {
//        System.out.println("calling me");
        players.get(turn).myTurn(grid);
        players.get(turn).useCard(grid.getReal());
        grid.addGone(turn);
        Update.updateSelection(grid);
    }

    public void passTo(Grid grid, ArrayList<Players> players)
    {
        boolean first = (grid.getReal() == grid.getReal()) && (players.get(grid.getToComputer()).myChoice());
        boolean second = (grid.getReal() != grid.getReal()) && !(players.get(grid.getToComputer()).myChoice());
        if(first || second)
        {
            players.get(0).addTable(grid.getReal());
        }
        else
        {
            players.get(grid.getToComputer()).addTable(grid.getReal());
        }
    }



    public CardType getTell() {
        return tell;
    }

    public void setTell(CardType tell)
    {
        this.tell = tell;
    }

    public CardType getReal() {
        return real;
    }

    public void setReal(CardType real) {
        this.real = real;
    }

    public int getToComputer() {
        return toComputer;
    }

    public void setToComputer(int toComputer) {
        this.toComputer = toComputer;
    }

    public YNP getYnp() {
        return ynp;
    }

    public void setYnp(YNP ynp) {
        this.ynp = ynp;
    }



    public boolean endGame(ArrayList<Players> players)
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                if(players.get(i).getCardOnTable(CardType.IndexToType(j)) == 4)
                {
                    loser = i+1;
                    return true;
                }
            }

        }
        return false;
    }

    public void addGone(int number)
    {
        System.out.println(number);
        if(number >0)
        {
//            System.out.println("addGone() is called");
            gone.add(number);
        }
        if(number == 4)
        {
            gone.clear();
        }
    }

    public boolean search(int i) {
        return gone.contains(i);
    }

    public void clearGone()
    {
//        System.out.println("Clear is called");
        gone.clear();
    }

    public int getTurn() {
        return turn;
    }

    public void addTurn() {
        turn++;
        turn %=4;
    }
}
