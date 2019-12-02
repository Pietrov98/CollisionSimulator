package State;
import GUI.Main;

public class StopState extends State{
	public void Handle()
	{
		Main.stop = 1;	
	}
}
