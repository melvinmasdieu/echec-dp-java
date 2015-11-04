package launcher;

import controler.controlerLocal.ChessGameControler;
import model.ChessGame;
import vue.ChessGameGUI;

import javax.swing.*;


public class LauncherGUI {

	public static void main(String[] args) {
		ChessGame chessGame;
		ChessGameControler chessGameControler;

		chessGame = new ChessGame();
		chessGameControler = new ChessGameControler(chessGame);

		ChessGameGUI chessGameGUI = new ChessGameGUI(chessGameControler);
		chessGame.addObserver(chessGameGUI);
		chessGameGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		chessGameGUI.pack();
		chessGameGUI.setResizable(true);
		chessGameGUI.setLocationRelativeTo(null);
		chessGameGUI.setVisible(true);

	}
}
