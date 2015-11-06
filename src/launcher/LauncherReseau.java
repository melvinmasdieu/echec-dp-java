package launcher;

/**
 * Created by Thomas on 06/11/2015.
 */
public class LauncherReseau {
    public static Thread t1,t2,t3;

    public static void main(String[] args) {
        Serveur serveur = new Serveur();
        Client client1 = new Client("Client1");
        Client client2 = new Client("Client1");
        t1 = new Thread(serveur);
        t1.start();
        t2 = new Thread(client1);
        t2.start();
        t3 = new Thread(client2);
        t2.start();

    }
}
