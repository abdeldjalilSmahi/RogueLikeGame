package fr.uvsq.pglp.roguelike.personnage;

import fr.uvsq.pglp.roguelike.donjon.DonjonObject;
import fr.uvsq.pglp.roguelike.donjon.PnjDonjon;
import fr.uvsq.pglp.roguelike.donjon.RoomDonjon;
import java.awt.geom.Point2D;
import java.util.List;

/** La classe Amicalstategie permet au pj de communiquer avec le pnj amicalm. */
public class Amicalstategie implements Strategy {
  DonjonObject[][] map;
  int roomSize;
  List<RoomDonjon> roomsDonjon;

  Point2D position;

  /**
   * constructeur de la class AmicalStrategie.
   *
   * @param map La carte du donjon.
   * @param roomSize La taille d'une salle.
   * @param roomsDonjon La liste des salles du donjon.
   * @param position La position du pj
   */
  public Amicalstategie(
      DonjonObject[][] map, int roomSize, List<RoomDonjon> roomsDonjon, Point2D position) {
    this.map = map;
    this.position = position;
    this.roomsDonjon = roomsDonjon;
    this.roomSize = roomSize;
  }

  @Override
  public void execute() {
    afficherinfos();
  }

  /** Affiche les informations des PNJ dans la salle du personnage. */
  public void afficherinfos() {
    int x = (int) (position.getX() % roomSize);
    int y = (int) (position.getY() % roomSize);
    int numberroom = x * y;
    for (int i = (int) roomsDonjon.get(numberroom).getHautDroit().getX();
        i <= roomsDonjon.get(numberroom).getBasGauche().getX();
        i++) {
      for (int j = (int) roomsDonjon.get(numberroom).getHautDroit().getY();
          j <= roomsDonjon.get(numberroom).getHautGauche().getY();
          j++) {
        if (map[i][j] instanceof PnjDonjon) {
          if(map[i][j].getAsciiChar().equals(" A ")){
            System.out.println("Y a un pnj à la position" + "(" + i + " " + j + ")");
          }

        }
      }
    }
  }
}
