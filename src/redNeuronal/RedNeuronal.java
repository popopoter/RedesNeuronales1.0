package redNeuronal;

import java.util.ArrayList;

public class RedNeuronal {
	
	private int nEntradas,nSalidas,nNeuronasOcultas;
	private int nCapasOcultas = 1;
	public ArrayList<Capa> capas;
	//public ArrayList <Double> input;
	//public ArrayList <Double> output;
	
	public ArrayList <Double> salidas;
	public ArrayList<Double> peso;
	
	
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
		salidas = new ArrayList<Double>();
		peso = new ArrayList<Double>();
	ArrayList <Double> aux = new ArrayList<Double>();
	int j=0;
	
		for(Capa capa: capas){
			int i=0;
			
			for(Neurona ne: capa.neuronas){
				for(int k=0; k< ne.pesos.size();k++)
				{
					peso.add(ne.pesos.get(k));	
				}
				aux.add(ne.activar(input));
				
					salidas.add(aux.get(i));
					
				
				
				i++;
				j++;
			}
			input.clear();
			input.addAll(aux);
			aux.clear();
			
		}
	
		
		}
	public void BackPropagation(ArrayList<Double> input){
		
		//objetivo que se busca
		double target=0.5;
		
		int parada=0;//contador para la parada de prueba
		//salida de la red neuronal
		double salidaO;
		double in1= input.get(0);
		double in2= input.get(1);
		
		ArrayList<Double> aux = new ArrayList<Double>();
		aux.add(in1);
		aux.add(in2);
		
		//variacion de pesos de las entradas a cada una de las neuronas de la capa oculta
		ArrayList<Double> varIH= new ArrayList<Double>();
		for(int i=0; i<10;i++)
		{
			varIH.add(0.0);
		}
	
		
		//variacion de pesos de las neuronas ocultas a la capa de salida
		ArrayList<Double> varHO= new ArrayList<Double>();
		for(int i=0; i<5;i++)
		{
			varHO.add(0.0);
		}
	
		
		do{
			ArrayList<Double> aux2 = new ArrayList<Double>();
			aux2.add(in1);
			aux2.add(in2);
			
			//error de la salida de las neuronas de la capa oculta
			ArrayList<Double> errorH= new ArrayList<Double>();
			for(int i=0; i<5;i++)
			{
				errorH.add(0.0);
			}
			
			
			//error de la salida 
			double errorO;
			
			//sumatorio del error de la salida por los pesos de cada uno de los pesos de la capa oculta
			double sumatorio=0;
			
			//constante de aprendizaje
			double aprendizaje=0.5;
			
			forwardPropagation(aux2);
			salidaO=aux.get(0);
			errorO= salidaO*(1-salidaO)*(target-salidaO);
			for(int i=0; i<varHO.size() ;i++)
			{
				varHO.set(i,varHO.get(i) + aprendizaje*errorO*salidas.get(i));
			}

			for(int i=0; i<5;i++){
				sumatorio += errorO*peso.get(i+10);
			}
			
			for(int i=0; i<errorH.size();i++)
			{
				errorH.set(i, salidas.get(i)*(1-salidas.get(i))*sumatorio);
			}

		

			for(int i=0; i<varIH.size();i++)
			{
					if((i%2)==0){
						if(i>=5)
						varIH.set(i,varIH.get(i)+aprendizaje*errorH.get(i-5)*aux.get(0));
						else
							varIH.set(i,varIH.get(i)+aprendizaje*errorH.get(i)*aux.get(0));
					}
					else{
						if(i>=5)
							varIH.set(i,varIH.get(i)+aprendizaje*errorH.get(i-5)*aux.get(1));
							else
								varIH.set(i,varIH.get(i)+aprendizaje*errorH.get(i)*aux.get(1));
					}	
			}
			
		

			System.out.println("pesos antes de cambiar: ");
			for(int i =0; i<peso.size();i++)
				System.out.println(peso.get(i));
			
			for(int i=0; i<peso.size();i++){
				if(i<10)
					peso.set(i, peso.get(i)+varIH.get(i));
				else
					peso.set(i, peso.get(i)+varHO.get(i-10));

			}
			System.out.println("pesos despues de cambiar: ");
			for(int i =0; i<peso.size();i++)
				System.out.println(peso.get(i));
			aux2.clear();
			
			
			parada++;
			//actualizar la lista de pesos con sus nuevos valores
		}while(parada<5);//condicion de parada para probar


	}
	
	}