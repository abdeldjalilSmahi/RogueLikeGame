package fr.uvsq.pglp.roguelike.equipement;

import fr.uvsq.pglp.roguelike.personnage.TypeDattaque;
import java.util.Random;

/**
 * classe de l'arme en attaque en contact.
 *
 * @author jalil, oussama, amir.
 */
public class ArmeContact extends Arme {

  /**
   * Type de l'arme contact.
   */
  private ArmeContactType armeContactType;

  /** random pour générer aléatoirement les valeurs des dés. */
  private Random random = new Random(new Random().nextInt());


  /**
   * Constructeur de l'arme de contact.
   *
   * @param armeContactType pour ramèner les armes enregistrés dans l'enum.
   */
  public ArmeContact(ArmeContactType armeContactType) {
    super(armeContactType.de, armeContactType.nbreDe, armeContactType.prix, TypeDattaque.AttaqueContact);
    this.armeContactType = armeContactType;
  }

  /**
   * Méthode pour fixer le random de la classe, pour faire les tests unitaires.
   *
   * @param random fixer la valeur random de la classe.
   */
  private ArmeContact setRandom(Random random) {
    this.random = random;
    return this;
  }

  /**
   * calcul le damage qu'inflige l'arme.
   *
   * @return damage de l'arme.
   */
  @Override
  public int calculDamage() {
    System.out.println(this.getTypeDattaque().toString());
    int dm = 0;
    for (int i = 0; i < super.getNbreDe(); i++) {
      dm += random.nextInt(super.getDe() + 1);
    }
    return dm;
  }
}


