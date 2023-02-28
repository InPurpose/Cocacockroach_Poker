import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

public class Card extends JButton {
    private CardType type;
    private final double rotate;
    private boolean front = true;
    private boolean highlight = false;

    public Card(CardType type,double rotate)
    {
        this.type = type;
        this.rotate = rotate;

        addImage();

//        AddMouseClickListener();
    }

    public CardType getType() {
        return type;
    }

    public boolean isFront() {
        return front;
    }

    public void setType(CardType type) {
        this.type = type;
        addImage();
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public void setFront(boolean front)
    {
        this.front = front;
    }


    public void AddMouseClickListener()
    {
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e)
            {
                super.mousePressed(e);

//                ((Card) e.getSource()).setType(CardType.getRandomCardType());
                ((Card)e.getSource()).setHighlight(false);

                repaint();
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                ((Card) e.getSource()).setLocation(e.getLocationOnScreen());
                repaint();
            }
        });

    }

    public void addImage()
    {
        Image img;

        try {
            if(front)
                img = ImageIO.read(Objects.requireNonNull(getClass().getResource(CardType.getColorFilePath(type))));
            else
            img = ImageIO.read(getClass().getResource(CardType.getGrayFilePath(type)));

//            ImageIcon imageIcon = new ImageIcon(img);

            Image newImg = img.getScaledInstance(43,66, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(newImg);


            RotatedIcon rotatedIcon = new RotatedIcon(imageIcon,rotate);
            setIcon(rotatedIcon);


            this.setBorderPainted(false);
            this.setOpaque(false);
            this.setContentAreaFilled(false);
            setVisible(true);

        }
        catch (IOException e)
        {

        }

    }
}
