import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Dialogs extends JApplet 
{
	JButton b1 = new JButton("Dialog Box");
	MyDialog dlg = new MyDialog(null);
	JFrame frm = new JFrame();

	public void init() 
	{
		dlg.setVisible(true);
		frm.setVisible(true);
		b1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dlg.setVisible(true);
			}
		});
		getContentPane().add(b1);
	}
	public static void main(String[] args) 
	{
		new Dialogs();
	}
}