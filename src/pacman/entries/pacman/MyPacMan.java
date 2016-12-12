package pacman.entries.pacman;

import java.util.ArrayList;

import dataRecording.DataTuple;
import pacman.controllers.Controller;
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
		input = tuple.toInput();
		red.forwardPropagation(input);
		tuple.setStrategy(input.get(0));
		return myMove;
	}
}