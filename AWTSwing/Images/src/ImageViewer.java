import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ImageViewer extends JFrame 
{
    Image image;
    String imageName = "";

    public ImageViewer(String simage) 
    {
    		imageName = simage;
        	DrawImage();
    }

    public void paint(Graphics g) 
    {
        g.drawImage(image, 10, 30, this);
    }

    public void DrawImage()
    {
        Toolkit tool = Toolkit.getDefaultToolkit();
        image = tool.getImage(imageName);
        setSize(image.getWidth(null),image.getHeight(null));
        setVisible(true);
        setLocation(200, 100);
    }
    
	public void run(JFrame frame, int width, int height) 
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	} 
	
    public static void main(String args[]) throws Exception 
    {
    	ImageViewer viewer = new ImageViewer("Image.jpg");
    	viewer.run(viewer, 800, 800);
    }
} 