package State;

import GUI.Main;
import Surface.Surface;

public class EndState extends State{
	public void Handle()
	{
		Surface.stop = 2;
	}
}
