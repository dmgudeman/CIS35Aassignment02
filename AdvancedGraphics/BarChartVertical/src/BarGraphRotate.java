
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.*;

public class BarGraphRotate extends JPanel
{
	GenerateDataRotate data;

	public BarGraphRotate(int npoints,int factor)
	{
		setupGUI(npoints,factor);
	}
	
	public GenerateDataRotate getData()
	{
		return data;
	}
	
	public void setupGUI(int npoints,int factor)
	{
		data = new GenerateDataRotate();
		data.generateData(npoints);
		data.AnalyzeData(factor);	
	}
	
    public void paintComponent(Graphics g)
    { 
    	super.paintComponents(g);
    	if (data != null)
    	{
    		// note: absolute positioning - not using layout manager
    		g.setColor(Color.yellow);
    		int widthStart = 0;
    		int width = getWidth() / data.Count();
    		for(Integer i : data.getScale())
    		{
    			// rotate 90 degrees
    			int height = Math.abs(i-getHeight());
    			g.fill3DRect(widthStart,height,width,getHeight(),true);
    			widthStart += width;
    		}
    	}
    }  
}
