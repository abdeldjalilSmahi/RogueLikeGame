package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;

/** Classe qui permet d'afficher la carte d'un donjon. */
public class DisplayMap {
  /**
   * Affiche la carte du donjon.
   *
   * @param donjon Le donjon dont on veut afficher .
   */
  public static void dispaly(Donjon donjon) {
    for (int i = 0; i < donjon.getMap().length; i++) {
      for (int j = 0; j < donjon.getMap()[0].length; j++) {
        System.out.print(donjon.getMap()[i][j].getAsciiChar());
      }
      System.out.println();
    }
  }
}
