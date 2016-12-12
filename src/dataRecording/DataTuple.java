package dataRecording;


import java.util.ArrayList;

import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class DataTuple {
	static int maxDistance = 150;
	static int maxTime = 200;
	
	double distance;
	double time; 
	double strategy;
	

	public DataTuple(Game game, MOVE move) {
		//Constructor juego
		distance = normalizeDistance(game.getDistanceToClosestGhost());
		time = normalizeTime(game.getGhostEdibleTime(game.getClosestGhost()));
		
		
		
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
	public ArrayList<Double> toInput(){
		ArrayList<Double> list = new ArrayList<Double>();

		list.add(distance);
		list.add(time);
		return list;
	}
	
	public double normalizeDistance(int dist) {
		return ((dist - 0) / (double) (this.maxDistance - 0)) * (1 - 0) + 0;
	}
	public double normalizeTime(int time) {
		return ((time - 0) / (double) (this.maxTime - 0)) * (1 - 0) + 0;
	}

	public void setStrategy(double strategy) {
		// TODO Auto-generated method stub
		this.strategy = strategy;
		
	}
	public double getStrategy(){
		
		return strategy;
	}
}
