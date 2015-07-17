// Demonstrate JLabel and ImageIcon. 
import java.awt.*; 
import javax.swing.*; 
/* 
  <applet code="JLabelDemo" width=300 height=300> 
  </applet> 
*/ 
 
public class JLabelDemo extends JApplet 
{ 
	public void init() 
	{ 
		try 
		{ 
			SwingUtilities.invokeAndWait( new Runnable() 
			{ 
				public void run() 
				{ 
					makeGUI(); 
				} 
			} ); 
		} 
		catch (Exception exc) 
		{ 
			System.out.println("Can't create because of " + exc); 
		} 
  } 
 
  private void makeGUI() 
  { 
	  
    // Create an icon. 
    ImageIcon icon = new ImageIcon("france.jpg"); 
 
    // Create a label. 
    JLabel jlabel = new JLabel("France", icon, JLabel.CENTER); 
 
    // Add the label to the content pane. 
    add(jlabel); 
  } 
}