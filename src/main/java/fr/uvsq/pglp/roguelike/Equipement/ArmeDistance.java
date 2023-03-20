
/**

 Classe définissant une arme à distance.
 Hérite de la classe ArmeContact.
 */
package fr.uvsq.pglp.roguelike.Equipement;
import java.util.Random;

public class ArmeDistance extends ArmeContact{

  /** Le type d'arme de contact associé à l'arme à distance. */
  private ArmeContactType armecontact;

  /** Instance d'un générateur aléatoire pour les dégâts. */
  private Random random = new Random(new Random().nextInt());

  /** La portée de l'arme à distance. */
  private int porte;

  /**

   Constructeur pour l'initialisation d'une arme à distance.
   @param armecontact L'arme de contact associée à l'arme à distance.
   */
  public ArmeDistance(ArmeContactType armecontact) {
    this.armecontact = armecontact;
  }
  /**

   Méthode privée pour le calcul des dégâts de l'arme à distance.
   */
  private void calculdegat(){
  }

}