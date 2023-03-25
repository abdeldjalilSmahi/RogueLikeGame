package fr.uvsq.pglp.roguelike.equipement;

/** Enumération définissant les types d'armes à distance disponibles. */
public enum ArmeDistanceType {

  /** Type d'une arbalète de poing. */
  Arbaletedepoing(6, 10, 8),

  /** Type d'une arbalète légère. */
  ArbaleteLegere(6, 2, 2);

  /** Le nombre de dés de dégâts de l'arme. */
  private int de;

  /** La portée de l'arme à distance. */
  private int portee;

  /** Le prix de l'arme à distance. */
  private int prix;

  /**
   * Constructeur pour l'initialisation d'un type d'arme à distance.
   *
   * @param de Le nombre de dés de dégâts de l'arme.
   * @param portee La portée de l'arme à distance.
   * @param prix Le prix de l'arme à distance.
   */
  ArmeDistanceType(int de, int portee, int prix) {
    this.de = de;
    this.portee = portee;
    this.prix = prix;
  }
  /**
   * Méthode pour obtenir le nombre de dés de dégâts de l'arme à distance.
   *
   * @return Le nombre de dés de dégâts de l'arme.
   */

  public int getDe() {
    return de;
  }

  /**
   * Méthode pour obtenir la portée de l'arme à distance.
   *
   * @return La portée de l'arme à distance.
   */

  public int getPortee() {
    return portee;
  }

  /**
   * Méthode pour obtenir le prix de l'arme à distance.
   *
   * @return Le prix de l'arme à distance.
   */

  public int getPrix() {
    return prix;
  }
}
