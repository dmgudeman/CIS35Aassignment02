
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class TextFields extends JApplet 
{
	JButton
    b1 = new JButton("Get Text"),
    b2 = new JButton("Set Text");
	JTextField
    t1 = new JTextField(20),
    t2 = new JTextField(20);
	String s = new String();
	public void init() 
	{
		b1.addActionListener(new B1());
		b2.addActionListener(new B2());
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		cp.add(b2);
		cp.add(t1);
		cp.add(t2);
	}
	class B1 implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(t1.getSelectedText() == null)
				s = t1.getText();
			else
				s = t1.getSelectedText();
			t1.setEditable(true);
		}
	}
	class B2 implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			t2.setText("Inserted by Button 2: " + s);
			t1.setEditable(false);
		}
	}
	public static void main(String[] args) 
	{
		Console.run(new TextFields(), 375, 125);
	}
}
