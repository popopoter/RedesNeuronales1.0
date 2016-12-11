package pacman;

import dataRecording.DataSaverLoader;
import dataRecording.DataTuple;
import pacman.game.util.IO;

public class DataTester {

	
	public static void main(String... args) {
		
		DataTuple[] tuples = DataSaverLoader.LoadPacManData();
		
		for (DataTuple d : tuples) {
			System.out.println(d);

	}


	}
	
}

