package GUI;

import java.io.FileNotFoundException;
import java.util.Random;

import Moveable.Caretaker;
import Moveable.Vector2D;
import State.Context;
import Surface.Surface;

public class Main {

	public static int stop;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		
		Main.stop = 1;
		
		Surface s = new Surface();
		Caretaker c = new Caretaker(s);
		Context context = new Context();
		
		
		for(int i = 0; i < 20; i++)
		{
			Random r = new Random();
			Vector2D pos = new Vector2D();
			pos.setVx(r.nextInt(100) + 1);
			pos.setVy(r.nextInt(100) + 1);

			Vector2D vel = new Vector2D();
			vel.setVx(r.nextInt(20) + 1);
			vel.setVy(r.nextInt(20) + 1);
			
			s.addMoveable(pos, vel);
		}
		
		UserInterface ui = new UserInterface();
		ui.displayUI(c , context);
		
		while(stop != 2)
		{
			System.out.print("");
			
			if(stop == 0)
			{
				s.nextIteration();
			}
			
		}
		
		
	}
}
