package controler.controlerResau;

import controler.ChessGameControlers;
import model.ChessGame;
import model.Coord;
import model.Couleur;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by melvin on 04/11/15.
 */
public class ChessGameControlerServer implements ChessGameControlers, Observer {

    private ChessGame chessGame;
    private String clientName;

    public ChessGameControlerServer(ChessGame chessGame) {
        this.chessGame = chessGame;
    }
    
    public void addClient(String name) {
        this.clientName = name;
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

    @Override
    public String toString() {
        return this.chessGame.toString();
    }

    @Override
    public void update(Observable o, Object obj) {
        List<Coord> listCoord = (List<Coord>) obj;
        if (this.clientName == "Client1" && this.getColorCurrentPlayer() == Couleur.BLANC) {
            this.move(listCoord.get(0), listCoord.get(1));
        } else if (this.clientName == "Client2" && this.getColorCurrentPlayer() == Couleur.NOIR) {
            this.move(listCoord.get(0), listCoord.get(1));
        } else {
            this.move(listCoord.get(0), listCoord.get(0));
        }
    }
}

