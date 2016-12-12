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

	public void forwardPropagation(ArrayList<Double> input, ArrayList<Double> pesos){
		salidas = new ArrayList<Double>();
		
	ArrayList <Double> aux = new ArrayList<Double>();
	int j=0;
	
		for(Capa capa: capas){
			int i=0;
			
			for(Neurona ne: capa.neuronas){
				
				aux.add(ne.activar(input, pesos));
				
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
		
		//inicializo todos los pesos a pelo
		peso= new ArrayList<Double>();
		for(int i=0;i<15;i++)
		{
			if(i%2 !=0)
				peso.add(-1.0 );
			else
				peso.add(1.0);
		}
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
			input.clear();
			input.add(in1);
			input.add(in2);
			
			ArrayList<Double> pesoAux= new ArrayList<Double>();
			for(int i=0; i<peso.size();i++)
			{
				pesoAux.add(peso.get(i));
			}
			
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
			System.out.println();

			System.out.println("pesos antes de cambiar: ");
			for(int i =0; i<peso.size();i++)
				System.out.println(peso.get(i));
			
			forwardPropagation(input,peso);
			
			salidaO=input.get(0);
			
			System.out.println("salida nueva: "+ salidaO);
			errorO= salidaO*(1-salidaO)*(target-salidaO);
			for(int i=0; i<varHO.size() ;i++)
			{
				varHO.set(i,varHO.get(i) + aprendizaje*errorO*salidas.get(i));
			}

			for(int i=0; i<5;i++){
				sumatorio += errorO*pesoAux.get(i+10);
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
			
		
			for(int i=0; i<pesoAux.size();i++){
				if(i<10)
					peso.add(pesoAux.get(i)+varIH.get(i));
				else
					peso.add( pesoAux.get(i)+varHO.get(i-10));

			}
			System.out.println();
			System.out.println("pesos despues de cambiar: ");
			for(int i =0; i<peso.size();i++)
				System.out.println(peso.get(i));
			
			
			
			parada++;
			//actualizar la lista de pesos con sus nuevos valores
		}while(parada<30);//condicion de parada para probar


	}
	
	}