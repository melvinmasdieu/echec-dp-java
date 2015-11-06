package launcher;

import controler.controlerResau.ChessGameControlerServer;
import model.ChessGame;
import input_output.SocketIn;
import input_output.SocketOut;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by melvin on 04/11/15.
 */
public class Serveur implements Runnable{

    public Serveur() {

        try {
            ServerSocket serveurSocket = new ServerSocket(2009);
            ChessGame model = new ChessGame();
            ChessGameControlerServer controler = new ChessGameControlerServer(model);

            while (true) {
                Socket socket = serveurSocket.accept();

                controler.addClient(clientName);

                SocketOut socketOut = new SocketOut(socket);
                Thread tOut = new Thread(socketOut);
                model.addObserver(socketOut);
                tOut.start();

                SocketIn socketIn = new SocketIn(socket);
                Thread tIn = new Thread(socketIn);
                socketIn.addObserver(controler);
                tIn.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {}
}

