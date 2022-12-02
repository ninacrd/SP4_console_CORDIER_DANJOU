/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_cordier_danjou;

import javax.swing.JButton;

/**
 *
 * @author Nina
 */
public class CelluleGraphique extends JButton {
    CelluleDeGrille celluleAssociee;
    
    public CelluleGraphique (CelluleDeGrille une_cellule){
        celluleAssociee = une_cellule;
    }
}
