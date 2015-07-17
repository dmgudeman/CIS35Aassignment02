

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel
{
    int[][] coord = { {50, 50, 200, 30},
                    {200, 30, 30, 200},
                    {30, 200, 200, 200},
                    {200, 200, 30, 30}};

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
         for (int i = 0; i<3; i++)
         {
                 g2d.drawLine(coord[i][i], coord[i][i+1], coord[i][i+2], coord[i][i+3]);
         }
        //  g2d.drawLine(50, 50, 200, 30);
        //g2d.drawLine(200, 30, 30, 200);
        //g2d.drawLine(30, 200, 200, 200);
        //g2d.drawLine(200, 200, 30, 30);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class LinesEx extends JFrame {

    public LinesEx() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Lines");
        setSize(1600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}