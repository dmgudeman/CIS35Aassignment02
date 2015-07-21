import jdk.internal.org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by davidgudeman on 7/17/15.
 */
public class NotHelloWorldComponent extends JComponent
{
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    public static final int DEFAULT_WIDTH = 600;
    public static final int DEFAULT_HEIGHT = 600;
    public ArrayList<Double[]> list;
    Calculate calc = new Calculate();
    XMLReader xmlReader = new XMLReader();

    public NotHelloWorldComponent(ArrayList<Double[]> list)
    {
        this.list = list;
        System.out.println("deeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }

    public void paintComponent(Graphics g)
    {
        ArrayList<Double[]> pointsLeft = new ArrayList<>(this.list);
        Graphics2D g2d = (Graphics2D) g.create();
        System.out.println("hoooooooooooooooooooooooooooPoints Left         ooo" + list.size());
        //AffineTransform at = AffineTransform.getTranslateInstance(30, 50);
        ArrayList<Boolean> viableIndices = new ArrayList<>();


        double x1, x2, y1, y2;
        double distance = 0;
        double xBase, yBase, xIdent, yIdent;
        int closestIndex = 0;
        int baseIndex = 18;
        list.get(0)[3] = 1.0;


        for (int j = this.list.size() - 1; j > 0; j--)
        {
            if (this.list.get(j)[3] == 0.0)
            {

                closestIndex = calc.getMinimumDistanceDouble(this.list, baseIndex);
                System.out.println("CLosest INDEX   " + closestIndex);
                this.list.get(closestIndex)[3] = 1.0;

                int ix1 = ((int)((this.list.get(baseIndex)[0]-35)*100));
                System.out.println("this.list.get(baseIndex[0] = " + this.list.get(baseIndex)[0]);
                System.out.println("this.list.get(baseIndex[0]-35 = " + (this.list.get(baseIndex)[0]-35));
                System.out.println("(this.list.get(baseIndex[0]-35)*100) = " + ((this.list.get(baseIndex)[0]-35)*100));
                System.out.println("x1 (int) (this.list.get(baseIndex[0]-35)*100) = " + ((int)((this.list.get(baseIndex)[0]-35)*100)));

                System.out.println("x2 (int) (this.list.get(closestIndex[0]-35)*100) = " + ((int)((this.list.get(closestIndex)[0]-35)*100)));
                System.out.println("y1 (int) (this.list.get(baseIndex[1]-104)*100) = " + ((int)((-1*(this.list.get(baseIndex)[1])-104)*100)));
                System.out.println("y2 (int) (this.list.get(closestIndex[1]-104)*100) = " + ((int)((-1*(this.list.get(closestIndex)[1])-104)*100)));
                int ix2 = ((int)((this.list.get(closestIndex)[0]-35)*100));

                int  iy1 = (int) (((-1*(this.list.get(baseIndex)[1]))-104)*100);
                int iy2 = (int) ((-1*(this.list.get(closestIndex)[1])-104) *100);
           //     g2d.transform(at);
                System.out.println("Base Index = " + baseIndex + " ix1 = " + ix1 + " x2 = " + iy1);
                System.out.println("Closest Index = " + closestIndex + " ix2 = " + ix2 + " iy2 = " + iy2);
                System.out.println("____________________________________________");
                System.out.println("\n");
                g2d.drawLine(ix1, iy1, ix2, iy2);


            }
            baseIndex = closestIndex;
        }


    }


    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}
