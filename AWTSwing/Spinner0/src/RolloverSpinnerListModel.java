import java.util.List;

import javax.swing.SpinnerListModel;

class RolloverSpinnerListModel extends SpinnerListModel 
{
	public RolloverSpinnerListModel(Object[] items) 
	{
		super(items);
	}
	public RolloverSpinnerListModel(List items) 
	{
		super(items);
	}

	public Object getNextValue() 
	{
		Object nv = super.getNextValue();
		if (nv != null) 
		{
			return nv;
		}
		return getList().get(0);
	}

	public Object getPreviousValue() 
	{
		Object pv = super.getPreviousValue();
		if (pv != null) 
		{
			return pv;
		}
		List l = getList();
		return l.get(l.size() - 1);
	}
}