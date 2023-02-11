package fr.uvsq.pglp.roguelike.personnage;

public class ScoreDeCaracteristique {

  private final int val;
  private final int mod;

  public ScoreDeCaracteristique(int val) {
    if (val < 1) {
      throw new IllegalArgumentException("la valeur de la caractéristique doit etre sup à 1");
    }
    if (val > 21) {
      throw new IllegalArgumentException("la valeur de la caractéristique doit etre inférieur 21");
    }
    this.val = val;
    this.mod = (val - 10) / 2;
  }

  public int val() {
    return val;
  }

  public int mod() {
    return mod;
  }
}
