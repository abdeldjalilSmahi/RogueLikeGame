package fr.uvsq.pglp.roguelike.equipement;

import java.util.Random;

/**
 * classe de l'arme en attaque en contact.
 *
 * @author jalil, oussama, amir.
 */
public class ArmeContact implements Equipement {

  /** Type de l'arme contact. */
  private ArmeContactType armeContactType;
  /** le dé de l'arme sert à calculer son dm. */
  private int de;
  /** nombre de dés de l'arme. */
  private int nbreDe;
  /** le prix de l'arme. */
  private int prix;
  /** random pour générer aléatoirement les valeurs des dés. */
  private Random random;

  /**
   * Constructeur de l'arme de contact.
   *
   * @param armeContactType pour ramèner les armes enregistrés dans l'enum.
   * @param random pour fixer le random de la classe.
   */
  public ArmeContact(ArmeContactType armeContactType, Random random) {
    this.armeContactType = armeContactType;
    this.de = armeContactType.de;
    this.nbreDe = armeContactType.nbreDe;
    this.prix = armeContactType.prix;
    this.random = random;
  }

  /**
   * Méthode pour fixer le random de la classe, pour faire les tests unitaires.
   *
   * @param random fixer la valeur random de la classe.
   */
  private void setRandom(Random random) {
    this.random = random;
  }

  /**
   * calcul le damage qu'inflige l'arme.
   *
   * @return damage de l'arme
   */
  private int calculDamage() {
    int dm = 0;
    for (int i = 0; i < this.nbreDe; i++) {
      dm += this.random.nextInt(this.de + 1);
    }
    return dm;
  }

  @Override
  public int getBonus() {
    return calculDamage();
  }
}
