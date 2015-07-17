
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.*;

public class BarGraph extends JPanel
{
	GenerateData data;

	public BarGraph(int npoints,int factor)
	{
		setupGUI(npoints,factor);
	}
	
	public GenerateData getData()
	{
		return data;
	}
	
	public void setupGUI(int npoints, int factor)
	{
		data = new GenerateData();
		data.generateData(npoints);
		data.AnalyzeData(factor);	
	}
	
    public void paintComponent(Graphics g)
    { 
    	super.paintComponents(g);
    	if (data != null)
    	{
    		// note: absolute positioning - not using layout manager
    		g.setColor(Color.cyan);
    		int heightStart = 0;
    		int height = getHeight() / data.Count();
    		for(Integer i : data.getScale())
    		{
    			g.fill3DRect(0,heightStart,i,height,true);
    			heightStart += height;
    		}
    	}
    }  
}
