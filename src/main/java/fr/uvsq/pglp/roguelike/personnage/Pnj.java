package fr.uvsq.pglp.roguelike.personnage;

import java.util.Map;

/** Classe représentant un pnj du jeu. */
public class Pnj {

  private int pv;
  /** L'initiative du personnage, utilisée pour déterminer l'ordre d'fttaque en combat. */
  private int init;
  /** La valeur de défense du personnage, qui réduit les dégâts subis lors d'une attaque. */
  private int defense;
  /**
   * Une table de hachage associant chaque caractéristique du personnage à son score de
   * caractéristique correspondant.
   */
  private Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap;
  /** Map identifie le type d'attaque de joueur. */
  private Map<TypeDattaque, Integer> typeDattaque;

  private Strategy strategy;
  private Personnage.Builder builder;

  /**
   * Constructeur de la classe {@link Personnage}.
   *
   * @param builder pour construire le personnage.
   */
  public Pnj(Personnage.Builder builder) {
    this.pv = builder.getPv();
    this.defense = builder.getDefense();
    this.init = builder.getInit();
    this.scoreDeCaracteristiqueMap = builder.getScoreDeCaracteristiqueMap();
    this.typeDattaque = builder.getScoreAttaque();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int getPv() {
    return pv;
  }

  public int getInit() {
    return init;
  }

  public int getDefense() {
    return defense;
  }

  public Map<Caracteristique, ScoreDeCaracteristique> getScoreDeCaracteristiqueMap() {
    return scoreDeCaracteristiqueMap;
  }

  public Map<TypeDattaque, Integer> getTypeDattaque() {
    return typeDattaque;
  }

  public Strategy getStrategy() {
    return strategy;
  }

  public void performAction() {
    strategy.execute();
  }

  public void setPv(int pv) {
    this.pv = pv;
  }

  public void setInit(int init) {
    this.init = init;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public void setScoreDeCaracteristiqueMap(
      Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap) {
    this.scoreDeCaracteristiqueMap = scoreDeCaracteristiqueMap;
  }

  public void setTypeDattaque(Map<TypeDattaque, Integer> typeDattaque) {
    this.typeDattaque = typeDattaque;
  }
}
