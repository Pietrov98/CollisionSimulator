package Surface;
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
		for(int i = 0; i < 5; i++)
		{
			Random r = new Random();
			Vector2D pos = new Vector2D();
			pos.setVx(r.nextInt(300) + 1);
			pos.setVy(r.nextInt(300) + 1);

			Vector2D vel = new Vector2D();
			vel.setVx(r.nextInt(10) + 1);
			vel.setVy(r.nextInt(10) + 1);
			
			this.addMoveable(pos, vel);
		}
		
		animator = new Thread(this);
        animator.start();
	}
	
	@Override
    public void paintComponent(Graphics g) 
	{
        super.paintComponent(g);

        // draw center of circle
        for(int i = 0; i < moveables.size(); i++)
        	g.fillOval((int) moveables.get(i).getPostion().getVx() - 5, 
        			(int) moveables.get(i).getPostion().getVy() - 5, 
        			(int) moveables.get(i).getDiameter(), (int) moveables.get(i).getDiameter());

    }

	
	public void nextIteration()
	{
		
		/*for(int i = 0; i < moveables.size(); i++)
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
					System.out.println("zderzenie " + moveables.get(i).getPostion().getVx() + " " + moveables.get(i).getPostion().getVy() 
							+ " " + moveables.get(j).getPostion().getVx() + " " + moveables.get(j).getPostion().getVy());
					
					for(int k = 0; k < moveables.size(); k++) 
					{
						System.out.println(moveables.get(k).getPostion().getVx() + " " + moveables.get(k).getPostion().getVy() 
								+ " " + moveables.get(k).getVelocity().getVx() + " " + moveables.get(k).getVelocity().getVy());
					}
					//tutaj tylko jeden wektor zmienia ten co sprawdzamy czyli i
					Vector2D vel = new Vector2D();
					if(moveables.get(i).getVelocity().getAngle() < Math.PI/4)
					{
						vel.setVx(moveables.get(i).getVelocity().getVx() * (-1));
						System.out.println("zmiana x");
					}
					if(moveables.get(i).getVelocity().getAngle() > Math.PI/4)
					{
						vel.setVx(moveables.get(i).getVelocity().getVy() * (-1));
						System.out.println("zmiana y");
					}
					//vel.setVy(moveables.get(i).getVelocity().getVy() * (-1));
					moveables.get(i).setPosition(vel);
					/*Vector2D vel2 = new Vector2D();
					vel2.setVx(moveables.get(j).getVelocity().getVx() * (-1));
					vel2.setVy(moveables.get(j).getVelocity().getVy() * (-1));
					System.out.println();
					moveables.get(j).setPosition(vel2);
				}
			}
		}*/
		for(int i = 0; i < moveables.size(); i++)
    	{
    		for(int j = i + 1; j < moveables.size(); j++)
    		{
    			
    			double deltaX = Math.abs(moveables.get(i).getPostion().getVx() - moveables.get(j).getPostion().getVx());
    	        double deltaY = Math.abs(moveables.get(i).getPostion().getVy() - moveables.get(j).getPostion().getVy());
    	        double distance = deltaX * deltaX + deltaY * deltaY;
    	        if (distance < (moveables.get(i).getDiameter() / 2 + moveables.get(j).getDiameter() / 2) * (moveables.get(i).getDiameter() / 2 + moveables.get(j).getDiameter() / 2)) 
    	        {

    	            double newxSpeed1 = (moveables.get(i).getVelocity().getVx() * (4 - 7) + (2 * 7 * moveables.get(j).getVelocity().getVx())) / 11;
    	            double newxSpeed2 = (moveables.get(j).getVelocity().getVx() * (7 - 4) + (2 * 4 * moveables.get(i).getVelocity().getVx())) / 11;
    	            double newySpeed1 = (moveables.get(i).getVelocity().getVy() * (4 - 7) + (2 * 7 * moveables.get(j).getVelocity().getVy())) / 11;
    	            double newySpeed2 = (moveables.get(j).getVelocity().getVy() * (7 - 4) + (2 * 4 * moveables.get(i).getVelocity().getVy())) / 11;
    	            
    	            if((newxSpeed1 < 0 && moveables.get(i).getVelocity().getVx() >= 0) || (newxSpeed1 > 0 && moveables.get(i).getVelocity().getVx() < 0))
    	            	moveables.get(i).getVelocity().setVx(-moveables.get(i).getVelocity().getVx());
    	            if((newySpeed1 < 0 && moveables.get(i).getVelocity().getVy() >= 0) || (newySpeed1 > 0 && moveables.get(i).getVelocity().getVy() < 0))
    	            	moveables.get(i).getVelocity().setVy(-moveables.get(i).getVelocity().getVy());
    	            if((newxSpeed2 < 0 && moveables.get(j).getVelocity().getVx() >= 0) || (newxSpeed2 > 0 && moveables.get(j).getVelocity().getVx() < 0))
    	            	moveables.get(j).getVelocity().setVx(-moveables.get(j).getVelocity().getVx());
    	            if((newySpeed2 < 0 && moveables.get(j).getVelocity().getVy() >= 0) || (newySpeed2 > 0 && moveables.get(j).getVelocity().getVy() < 0))
    	            	moveables.get(j).getVelocity().setVy((-moveables.get(j).getVelocity().getVy()));
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

	@Override
	public void run() 
	{
		//UserInterface ui = new UserInterface(c , context);
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
