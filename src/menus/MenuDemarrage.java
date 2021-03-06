package menus;

import utils.RawConsoleInput;
import java.util.Scanner;

/**
 * Menu de démarrage du jeu
 */
public class MenuDemarrage {

    /**
     * Afficher le menu de démarrage
     */
    public void showMenu() {
        RawConsoleInput.clear();
        RawConsoleInput.println("Burger Time");
        RawConsoleInput.println();
        RawConsoleInput.println("Saisir le numéro du choix que vous souhaitez :");
        RawConsoleInput.println("1. Démarrer un serveur de jeu");
        RawConsoleInput.println("2. Rejoindre un serveur de jeu");
    }

    /**
     * Retourner le choix de l'utilisateur
     *
     * @return Numéro choix
     */
    public int getChoix() {
        Scanner scanner = new Scanner(System.in);

        this.showMenu();

        String choix = scanner.nextLine();
        while (!choix.equals("1") && !choix.equals("2")) {
            showMenu();
            choix = scanner.nextLine();
        }

        return Integer.valueOf(choix);
    }

}
