package model;

import java.util.Observable;
import java.util.List;


public class ChessGame extends Observable {

	private Echiquier echiquier;
	
	public ChessGame() {
		this.echiquier = new Echiquier();
	}

	public void init() {
		this.setChanged();
		this.notifyObservers(this);
	}

	@Override
	public String toString() {
		return this.getMessage() + this.echiquier.toString();
	}

	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean move = false;
		if (this.echiquier.isMoveOk(xInit, yInit, xFinal, yFinal)) {
			if (this.echiquier.move(xInit, yInit, xFinal, yFinal)) {
				this.echiquier.switchJoueur();
				move = true;
			}
		}
		this.setChanged();
		this.notifyObservers(this);
		System.out.println(this.getMessage());
		return move;
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

	public List<PieceIHM> getPiecesIHM() {
		return this.echiquier.getPiecesIHM();
	}
}
