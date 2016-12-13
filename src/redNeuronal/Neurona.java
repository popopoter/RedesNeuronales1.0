package redNeuronal;

import java.util.*;

public class Neurona {
	
	public int numEntradas;
	
	public ArrayList<Double> pesos;

	
	
	
	public double BIASPeso = 1;
	
	FuncionActivacion activador;
	
//Constructor con un activador por defecto(Sigmoidal)
	


public Neurona(int nEntradas){
	
	
	numEntradas=nEntradas;
	activador = new Sigmoidal();
}

public void setActivador(FuncionActivacion activador) {
	this.activador = activador;
}


public double activar(ArrayList<Double> entradas,ArrayList<Double> peso,ArrayList<Double> pBias){
		
	double acumulador = 0;

	//no pasa nunca por este for porque el arraylist de pesos esta vac�o
	//y cuando lo inicializo me sale una excepcion to guapa :/
	for(int i = 0; i<numEntradas;i++){
		acumulador += peso.get(0)* entradas.get(i);
		peso.remove(0);
	
	}
		//Contamos con el vias
	acumulador+= 1.0*pBias.get(0);
	//pBias.remove(0);
	//System.out.println(acumulador);
	return activador.activar(acumulador);
		
		}
	
}