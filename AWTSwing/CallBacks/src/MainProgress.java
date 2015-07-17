import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;


public class MainProgress extends JPanel implements ChangeListener, Callback
{
	ProgressYellow ybar = null;
	ProgressRed rbar = null;
	JProgressBar yellowbar = null;
	JProgressBar redbar = null;
	JButton okbutton = null;
	JLabel label = null;

	public MainProgress()
	{
		initGUI();
	}

	public void initGUI()
	{
		okbutton = new JButton("OK");
		yellowbar = new JProgressBar(0,100);
		redbar = new JProgressBar(0,100);	
		label = new JLabel("");
		this.setPreferredSize(new Dimension(400,300));
      	setLayout(new GridLayout(0, 1));
      	add(yellowbar);
      	add(label);
      	add(redbar);
      	add(okbutton);
      	yellowbar.addChangeListener(new ChangeListener()
      	{
      		public void stateChanged(ChangeEvent event)
      		{
      			yellowbar.setValue(50);
      			yellowbar.repaint();
      		}
      	} );
      	redbar.addChangeListener(new ChangeListener()
      	{
      		public void stateChanged(ChangeEvent event)
      		{
      			redbar.setValue(50);
      			redbar.repaint();
      		}
      	} );
	}	
	
	private void createAndShowGUI() 
	{
		final MainProgress window = this;
	    JFrame frame = new JFrame("ProgressBar Callback");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add( this );
	    frame.pack();
	    frame.setVisible(true);
  	  	ybar = new ProgressYellow(window);
  	  	ybar.createAndShowGUI();
  	  	rbar = new ProgressRed(window);
  	  	rbar.createAndShowGUI();
	}
	
	public void doCallback(int amount) throws InterruptedException, InvocationTargetException
	{
		int value = redbar.getValue();
		value = amount;
		redbar.setValue(value);
	}
				
	
	public void stateChanged(ChangeEvent event)
	{
		redbar.repaint();
	}
	
	public void showGUI() throws InterruptedException, InvocationTargetException
	{
		SwingUtilities.invokeAndWait( new Runnable() 
		{ 
	          public void run() 
	          { 
	        	  createAndShowGUI();

//	        	  ybar = new ProgressYellow(window);
//	        	  ybar.createAndShowGUI();
//		
//	        	  rbar = new ProgressRed(window);
//	        	  rbar.createAndShowGUI();
	          }
		} );
	}
	
	public static void main(String[] args) throws InterruptedException, InvocationTargetException
	{
		MainProgress mp = new MainProgress();
		mp.showGUI();
	}
}
