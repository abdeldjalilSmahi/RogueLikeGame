package fr.uvsq.pglp.roguelike.equipement;

/** Cette énumération représente différents types d'armes de contact. */
public enum ArmeContactType {
  Baton(4, 2, 0),
  BatonFerre(6, 2, 2);

  private int de;
  private int nbrMain;
  private int prix;

  /**
   * Constructeur pour l'énumération ArmeContactType.
   *
   * @param de Le nombre de jets de dés pour le calcul des dégâts.
   * @param nbrMain Le nombre de mains nécessaires pour utiliser l'arme.
   * @param prix Le prix de l'arme.
   */
  ArmeContactType(int de, int nbrMain, int prix) {
    this.de = de;
    this.nbrMain = nbrMain;
    this.prix = prix;
  }

  /**
   * Renvoie le nombre de jets de dés pour le calcul des dégâts.
   *
   * @return Le nombre de jets de dés pour le calcul des dégâts.
   */

  public int getDe() {
    return de;
  }
  /**
   * Renvoie le nombre de mains nécessaires pour utiliser l'arme.
   *
   * @return Le nombre de mains nécessaires pour utiliser l'arme.
   */

  public int getNbrMain() {
    return nbrMain;
  }
  /**
   * Renvoie le prix de l'arme.
   *
   * @return Le prix de l'arme.
   */

  public int getPrix() {
    return prix;
  }
}
