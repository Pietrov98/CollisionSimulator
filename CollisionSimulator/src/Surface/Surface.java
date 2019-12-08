package Surface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.DataDisplayer;
import GUI.UserInterface;
import Moveable.Caretaker;
import Moveable.Moveable;
import Moveable.MoveableData;
import Moveable.Vector2D;
import State.Context;

public class Surface extends JPanel implements Runnable {
	private List<Moveable> moveables = new ArrayList();
	private Vector2D size; //rozmiar Jpanelu
	
	private Caretaker caretaker;
	private Context context;
	
	public static int stop = 0;
	Thread animator;
	 
	public Surface()
	{
		//caretaker = new Caretaker(this);
		context = new Context();
		for(int i = 0; i < 100; i++)
		{
			Random r = new Random();
			Vector2D pos = new Vector2D();
			pos.setVx(r.nextInt(300) + 1);
			pos.setVy(r.nextInt(300) + 1);

			Vector2D vel = new Vector2D();
			vel.setVx(r.nextInt(10) + 1);
			vel.setVy(r.nextInt(10) + 1);
			
			Random rand = new Random();
			float r1 = rand.nextFloat();
			float g1 = rand.nextFloat();
			float b1 = rand.nextFloat();
			Color randomColor = new Color(r1, g1, b1);
			
			this.addMoveable(pos, vel, randomColor);
		}
		
		animator = new Thread(this);
        animator.start();
	}
	
	@Override
    public void paintComponent(Graphics g) 
	{
        super.paintComponent(g);

        for(int i = 0; i < moveables.size(); i++)
        	moveables.get(i).draw(g);

    }

	
	public void nextIteration()
	{
		for(int i = 0; i < moveables.size(); i++)
    	{
    		for(int j = i + 1; j < moveables.size(); j++)
    		{
    			if (moveables.get(i).colliding(moveables.get(j)))  
    	        {
    				moveables.get(i).resolveCollision(moveables.get(j));
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
	
	public void addMoveable(Vector2D pos, Vector2D vel, Color color)
	{
		
		Moveable obj = new Moveable();
		obj.setPosition(pos);
		obj.setVelocity(vel);
		obj.setColor(color);
		moveables.add(obj);	
	}
		
	
	
	public void setMoveables(List<Moveable> moveables)
	{
		this.moveables = moveables;
	}

	@Override
	public void run() 
	{
		while(stop != 2)
		{
			 try {
	                Thread.sleep(15);
	            } catch (InterruptedException ex) {
	            }
			if(stop == 0)
			{
				for(int i = 0; i < moveables.size(); i++)
	        		moveables.get(i).move();
	        	
	            nextIteration();
	            repaint();
		   }	
		}  	
     }		
}
