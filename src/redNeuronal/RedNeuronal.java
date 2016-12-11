package redNeuronal;

import java.util.ArrayList;

public class RedNeuronal {
	
	private int nEntradas,nSalidas,nNeuronasOcultas;
	private int nCapasOcultas = 1;
	public ArrayList<Capa> capas;
	//public ArrayList <Double> input;
	//public ArrayList <Double> output;
	
	
	
	
	public RedNeuronal(int nEntradas, int nSalidas){
		
		
		capas = new ArrayList<Capa>();
		nNeuronasOcultas = Kolgomorov(nEntradas);
		
		
		this.nEntradas = nEntradas;
		this.nSalidas = nSalidas;
		
		
		
		
		//Iniazalizamos el array con las capas
		//capas = new ArrayList<Neurona[]>(nCapas);
		
		//Primera capa: numero de entradas = numero de neuronas  que no hace nada solo propaga para alante
		//capas.add(new Neurona[nEntradas]);
		//Segunda capa de nNeuronasOcultas
		//Se crean todas la neuronas por capa || Neuronas ocultas = 2*entradas+ 1
		
		Capa capa;
		/*
		capa = new Capa(nEntradas,1);
		for(Neurona neuro: capa.neuronas){
			
			neuro.setActivador(new Trivial());
		}
		capas.add(capa);
		*/
		capa = new Capa(nNeuronasOcultas,nEntradas);
		capas.add(capa);
		capa = new Capa(nSalidas,nNeuronasOcultas);
		capas.add(capa);
		/*
		capas.add(capa);
		System.out.println("capa de entrada: ");
		forwardPropagation(input,capa);
		
		
		capa = new Capa(nNeuronasOcultas,nEntradas);
		capas.add(capa);
		System.out.println("capa oculta: ");
		forwardPropagation(output,capa);// esto se puede hacer recursivo mas guay pero de momento asi vale 
		
		
		capa = new Capa(nSalidas,nNeuronasOcultas);
		capas.add(capa);
		System.out.println("capa de salida: ");
		forwardPropagation(output,capa);
		
		//Cada neurona se conecta con la de la capaSiguiente
		 */
		
		
	}	
	
	public int Kolgomorov(int nEntradas){
		
		return nEntradas*2+1;
	}

	public void forwardPropagation(ArrayList<Double> input){
		
	ArrayList <Double> aux = new ArrayList<Double>();
		for(Capa capa: capas){
			
			for(Neurona ne: capa.neuronas){
				aux.add(ne.activar(input));
			}
			input.clear();
			input.addAll(aux);
			aux.clear();
			
		}
		
		}
		
	}

