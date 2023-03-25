package fr.uvsq.pglp.roguelike.equipement;

public enum ArmeContactType {
  GOURDIN(1, 4, 1),
  BATON(1, 4, 1),
  BATON_FEREE(1, 6, 2),
  DAGUE(1, 4, 3),
  EPEE_BATARDE(1, 12, 9),
  HACHE(1, 8, 6)

  ;
  int nbreDe;
  int de;
  int prix ;

  ArmeContactType(int nbreDe, int de, int prix ) {
    this.nbreDe = nbreDe ;
    this.de = de ;
    this.prix = prix ;
  }


}
