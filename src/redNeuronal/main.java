package redNeuronal;

import java.util.*;

public class main {

	public static void main(String[] args) {
		
		RedNeuronal red= new RedNeuronal(2,1);
		ArrayList<Double> input = new ArrayList<Double>();
		//System.out.println("hola " + new Sigmoidal().activar(-5));
		input.add((double) -5);
		input.add((double) 1);
		red.BackPropagation(input);
		System.out.println("salida: ");
		for(double d: input){
			System.out.println(d);
		}
	}

}
