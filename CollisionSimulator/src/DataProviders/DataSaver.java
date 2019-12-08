package DataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import GUI.DataDisplayer;
import Moveable.MoveableData;

public class DataSaver {
	private String filename = "results.txt";
	
	public void saveData(List<MoveableData> moveables) throws FileNotFoundException
	{
		File file = new File(filename);
		PrintWriter write = new PrintWriter(filename);
		for(int i = 0; i < moveables.size(); i++)
		{
			write.print(moveables.get(i).getPostion().getVx() + " " + moveables.get(i).getPostion().getVy() 
					+ " " + moveables.get(i).getVelocity().getVx() + " " + moveables.get(i).getVelocity().getVy());
			write.println(" " + moveables.get(i).getColor().getRed() + " " + moveables.get(i).getColor().getGreen() + " " + moveables.get(i).getColor().getBlue());
		}
		DataDisplayer.displayData(moveables);
		write.close();
	}
}
