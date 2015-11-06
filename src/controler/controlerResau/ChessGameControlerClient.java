package controler.controlerResau;

import controler.ChessGameControlers;
import model.ChessGame;
import model.Coord;
import model.Couleur;

import java.util.*;

/**
 * Created by Thomas on 05/11/2015.
 */
public class ChessGameControlerClient extends Observable implements ChessGameControlers {


    @Override
    public boolean move(Coord initCoord, Coord finalCoord) {
        List<Coord> envoiCoord = new ArrayList();
        envoiCoord.add(initCoord);
        envoiCoord.add(finalCoord);
        setChanged();
        notifyObservers(envoiCoord);
        return true;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isEnd() {
        return false;
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        return null;
    }


}