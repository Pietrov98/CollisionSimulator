package Surface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

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
			for(int j = 0; j < moveables.size(); j++)
			{					
				if(j != i && moveables.get(i).getPostion().getVx() == moveables.get(j).getPostion().getVx() 
						&& moveables.get(i).getPostion().getVy() == moveables.get(j).getPostion().getVy())
				{
					System.out.println("zderzenie1 " + moveables.get(i).getPostion().getVx() + " " + moveables.get(i).getPostion().getVy() 
							+ " " + moveables.get(j).getPostion().getVx() + " " + moveables.get(j).getPostion().getVy());
					Vector2D vel1 = new Vector2D();
					vel1.setVx(moveables.get(i).getVelocity().getVx() * (-1));
					vel1.setVy(moveables.get(i).getVelocity().getVy() * (-1));
					moveables.get(i).setPosition(vel1);
					Vector2D vel2 = new Vector2D();
					vel2.setVx(moveables.get(j).getVelocity().getVx() * (-1));
					vel2.setVy(moveables.get(j).getVelocity().getVy() * (-1));
					moveables.get(j).setPosition(vel2);
				}
			}
		}
		for(int i = 0; i < moveables.size(); i++)
		{
			moveables.get(i).move();
		}
		
	}
	
	public List<MoveableData> saveMementos()
	{
		List<MoveableData> moveables_helper = new ArrayList<MoveableData>();
		System.out.println(moveables.size());
		for(int i = 0; i < moveables.size(); i++)
		{
			moveables_helper.add(moveables.get(i).createData());
		}
		return moveables_helper;
	}
	
	public void addMoveable()
	{
		Random r = new Random();
		Moveable obj = new Moveable();
		Vector2D pos = new Vector2D();
		pos.setVx(r.nextInt(100));
		pos.setVy(r.nextInt(100));
		obj.setPosition(pos);
		
		Vector2D vel = new Vector2D();
		vel.setVx(r.nextInt(20) + 1);
		vel.setVy(r.nextInt(20) + 1);
		obj.setVelocity(vel);
		
		moveables.add(obj);	
	}
}
