package fr.uvsq.pglp.roguelike.equipement;

import fr.uvsq.pglp.roguelike.personnage.TypeDattaque;

/** Classe abstraite des armes. */
public abstract class Arme {

  /** Type de l'arme contact. */
  private ArmeContactType armeContactType;
  /** le dé de l'arme sert à calculer son dm. */
  private int de;
  /** nombre de dés de l'arme. */
  private int nbreDe;
  /** le prix de l'arme. */
  private int prix;
  /** Type d'attaque de l'arme. */
  private TypeDattaque typeDattaque;

  /**
   * Constructeur de l'arme de contact.
   *
   * @param de la valeur maximale de dé.
   * @param nbreDe le nombre de dé.
   * @param prix le prix de l'arme.
   */
  public Arme(int de, int nbreDe, int prix, TypeDattaque typeDattaque) {
    this.de = de;
    this.nbreDe = nbreDe;
    this.prix = prix;
    this.typeDattaque = typeDattaque;
  }


  public int getDe() {
    return de;
  }

  public void setDe(int de) {
    this.de = de;
  }

  public int getNbreDe() {
    return nbreDe;
  }

  public void setNbreDe(int nbreDe) {
    this.nbreDe = nbreDe;
  }

  public int getPrix() {
    return prix;
  }

  public void setPrix(int prix) {
    this.prix = prix;
  }

  public TypeDattaque getTypeDattaque() {
    return typeDattaque;
  }

  /** pour calculer les domagement de l'arme. */
  public abstract int calculDamage();
}
