package fr.uvsq.pglp.roguelike.equipement;

/** Classe Armure qui implémente l'interface {@link Equipement}. */
public class Armure implements Equipement {

  /** pour récuppérer le type de l'armure stocké dans l'enum. */
  private ArmureType armureType;
  /** Pour réccupérer le type de l'armure bouclier ou corps. */
  private ArmureTypes typeArmure;
  /** Bonus ajouté par l'armure à la défense du joueur. */
  private int bonusDef;
  /** prix de l'armure. */
  private int prix;

  /**
   * Constructeur de l'armure.
   *
   * @param armureType pour préciser l'armure.
   */
  public Armure(ArmureType armureType) {
    this.armureType = armureType;
    this.typeArmure = armureType.armureTypes;
    this.bonusDef = armureType.bonusDef;
    this.prix = armureType.prix;
  }

  /**
   * implémentation de la méthode de l'interface.
   *
   * @return la valeur de bonus ajouté au joueur.
   */
  @Override
  public int getBonus() {
    return this.bonusDef;
  }
}
