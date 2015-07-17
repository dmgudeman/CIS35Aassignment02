import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BusinessLayer 
{
	DataLayer dataLayer;
	ArrayList<String> slist;
	
	public BusinessLayer()
	{
		dataLayer = new DataLayer();
	}
	
	public DataLayer getDataLayer()
	{
		return dataLayer;
	}
	
	public void read(String sfile)
	{
			try 
			{
				slist = new ArrayList<String>();
				File inFile  = new File(sfile);
				BufferedReader reader;
				reader = new BufferedReader(new FileReader(inFile));
				String sline = null;
				while ((sline=reader.readLine()) != null) 
					slist.add(sline);
				reader.close();  
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	}
	
	public void setData(String[] sfields)
	{
		dataLayer.setData(slist,sfields);
	}
	
	public ArrayList<String> getData()
	{
		return slist;
	}
}
