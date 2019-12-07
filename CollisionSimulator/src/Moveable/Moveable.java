package Moveable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Moveable{
	private Vector2D position = new Vector2D();
	private Vector2D velocity = new Vector2D();
	int diameter;
	private Color color;
	
	public Moveable() {
		//position.setVx(pos_x);
		//position.setVy(pos_y);
		//velocity.setVx(5);
		//velocity.setVy(2);
		this.diameter = 20;
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);
		this.color = randomColor;
	}

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
	
	public void draw(Graphics g) {
		
		g.setColor(this.color);
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(position.getVx() - diameter / 2, position.getVx() - diameter / 2, diameter, diameter);
        g2d.fill(circle);
    }
	
	public void move() //jeden promienia, 300x300 plansza
	{
		/* if (position.getVx() + velocity.getVx() < 0 || (position.getVx() + 1 + velocity.getVx()) > (300 - 1))
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
         this.position.setVy(position.getVy() + velocity.getVy());*/
		
		 position.setVx(((double) (position.getVx() + velocity.getVx())));
	        if (position.getVx() - diameter / 2 < 0) 
	        {
	            position.setVx((diameter / 2));
	            velocity.setVx((-velocity.getVx()));
	        } 
	        else if(position.getVx() + diameter / 2 > 390) 
	        {
	            velocity.setVx((-velocity.getVx()));
	        }
	        
	        position.setVy(((double) (position.getVy() + velocity.getVy())));
	        if(position.getVy() - diameter / 2 < 0) 
	        {
	            velocity.setVy((-velocity.getVy()));
	        } 
	        else if(position.getVy() + diameter / 2 > 360) 
	        {
	            position.setVy((360 - diameter / 2));
	            velocity.setVy((-velocity.getVy()));
	        }

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

	public int getDiameter() {
		return diameter;
	}

}
