import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by davidgudeman on 7/17/15.
 */
public class NotHelloWorldComponent extends JComponent
{
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    public static final int DEFAULT_WIDTH = 500;
    public static final int DEFAULT_HEIGHT = 500;
    ArrayList<Double[]> list;

    public NotHelloWorldComponent(ArrayList<Double[]> list)
    {
        this.list = list;
        System.out.println("deeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }

    public void paintComponent(Graphics g)
    {
        System.out.println("hoooooooooooooooooooooooooooooo");
        for (int i =0; i < list.size()-1; i++)
        {
            int x1 = (int)this.list.get(i)[0].doubleValue();
            int x2 = (int)this.list.get(i+1)[0].doubleValue();
            int y1 = (int)this.list.get(i)[1].doubleValue();
            int y2 = (int)this.list.get(i+1)[1].doubleValue();
            System.out.println("x1111111111111111111111111 " +(int)this.list.get(i)[0].doubleValue());


            g.drawLine(x1, x2, y1, y2);
        }

    }
    public Dimension getPreferredSize(){return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);}

}
