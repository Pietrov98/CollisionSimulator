package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {

	private JFrame frame = new JFrame();
	private List<Point> moveables = new ArrayList();
	
    public GUI() {
        //EventQueue.invokeLater(new Runnable() {
         //   @Override
          //  public void run() 
          //  {
              
               frame.setLayout(new BorderLayout());
               frame.add(new Balls());
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	       frame.setSize(300,300);
     	       frame.setLocationRelativeTo(null);
     	       frame.setVisible(true);
           // }
       // });
    
    }

    public class Balls extends JPanel {

        public Balls() {
            setLayout(null);
            Random random = new Random();
            // Randomize the speed and direction...
            for(int i = 0; i < 2; i++)
            {
                moveables.add(new Point(random.nextInt(14), 10 - (int) Math.round((Math.random() * 20)), 10 - (int) Math.round((Math.random() * 20))));

            }
           // moveables.add(new Point(random.nextInt(14), 10 - (int) Math.round((Math.random() * 20)), 10 - (int) Math.round((Math.random() * 20))));
           // moveables.add(new Point(random.nextInt(14), 10 - (int) Math.round((Math.random() * 20)), 10 - (int) Math.round((Math.random() * 20))));
           // moveables.add(new Point(random.nextInt(14), 10 - (int) Math.round((Math.random() * 20)), 10 - (int) Math.round((Math.random() * 20))));
            for(int i = 0; i < moveables.size(); i++)
            {
            	List<Point> moveables2 = new ArrayList(moveables);
            	moveables2.remove(i);
            	
            	moveables.get(i).setMoveables(moveables2);
            	add(moveables.get(i));
            }
        }
    }
}

    