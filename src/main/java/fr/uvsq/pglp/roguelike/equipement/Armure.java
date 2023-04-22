package fr.uvsq.pglp.roguelike.equipement;

/** Classe Armure qui implémente. */
public class Armure {

  /** pour récuppérer le type de l'armure stocké dans l'enum. */
  private ArmureType armureType;
  /** Pour réccupérer le type de l'armure bouclier ou corps. */
  private ArmureTypes armureTypes;
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
    this.armureTypes = armureType.armureTypes;
    this.bonusDef = armureType.bonusDef;
    this.prix = armureType.prix;
  }

  /**
   * Méthode retournant le bonus à rajouter à la def du personnages.
   *
   * @return la valeur de bonus ajouté au joueur.
   */

  public int getBonus() {
    return this.bonusDef;
  }
}
