package redNeuronal;

import java.util.*;

public class main {

	public static void main(String[] args) {
		
		RedNeuronal red= new RedNeuronal(2,1);
		ArrayList<Double> input = new ArrayList<Double>();
		System.out.println(new Sigmoidal().activar(-5));
		input.add((double) 0);
		input.add((double) 8);
		red.forwardPropagation(input);
		
		for(double d: input){
			System.out.println(d);
		}
	}

}
