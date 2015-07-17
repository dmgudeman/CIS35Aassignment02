
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class Tabs extends JApplet 
{
	private String[] flavors = 
	{
		  "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
		  "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
		  "Praline Cream", "Mud Pie"
	};
	JTabbedPane tabs = new JTabbedPane();
	JTextField txt = new JTextField(20);
	public void init() 
	{
			setSize(500,200);
			for(int i = 0; i < flavors.length; i++)
				tabs.addTab(flavors[i], new JButton("Tabbed pane " + i));
			tabs.addChangeListener(new ChangeListener() 
			{
				public void stateChanged(ChangeEvent e) 
				{
					txt.setText("Tab selected: " +
						tabs.getSelectedIndex());
				}
			});
			Container cp = getContentPane();
			cp.add(BorderLayout.EAST, txt);
			cp.add(tabs);
	}
}