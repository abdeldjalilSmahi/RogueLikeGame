package fr.uvsq.pglp.roguelike.personnage;
import fr.uvsq.pglp.roguelike.validation.Ivaldator;

public final class ScoreDeCaracteristique implements Ivaldator{

  private final int val;
  private final int mod;

  public ScoreDeCaracteristique(int val) {
    validate();
    this.val = val;
    this.mod = getModifcateur(val) ;
  }

  public int val() {
    return val;
  }
  public int mod() {
    return mod;
  }
  
  private int getModifcateur(int val){
    int modificateur;
    switch(val){
      case 1,2,3 -> modificateur = -4 ;
      case 4,5 -> modificateur = -3 ;
      case 6,7 -> modificateur = -2 ;
      case 8,9 -> modificateur = -1 ;
      case 10, 11 -> modificateur = 0;
      case 12,13 -> modificateur = 1 ;
      case 14,15 -> modificateur = 2 ;
      case 16,17 -> modificateur = 3 ;
      case 18,19 -> modificateur = 4 ;
      case 20,21 -> modificateur = 5 ;
      default -> throw new IllegalArgumentException("(\"Valeur de Caractéristique non valide : \" + val");
    }
    return modificateur ;
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
