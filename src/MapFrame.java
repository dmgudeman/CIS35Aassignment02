import javax.swing.*;

/**
 * Created by davidgudeman on 7/17/15.
 */
import java.util.ArrayList;

class MapFrame extends JFrame
{

    public MapFrame(ArrayList<Double[]> list)
    {
        add(new MapComponent(list));
        pack();
    }
}

