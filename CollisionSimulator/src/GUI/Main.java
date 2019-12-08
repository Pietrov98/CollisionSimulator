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
	
	public static void main(String[] args) throws FileNotFoundException
	{
	
		JFrame window = new JFrame();
		Surface surface= new Surface();
		Caretaker caretaker = new Caretaker(surface);
		Context context = new Context();
		UserInterface UI = new UserInterface(context, caretaker);
		
        surface.setSize(400, 400);
        surface.setBackground(Color.LIGHT_GRAY);
		window.add(surface, BorderLayout.CENTER);
		window.add(UI, BorderLayout.SOUTH);
		window.setSize(410, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
