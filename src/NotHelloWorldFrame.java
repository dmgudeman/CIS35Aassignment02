import javax.swing.*;

/**
 * Created by davidgudeman on 7/17/15.
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

class NotHelloWorldFrame extends JFrame
{
  //  private static final int DEFAULT_WIDTH = 800;
  //  private static final int DEFAULT_HEIGHT = 400;

    public NotHelloWorldFrame(ArrayList<Double[]> list)
    {
        add(new NotHelloWorldComponent(list));
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        pack();
    }
}

