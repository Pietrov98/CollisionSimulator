package Moveable;

import java.io.FileNotFoundException;
import java.util.List;

import DataProviders.DataLoader;
import DataProviders.DataSaver;
import Surface.Surface;

public class Caretaker {
	private List<MoveableData> moveables;
	private Surface surface = new Surface();
	private DataLoader loader = new DataLoader();
	private DataSaver saver = new DataSaver();
	
	public Caretaker(Surface surface)
	{
		this.surface = surface;
	}
	
	public void save() throws FileNotFoundException
	{
		this.moveables = surface.saveMementos();
		//zapisanie do pliku listy
		saver.saveData(moveables);
	}
	
	public void load()
	{
		//odczytanie z pliku listy
		loader.loadData();
		for(int i = 0; i < moveables.size(); i++)
		{
			System.out.println(moveables.get(i).getPostion().getVx() + " " + moveables.get(i).getPostion().getVy() 
					+ " " + moveables.get(i).getVelocity().getVx() + " " + moveables.get(i).getVelocity().getVy());
		}
	}
	
}
