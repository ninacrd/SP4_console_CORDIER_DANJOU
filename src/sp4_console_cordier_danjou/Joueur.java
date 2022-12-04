/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_cordier_danjou;

import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class Joueur {
    private String nom;
    String couleur;
    private ArrayList <Jeton> reserveJetons;
    private int nombreDesintegrateurs;
    

    public void Joueur (String un_nom){
        nom = un_nom;
        nombreDesintegrateurs = 0;
        reserveJetons = null;
    }
    
    public void affecterCouleur(String une_couleur){
        couleur = une_couleur;
    }

    public int nombreDeJetons (){
        int taille = reserveJetons.size();
        return taille;
    }

    public void  ajouterJeton(Jeton ajout){
        reserveJetons.add(ajout);
    }

    public Jeton jouerJeton(){
        int m = nombreDeJetons();
        Jeton jt = reserveJetons.remove(m);
        return jt;
    }
    
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs += 1;
    }
    
    public void utiliserDesintegrateur(){
        nombreDesintegrateurs -= 1;
    }

    boolean ajouterJetonDansColonne(Jeton un_jeton) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
