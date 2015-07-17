
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class CheckBoxes extends JApplet 
{
	JTextArea t = new JTextArea(6, 15);
	JCheckBox
    cb1 = new JCheckBox("Check Box 1"),
    cb2 = new JCheckBox("Check Box 2"),
    cb3 = new JCheckBox("Check Box 3");
	public void init() 
	{
		cb1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				trace("1", cb1);
			}
		});
		cb2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				trace("2", cb2);
			}
		});
		cb3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				trace("3", cb3);
			}
		});
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JScrollPane(t));
		cp.add(cb1);
		cp.add(cb2);
		cp.add(cb3);
  }
  private void trace(String b, JCheckBox cb) 
  {
	  if(cb.isSelected())
		  t.append("Box " + b + " Set\n");
	  else
		  t.append("Box " + b + " Cleared\n");
  }
	public void run(JApplet applet, int width, int height) 
	{
		JFrame frame = new JFrame("CheckBoxes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(applet);
		frame.setSize(width, height);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}
  public static void main(String[] args) 
  {
	  CheckBoxes cb = new CheckBoxes();
	  cb.run(cb, 200, 200);
  }
}