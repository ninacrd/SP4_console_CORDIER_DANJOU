/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_cordier_danjou;

/**
 *
 * @author Nina
 */
public class PlateauDeJeu {
    CelluleDeGrille [][] grille = new CelluleDeGrille [6][7]; /*creation du tableau à 2 dimensions*/
    
    public PlateauDeJeu(){ /*creation du constructeur de la classe*/
        /* utilisation de 2 boucles imbriquées afin de stocker les 42 cellules vides dans la grille*/
        for (int i = 0; i < 6; i++) { /*on parcourt les 6 lignes avec i*/
            for (int j = 0; i < 7; i ++) { /*on parcourt les 7 colonnes avec j*/
                grille[i][j]=new CelluleDeGrille();
            }  
        }
    }
    
    public int ajouterJetonDansColonne (Jeton jeton, int j){ 
        for (int i = 0; i < 6; i ++){ /*parcours les 6 lignes*/
            if (grille[i][j].presenceJeton() == false) {
                
            }
            
            
        }
        
    }
}
