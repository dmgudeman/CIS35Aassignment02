import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * Created by davidgudeman on 7/17/15.
 */
public class MapComponent extends JComponent
{

    public static final int DEFAULT_WIDTH = 1800;
    public static final int DEFAULT_HEIGHT = 1200;
    public ArrayList<Double[]> list;
    Calculate calc = new Calculate();

    public MapComponent(ArrayList<Double[]> list)
    {
        this.list = list;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();

        int closestIndex = 0;
        int baseIndex = this.list.size()-1;
        list.get(0)[3] = 1.0;

        for (int j = this.list.size() - 1; j > 0; j--)
        {
            if (this.list.get(j)[3] == 0.0)
            {

                closestIndex = calc.getMinimumDistanceDouble(this.list, baseIndex);
                this.list.get(closestIndex)[3] = 1.0;
                int ix1 = (int) ((this.list.get(baseIndex)[0] - 34.5) * 300);
                int ix2 = (int) ((this.list.get(closestIndex)[0] - 34.5) * 300);
                int iy1 = (int) ((((this.list.get(baseIndex)[1])) + 107) * 400);
                int iy2 = (int) (((this.list.get(closestIndex)[1]) + 107) * 400);

             /*   int ix1 = (int) (this.list.get(baseIndex)[0]+0.0);
                int ix2 = (int) (this.list.get(closestIndex)[0] + 0.0);
                int iy1 = (int) (this.list.get(baseIndex)[1] + 0.0);
                int iy2 = (int) (this.list.get(closestIndex)[1] + 0.0);
                AffineTransform at = new AffineTransform();
                at.translate(-34.5, 107);
                at.scale(1.5,1.5);
*/
                g2d.drawLine(ix1, iy1, ix2, iy2);
                g2d.dispose();
            }
            baseIndex = closestIndex;
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}
