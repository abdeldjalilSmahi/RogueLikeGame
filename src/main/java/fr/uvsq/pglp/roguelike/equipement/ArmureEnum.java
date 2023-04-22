package fr.uvsq.pglp.roguelike.equipement;

/** enum pour enregistrer tous les armures de jeux. */
public enum ArmureEnum {
  PETIT_BOUCLIER(ArmureTypes.BOUCLIER, 1, 2),
  CUIR(ArmureTypes.CORPS, 2, 4),
  GRAND_BOUCLIER(ArmureTypes.BOUCLIER, 2, 4),
  CUIR_RENFORCE(ArmureTypes.CORPS, 3, 8),
  DEMI_PLAQUE(ArmureTypes.CORPS, 6, 50)
  ;

  /** {@link ArmureTypes} pour recuperer le type d'armure CORPS ou BOUCLIER. */
  ArmureTypes armureTypes;

  /**
   * bourseDef, la bourse qui s'ajoute a la caracteristique DEF du {@link
   * fr.uvsq.pglp.roguelike.personnage.Personnage}.
   */
  int bonusDef;

  /** le prix de l'armure. */
  int prix;

  /**
   * Constructeur de l'enum.
   *
   * @param armureTypes type d'armure
   * @param bonusDef bonus ajouté a la défense du joueur
   * @param prix le prix de l'armure.
   */
  ArmureEnum(ArmureTypes armureTypes, int bonusDef, int prix) {
    this.armureTypes = armureTypes;
    this.bonusDef = bonusDef;
    this.prix = prix;
  }
}
