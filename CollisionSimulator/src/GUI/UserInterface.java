package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Moveable.Caretaker;
import State.Context;
import Surface.Surface;

public class UserInterface extends JPanel{
	JButton stopButton = new JButton("Stop");
	JButton startButton = new JButton("Start");
	JButton exitButton = new JButton("Koniec");
	JButton saveButton = new JButton("Zapisz");
	JButton loadButton = new JButton("Wczytaj");
	public UserInterface(Context context, Caretaker caretaker)
	{
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
	    			caretaker.save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}}); 
	    loadButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e)
	    	{  
	    		caretaker.load();
	    	}}); 
	    this.add(stopButton, BOTTOM_ALIGNMENT);
	    this.add(startButton, BOTTOM_ALIGNMENT);
	    this.add(exitButton, BOTTOM_ALIGNMENT);
	    this.add(saveButton, BOTTOM_ALIGNMENT);
	    this.add(loadButton, BOTTOM_ALIGNMENT);
	    
	}
}
