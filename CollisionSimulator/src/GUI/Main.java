package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.RepaintManager;

import Moveable.Caretaker;
import Moveable.Moveable;
import Surface.Surface;

public class Main {

	static int stop = 0;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		//new GUI();
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(30, 30, 300, 300);
	    window.setSize(400, 400);
	    window.setVisible(true);
	    JButton stopButton = new JButton("Stop");
	    stopButton.setBounds(250,0,80,30);
	    JButton startButton = new JButton("Start");
	    startButton.setBounds(250,50,80,30);
	    JButton exitButton = new JButton("Koniec");
	    exitButton.setBounds(250,100,80,30);
	    
	    stopButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		stop = 1; 
	    	}}); 
	    startButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		stop = 0; 
	    	}}); 
	    
	    exitButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		stop = 3; 
	    	}}); 
	    window.add(stopButton);
	    window.add(startButton);
	    window.add(exitButton);
	    
	    
		Surface s = new Surface();
		Caretaker c = new Caretaker(s);
		for(int i = 0; i < 20; i++)
		{
			s.addMoveable();
		}
		c.save();
		int i = 0;
		
		while(stop != 3)
		{
			System.out.println(stop);
			if(stop == 0)
			{
				s.nextIteration();
			}
			
		}
		
		c.save();
		
		//c.load();
		
	}
}
