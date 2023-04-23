package fr.uvsq.pglp.roguelike.donjon;


public class Donjon {

  private Strategie strategie;
  // private Map <DonjonObject, Point2D>allElements;

  public void setStrategie(Strategie strategie) {
    this.strategie = strategie;
  }

  public void genererDonjon() {
    strategie.makedonjon();
  }
}
