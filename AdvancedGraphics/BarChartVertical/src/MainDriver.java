import javax.swing.JFrame;


public class MainDriver 
{
	public void run(int width, int height)
	{
		JFrame frame = new JFrame("Rotate Bar Graph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.getContentPane().add(new BarGraphRotate(10,frame.getHeight()));
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		MainDriver md = new MainDriver();
		md.run(800,600);
	}
}