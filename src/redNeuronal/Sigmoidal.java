package redNeuronal;

public class Sigmoidal extends FuncionActivacion {

	@Override
	public double activar(double x) {
		
			
			return (1/(Math.pow(Math.E, x*-1)+1));
			
			
	}

}
