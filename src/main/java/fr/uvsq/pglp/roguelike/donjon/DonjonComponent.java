package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

public class DonjonComponent implements Strategie {

  private DonjonObject map [][];

  public DonjonObject[][] getMap() {
    return map;
  }

  @Override
  public void setup() {
    int nbRooms =3 ;
    int roomSize = 6;
    int nbrfloors=3;
    int profondeur = (nbrfloors * roomSize)+2+(nbrfloors-1);
    int largeur = (nbRooms * roomSize)+2+nbRooms-1;

    // Initialisation de la carte de donjon
    map = new DonjonObject[profondeur][largeur];

    for (int i = 0; i <profondeur; i++) {
      for (int j = 0; j < largeur; j++) {
        if (i == 0 || i == profondeur - 1 || j == 0 || j == largeur - 1) {
          map[i][j] = new DonjonObject(new Point2D.Double(i, j), " # ", Color.CYAN);
        } else map[i][j] = new DonjonObject(new Point2D.Double(i, j), " . ", Color.CYAN);
        int k;
        for (k = 1; k < nbrfloors; k++) {
          map[(((nbrfloors * roomSize) / nbrfloors) + 1) * k][j] =
                  new DonjonObject(new Point2D.Double(i, j), " # ", Color.CYAN);
        }
        for (k = 1; k < nbRooms; k++) {
          map[i][(roomSize + 1) * k] =
                  new DonjonObject(new Point2D.Double(i, j), " # ", Color.CYAN);
        }


      }
    }
  }
}
