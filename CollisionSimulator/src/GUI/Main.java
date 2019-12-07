package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Moveable.Caretaker;
import Moveable.Vector2D;
import State.Context;
import Surface.Surface;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		/*JFrame frame = new JFrame ();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Surface surface= new Surface(frame);
        surface.setSize(400, 400);
        frame.setSize(800,500);
        frame.setVisible(true);
       // frame.add(surface);		
        JPanel pan = new JPanel();
        pan.add(surface);
        frame.add(pan);
        JButton p = new JButton("COs");
        p.setBounds(500, 300, 28, 30);
        p.setSize(40, 40);*/
		
		
		JFrame window = new JFrame();
		Surface surface= new Surface();
		Caretaker caretaker = new Caretaker(surface);
		Context context = new Context();
        surface.setSize(400, 400);
        surface.setBackground(Color.LIGHT_GRAY);
        UserInterface UI = new UserInterface(context, caretaker);
		JPanel p2 = new JPanel();
		JButton b1 = new JButton("asdasd");
		//p2.add(b1);
		//p2.setSize(400, 100);
		window.add(surface, BorderLayout.CENTER);
		window.add(UI, BorderLayout.SOUTH);
		window.setSize(410, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		
       
       // frame.add(p);
		
		
		/*Caretaker c = new Caretaker(s);
		Context context = new Context();*/
		
		
		
		
		//UserInterface ui = new UserInterface(c , context);
		//ui.displayUI();
		
		/*while(stop != 2)
		{
			System.out.print("");
			
			if(stop == 0)
			{
				s.nextIteration();
			}
			
		}*/
		
		
	}
}
