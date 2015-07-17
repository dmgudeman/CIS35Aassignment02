import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.applet.AudioClip;
import javax.swing.JButton;
import java.net.*;


public class PlaySound extends JApplet
{
		JButton button = new JButton();

		public PlaySound()
		{
			ImageIcon playIcon = new ImageIcon("Play.png");
			button.setIcon(playIcon);
			button.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					PlayAudio();
				}
			});
			Container cp = getContentPane();
			cp.add(BorderLayout.SOUTH, button);
		}
		
		public void PlayAudio()
		{
			URL url = getDocumentBase(); 
			String s = url.toString();
			AudioClip ac = getAudioClip(url,"burp.wav");
			ac.play();   //play once				
		}
}
