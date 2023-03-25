package fr.uvsq.pglp.roguelike.equipement;

public enum ArmeDistanceType {
  ARBALETE_POING(1, 6, 10, 8),
  ARBALETE_LEGERE(2, 4, 30, 10),
  ARBALETE_LOURDE(3, 4, 60, 12),
  ARC_COURT(1, 6, 30, 4),
  ARC_LONG(1, 8, 50, 5),
  DAGUE(1, 4, 5, 3),
  MOUSQUET(2, 6, 50, 20)
  ;
  int nbreDe;
  int de;
  int prix ;
  int portee;

  ArmeDistanceType(int nbreDe, int de, int portee, int prix ) {
    this.nbreDe = nbreDe ;
    this.de = de ;
    this.portee = portee ;
    this.prix = prix ;
  }


}
