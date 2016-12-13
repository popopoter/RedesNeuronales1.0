package pacman.entries.pacman;

import java.util.ArrayList;

import dataRecording.DataSaverLoader;
import dataRecording.DataTuple;
import pacman.controllers.Controller;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import redNeuronal.RedNeuronal;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	private MOVE myMove=MOVE.NEUTRAL;
	RedNeuronal red = new RedNeuronal(2,1);
	//Entrenar
	
	public MOVE getMove(Game game, long timeDue) 
	{
		ArrayList<Double> input;
		DataTuple tuple = new DataTuple(game, myMove);
		ArrayList<Double> peso=new ArrayList<Double>();
		for(int i=0; i<red.getPesos().size();i++)
			peso.add(red.getPesos().get(i));
		ArrayList<Double> pesoBias=new ArrayList<Double>();
		for(int i=0; i<red.getPesosBias().size();i++)
			pesoBias.add(red.getPesosBias().get(i));
		
		input = tuple.toInput();
		red.forwardPropagation(input,peso,pesoBias);
		double strategy = input.get(0);
		tuple.setStrategy(strategy);
		return myMove;
	}
	public MOVE getStrategy(double a,Game game){
		int current=game.getPacmanCurrentNodeIndex();

		if(a > 0.66){
			return  game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(game.getClosestGhost()),DM.PATH);
		}
		if(a> 0.33){
			int[] pills=game.getPillIndices();
			int[] powerPills=game.getPowerPillIndices();		
			
			ArrayList<Integer> targets=new ArrayList<Integer>();
			
			for(int i=0;i<pills.length;i++)					//check which pills are available			
				if(game.isPillStillAvailable(i))
					targets.add(pills[i]);
			
			for(int i=0;i<powerPills.length;i++)			//check with power pills are available
				if(game.isPowerPillStillAvailable(i))
					targets.add(powerPills[i]);				
			
			int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
			
			for(int i=0;i<targetsArray.length;i++)
				targetsArray[i]=targets.get(i);
			
			//return the next direction once the closest target has been identified
			return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
		}
		
		return game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(game.getClosestGhost()),DM.PATH);
		
		
	}
}