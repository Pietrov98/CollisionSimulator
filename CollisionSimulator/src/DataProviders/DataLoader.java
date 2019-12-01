package DataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import Moveable.MoveableData;
import Moveable.Vector2D;

public class DataLoader {
	private String filename;
	
	public List<MoveableData> loadData()
	{
		List<MoveableData> moveable_helper = new ArrayList<MoveableData>();
		int arr[] = new int[4];
		File file = new File("results.txt");
        Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println();
        String read;
		while(in.hasNext())
		{
			MoveableData obj = new MoveableData();
			Vector2D pos = new Vector2D();
			Vector2D vel = new Vector2D();
			for(int i = 0; i < 4; i++)
			{
				read = in.next();
				arr[i] = Integer.parseInt(read.substring(0, read.indexOf('.')));
			}
			pos.setVx(arr[0]);
			pos.setVy(arr[1]);
			vel.setVx(arr[2]);
			vel.setVy(arr[3]);
			obj.setPosition(pos);
			obj.setVelocity(vel);
			moveable_helper.add(obj);
		}
		
		return moveable_helper;
		
	}
}
