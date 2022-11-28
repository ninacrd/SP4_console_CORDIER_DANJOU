/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_cordier_danjou;

/**
 *
 * @author Utilisateur
 */
public class CelluleDeGrille {

    /*creation d'une nouvelle classe*/
    private Jeton jetonCourant;

    public CelluleDeGrille() {/*initialisation de l'attribut*/
        jetonCourant = null;
    }

    public boolean presenceJeton() {
        /*chercher la présence ou non de jeton grâce à la méthode boolean*/
        if (jetonCourant == null) {
            return true;
        } else {
            return false;
        }
    }

    public void affecterJeton(Jeton un_jeton) {/*on ajoute le jeton en parametre a la cellule*/

        jetonCourant = un_jeton;
    }

    public String lireCouleurDuJeton() {
        /*on renvoie la couleur du jeton si il est présent */
        if (jetonCourant == null) {
            return "vide";
        } else {
            return jetonCourant.lireCouleur();
        }
    }

    public Jeton recupererJeton() {
        Jeton temp = jetonCourant;
        jetonCourant = null;
        return (temp);
    }

    
@Override
        public String toString() { 
        String clr=lireCouleurDuJeton();
        String chaine_a_retourner;
        
        chaine_a_retourner ="erreur";
        if (jetonCourant==null){
            chaine_a_retourner=".";
            
        }
        if (clr =="rouge" ) { 
            chaine_a_retourner= "R";
        }
        if (clr == "jaune") {
           chaine_a_retourner = "J";
        }
        
            return chaine_a_retourner;
        }
        
    }
    
    
    



   
       

