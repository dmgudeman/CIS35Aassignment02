
import javax.swing.JTable;
import java.util.*;


public class DataLayer 
{
	  JTable table;
	  String[][] data;
	  
	  public JTable getTable()
	  {
		  return table;
	  }
	  
	  public void setData(ArrayList<String> slist, String[] fields)
	  {
		  data = new String[slist.size()][fields.length];
		  for (int x=0; x<slist.size(); x++)
		  {
			  String s  = slist.get(x);
			  String[] sa = s.split(",");
			  for (int y=0; y<sa.length; y++)
				  data[x][y] = sa[y];
		  }
		  table = new JTable( data, fields );
	  }
}
