package model;

import java.util.Observable;
import java.util.Observer;


public class ChessGame extends Observable {

	private Echiquier echiquier;
	
	public ChessGame() {
		this.echiquier = new Echiquier();
	}

	@Override
	public void addObserver(Observer o) {   // Surcharge de la fonction addObserver afin de faire un update au début
		super.addObserver(o);
		this.setChanged();
		this.notifyObservers(this.echiquier.getPiecesIHM());
	}

	@Override
	public String toString() {
		return this.getMessage() + this.echiquier.toString();
	}

	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean move = false;
		if (this.echiquier.isMoveOk(xInit, yInit, xFinal, yFinal)) { // test si le déplacement est possible
			if (this.echiquier.move(xInit, yInit, xFinal, yFinal)) { // si oui
				this.echiquier.switchJoueur();  // change de joueur courant
				move = true;
			}
		}
		this.setChanged();
		this.notifyObservers(this.echiquier.getPiecesIHM()); // update de l'échiquier
		System.out.println(this.getMessage());  // affichage du message dans la console
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

}
