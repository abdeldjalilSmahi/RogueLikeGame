package fr.uvsq.pglp.roguelike.equipement;

import java.util.Random;

/** Classe de l'arme à distance. */
public class ArmeDistance implements Equipement {

  /** Attribut de type de l'arme stocké dans l'enum {@link ArmeDistanceType}. */
  private ArmeDistanceType armeDistanceType;
  /** la valeur maximale du dé. */
  private int de;
  /** Nombre de dé de cette arme. */
  private int nbreDe;
  /** la porté de l'arme en mettre. */
  private int portee;
  /** le prix de l'arme. */
  private int prix;
  /** {@link Random} pour controler le random au test unitaires. */
  private Random random = new Random(new Random().nextInt());

  /**
   * Constructeur de cette classe.
   *
   * @param armeDistanceType type de l'arme à distance stocké dans l'enum.
   */
  public ArmeDistance(ArmeDistanceType armeDistanceType) {
    this.armeDistanceType = armeDistanceType;
    this.de = armeDistanceType.de;
    this.nbreDe = armeDistanceType.nbreDe;
    this.portee = armeDistanceType.portee;
    this.prix = armeDistanceType.prix;
  }

  /**
   * Methode pour fixer le random de la classe.
   *
   * @param random passé en paramètre pour ecraser la valeur aléatoire.
   */
  private ArmeDistance setRandom(Random random) {
    this.random = random;
    return this;
  }

  /**
   * méthode qui sert à calculer le damage infligé par l'arme.
   *
   * @return la valeur de ce damage, qui dépend du nombre de dés et la valeur max du dé. se calcule
   *     aléatoirement.
   */
  public int calculDamage() {
    int dm = 0;
    for (int i = 0; i < this.nbreDe; i++) {
      dm += this.random.nextInt(this.de + 1);
    }
    return dm;
  }

  /**
   * la méthode implémenté de l'interface qui sert à retourner la valeur de bonus.
   *
   * @return le damage de l'arme distance dans le cas d'une arme à distance.
   */
  @Override
  public int getBonus() {
    return calculDamage();
  }
}
