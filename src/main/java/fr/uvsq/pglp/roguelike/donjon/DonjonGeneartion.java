package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import fr.uvsq.pglp.roguelike.personnage.Pnj;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.fusesource.jansi.Ansi.Color;

public class DonjonGeneartion implements Strategie {

  public int random;
  private DonjonObject[][] map;
  private final Random rand = new Random();
  int nbRooms = 3;
  int roomSize = 6;
  int nbrfloors = 3;
  int profondeur = (nbrfloors * roomSize) + 2 + (nbrfloors - 1);
  int largeur = (nbRooms * roomSize) + 2 + nbRooms - 1;
  int k;
  List<RoomDonjon> roomsDonjon = new ArrayList<>();
  private Personnage pj;
  private PersonnageDonjon pjDonjon;
  private List<Pnj> pnjList;
  private List<PnjDonjon> pnjDonjonList;

  private Map<Point2D, DonjonObject> allDonjonObjects = new HashMap<>();

  public DonjonGeneartion(Personnage pj) {
    this.pj = pj;
    //        this.pnjList = pnjList ;
  }

  public List<RoomDonjon> getRoomsDonjon() {
    return roomsDonjon;
  }

  public DonjonObject[][] getMap() {
    return map;
  }

  @Override
  public void makedonjon() {
    generatepiecefixe();
    createportealeatoire();
    determinateRoom();
    initPj();
    initPnj();
  }

  private void generatepiecefixe() {
    map = new DonjonObject[profondeur][largeur];
    // creer des salles
    for (int i = 0; i < profondeur; i++) {
      for (int j = 0; j < largeur; j++) {
        if (i == 0 || i == profondeur - 1 || j == 0 || j == largeur - 1) {
          Point2D point2D = new Point2D.Double(i, j);
          ComponentDonjon componentDonjon =
              new ComponentDonjon(point2D, Color.CYAN, DonjonComponentType.OBSTACLE);
          map[i][j] = componentDonjon;
          this.addToHashMap(point2D, componentDonjon);
        } else {
          Point2D point2D = new Point2D.Double(i, j);
          ComponentDonjon componentDonjon =
              new ComponentDonjon(new Point2D.Double(i, j), Color.CYAN, DonjonComponentType.SOL);
          map[i][j] = componentDonjon;
          this.addToHashMap(point2D, componentDonjon);
        }
        for (k = 1; k < nbrfloors; k++) {
          Point2D point2D = new Point2D.Double((roomSize + 1) * k, j);
          ComponentDonjon componentDonjon =
              new ComponentDonjon(
                  new Point2D.Double(i, j), Color.CYAN, DonjonComponentType.OBSTACLE);
          map[(roomSize + 1) * k][j] = componentDonjon;
          this.addToHashMap(point2D, componentDonjon);
        }
      }
      for (k = 1; k < nbRooms; k++) {
        Point2D point2D = new Point2D.Double(i, (roomSize + 1) * k);
        ComponentDonjon componentDonjon =
            new ComponentDonjon(
                new Point2D.Double(i, (roomSize + 1) * k),
                Color.CYAN,
                DonjonComponentType.OBSTACLE);
        map[i][(roomSize + 1) * k] = componentDonjon;
        this.addToHashMap(point2D, componentDonjon);
      }
    }
  }

  private void createportealeatoire() {
    for (int level = 1; level < nbrfloors; level++) {
      for (k = 1; k <= nbRooms; k++) {
        random = rand.nextInt((roomSize * k) - roomSize * (k - 1) - 1) + roomSize * (k - 1) + k;
        Point2D point2D = new Point2D.Double((roomSize + 1) * level, random);
        ComponentDonjon componentDonjon =
            new ComponentDonjon(
                new Point2D.Double((roomSize + 1) * level, random),
                Color.CYAN,
                DonjonComponentType.PORTE);
        map[(roomSize + 1) * level][random] = componentDonjon;
        this.addToHashMap(point2D, componentDonjon);
      }
    }
    for (int room = 1; room < nbRooms; room++) {
      for (k = 1; k <= nbrfloors; k++) {
        random = rand.nextInt((roomSize * k) - roomSize * (k - 1) - 1) + roomSize * (k - 1) + k;
        Point2D point2D = new Point2D.Double(random, (roomSize + 1) * room);
        ComponentDonjon componentDonjon =
            new ComponentDonjon(
                new Point2D.Double(random, (roomSize + 1) * room),
                Color.CYAN,
                DonjonComponentType.PORTE);
        map[random][(roomSize + 1) * room] = componentDonjon;
        this.addToHashMap(point2D, componentDonjon);
      }
    }
  }

  private void determinateRoom() {
    for (int i = 0; i < profondeur - roomSize; i = i + roomSize + 1) {
      for (int j = 0; j < largeur - roomSize; j = j + roomSize + 1) {
        int hgI = i + 1;
        int hdI = hgI;
        int bgI = i + roomSize;
        int bdI = bgI;

        int hgJ = j + 1;
        int hdJ = roomSize + j;
        int bgJ = hgJ;
        int bdJ = hdJ;

        Point2D hgPoint = new Point2D.Double(hgI, hgJ);
        Point2D hdPoint = new Point2D.Double(hdI, hdJ);
        Point2D bgPoint = new Point2D.Double(bgI, bgJ);
        Point2D bdPoint = new Point2D.Double(bdI, bdJ);

        RoomDonjon room = new RoomDonjon(hgPoint, hdPoint, bgPoint, bdPoint);
        roomsDonjon.add(room);
      }
    }
  }

  private void initPj() {
    Point2D point2D = new Point2D.Double(1, 1);
    this.pjDonjon = new PersonnageDonjon(pj, point2D);
    ajoutMap(this.pjDonjon);
    this.addToHashMap(point2D, this.pjDonjon);
  }

  private void ajoutMap(DonjonObject donjonObject) {
    this.map[(int) donjonObject.position.getX()][(int) donjonObject.position.getY()] = donjonObject;
  }

  private void initPnj() {

    for (RoomDonjon roomDonjon : roomsDonjon) {
      int nbrofdange = rand.nextInt(3) + 2;
      for (int k = 0; k < nbrofdange; k++) {
        Personnage.Builder builder = new Personnage.Builder("za3im");
        Pnj pnj = new Pnj(builder);
        Point2D point2D;
        do {
          int x =
              rand.nextInt(
                      (int) (roomDonjon.getBasGauche().getX() - roomDonjon.getHautGauche().getX())
                          + 1)
                  + (int) roomDonjon.getHautGauche().getX();
          int y =
              rand.nextInt(
                      (int) (roomDonjon.getHautDroit().getY() - roomDonjon.getHautGauche().getY())
                          + 1)
                  + (int) roomDonjon.getHautGauche().getY();
          point2D = new Double(x, y);
        } while (!validateposition(point2D));
        PnjDonjon pnjDonjon = new PnjDonjon(pnj, point2D);
        this.ajoutMap(pnjDonjon);
        this.addToHashMap(point2D, pnjDonjon);
      }
    }
  }

  private boolean validateposition(Point2D point2D) {
    return allDonjonObjects.get(point2D).getAsciiChar() == DonjonComponentType.SOL.getAsciiChar();
  }

  private void addToHashMap(Point2D key, DonjonObject value) {
    this.allDonjonObjects.put(key, value);
  }
}
