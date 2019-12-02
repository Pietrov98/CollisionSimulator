package GUI;
import java.util.List;

import Moveable.MoveableData;

public abstract class DataDisplayer {
	public static void displayData(List<MoveableData> moveable_helper)
	{
		System.out.println();
		for(int i = 0; i < moveable_helper.size(); i++) 
		{
			
			System.out.println(moveable_helper.get(i).getPostion().getVx() + " " + moveable_helper.get(i).getPostion().getVy() 
					+ " " + moveable_helper.get(i).getVelocity().getVx() + " " + moveable_helper.get(i).getVelocity().getVy());
		}
		
	}
}
