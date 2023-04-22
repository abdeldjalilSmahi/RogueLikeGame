package fr.uvsq.pglp.roguelike.equipement;

/** Enum pour enregistrer les armes contact. */
public enum ArmeContactType {
  GOURDIN(1, 4, 1),
  BATON(1, 4, 1),
  BATON_FEREE(1, 6, 2),
  EPEE_BATARDE(1, 12, 9),
  HACHE(1, 8, 6);

  /** Nombre de dé de l'arme. */
  int nbreDe;
  /** la valeur du dé. */
  int de;
  /** le prix de l'arme. */
  int prix;

  /**
   * Constructeur de l'enum.
   *
   * @param nbreDe représente le nombre de dé de l'arme.
   * @param de la valeur max de dé.
   * @param prix représente le prix de l'arme.
   */
  ArmeContactType(int nbreDe, int de, int prix) {
    this.nbreDe = nbreDe;
    this.de = de;
    this.prix = prix;
  }
}
