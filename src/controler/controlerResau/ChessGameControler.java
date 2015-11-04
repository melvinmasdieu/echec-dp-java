package controler.controlerResau;

import controler.ChessGameControlers;
import model.Coord;
import model.Couleur;

/**
 * Created by melvin on 04/11/15.
 */
public class ChessGameControler implements ChessGameControlers {

    @Override
    public boolean move(Coord initCoord, Coord finalCoord) {
        return false;
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
