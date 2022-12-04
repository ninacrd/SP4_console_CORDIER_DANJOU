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
    Jeton jetonCourant;
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;

    public CelluleDeGrille() {/*initialisation de l'attribut*/
        jetonCourant = null;
        avoirTrouNoir = false;
        avoirDesintegrateur = false;
    }

    public boolean presenceJeton() {
        /*chercher la présence ou non de jeton grâce à la méthode boolean*/
        if (jetonCourant == null) {
            return false;
        } else {
            return true;
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

    public void placerTrouNoir(){
        avoirTrouNoir = true;
    }
    
    public void supprimerTrouNoir(){
        avoirTrouNoir = false;
    }
    
    public boolean presenceTrouNoir(){
        if (avoirTrouNoir == true){
            return true;
        } else {
            return false;
        }
    }
    
    public Jeton recupererJeton() {
        Jeton temp = jetonCourant; /*utilisation d'une variable temporaire*/
        jetonCourant = null;
        return (temp);
    }
    
    public void supprimerJeton(){
        jetonCourant = null;
    }
    
    public boolean presenceDesintegrateur(){
        if (avoirDesintegrateur == true){
            return true;
        } else {
            return false;
        }
    }
    
    public void placerDesintegrateur(){
        avoirDesintegrateur = true;
    }
    
    public void supprimerDesintegrateur(){
        avoirDesintegrateur = false;
    }
    
    public void activerTrouNoir(){
        this.supprimerJeton();
        this.supprimerTrouNoir();
    }
    
@Override
        public String toString() { 
        String clr=lireCouleurDuJeton();
        String chaine_a_retourner;
        
        chaine_a_retourner ="erreur";
        if (jetonCourant==null && avoirTrouNoir == false && avoirDesintegrateur == false){
            chaine_a_retourner=".";
            
        }
        if (clr =="rouge" ) { 
            chaine_a_retourner= "R";
        }
        if (clr == "jaune") {
           chaine_a_retourner = "J";
        }
        
        if (avoirTrouNoir == true){
            chaine_a_retourner = "@";
        }
        
        if (avoirDesintegrateur == true){
            chaine_a_retourner = "D";
        }
        
            return chaine_a_retourner;
        }
}      
    
    
    



   
       

