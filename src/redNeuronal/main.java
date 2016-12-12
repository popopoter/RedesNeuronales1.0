package redNeuronal;

import java.util.*;

import dataRecording.DataSaverLoader;
import dataRecording.DataTuple;

public class main {

	public static void main(String[] args) {
		
		RedNeuronal red= new RedNeuronal(2,1);
		DataTuple[] tuples = DataSaverLoader.LoadPacManData();
		//System.out.println("hola " + new Sigmoidal().activar(-5));
		
		red.BackPropagation(tuples);
		
	}

}
