/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_cordier_danjou;

/**
 *
 * @author Nina
 */
public class SP4_console_CORDIER_DANJOU {

    /**
     * @param args the command line arguments
     */
    public static void fmain(String[] args) {
        // TODO code application logic here
        Joueur J1 = new Joueur("Nina");
        Joueur J2 = new Joueur("Matthieu");
        
        Partie game = new Partie(J1,J2);   

        game.initialiserPartie();

        game.grille_jeu.afficherGrilleSurConsole();
        game.LancerPartie();

    }
    
}
