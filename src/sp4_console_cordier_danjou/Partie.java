/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_cordier_danjou;

import java.util.Random;

/**
 *
 * @author Utilisateur
 */
public class Partie {

    private Joueur[] listeJoueurs = new Joueur[2];
    private Joueur joueurCourant;
    private PlateauDeJeu plateau;

    public void Partie(Joueur J1, Joueur J2) {
        listeJoueurs[0] = J1;
        listeJoueurs[1] = J2;
    }

    public void attribuerCouleurAuxJoueurs() {
        Random generateurAleat = new Random();
        int couleur = generateurAleat.nextInt(1);
        if (couleur == 1) {
            listeJoueurs[0].affecterCouleur("rouge");
            listeJoueurs[1].affecterCouleur("jaune");
        } else {
            listeJoueurs[1].affecterCouleur("rouge");
            listeJoueurs[0].affecterCouleur("jaune");
        }

    }
    public void creerEtAffecterJeton( Joueur jr){
        Jeton []jetons = new Jeton[30];
        for (int i=0 ; i<=30;i++){
        jetons[i]=new Jeton (jr.couleur);
        jr.ajouterJeton(jetons[i]);
    }
    }
    public void placerTrousNoirsEtDesintegrateurs(){
        Random lgn= new Random();
        Random cln= new Random();
        for(int i=0; i<3;i++){
            int Ligne = lgn.nextInt(0,6);
            int Colonne= cln.nextInt(0,7);
            
        }
    }
    
    
    
}

