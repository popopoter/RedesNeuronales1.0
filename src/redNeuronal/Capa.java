package redNeuronal;

import java.util.ArrayList;

public class Capa {
	
	ArrayList<Neurona> neuronas;
	ArrayList<Double> input;
	ArrayList <Double> output;
	
	int nNeuronas;
	
	public Capa(int nNeuronas,int nNeuronasAnterior){
		
		neuronas = new ArrayList<Neurona>();
		input = new ArrayList<Double>();
		output = new ArrayList<Double>();
	
		this.nNeuronas = nNeuronas;
		
		
		
		for(int i = 0; i<nNeuronas;i++){
			
			 neuronas.add(new Neurona(nNeuronasAnterior));
			
			
		}
		
		
	}
	

}
