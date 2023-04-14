package fr.uvsq.pglp.roguelike.equipement;

import fr.uvsq.pglp.roguelike.personnage.TypeDattaque;
import java.util.Random;

/** Classe de l'arme à distance. */
public class ArmeDistance extends Arme {

  /** Attribut de type de l'arme stocké dans l'enum {@link ArmeDistanceType}. */
  private ArmeDistanceType armeDistanceType;
  /** Type d'attaque de l'arme. */
  private TypeDattaque typeDattaque;
  /** la porté de l'arme en mettre. */
  private int portee;

  /** {@link Random} pour controler le random au test unitaires. */
  private Random random = new Random(new Random().nextInt());

  /**
   * Constructeur de cette classe.
   *
   * @param armeDistanceType type de l'arme à distance stocké dans l'enum.
   */
  public ArmeDistance(ArmeDistanceType armeDistanceType) {
    super(
        armeDistanceType.de,
        armeDistanceType.nbreDe,
        armeDistanceType.prix,
        TypeDattaque.AttaqueDistance);
    this.armeDistanceType = armeDistanceType;
    this.portee = armeDistanceType.portee;
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
  @Override
  public int calculDamage() {
    System.out.println(this.getTypeDattaque().toString());
    int dm = 0;
    for (int i = 0; i < super.getNbreDe(); i++) {
      dm += this.random.nextInt(super.getDe() + 1);
    }
    return dm;
  }
}
