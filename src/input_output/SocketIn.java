package input_output;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;

/**
 * Created by melvin on 04/11/15.
 */
public class SocketIn extends Observable implements Runnable  {

    private Socket socket;
    private Object message;

    public SocketIn(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        while (true) {

            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(socket.getInputStream());
                message = in.readObject();  // objet génerique qui sera casté en fonction de si on est dans le client ou le serveur
                in.close();
                setChanged();
                notifyObservers(message);
            }

            catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
