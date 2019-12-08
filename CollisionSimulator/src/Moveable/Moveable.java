package Moveable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.Vector;


public class Moveable{
	private Vector2D position = new Vector2D();
	private Vector2D velocity = new Vector2D();
	int diameter;
	private Color color;
	
	public Moveable() 
	{
		
		this.diameter = 15;
		
	}

	public MoveableData createData()
	{
		MoveableData obj = new MoveableData();
		obj.setPosition(position);
		obj.setVelocity(velocity);
		obj.setColor(this.color);
		
		return obj;
	}
	
	public void loadData(MoveableData obj)
	{
		//bedzie ladowac zapisane
	}
	
	public void draw(Graphics g) {
		
		g.setColor(this.color);
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(position.getVx() - diameter / 2, position.getVy() - diameter / 2, diameter, diameter);
        g2d.fill(circle);
    }
	
	public void move() //jeden promienia, 300x300 plansza
	{
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
	
	public Vector2D getPosition()
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

	public void setColor(Color color) 
	{
		this.color = color;
		
	}

	public boolean colliding(Moveable moveable) 
	{
		double deltaX = Math.abs(this.getPosition().getVx() - moveable.getPosition().getVx());
        double deltaY = Math.abs(this.getPosition().getVy() - moveable.getPosition().getVy());
        double distance = deltaX * deltaX + deltaY * deltaY;
        if (distance < (this.getDiameter() / 2 + moveable.getDiameter() / 2) * this.getDiameter() / 2 + moveable.getDiameter() / 2)
        {
        	return true;
        }
        return false;
	}

	public void resolveCollision(Moveable moveable) 
	{
		double xDist = this.getPosition().getVx() - moveable.getPosition().getVx();
        double yDist = this.getPosition().getVy() - moveable.getPosition().getVy();
        double distSquared = xDist*xDist + yDist*yDist;
        
		double xVelocity = moveable.getVelocity().getVx() - this.getVelocity().getVx();
        double yVelocity = moveable.getVelocity().getVy() - this.getVelocity().getVy();
        double dotProduct = xDist * xVelocity + yDist * yVelocity;
        if(dotProduct > 0)
        {
            double collisionScale = dotProduct / distSquared;
            double xCollision = xDist * collisionScale;
            double yCollision = yDist * collisionScale;

            System.out.println(xCollision + " " + yCollision);
            this.getVelocity().setVx(this.getVelocity().getVx() + xCollision);
            this.getVelocity().setVy(this.getVelocity().getVy() + yCollision);
            moveable.getVelocity().setVx(this.getVelocity().getVx() - xCollision);
            moveable.getVelocity().setVy(this.getVelocity().getVy() - yCollision);
        }
	}

}
