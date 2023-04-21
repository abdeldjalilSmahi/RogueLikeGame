package fr.uvsq.pglp.roguelike.donjon;

import org.fusesource.jansi.Ansi.Color;

import java.awt.geom.Point2D;
import java.util.Random;

public class DonjonComponent implements Strategie {

    public int random;
    private DonjonObject[][] map;
    private final Random rand = new Random();

    public DonjonObject[][] getMap() {
        return map;
    }

    @Override
    public void setup() {
        int nbRooms = 4;
        int roomSize = 6;
        int nbrfloors = 2;
        int profondeur = (nbrfloors * roomSize) + 2 + (nbrfloors - 1);
        int largeur = (nbRooms * roomSize) + 2 + nbRooms - 1;
        int k;

        // Initialisation de la carte de donjon
        map = new DonjonObject[profondeur][largeur];

        for (int i = 0; i < profondeur; i++) {
            for (int j = 0; j < largeur; j++) {
                if (i == 0 || i == profondeur - 1 || j == 0 || j == largeur - 1) {
                    map[i][j] = new DonjonObject(new Point2D.Double(i, j), " # ", Color.CYAN);
                } else map[i][j] = new DonjonObject(new Point2D.Double(i, j), " . ", Color.CYAN);
                for (k = 1; k < nbrfloors; k++) {
                    map[(roomSize + 1) * k][j] =
                            new DonjonObject(new Point2D.Double(i, j), " # ", Color.CYAN);

                }
            }
            for (k = 1; k < nbRooms; k++) {
                map[i][(roomSize + 1) * k] =
                        new DonjonObject(new Point2D.Double(i, (roomSize + 1) * k), " # ", Color.CYAN);
            }
        }
        for(int level=1;level<nbrfloors;level++){
            for (k = 1; k <= nbRooms; k++) {
                random = rand.nextInt((roomSize * k) - roomSize*(k-1)-1) + roomSize*(k-1)+k;
                map[(roomSize + 1) * level][random] =
                        new DonjonObject(new Point2D.Double((roomSize + 1) * level, random), " P ", Color.CYAN);
            }
        }
        for(int room=1;room<nbRooms;room++){
            for (k = 1; k <= nbrfloors; k++) {
                random = rand.nextInt((roomSize * k) - roomSize*(k-1) - 1) + roomSize*(k-1)+k;
                map[random][(roomSize + 1) * room] =
                        new DonjonObject(new Point2D.Double(0, 0), " P ", Color.CYAN);
            }
        }

    }
}
