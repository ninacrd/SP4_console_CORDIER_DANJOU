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
    String couleur; /*ajout de l'attribut couleur associé au jeton*/
    
    public Jeton (String une_couleur) { /*creation d'un constructeur, il initialise
        l'attribut couleur du jeton avec la valeur passée en paramètre*/
        couleur = une_couleur;
    }
    
    public String lireCouleur() {
        return couleur;
    }
    
    public String getCouleur() {  
        if (couleur=="rouge"){
            return "R";
        }else return "J";        
    }
    
    @Override
        public String toString() { /*methode qui permet de retourner la chaine de 
        caractere que l'on veut afficher quand l'objet est cree*/
        String chaine_a_retourner;
        if (couleur == "rouge") { /*retourne le caractèe en lien avec la couleur du jeton*/
            couleur = "R";
        }
        else if (couleur == "jaune") {
            couleur = "J";
        }
        else {
            couleur = "erreur";
        }
        chaine_a_retourner = couleur;
        return chaine_a_retourner;
        
    }
}

