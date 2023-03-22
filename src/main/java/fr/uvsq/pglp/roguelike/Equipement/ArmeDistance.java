package fr.uvsq.pglp.roguelike.Equipement;

import java.util.Random;

public class ArmeDistance implements Equipement{


  private ArmeDistanceType armeDistance;
  private int degat;
  private int prix;
  private int de;
  private int nbrDede;
  private int portee;
  private Random random = new Random(new Random().nextInt());

  public ArmeDistance(ArmeDistanceType armeDistance) {
    this.armeDistance = armeDistance;
    this.prix = armeDistance.getPrix();
    this.de = armeDistance.getDe();
    this.nbrDede=armeDistance.getNbrDede();
    this.portee=armeDistance.getPortee();
    calculdegat();
  }

  private void calculdegat(){
    if (nbrDede==1) this.degat=random.nextInt(de)+1;
    else {

    }
  }

  public int getPortee() {
    return portee;
  }

  public int getDegat() {
    return degat;
  }

  public int getPrix() {
    return prix;
  }

}
