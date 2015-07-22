import javax.swing.*;
import java.awt.*;
import java.awt.Image;

/**
 * Created by davidgudeman on 7/21/15.

public class ImagePanel extends JPanel
{
    private Image img;
   int DEFAULT_WIDTH = 1600;
    int DEFAULT_HEIGHT = 800;

    public ImagePanel(Image img)
    {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));

        getSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setLayout(null);

    }
    public void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class ImagePanel extends JComponent {

    private static BufferedImage picture = null;
    private static final double SCALE_FACTOR = 1.75;
    private int scaleW, scaleH;

    /** Creates a new instance of ScalingMethods */
    public ImagePanel() {
        try {
            String imageName= "MAP.jpg";
            File input = new File(imageName);
            picture = ImageIO.read(input);

            scaleW = (int)(SCALE_FACTOR * picture.getWidth());
            scaleH = (int)(SCALE_FACTOR * picture.getHeight());
            setPreferredSize(new Dimension( (1 * (scaleW )),
                    scaleH ));
        } catch (Exception e) {
            System.out.println("Problem reading image file: " + e);
            System.exit(0);
        }
    }

    /**
     * Draws the picture five times, using the five different scaling
     * approaches described in the book. All five look the same, since
     * all are using default (nearest neighbor) filtering during the
     * scale operation.
     */
    public void paintComponent(Graphics g) {



        // Graphics2D.scale approach
     //   x += scaleW + PADDING;
        Graphics2D g2d = (Graphics2D)g.create();


        // AffineTransform.scale approach
        g2d = (Graphics2D)g.create();
        AffineTransform at = new AffineTransform();
        at.translate(0, 0);
        at.scale(SCALE_FACTOR,SCALE_FACTOR);

        g2d.drawImage(picture, at, null);
        g2d.dispose();


    }

   /* private static void createAndShowGUI() {
        JFrame f = new JFrame("ScalingMethods");
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImagePanel test = new ImagePanel();
        f.add(test);
        f.validate();
        f.pack();
        f.setVisible(true);
    }

    public static void main(String args[]) {
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }
*/
}
