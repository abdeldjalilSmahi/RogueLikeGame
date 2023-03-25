package fr.uvsq.pglp.roguelike.equipement;

import java.util.Random;

public class ArmeContact implements Equipement {
  private ArmeContactType armeContactType ;
  private int de ;
  private int nbreDe ;
  private int prix ;
  private Random random;

  public ArmeContact(ArmeContactType armeContactType, Random random) {
    this.armeContactType = armeContactType;
    this.de = armeContactType.de;
    this.nbreDe = armeContactType.nbreDe;
    this.prix = armeContactType.prix;
    this.random = random;
  }

  private void setRandom(Random random) {
    this.random = random;
  }

  private int calculDamage(){
    int dm = 0;
    for(int i = 0 ; i < this.nbreDe ; i++){
      dm += this.random.nextInt(this.de + 1);
    }
    return dm ;
  }

  @Override
  public int getBonus() {
    return calculDamage() ;
  }
}
