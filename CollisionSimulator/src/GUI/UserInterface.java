package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Moveable.Caretaker;
import State.Context;

public class UserInterface {
	public void displayUI(Caretaker c, Context context)
	{
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
	    JButton saveButton = new JButton("Zapisz");
	    saveButton.setBounds(250,150,80,30);
	    JButton loadButton = new JButton("Wczytaj");
	    loadButton.setBounds(250,200,80,30);
	    
	    stopButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		//stop = 1; 
	    		context.Request(1);
	    	}}); 
	    startButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		//stop = 0; 
	    		context.Request(0);
	    	}}); 
	    
	    exitButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		//stop = 2; 
	    		context.Request(2);
	    	}}); 
	    saveButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		try {
					c.save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}}); 
	    loadButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		c.load();
	    	}}); 
	    window.add(stopButton);
	    window.add(startButton);
	    window.add(exitButton);
	    window.add(saveButton);
	    window.add(loadButton);
	    
	}
}
