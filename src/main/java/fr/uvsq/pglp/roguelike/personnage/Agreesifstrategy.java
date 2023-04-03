package fr.uvsq.pglp.roguelike.personnage;

public class Agreesifstrategy implements Strategy {
  private Pnj pnj;
  private Personnage personnage ;

  public Agreesifstrategy(Pnj pnj, Personnage personnage) {
    this.pnj = pnj;
    this.personnage = personnage;
  }

  @Override
  public void execute() {

  }
}
