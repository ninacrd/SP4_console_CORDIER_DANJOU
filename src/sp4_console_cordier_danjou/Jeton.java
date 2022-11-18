/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_cordier_danjou;

/**
 *
 * @author Nina
 */
public class Jeton {
    private String couleur; /*ajout de l'attribut couleur associé au jeton*/
    
    public Jeton (String une_couleur) { /*creation d'un constructeur, il initialise
        l'attribut couleur du jeton avec la valeur passée en paramètre*/
        couleur = une_couleur;
    }
    
    public String lireCouleur() {
        return couleur;
    }
    
}
