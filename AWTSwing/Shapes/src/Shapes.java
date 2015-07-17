
import javax.swing.*;

import java.awt.*;

public class Shapes extends JFrame 
{
     public Shapes()
     {
         super( "Drawing 2D shapes" );        
         setVisible(true);
     }    
     public void paint(Graphics g)
     {
    	 int[] xpoints = new int[] { 250,300,350 };
    	 int[] ypoints = new int[] { 150,50,150 };
         g.drawOval(50, 50, 100,100);
         g.drawRect(160, 60, 75, 75);
         g.drawPolygon(xpoints,ypoints,3);     
     }  
 	 public void run(Frame frame, int width, int height) 
 	 {
 		frame.setSize(width, height);
 		frame.setVisible(true);
 	 }
     public static void main( String args[] )
	 {
    	 Shapes shape = new Shapes();
    	 shape.run(new Shapes(), 500, 500);
     }
}