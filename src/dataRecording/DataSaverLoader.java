package dataRecording;

import pacman.game.util.*;

/**
 * This class uses the IO class in the PacMan framework to do the actual saving/loading of
 * training data.
 * @author andershh
 *
 */
public class DataSaverLoader {
	
	private static String FileName = "dataset.txt";
	
	public static void SavePacManData(DataTuple data)
	{
		IO.saveFile(FileName, data.getSaveString(), true);
	}
	
	public static DataTuple[] LoadPacManData()
	{
		String data = IO.loadFile(FileName);
		String[] dataLine = data.split("\n");
		DataTuple[] dataTuples = new DataTuple[dataLine.length];
		System.out.println(dataLine.length);
		for(int i = 0; i < dataLine.length; i++)
		{
			
			dataTuples[i] = new DataTuple(dataLine[i]);
		}
		
		return dataTuples;
	}
	public static DataTuple[] LoadPacManDataTraining()
	{
		String data = IO.loadFile(FileName);
		String[] dataLine = data.split("\n");
		DataTuple[] dataTuples = new DataTuple[dataLine.length-3000];
		System.out.println("tamanio de dataset de entrenamiento: " + (dataLine.length-3000));
		for(int i = 0; i <dataLine.length-3000; i++)
		{
			
			dataTuples[i] = new DataTuple(dataLine[i]);
		}
		
		return dataTuples;
	}
	public static DataTuple[] LoadPacManDataValidar()
	{
		String data = IO.loadFile(FileName);
		String[] dataLine = data.split("\n");
		DataTuple[] dataTuples = new DataTuple[dataLine.length-7000];
		System.out.println("tamanio de dataset de validacion"+(dataLine.length-7000));
		for(int i = 7000,  j=0; i <dataLine.length; i++,j++)
		{
			
			dataTuples[j] = new DataTuple(dataLine[i]);
		}
		
		return dataTuples;
	}
}
