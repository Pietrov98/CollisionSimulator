package Moveable;

import java.awt.Color;

public class MoveableData{

	private Vector2D position;
	private Vector2D velocity;
	private Color color;
	
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

	public Color getColor() 
	{
		
		return color;
	}

	public void setColor(Color color) 
	{
		this.color = color;
		
	}
			

}
