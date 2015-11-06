package input_output;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;

/**
 * Created by melvin on 04/11/15.
 */
public class SocketIn extends Observable implements Runnable {

    private Socket socket;
    private Object message;

    public SocketIn(Socket socket) {
        this.socket = socket;
    }

    public void run() {


        try {
            ObjectInputStream in = null;
            in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                try {
                    message = in.readObject();  // objet génerique qui sera casté en fonction de si on est dans le client ou le serveur
                    setChanged();
                    notifyObservers(message);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
