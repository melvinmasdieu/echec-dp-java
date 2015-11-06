package input_output;


import model.Coord;
import vue.ChessGameGUI;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by melvin on 04/11/15.
 */

public class SocketOut implements Runnable, Observer {

    private Socket socket;
    private Object message;

    public SocketOut(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void update(Observable o, Object obs) {

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();

            message = obs;
            out.writeObject(message);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {


    }
}
