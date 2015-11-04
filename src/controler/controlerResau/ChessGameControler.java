package controler.controlerResau;

import controler.ChessGameControlers;
import model.ChessGame;
import model.Coord;
import model.Couleur;
import java.io.IOException;
import java.net.*;

/**
 * Created by melvin on 04/11/15.
 */
public class ChessGameControler implements ChessGameControlers, Runnable {

    private ChessGame chessGame;
    private ServerSocket socketserver;
    private Socket socket;
    private int nbrclient = 1;

    public ChessGameControler(ChessGame chessGame, ServerSocket s) {
        this.chessGame = chessGame;
        socketserver = s;
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

    public void run() {
        try {
            while (true) {
                socket = socketserver.accept(); // Un client se connecte on l'accepte
                System.out.println("Le client numéro " + nbrclient + " est connecté !");
                nbrclient++;
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

