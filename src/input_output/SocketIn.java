package input_output;

import java.net.Socket;
import java.util.Observable;

/**
 * Created by melvin on 04/11/15.
 */
public class SocketIn extends Observable implements Runnable  {

    private Socket socket;

    public SocketIn(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        while (true) {


        }
    }
}
