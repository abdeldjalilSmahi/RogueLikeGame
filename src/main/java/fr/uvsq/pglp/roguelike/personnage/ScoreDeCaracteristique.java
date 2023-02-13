package fr.uvsq.pglp.roguelike.personnage;
import fr.uvsq.pglp.roguelike.validation.Ivaldator;

public class ScoreDeCaracteristique implements Ivaldator{

  private final int val;
  private final int mod;

  public ScoreDeCaracteristique(int val) {
    this.val = val;
    this.mod =
  }

  public int val() {
    return val;
  }
  public int mod() {
    return mod;
  }
  @Override
  public void validate(){
    if (val < 1) {
      throw new IllegalArgumentException("la valeur de la caractéristique doit etre sup à 1");
    }
    if (val > 21) {
      throw new IllegalArgumentException("la valeur de la caractéristique doit etre inférieur 21");
    }
  }
}
