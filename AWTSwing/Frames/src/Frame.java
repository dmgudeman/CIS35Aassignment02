
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Frame extends JFrame 
{
	JButton b = new JButton("Read File");
	JTextPane tp = new JTextPane();
	public Frame() 
	{
		setSize(500,700);
		Font font = new Font("Arial",Font.PLAIN,16);
		b.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FileIO file = new FileIO();
				try 
				{
					file.ReadFile(tp,"Grape.txt");
				} 
				catch (IOException e1) 
				{
				}				
			}
		});
		Container cp = getContentPane();
		cp.add(new JScrollPane(tp));
		cp.add(BorderLayout.NORTH, b);
		cp.setFont(font);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new Frame();
	}
}