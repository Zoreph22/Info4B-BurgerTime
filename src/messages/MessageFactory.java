package messages;

import messages.client.*;
import messages.serveur.*;

/**
 * Classe pour instancier la classe correspondant à un message
 */
public class MessageFactory {

    /**
     * Créer une instance à partir du message brut reçu du client
     *
     * @param msg Message brut reçu du client
     * @return Message correspondant au message brut
     * @throws java.lang.Exception Message inconnu
     */
    public static Message creerMessageClient(String msg) throws Exception {
        String[] args = parseMessageArgs(msg);

        switch (args[0]) {
            case "CLIENT_CONNECTED":
                return new MessageConnecte(args[1]);
            case "CLIENT_DISCONNECTED":
                return new MessageDeconnexionClient(args[1]);
            case "CLIENT_LOBBY_PLAYER_READY":
                return new MessagePret();
            case "CLIENT_PLAYER_MOVED":
                return new MessagePlayerMoved(args[1], args[2]);
            default:
                throw new Exception("Message reçu inconnu : " + msg);
        }
    }

    /**
     * Créer une instance à partir du message brut reçu du serveur
     *
     * @param msg Message brut reçu du serveur
     * @return Message correspondant au message brut
     * @throws java.lang.Exception Message inconnu
     */
    public static Message creerMessageServeur(String msg) throws Exception {
        String[] args = parseMessageArgs(msg);

        switch (args[0]) {
            case "SERVER_CLIENT_INFO":
                return new MessageInfoClient(args[1]);
            case "SERVER_DISCONNECT":
                return new MessageDeconnexion();
            case "SERVER_CLIENT_DISCONNECTED":
                return new MessageClientDeconnexion(args[1]);
            case "SERVER_LOBBY_REFRESH":
                return new MessageLobbyActualiser(args[1], args[2]);
            case "SERVER_LOAD_LEVEL":
                return new MessageEnvoyerLevel(args[1]);
            case "SERVER_SPAWN_PLAYER":
                return new MessageSpawnPlayer(args[1], args[2], args[3], args[4]);
            case "SERVER_SPAWN_ENEMY":
                return new MessageSpawnEnemy(args[1], args[2], args[3]);
            case "SERVER_PLAYER_MOVED":
                return new MessageServerPlayerMoved(args[1], args[2]);
            case "SERVER_ENEMY_MOVED":
                return new MessageEnemyMoved(args[1], args[2]);
            case "SERVER_PLAYER_DIED":
                return new MessagePlayerDied(args[1]);
            case "SERVER_LEVEL_WIN":
                return new MessageLevelWin();
            case "SERVER_LEVEL_LOSE":
                return new MessageLevelLose();
            default:
                throw new Exception("Message reçu inconnu : " + msg);
        }
    }

    /**
     * Parser les arguments du message
     *
     * @param msg Message à parser
     * @return [0] : nom du message, les autres index sont les arguments
     */
    private static String[] parseMessageArgs(String msg) {
        return msg.split("\\|");
    }
}
