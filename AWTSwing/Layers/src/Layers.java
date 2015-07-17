import javax.swing.*;

public class Layers extends JFrame 
{
	BusinessLayer businessLayer;
	UILayer userLayer;
	String sfields[] = { "Last", "First", "Email", "Card" };

	public Layers(String title) 
	{
		super(title);
		init();
		pack();
		setVisible(true);
		start();
	}

	public void init() 
	{
		userLayer = new UILayer();
		businessLayer = new BusinessLayer();
	}

	public void start() 
	{
		businessLayer.read("customer.csv");
		businessLayer.setData(sfields);
		userLayer.addControls(getContentPane(), businessLayer.getDataLayer());
	}

	public static void main(String[] argv) 
	{
		Layers layer = new Layers("Customers");
		Console.run(layer, 600, 300);
	}
}