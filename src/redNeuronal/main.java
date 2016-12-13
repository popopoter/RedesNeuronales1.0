package redNeuronal;

import java.util.*;

import dataRecording.DataSaverLoader;
import dataRecording.DataTuple;

public class main {

	public static void main(String[] args) {
		
		RedNeuronal red= new RedNeuronal(2,1);
		DataTuple[] tuples = DataSaverLoader.LoadPacManDataTraining();
		//System.out.println("hola " + new Sigmoidal().activar(-5));
		double salidaO;
		double target;
		int aciertos=0;
		int contador=0;
		red.BackPropagation(tuples);
		ArrayList<Double> peso=new ArrayList<Double>();
		DataTuple[] tuples2 = DataSaverLoader.LoadPacManDataValidar();
		for (DataTuple d : tuples2) {
			for(int i=0; i<red.getPesos().size();i++)
				peso.add(red.getPesos().get(i));
			ArrayList<Double> pesoBias=new ArrayList<Double>();
			for(int i=0; i<red.getPesosBias().size();i++)
				pesoBias.add(red.getPesosBias().get(i));
			
			target=d.getStrategy();
			ArrayList<Double> input=d.toInput();
			red.forwardPropagation(input, peso, pesoBias);
			salidaO=input.get(0);
			if((target<0.33 && salidaO < 0.33)||((target<0.66 && salidaO < 0.66)&&(target>0.33 && salidaO > 0.33)) || (target>0.66 && salidaO > 0.66))
			{
			aciertos++;	
			}
			contador++;
			}
		System.out.println("numero de aciertos : " + aciertos + "/"+ contador);
		}
		
	}


