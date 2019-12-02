package Surface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import GUI.DataDisplayer;
import GUI.UserInterface;
import Moveable.Moveable;
import Moveable.MoveableData;
import Moveable.Vector2D;

public class Surface {
	private List<Moveable> moveables = new ArrayList();
	private Vector2D size;
	
	
	
	public void nextIteration()
	{
		
		for(int i = 0; i < moveables.size(); i++)
		{
			moveables.get(i).move();
		}
		
		
		for(int i = 0; i < moveables.size(); i++)
		{
			for(int j = 0; j < moveables.size(); j++)
			{					
				if(j != i && moveables.get(i).getPostion().getVx() == moveables.get(j).getPostion().getVx() 
						&& moveables.get(i).getPostion().getVy() == moveables.get(j).getPostion().getVy())
				{
					System.out.println("zderzenie1 " + moveables.get(i).getPostion().getVx() + " " + moveables.get(i).getPostion().getVy() 
							+ " " + moveables.get(j).getPostion().getVx() + " " + moveables.get(j).getPostion().getVy());
					
					System.out.println("rycht");
					for(int k = 0; k < moveables.size(); k++) 
					{
						System.out.println(moveables.get(k).getPostion().getVx() + " " + moveables.get(k).getPostion().getVy() 
								+ " " + moveables.get(k).getVelocity().getVx() + " " + moveables.get(k).getVelocity().getVy());
					}
					//tutaj tylko jeden wektor zmienia ten co sprawdzamy czyli i
					Vector2D vel = new Vector2D();
					vel.setVx(moveables.get(i).getVelocity().getVx() * (-1));
					//vel.setVy(moveables.get(i).getVelocity().getVy() * (-1));
					moveables.get(i).setPosition(vel);
					/*Vector2D vel2 = new Vector2D();
					vel2.setVx(moveables.get(j).getVelocity().getVx() * (-1));
					vel2.setVy(moveables.get(j).getVelocity().getVy() * (-1));
					System.out.println();
					moveables.get(j).setPosition(vel2);*/
				}
			}
		}
		
	}
	
	public List<MoveableData> saveMementos()
	{
		List<MoveableData> moveables_helper = new ArrayList<MoveableData>();
		for(int i = 0; i < moveables.size(); i++)
		{
			moveables_helper.add(moveables.get(i).createData());
		}
		DataDisplayer.displayData(moveables_helper);

		return moveables_helper;
	}
	
	public void addMoveable(Vector2D pos, Vector2D vel)
	{
		
		Moveable obj = new Moveable();
		obj.setPosition(pos);
		obj.setVelocity(vel);
		moveables.add(obj);	
	}
		
	
	
	public void setMoveables(List<Moveable> moveables)
	{
		this.moveables = moveables;
	}
}
