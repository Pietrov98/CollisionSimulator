package State;
import GUI.Main;
import Surface.Surface;

public class StopState extends State{
	public void Handle()
	{
		Surface.stop = 1;	
	}
}
