package fr.uvsq.pglp.roguelike.Equipement;

public enum ArmeContactType {
  Baton(4,1,0),
  BatonFerre(6,1,2),
  Dague(4,1,3),
  Épée2mains(6,2,10);

  private int De;
  private int prix;
  private int nbrDede;

  ArmeContactType(int de, int nbrDede,int prix) {
    this.De = de;
    this.prix = prix;
    this.nbrDede=nbrDede;
  }

  public int getDe() {
    return De;
  }

  public int getNbrDede() {
    return nbrDede;
  }

  public int getPrix() {
    return prix;
  }
}
