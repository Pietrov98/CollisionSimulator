package Moveable;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
		this.moveables = loader.loadData();
		surface.setMoveables(new ArrayList<Moveable>());
		for(int i = 0; i < this.moveables.size(); i++)
		{
			Vector2D pos = new Vector2D();
			pos.setVx(this.moveables.get(i).getPostion().getVx());
			pos.setVy(this.moveables.get(i).getPostion().getVy());
			
			Vector2D vel = new Vector2D();
			vel.setVx(this.moveables.get(i).getVelocity().getVx());
			vel.setVy(this.moveables.get(i).getVelocity().getVy());
			surface.addMoveable(pos, vel);
		}
	}
	
}
