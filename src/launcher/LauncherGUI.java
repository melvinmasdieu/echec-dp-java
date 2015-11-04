package launcher;

import controler.controlerLocal.ChessGameControler;
import model.ChessGame;
import vue.ChessGameGUI;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class LauncherGUI {

	public static void main(String[] args) {
		try {
			System.out.println((new File("")).getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ChessGame chessGame;
		ChessGameControler chessGameControler;

		chessGame = new ChessGame();
		chessGameControler = new ChessGameControler(chessGame);

		ChessGameGUI chessGameGUI = new ChessGameGUI(chessGameControler);
		chessGame.addObserver(chessGameGUI);
		chessGame.init();
		chessGameGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		chessGameGUI.pack();
		chessGameGUI.setResizable(true);
		chessGameGUI.setLocationRelativeTo(null);
		chessGameGUI.setVisible(true);

	}
}
