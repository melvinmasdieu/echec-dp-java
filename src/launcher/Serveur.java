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
public class Serveur {

    public static void main(String[] args) {

        try {
            ServerSocket serveurSocket = new ServerSocket();
            Socket socket = serveurSocket.accept();

            ChessGame model = new ChessGame();
            ChessGameControlerServer controler = new ChessGameControlerServer(model);

            SocketIn socketIn = new SocketIn(socket);
            Thread tIn = new Thread(socketIn);
            socketIn.addObserver(controler);
            tIn.start();

            SocketOut socketOut = new SocketOut(socket);
            Thread tOut = new Thread(socketIn);
            model.addObserver(socketOut);
            tOut.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
