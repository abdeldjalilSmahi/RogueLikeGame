package fr.uvsq.pglp.roguelike.equipement;

import java.util.Random;

/** interface pour les equipements. */
public interface Equipement {

  /**
   * méthode pour retourner le bonuse de l'arme / l'armure.
   *
   * @return le bonus en entier.
   */
  int getBonus();
}
