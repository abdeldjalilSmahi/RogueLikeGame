package fr.uvsq.pglp.roguelike.personnage;

import fr.uvsq.pglp.roguelike.donjon.DonjonObject;
import fr.uvsq.pglp.roguelike.donjon.PnjDonjon;
import fr.uvsq.pglp.roguelike.donjon.RoomDonjon;
import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.ArmeContactType;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistance;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistanceType;
import fr.uvsq.pglp.roguelike.equipement.Armure;
import fr.uvsq.pglp.roguelike.equipement.ArmureType;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Amicalstategie implements Strategy {
  DonjonObject[][] map;
  int roomSize;
  List<RoomDonjon> roomsDonjon;

  Point2D position;
  public Amicalstategie(DonjonObject[][] map,int roomSize,List<RoomDonjon> roomsDonjon,Point2D position) {
      this.map=map;
      this.position=position;
      this.roomsDonjon=roomsDonjon;
      this.roomSize=roomSize;
  }

  @Override
  public void execute() {afficherinfos();}
  public void afficherinfos(){
    int x = (int) (position.getX() % roomSize);
    int y = (int) (position.getY() % roomSize);
    int numberroom=x*y;
    for(int i = (int) roomsDonjon.get(numberroom).getHautDroit().getX();i<=roomsDonjon.get(numberroom).getBasGauche().getX();i++){
      for(int j = (int) roomsDonjon.get(numberroom).getHautDroit().getY();j<=roomsDonjon.get(numberroom).getHautGauche().getY();j++){
        if(map[i][j] instanceof PnjDonjon)
          System.out.println("Y a un pnj à la position"+"("+i+" "+j+")");
      }
    }

  }
}
