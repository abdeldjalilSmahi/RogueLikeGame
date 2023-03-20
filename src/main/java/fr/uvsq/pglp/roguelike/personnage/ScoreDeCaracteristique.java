package fr.uvsq.pglp.roguelike.personnage;

/** Classe représentant un score de caractéristique. */
public final class ScoreDeCaracteristique {

  /** La valeur du score de caractéristique. */
  private final int val;

  /** Le modificateur du score de caractéristique. */
  private final int mod;

  /**
   * Constructeur de la classe.
   *
   * @param val La valeur du score de caractéristique
   */
  public ScoreDeCaracteristique(int val) {
    validate(val);
    this.val = val;
    this.mod = getModifcateur(val);
  }

  /**
   * Retourne la valeur du score de caractéristique.
   *
   * @return La valeur du score de caractéristique
   */
  public int val() {
    return val;
  }

  /**
   * Retourne le modificateur du score de caractéristique.
   *
   * @return Le modificateur du score de caractéristique
   */
  public int mod() {
    return mod;
  }

  /**
   * Méthode interne pour obtenir le modificateur à partir de la valeur.
   *
   * @param val La valeur du score de caractéristique
   * @return Le modificateur du score de caractéristique
   */
  private int getModifcateur(int val) {
    int modificateur;
    switch (val) {
      case 1, 2, 3 -> modificateur = -4;
      case 4, 5 -> modificateur = -3;
      case 6, 7 -> modificateur = -2;
      case 8, 9 -> modificateur = -1;
      case 10, 11 -> modificateur = 0;
      case 12, 13 -> modificateur = 1;
      case 14, 15 -> modificateur = 2;
      case 16, 17 -> modificateur = 3;
      case 18, 19 -> modificateur = 4;
      case 20, 21 -> modificateur = 5;
      default -> throw new IllegalArgumentException(
          "(\"Valeur de Caractéristique non valide : \" + val");
    }
    return modificateur;
  }

  /**
   * Méthode static responsable de la verification des valeurs.
   *
   * @throws IllegalArgumentException si la valeur est inf à 1 ou sup à 21
   */
  public static void validate(int val) {
    if (val < 1) {
      throw new IllegalArgumentException("la valeur de la caractéristique doit etre sup à 1");
    }
    if (val > 21) {
      throw new IllegalArgumentException("la valeur de la caractéristique doit etre inférieur 21");
    }
  }
}
