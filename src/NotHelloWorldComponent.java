import javax.swing.*;
import java.awt.*;

/**
 * Created by davidgudeman on 7/17/15.
 */
public class NotHelloWorldComponent extends JComponent
{
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;


    public void paintComponent(Graphics g)
    {
        int x1 = 10;
        int x2 = 10;
        int y1 = 45;
        int y2 = 45;
        for (int i = 0; i <5; i++)
        {

            g.drawLine(x1, x2, y1*20*i  +10, y2 *20*1 +10);
        }

    }
    public Dimension getPreferredSize(){return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);}

}
