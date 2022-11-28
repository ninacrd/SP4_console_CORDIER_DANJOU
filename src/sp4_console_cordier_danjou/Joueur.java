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
private String couleur;
private ArrayList <Jeton> reserveJetons;

public void Joueur (String Unnom){
nom=Unnom;

}
public void affecterCouleur(String Unecouleur){
 couleur = Unecouleur;   
}
public int nombreDeJetons (){
    int taille = reserveJetons.size();
    return taille;
   
}
public void  ajouterJeton( Jeton ajout){
    reserveJetons.add(ajout);
 
    
}
public Jeton joueurJeton(){
    int m =nombreDeJetons();
    Jeton jt = reserveJetons.remove(m);
    return jt;
    
}
}
