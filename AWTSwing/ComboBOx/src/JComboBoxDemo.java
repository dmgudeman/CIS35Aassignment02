import java.awt.*; 
import java.awt.event.*; 

import javax.swing.*; 

public class JComboBoxDemo extends JFrame
{ 
	  JLabel jlab; 
	  ImageIcon france, germany, italy, japan; 
	  JComboBox jcb; 
	 
	  String flags[] = { "France", "Germany", "Italy", "Japan" }; 
	 
	  public void JComboBoxDemo() 
	  { 
	    try 
	    { 
	      SwingUtilities.invokeAndWait( new Runnable() 
	      { 
	          public void run() 
	          { 
	            makeGUI(); 
	          } 
	        } 
	      ); 
	    } 
	    catch (Exception exc) 
	    { 
	      System.out.println("Can't create because of " + exc); 
	    } 
	  }     
	 
	  private void makeGUI() 
	  { 
	    // Change to flow layout. 
	    setLayout(new FlowLayout()); 
	 
	    // Instantiate a combo box and add it to the content pane. 
	    jcb = new JComboBox(flags); 
	    getContentPane().add(jcb); 
	 
	    // Handle selections. 
	    jcb.addActionListener(new ActionListener() 
	    { 
	      public void actionPerformed(ActionEvent ae) 
	      { 
	        String s = (String) jcb.getSelectedItem(); 
	        jlab.setIcon(new ImageIcon(s + ".gif")); 
	      } 
	    }); 
	 
	    // Create a label and add it to the content pane. 
	    jlab = new JLabel(new ImageIcon("france.gif")); 
	    getContentPane().add(jlab); 
	  } 

	  public void run(int width, int height) 
	  {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setSize(width, height);
		  setVisible(true);
	  }
	  
	  public static void main(String[] args) 
	  {
		  JComboBoxDemo cbox = new JComboBoxDemo();
		  cbox.run(500, 500);
	  }
}
