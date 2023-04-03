package fr.uvsq.pglp.roguelike.personnage;

public class Pnj extends Personnage {


  /**
   * Constructeur de la classe {@link Personnage}.
   *
   * @param builder pour construire le personnage.
   */
  protected Pnj(Builder builder) {
    super(builder);
  }
  public static class Pnjbuilder extends Builder {

    /**
     * Constructeur prenant en paramètre le nom du personnage.
     *
     * @param name Le nom du personnage.
     */
    public Pnjbuilder(String name) {
      super(name);

    }
  }
}
