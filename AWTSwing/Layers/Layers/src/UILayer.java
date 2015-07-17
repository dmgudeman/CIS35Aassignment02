
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;

import java.util.*;

public class UILayer
{
  JScrollPane pane;
   
  public void addControls( Container c, DataLayer dlayer ) 
  {
	  pane = new JScrollPane( dlayer.getTable() );
	  c.add(pane);
	  addEvents(dlayer);
  }
  
  public void addEvents( DataLayer dlayer )
  {
	  if (dlayer != null)
	  {
		  dlayer.getTable().addMouseListener(new MouseAdapter()
		  {
			  public void mouseClicked(MouseEvent e) 
			  {
				  JTable target = (JTable)e.getSource();
				  int row = target.getSelectedRow();
				  int column = target.getSelectedColumn();
				  String text = (String)target.getValueAt(row, column);
				  String srow = "Row = " + row +" Column = " + column + " " + text;
				  JOptionPane.showMessageDialog(new JFrame(),srow,"Table",JOptionPane.PLAIN_MESSAGE);
			  }
		  });
	  }
  }
}