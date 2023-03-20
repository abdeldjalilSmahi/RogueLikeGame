package fr.uvsq.pglp.roguelike.Equipement;

public enum ArmeContactType {
  Baton(4,2,0),
  BatonFerre(6,2,2);


  private int De;
  private int nbrMain;
  private int prix;

  ArmeContactType(int de, int nbrMain, int prix) {
    De = de;
    this.nbrMain = nbrMain;
    this.prix = prix;
  }

  public int getDe() {
    return De;
  }

  public int getNbrMain() {
    return nbrMain;
  }

  public int getPrix() {
    return prix;
  }
}
