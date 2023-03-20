
/**

 Cette classe représente une arme de contact.
 */
package fr.uvsq.pglp.roguelike.Equipement;
import java.util.Random;

/**

 Cette classe représente une arme de contact.
 */
public class ArmeContact implements Equipement {
  private ArmeContactType armecontact;
  private int degat;
  private Random random = new Random(new Random().nextInt());

  /**

   Constructeur pour la classe ArmeContact.
   */
  public ArmeContact() {
  }

  /**

   Cette méthode calcule les dégâts infligés par l'arme.
   */
  private void calculdegat(){
  }
}