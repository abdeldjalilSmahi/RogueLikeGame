package fr.uvsq.pglp.roguelike.equipement;

/** enum pour stocker les ArmeDistance. */
public enum ArmeDistanceType {
 ARBALETE_LEGERE(2, 4, 30, 10),
  ARBALETE_LOURDE(3, 4, 60, 12),
  ARC_LONG(1, 8, 50, 5),
  MOUSQUET(2, 6, 50, 20);
  /** nombre de dé de l'arme. */
  int nbreDe;
  /** la valeur maximum du dé. */
  int de;
  /** le prix de l'arme à distance. */
  int prix;
  /** la porté de l'arme en mettres. */
  int portee;

  /**
   * constructeur de l'enum.
   *
   * @param nbreDe représente le nombre de dé de l'armure.
   * @param de la valeur maximale de dé.
   * @param portee la portée de l'arme en mettre.
   * @param prix représente le prix de l'arme.
   */
  ArmeDistanceType(int nbreDe, int de, int portee, int prix) {
    this.nbreDe = nbreDe;
    this.de = de;
    this.portee = portee;
    this.prix = prix;
  }
}
