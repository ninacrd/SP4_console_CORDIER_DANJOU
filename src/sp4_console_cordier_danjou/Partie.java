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
    private Joueur joueurCourant;
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
        grille_jeu.viderGrille();
        int choix_joueur;
        
        /*création des joueurs*/
        Scanner saisie_joueur = new Scanner(System.in);
        System.out.println("Quel est le nom du joueur 1 ?"); /*on demande le nom du premier joueur*/
        String nom_j1 = saisie_joueur.nextLine();
        listeJoueurs[0].Joueur(nom_j1); 
       
        System.out.println("Quel est le nom du joueur 2 ?"); /*on demande le nom du second joueur*/
        String nom_j2 = saisie_joueur.nextLine();
        listeJoueurs[1].Joueur(nom_j2);
       
        /*on récupère le nom et la couleur affectée aux joueurs*/
        System.out.println(nom_j1.nom + " est de couleur " + nom_j1.couleur);
        System.out.println(nom_j1.nom + " est de couleur " + nom_j1.couleur);

        /*on détermine le premier joueur*/
        Random generateurAleat = new Random();
        boolean premier_joueur = generateurAleat.nextBoolean();
        if (premier_joueur){
            joueurCourant = listeJoueurs[0];
        } else {
            joueurCourant = listeJoueurs[1];
        }
       
        int jr = generateurAleat.nextInt(1); /*on tire un nombre aléatoire*/
        boolean victoire = false;
        while (victoire != true){ /*tant que personne n'a eu 4 jetons alignés on continu de jouer donc la boucle continue*/
            if (jr==1){
                joueurCourant = listeJoueurs [0];/*si le tirage au sort tombe sur 1 c'est le joueur1 qui joue*/
                jr=0;/*on change la valeur de la variable jr pour  qu'après ce soit le joueur2*/
            }
            else{
                joueurCourant = listeJoueurs[1]; /*même démarche si jr==0: ce sera le joueur2 qui jouera*/
                jr=1; /*puis le joueur1*/
            }
            
            System.out.println("C'est à " + joueurCourant.nom + " de jouer");
            
            System.out.println("Que souhaitez vous faire ?\nPlacer un jeton ? 0\nRetirer un jeton ? 1\nUtiliser un désintégrateur ? 2");

            choix_joueur = choix_joueur();
            switch(choix_joueur){ /*le joueur courant joue et donc choisit en premier*/
                case 0:
                    jouerJeton();
                    break;
                case 1:
                    recupererJeton();
                    break;
                case 2:
                    utiliserDesintegrateur();
                    break;
            }
            
            if (choix_joueur == 1){ /*s'il choisi 1 il veut placer un jeton*/
                if (joueurCourant.nombreDeJetons() == 0){/*on vérifie que le joueur possede assez de jetons pour jouer*/
                    System.out.println("Vous n'avez plus de jeton donc vous ne pouvez pas jouer");
                }
                else {
                    System.out.println("Où souhaitez vous jouer ?");
                    int colonne = saisie_joueur.nextInt();
                    Jeton jeton_joué = joueurCourant.jouerJeton();/*on crée le jeton qui va être joué et le retire de ceux que le joueur possède*/                
                    boolean cr = plateau.colonneRemplie(colonne);/*on vérifie que la colonne n'est pas remplie*/
                    if(cr==true){/*si la colonne est remplie on ne peut plus placer de pion*/
                        System.out.println("Cette colonne est pleine");
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
            }
            String clr = joueurCourant.affecterCouleur();/*on recupere la couleur du joueur courant*/
            victoire = plateau.etreGagnantePourCouleur(clr);/*on regarde si le joueur a aligné 4 jetons*/
        }
        if (choix_joueur == 2){/*s'il choisi 2 il veut retirer un jeton*/
            System.out.println("Quelle est la colonne du jeton à retirer ?");
            int colonne_jr = saisie_joueur.nextInt(); /*on demande la colonne du jeton à retirer*/
            System.out.println("Quelle est la ligne du jeton à retirer ?");
            int ligne_jr = saisie_joueur.nextInt(); /*on demande la ligne du jeton à retirer*/
            boolean presence = plateau.presenceJeton(colonne_jr,ligne_jr); /*on vérifie qu'il y a bien un jeton à cet emplacement*/


            String clr_j = joueurCourant.affecterCouleur();
            String clr_j = plateau.lireCouleurDuJeton(colonne_jr,ligne_jr);



            if(presence==true &
clr_j==clr_jt){//on vérifie s'il y en a un et s'il est de la couleur du joueur courant



                plateau.recupererJeton(colonne_r,
ligne_r);



                plateau.tasserColone(colonne_r);



            }



            else{



                System.out.println("il
 n'y a pas de jeton à retirer ou ce jeton ne vous appartient pas");



            }







            String clr=joueurCourant.donnerCouleur();



            victoire =
plateau.etreGagnantePourCouleur(clr);







        }







        if(choix==3){



            System.out.println("Dans
 quelle colonne est le jeton que vous voulez desintégrer ?");



            int colonne_r =
saisieUtilisateur.nextInt();



            System.out.println("Dans
 quelle ligne est le jeton que vous voulez desintégrer ?");



            int ligne_r =
saisieUtilisateur.nextInt();



            boolean presence=plateau.presenceJeton(colonne_r,
ligne_r);







            if(presence==true){



                plateau.supprimerJeton(colonne_r,
ligne_r);



                plateau.tasserColone(colonne_r);



            }



            else{



                System.out.println("il
 n'y a pas de jeton à desintégrer");



            }



            joueurCourant.utiliserDesintegrateur();







            String clr=joueurCourant.donnerCouleur();



            victoire =
plateau.etreGagnantePourCouleur(clr);







            }







        }



        String nomGagnant=joueurCourant.retournerNom();



        System.out.println(nomGagnant+"a
 gagné");



    }



    



}




       
    }
}
    
    
    


