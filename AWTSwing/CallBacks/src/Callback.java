import java.lang.reflect.InvocationTargetException;


public interface Callback 
{
	void doCallback(int value) throws InterruptedException, InvocationTargetException;
}
