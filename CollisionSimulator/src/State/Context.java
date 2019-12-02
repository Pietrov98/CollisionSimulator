package State;

public class Context {
	private State state = new RunState();
	public void Request(int flg)
	{
		state = new RunState();
		if(flg == 1)
			state = new StopState();
		else if(flg == 2)
			state = new EndState();			
		state.Handle();
	}
}
