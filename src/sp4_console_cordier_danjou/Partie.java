/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_cordier_danjou;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class Partie {

    private Joueur[] listeJoueurs = new Joueur[2];
    private Joueur jc;
    private PlateauDeJeu plateau;
    PlateauDeJeu grille_jeu = new PlateauDeJeu();

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
            int Ligne = lgn.nextInt(6);
            int Colonne= cln.nextInt(7);
        if(plateau.presenceTrouNoir(Ligne,Colonne)==false&& plateau.presenceDesintegrateur(Ligne, Colonne) == false) {
         plateau.placerTrouNoir(Ligne, Colonne);
                plateau.placerDesintegrateur(Ligne, Colonne);

            } else {

                i -= 1;
            }
        }
     for (int j = 0; j < 2; j++) {

            int Ligne = lgn.nextInt(6);

            int Colonne = cln.nextInt(7);

            if (plateau.presenceDesintegrateur(Ligne, Colonne) == false) {

                plateau.placerDesintegrateur(Ligne, Colonne);

            } else {

                j -= 1;

            }

        }
    for (int r = 0; r< 2; r++) {

            int Ligne = lgn.nextInt(6);

            int Colonne = cln.nextInt(7);

            if (plateau.presenceTrouNoir(Ligne, Colonne) == false && plateau.presenceDesintegrateur(Ligne, Colonne) == false) {

                plateau.placerTrouNoir(Ligne, Colonne);

            } else {

                r -= 1;

            }

        }
    }
   
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        creerEtAffecterJeton(listeJoueurs[0]);
        creerEtAffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs();
    }

    public void LancerPartie(){
        /*mise en place de la grille*/
        plateau.viderGrille();
        int choix_joueur;
        int nombre_joué = 0;
        String couleur_jeton = joueurCourant.affecterCouleur();
        
        /*création des joueurs*/
        Scanner saisie_joueur = new Scanner(System.in);
        System.out.println("Quel est le nom du joueur 1 ?"); /*on demande le nom du premier joueur*/
        String nom_j1 = saisie_joueur.next();
        listeJoueurs[0].Joueur(nom_j1); /*on lui affecte son nom*/
       
        System.out.println("Quel est le nom du joueur 2 ?"); /*on demande le nom du second joueur*/
        String nom_j2 = saisie_joueur.next();
        listeJoueurs[1].Joueur(nom_j2);
       
        /*on récupère le nom et la couleur affectée aux joueurs*/
        System.out.println(listeJoueurs[0].nom + " est de couleur " + listeJoueurs[0].couleur);
        System.out.println(listeJoueurs[1].nom + " est de couleur " + listeJoueurs[1].couleur);

        /*on détermine le premier joueur*/
        Random generateurAleat = new Random();
        boolean premier_joueur = generateurAleat.nextBoolean();
        if (premier_joueur){
            joueurCourant = listeJoueurs[0];
        } else {
            joueurCourant = listeJoueurs[1];
        }
        
        /*on créé une méthode qui déterminera le joueur suivant*/
        while(true){
            if(nombre_joué % 2 == 0){/*si on en a joué 1 : on joue, ensuite on aura = 0 donc ce sera à l'autre et ainsi de suite*/
                joueurCourant = listeJoueurs[0];
            } else {
                joueurCourant = listeJoueurs[1];
            }
       
        boolean victoire = false; /*au départ personne n'a gagné*/
        while (victoire != true){ /*tant que personne n'a eu 4 jetons alignés on continu de jouer donc la boucle continue de s'exécuter*/
            System.out.println("C'est à " + joueurCourant.nom + " de jouer");
            
            System.out.println("Que souhaitez vous faire ?\nPlacer un jeton ? 1\nRetirer un jeton ? 2\nUtiliser un désintégrateur ? 3");

            choix_joueur = saisie_joueur.nextInt();
            
            if (choix_joueur == 1){ /*s'il choisi 1 il veut placer un jeton*/
                if (joueurCourant.nombreDeJetons() == 0){/*on vérifie que le joueur possede assez de jetons pour jouer*/
                    System.out.println("Vous n'avez plus de jeton donc vous ne pouvez pas jouer");
                }
                else {
                    System.out.println("Où souhaitez vous jouer ?");
                    int colonne = saisie_joueur.nextInt();
                    Jeton jeton_joué = joueurCourant.jouerJeton();/*on crée le jeton qui va être joué et le retire de ceux que le joueur possède*/                
                    boolean cr = plateau.colonneRemplie(colonne);/*on vérifie que la colonne n'est pas remplie*/
                    if(cr == true){/*si la colonne est remplie on ne peut plus placer de pion*/
                        System.out.println("Cette colonne est pleine, choisissez en une autre");
                    } 
                    else {/*cas où la colonne n'est pas remplie : on peut jouer*/
                        plateau.ajouterJetonDansColonne(jeton_joué,colonne);
                        for(int j=0; j<7 ; j++){/*s'il y a un trou noir, on le retire ainsi que le jeton*/
                            boolean a = plateau.presenceTrouNoir(colonne,j);
                            if(a==true){
                                plateau.supprimerTrouNoir(colonne,j);
                                plateau.supprimerJeton(colonne,j);
                            }
                        }
                    }
                }
                nombre_joué ++;
                victoire = plateau.etreGagnantePourCouleur(couleur_jeton);/*on regarde si le joueur a aligné 4 jetons*/
            }
            
        
            if (choix_joueur == 2){/*s'il choisi 2 il veut retirer un jeton*/
                System.out.println("Quelle est la colonne du jeton à retirer ?");
                int colonne_jr = saisie_joueur.nextInt(); /*on demande la colonne du jeton à retirer*/
                System.out.println("Quelle est la ligne du jeton à retirer ?");
                int ligne_jr = saisie_joueur.nextInt(); /*on demande la ligne du jeton à retirer*/
                boolean presence = plateau.presenceJeton(colonne_jr,ligne_jr); /*on vérifie qu'il y a bien un jeton à cet emplacement*/
                String clr_j = joueurCourant.affecterCouleur();
                String clr_jj = plateau.lireCouleurDuJeton(colonne_jr,ligne_jr);



                if(presence == true & clr_j == clr_jj){//on vérifie qu'il y ai un jeton à l'endroit indiqué et qu'il soit bien de la même couleur que le jeton courant*/
                    plateau.recupererJeton(colonne_jr,ligne_jr);
                    plateau.tasserColonne(colonne_jr);/*on retire le jeton donc on descend tous les jetons de la colonne d'un cran*/
                }
                else if (presence == false || clr_j != clr_jj) {
                    System.out.println("Il n'y a pas de jeton à retirer à l'endroit indiqué ou ce jeton c'est pas le votre");
                }
                nombre_joué ++;
                victoire = plateau.etreGagnantePourCouleur(couleur_jeton);
            }
        
        
            if(choix_joueur==3){
                System.out.println("Dans quelle colonne est le jeton que vous voulez desintégrer ?");
                int colonne_d = saisie_joueur.nextInt();
                System.out.println("Dans quelle ligne est le jeton que vous voulez desintégrer ?");
                int ligne_d = saisie_joueur.nextInt();
                boolean presence = plateau.presenceJeton(colonne_d,ligne_d);
            
                if(presence==true){
                    plateau.supprimerJeton(colonne_d, ligne_d);
                    plateau.tasserColonne(colonne_d);/*on a retiré le jeton donc on descend tous les jetons de la colonne d'un cran*/
                }   else {
                        System.out.println("Il n'y a pas de jeton à desintégrer à l'endroit indiqué");
                    }
                joueurCourant.utiliserDesintegrateur();
                victoire = plateau.etreGagnantePourCouleur(couleur_jeton);
            }
        }
        String Gagnant = joueurCourant.afficher_nom_gagnant();
        System.out.println(Gagnant +" a gagné");
    }
    }
}

    
    
    


