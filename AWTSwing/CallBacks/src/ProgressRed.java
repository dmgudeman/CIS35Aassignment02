import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

public class ProgressRed extends JPanel implements ActionListener
{
	MainProgress window = null;
	JButton updatebutton = null;
	int amount = 0;
	
	public ProgressRed(MainProgress mp)
	{
		window = mp;
		initGUI();
	}

	public void initGUI()
	{
		updatebutton = new JButton("Update");
		updatebutton.addActionListener(this);
		updatebutton.setBackground(Color.red);
      	setLayout(new GridLayout(0, 1));
      	add(updatebutton);
	}	
	
	public void createAndShowGUI() 
	{
	    JFrame frame = new JFrame("Update Red");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(300,150));
	    frame.getContentPane().add( this );
	    frame.pack();
	    frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt)
	{  
		amount += 10;
		try 
		{
			doCallback(amount);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void doCallback(int value) throws InterruptedException, InvocationTargetException
	{
		window.doCallback(value);
	}	
}
