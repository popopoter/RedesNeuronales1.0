package dataRecording;


import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class DataTuple {

	double distance;
	double time; 
	double strategy;
	

	public DataTuple(Game game, MOVE move) {
		//Constructor juego
	}

	public DataTuple(String data) {
		String[] dataSplit = data.split(",");
		this.distance =Double.parseDouble(dataSplit[0]);
		this.time= Double.parseDouble(dataSplit[1]);
		this.strategy= Double.parseDouble(dataSplit[2]);
		

		
	}

	public String getSaveString() {
		StringBuilder stringbuilder = new StringBuilder();

		stringbuilder.append(this.distance + ",");
		stringbuilder.append(this.time + ",");
		stringbuilder.append(this.strategy );
		

		return stringbuilder.toString();
	}

	@Override
	public String toString(){
		StringBuilder stringbuilder = new StringBuilder();

		stringbuilder.append(this.distance + ",");
		stringbuilder.append(this.time + ",");
		stringbuilder.append(this.strategy );
		

		return stringbuilder.toString();
	}
	

}
