package fr.uvsq.pglp.roguelike.Equipement;

import java.util.Random;

public class ArmeContact implements Equipement {

private ArmeContactType armecontact;
private int degat;
private int prix;
private int de;
private int nbrDede;
private Random random = new Random(new Random().nextInt());

  public ArmeContact(ArmeContactType armecontact) {
    this.armecontact = armecontact;
    this.prix = armecontact.getPrix();
    this.de = armecontact.getDe();
    this.nbrDede=armecontact.getNbrDede();
    calculdegat();
  }

  private void calculdegat(){
    if (nbrDede==1) this.degat=random.nextInt(de)+1;
    else {

    }
  }

  public int getDegat() {
    return degat;
  }

  public int getPrix() {
    return prix;
  }

}
