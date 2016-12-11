package redNeuronal;

import java.util.*;

public class Neurona {
	
	public int numEntradas;
	
	public ArrayList<Double> pesos;

	
	
	
	public double VIASPeso = 1;
	
	FuncionActivacion activador;
	
//Constructor con un activador por defecto(Sigmoidal)
	


public Neurona(int nEntradas){
	
	
	
	pesos = new ArrayList<Double>();
	for(int i =0;i<nEntradas;i++){
		
		if((i%2)!=0){
			pesos.add((double)-1);
		}
		else{
			pesos.add((double)1);
		}		
	}
	activador = new Sigmoidal();
}

public void setActivador(FuncionActivacion activador) {
	this.activador = activador;
}


public double activar(ArrayList<Double> entradas){
		
	double acumulador = 0;

	//no pasa nunca por este for porque el arraylist de pesos esta vacío
	//y cuando lo inicializo me sale una excepcion to guapa :/
	for(int i = 0; i<pesos.size();i++){
		acumulador += pesos.get(i)* entradas.get(i);
	
	}
		//Contamos con el vias
	acumulador+= 1.0*VIASPeso;
	System.out.println(acumulador);
	return activador.activar(acumulador);
		
		}
	
}