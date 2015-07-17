
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;

class Drawing extends JPanel
{
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		int x1 = 0;
		int x2 = getWidth();
		int y1 = 0;
		int y2 = getHeight();
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y1, x1, y2);
	}
	public void run(JPanel panel, int width, int height) 
	{
		JFrame frame = new JFrame("JPanel Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	public static void main(String[] arg)
	{
		Drawing draw = new Drawing();
		draw.run(draw,500,500);
	}
}