import java.util.*;

public class GenerateDataRotate 
{
	Random rand = new Random(System.currentTimeMillis());
	ArrayList<Integer> ilist;
	ArrayList<Integer> iscale;
	Integer numberPoints = -1;
	Integer smallest = Integer.MAX_VALUE;
	Integer largest = Integer.MIN_VALUE;
	
	public GenerateDataRotate()
	{
		ilist = new ArrayList<Integer>();
		iscale = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getList()
	{
		return ilist;
	}
	
	public ArrayList<Integer> getScale()
	{
		return iscale;
	}
	
	public Integer getSmallest() 
	{
		return smallest;
	}

	public Integer getLargest() 
	{
		return largest;
	}
	
	public Integer Count()
	{
		return numberPoints;
	}
	
	public Integer range()
	{
		return largest - smallest;
	}

	public void generateData(int count)
	{
		numberPoints = count;
		for (int x=0; x<count; x++)
			ilist.add(rand.nextInt(100));
	}
	
	public Integer minimum()
	{
		for (Integer i : ilist)
		{
			if ( i < smallest)
				smallest = i;
		}
		return smallest;
	}
	
	public Integer maximum()
	{
		for (Integer i : ilist)
		{
			if ( i > largest)
				largest = i;
		}
		return largest;
	}
	
	public void scaleData(int factor)
	{
		System.out.println("height = " + factor);		
		for (Integer i : ilist)
		{
			float percentage = (float) i / (float) largest;
			float adjust = percentage * factor;
			System.out.println(i + "  " + adjust);
			iscale.add((int)adjust);
		}
	}
	
	public void AnalyzeData(int factor)
	{
		minimum();
		maximum();
		scaleData(factor);
	}
}
