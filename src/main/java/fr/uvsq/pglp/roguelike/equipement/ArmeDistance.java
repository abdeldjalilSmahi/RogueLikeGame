<<<<<<< HEAD:src/main/java/fr/uvsq/pglp/roguelike/equipement/ArmeDistance.java
package fr.uvsq.pglp.roguelike.equipement;

import java.util.Random;

/** classe d'arme a distance. */
public class ArmeDistance implements Equipement {
=======
package fr.uvsq.pglp.roguelike.Equipement;

import java.util.Random;

public class ArmeDistance implements Equipement{
>>>>>>> 6feefd23f54e8856085f2f7612067402cabf4631:src/main/java/fr/uvsq/pglp/roguelike/Equipement/ArmeDistance.java


  private ArmeDistanceType armeDistance;
  private int degat;
  private int prix;
  private int de;
  private int nbrDede;
  private int portee;
  private Random random = new Random(new Random().nextInt());

<<<<<<< HEAD:src/main/java/fr/uvsq/pglp/roguelike/equipement/ArmeDistance.java
  /** La portée de l'arme à distance. */
  private int porte;

  /**
   * Constructeur pour l'initialisation d'une arme à distance.
   *
   * @param armecontact L'arme de contact associée à l'arme à distance.
   */
  public ArmeDistance(ArmeContactType armecontact) {
    this.armecontact = armecontact;
  }

  /** Méthode privée pour le calcul des dégâts de l'arme à distance. */
  private void calculdegat() {}
=======
  public ArmeDistance(ArmeDistanceType armeDistance) {
    this.armeDistance = armeDistance;
    this.prix = armeDistance.getPrix();
    this.de = armeDistance.getDe();
    this.nbrDede=armeDistance.getNbrDede();
    this.portee=armeDistance.getPortee();
    calculdegat();
  }

  private void calculdegat(){
    if (nbrDede==1) this.degat=random.nextInt(de)+1;
    else {

    }
  }

  public int getPortee() {
    return portee;
  }

  public int getDegat() {
    return degat;
  }

  public int getPrix() {
    return prix;
  }

>>>>>>> 6feefd23f54e8856085f2f7612067402cabf4631:src/main/java/fr/uvsq/pglp/roguelike/Equipement/ArmeDistance.java
}
