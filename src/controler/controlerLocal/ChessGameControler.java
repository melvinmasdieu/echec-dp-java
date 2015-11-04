package controler.controlerLocal;

import controler.ChessGameControlers;
import model.*;

public class ChessGameControler implements ChessGameControlers {

	private ChessGame chessGame;

	public ChessGameControler(ChessGame chessGame) {
		this.chessGame = chessGame;
	}

	@Override
	public boolean move(Coord initCoord, Coord finalCoord) {
		return this.chessGame.move(initCoord.x, initCoord.y, finalCoord.x,
				finalCoord.y);
	}

	@Override
	public String getMessage() {
		return this.chessGame.getMessage();
	}

	@Override
	public boolean isEnd() {
		return this.chessGame.isEnd();
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.chessGame.getColorCurrentPlayer();
	}
	
	public String toString() {
		return this.chessGame.toString();
	}

}
