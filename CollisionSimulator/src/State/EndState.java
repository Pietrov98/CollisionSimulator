package State;

import GUI.Main;

public class EndState extends State{
	public void Handle()
	{
		Main.stop = 2;
	}
}
