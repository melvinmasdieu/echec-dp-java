package launcher;


import controler.controlerLocal.ChessGameControler;
import input_output.SocketIn;
import input_output.SocketOut;
import model.ChessGame;
import vue.ChessGameGUI;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



/**
 * Created by melvin on 04/11/15.
 */
public class Client {
    public static Socket socket = null;
    public static Thread t1,t2;



    public static void main(String[] args) {

        try {

            System.out.println("Demande de connexion au serveur");
            socket = new Socket("127.0.0.1",2009);
            System.out.println("Connexion établie avec le serveur, authentification :"); // Si le message s'affiche c'est que je suis connecté

            ChessGame chessGame = new ChessGame();
            ChessGameControler clientControler = new ChessGameControler(chessGame);


            ChessGameGUI chessGameGUI = new ChessGameGUI(clientControler);

            SocketIn socketIn = new SocketIn(socket);
            SocketOut socketOut = new SocketOut(socket);

            t1 = new Thread(socketOut);   // thread d'émission
            t1.start();
            t2 = new Thread(socketIn);    // thread de réception
            t2.start();

            //chessGameGUI.addObserver(socketOut); à résoudre (peut pas extend 2 trucs -> gui pas observable)
            socketIn.addObserver(chessGameGUI);

        } catch (UnknownHostException e) {
            System.err.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
        } catch (IOException e) {
            System.err.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
        }



    }
}
