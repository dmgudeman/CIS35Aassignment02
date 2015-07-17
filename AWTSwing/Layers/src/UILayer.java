
import javax.swing.*;
import java.awt.*;


public class UILayer
{
  JScrollPane pane;
   
  public void addControls( Container c, DataLayer dlayer ) 
  {
	  pane = new JScrollPane( dlayer.getTable() );
	  c.add(pane);
  }
}