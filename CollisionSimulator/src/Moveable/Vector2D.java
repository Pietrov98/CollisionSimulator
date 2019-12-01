package Moveable;

public class Vector2D{

	private double vx, vy;
	
	
	public double getAbs() 
	{
		return Math.abs(Math.sqrt((vx*vx + vy*vy)));
	}

	
	public double getVx() 
	{
		return vx;
	}

	
	public double getVy() 
	{	
		return vy;
	}

	
	public void setVx(double vx) 
	{

		this.vx = vx;
	}

	
	public void setVy(double vy) 
	{
		this.vy = vy;
		
	}
	
	public double getAngle()
	{
		double angle = Math.acos(this.vx / getAbs());
		return angle;
	}
			

}
