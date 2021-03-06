package menus;

import client.ClientSocket;
import utils.RawConsoleInput;
import java.io.IOException;
import java.util.Scanner;

/**
 * Menu du lobby pour rejoindre un serveur
 */
public class MenuLobby {

    /**
     * Afficher le menu de lobby
     */
    public void showMenu() {
        RawConsoleInput.clear();
        RawConsoleInput.println("Lobby, rejoindre un serveur");
        RawConsoleInput.println();
        RawConsoleInput.println("Saisir l'IP du serveur :");
    }

    /**
     * Retourner l'IP saisie
     *
     * @return IP serveur
     */
    public String getIp() {
        Scanner scanner = new Scanner(System.in);

        this.showMenu();

        String ip = scanner.nextLine();
        while (ip.isEmpty()) {
            showMenu();
            ip = scanner.nextLine();
        }

        return ip;
    }

    /**
     * Démarrer la connexion avec le serveur
     *
     * @return Connexion au serveur
     */
    public ClientSocket startClient() {
        boolean ok = false;
        ClientSocket socket = ClientSocket.getInstance();

        while (!ok) {
            RawConsoleInput.clear();
            String ip = this.getIp();

            try {
                RawConsoleInput.clear();
                RawConsoleInput.println("Connexion au serveur " + ip + "...");
                socket.connecter(ip);
                ok = true;
            } catch (IOException ex) {
                RawConsoleInput.println("Erreur de connexion, réessayez.");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex1) {
                }
            }
        }

        return socket;
    }
}
