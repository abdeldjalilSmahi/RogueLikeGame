package fr.uvsq.pglp.roguelike.Equipement;

public enum ArmeDistanceType {
  Arbaletedepoing(6,1,10,8),
  ArbaleteLegere(6,2,2,2);


  private int De;
  private int portee;
  private int prix;
  private int nbrDede;

  ArmeDistanceType(int de, int poertee, int nbrDede,int prix) {
    this.De = de;
    this.portee = portee;
    this.prix = prix;
    this.nbrDede=nbrDede;
  }

  public int getDe() {
    return De;
  }

  public int getPortee() {
    return portee;
  }

  public int getPrix() {
    return prix;
  }

  public int getNbrDede() {
    return nbrDede;
  }
}
