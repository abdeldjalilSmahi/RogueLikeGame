package fr.uvsq.pglp.roguelike.personnage;

/**
 * Classe représentant un pnj du jeu.
 */
public class Pnj extends Personnage {

  private Strategy strategy;

  /**
   * Constructeur de la classe {@link Personnage}.
   *
   * @param builder pour construire le personnage.
   */
  protected Pnj(Pnjbuilder builder) {
    super(builder);
    this.strategy = builder.strategy;
  }

  public void proofaction() {
    strategy.execute();
  }

  /**
   * Classe interne permettant de construire un objet Pnj.
   */
  public static class Pnjbuilder extends Builder {

    private Strategy strategy;

    /**
     * Constructeur prenant en paramètre le nom du personnage.
     *
     * @param name Le nom du personnage.
     */
    public Pnjbuilder(String name) {
      super(name);
    }

    public void setStrategy(Strategy strategy) {
      this.strategy = strategy;
    }
  }
}
