import javax.swing.*;

/**
 * Created by davidgudeman on 7/17/15.
 */
import java.util.ArrayList;

class MapFrame extends JFrame
{
  //  private static final int DEFAULT_WIDTH = 800;
  //  private static final int DEFAULT_HEIGHT = 400;

    public MapFrame(ArrayList<Double[]> list)
    {
        add(new MapComponent(list));
        pack();
    }
}

