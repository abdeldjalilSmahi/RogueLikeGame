package fr.uvsq.pglp.roguelike.equipement;

/** enum pour enregistrer tous les armures de jeux. */
public enum ArmureType {
  PETIT_BOUCLIER(ArmureTypes.BOUCLIER, 1, 2),
  TISSU_MATELASSE(ArmureTypes.CORPS, 1, 2),
  CUIR(ArmureTypes.CORPS, 2, 4),
  GRAND_BOUCLIER(ArmureTypes.BOUCLIER, 2, 4),
  CUIR_RENFORCE(ArmureTypes.CORPS, 3, 8),
  CHEMISE_MAILLES(ArmureTypes.CORPS, 4, 15),
  COTTES_MAILLES(ArmureTypes.CORPS, 5, 20),
  DEMI_PLAQUE(ArmureTypes.CORPS, 6, 50),
  PLAQUE_COMPLETE(ArmureTypes.CORPS, 8, 200);

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
  ArmureType(ArmureTypes armureTypes, int bonusDef, int prix) {
    this.armureTypes = armureTypes;
    this.bonusDef = bonusDef;
    this.prix = prix;
  }
}
