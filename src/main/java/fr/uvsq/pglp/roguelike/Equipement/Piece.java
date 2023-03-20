package fr.uvsq.pglp.roguelike.Equipement;

public class Piece implements Equipement {

  private int nbr = 5;

  public Piece() {
  }

  private void depense(int prix) {
    this.nbr = this.nbr - prix;
  }

  private void collect(int piece) {
    this.nbr = this.nbr + piece;
  }

  public int getNbr() {
    return nbr;
  }
}
