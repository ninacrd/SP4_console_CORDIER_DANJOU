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
            if (grille[i][j].presenceJeton() == false) { /*s'il y a déjà un jeton, on n'en affecte pas un autre, on sort de la boucle et fait i+1*/
                grille[i][j].affecterJeton(jeton);
                return i;
            }
        }
        return -1; /*retourne -1 si la colonne est pleine*/
    }
    
    public boolean grilleRemplie(){
        for (int j = 0; j < 7; j ++) { /*parcourt chaque colonne pour voir si la dernière ligne est remplie ou non*/
            if (grille[5][j].presenceJeton() == false){ /*signifie que la grille n'est pas remplie*/
                return false;
            }
        }
        return true;
    }
    
    public void afficherGrilleSurConsole(){ /*on affiche la grille sur la console*/
        for (int i=5;i>=0;i--){
            for (int j=0;j<7;j++){
                grille[i][j].toString();
            }
        }
    }
    
    public void presenceJeton(int x,int y){
        grille[x][y].presenceJeton(); /*retourne la valeur de cette méthode aux coordonnées [x][y}*/
    }
    
    public void lireCouleurDuJeton(int x, int y){
        grille[x][y].lireCouleurDuJeton(); /*meme méthode*/
    }
    
    public boolean ligneGagnantePourCouleur(String C){ /*test si la ligne est gagnante*/
        int i;
        int j;
        for (i=0; i<6; i++){ /*car methode ligne et on a 6 lignes donc de 0 à 5*/
            for (j=0; j<4; j++){ /*on cherche si on a 4 jetons alignés sur la même ligne donc l'indice de la colonne ne peut dépasser 3*/
                if (C==grille[i][j].lireCouleurDuJeton() && C==grille[i][j+1].lireCouleurDuJeton() && C==grille[i][j+2].lireCouleurDuJeton() && C==grille[i][j+3].lireCouleurDuJeton()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean colonneGagnantePourCouleur(String C){
        int i;
        int j;
        for (i=0; i<3; i++){ /*l'indice de la ligne jeton ne peut dépasser 2*/
            for (j=0; j<7; i++){ /*l'indice de la colonne va de 0 à 6*/
                if (C==grille[i][j].lireCouleurDuJeton() && C==grille[i][j+1].lireCouleurDuJeton() && C==grille[i][j+2].lireCouleurDuJeton() && C==grille[i][j+3].lireCouleurDuJeton()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean diagonaleMontanteGagnantePourCouleur(String C){
        int i;
        int j;
        for (i=0; i<3; i++){ /*l'indice de la ligne ne peut dépasser 2*/
            for (j=0; i<4; i++){ /*l'indice de la colonne ne peut dépasser 3*/
                if (C==grille[i][j].lireCouleurDuJeton() && C==grille[i][j+1].lireCouleurDuJeton() && C==grille[i][j+2].lireCouleurDuJeton() && C==grille[i][j+3].lireCouleurDuJeton()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean diagonaleDescendanteGagnantePourCouleur(String C){
        int i;
        int j;
        for (i=3; i<6; i++){ 
            for (j=0; i<4; i++){ /*l'indice de la colonne ne peut dépasser 3*/
                if (C==grille[i][j].lireCouleurDuJeton() && C==grille[i][j+1].lireCouleurDuJeton() && C==grille[i][j+2].lireCouleurDuJeton() && C==grille[i][j+3].lireCouleurDuJeton()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean etreGagnantePourCouleur(String C){
        boolean l = ligneGagnantePourCouleur(C);
        boolean c = colonneGagnantePourCouleur(C);
        boolean dm = diagonaleMontanteGagnantePourCouleur(C);
        boolean dd = diagonaleDescendanteGagnantePourCouleur(C);
        
        if (l == true || c == true ||dm == true || dd == true){
            return true;
        }
        return false;
    }
}



