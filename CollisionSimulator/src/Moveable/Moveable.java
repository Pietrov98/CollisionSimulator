package Moveable;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Moveable extends JPanel{
	private Vector2D position;
	private Vector2D velocity;
	
	
	public MoveableData createData()
	{
		MoveableData obj = new MoveableData();
		obj.setPosition(position);
		obj.setVelocity(velocity);
		
		return obj; //to bedzie zapisywac obiekty
	}
	
	public void loadData(MoveableData obj)
	{
		//bedzie ladowac zapisane
	}
	
	public void move() //jeden promienia, 300x300 plansza
	{
		 if (position.getVx() + velocity.getVx() < 0 || (position.getVx() + 1 + velocity.getVx()) > (300 - 1))
		 {
			 //System.out.println("tak1 " + position.getVx() + " " + position.getVy());
             velocity.setVx(velocity.getVx() * -1);
         }
         if (position.getVy() + velocity.getVy() < 0 || (position.getVy() + 1 + velocity.getVy()) > (300 - 1)) 
         {
        	 //System.out.println("tak2 " + position.getVx() + " " + position.getVy());
        	 velocity.setVy(velocity.getVy() * -1);
         }
       
         this.position.setVx(position.getVx() + velocity.getVx());
         this.position.setVy(position.getVy() + velocity.getVy());

	}
	
	public Vector2D getPostion()
	{
		return position;
		
	}
	
	public Vector2D getVelocity()
	{
		return velocity;
		
	}
	
	public void setPosition(Vector2D position)
	{
		this.position = position;
	}
	
	public void setVelocity(Vector2D velocity)
	{
		this.velocity = velocity;
	}

}
