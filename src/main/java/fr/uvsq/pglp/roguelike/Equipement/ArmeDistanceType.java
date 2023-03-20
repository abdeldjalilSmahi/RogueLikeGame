package fr.uvsq.pglp.roguelike.Equipement;

public enum ArmeDistanceType {
  Arbaletedepoing(6,10,8),
  ArbaleteLegere(6,2,2);


  private int De;
  private int portee;
  private int prix;

  ArmeDistanceType(int de, int poertee, int prix) {
    De = de;
    this.portee = portee;
    this.prix = prix;
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
}
