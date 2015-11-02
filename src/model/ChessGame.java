package model;

import java.util.Observable;

public class ChessGame extends Observable {

	private Echiquier echiquier;
	
	public ChessGame() {
		this.echiquier = new Echiquier();
	}

	@Override
	public String toString() {
		return this.getMessage() + this.echiquier.toString();
	}

	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if (this.echiquier.isMoveOk(xInit, yInit, xFinal, yFinal)) {
			if (this.echiquier.move(xInit, yInit, xFinal, yFinal)) {
				this.echiquier.switchJoueur();
				setChanged();
			    notifyObservers();
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean isEnd() {
		return this.echiquier.isEnd();
	}

	public String getMessage() {
		return this.echiquier.getMessage();
	}

	public Couleur getColorCurrentPlayer() {
		return this.echiquier.getColorCurrentPlayer();
	}

}
