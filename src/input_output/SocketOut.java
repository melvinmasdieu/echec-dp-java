package input_output;


import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by melvin on 04/11/15.
 */

public class SocketOut implements Runnable, Observer {

    private Socket socket;

    public SocketOut(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void update(Observable o, Object obs) {

    }

    public void run() {
        while (true) {

        }
    }

}
