import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyDialog extends JDialog 
{
	public MyDialog(JFrame parent) 
	{
		super(parent, "My dialog ", true);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Here is my dialog"));
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose(); // Closes the dialog
			}
		});
		cp.add(ok);
		setSize(150,125);
	}
}
