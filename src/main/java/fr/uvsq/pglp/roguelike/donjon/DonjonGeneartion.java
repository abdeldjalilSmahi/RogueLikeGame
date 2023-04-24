package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.ArmeContactType;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistance;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistanceType;
import fr.uvsq.pglp.roguelike.personnage.Agreesifstrategy;
import fr.uvsq.pglp.roguelike.personnage.Amicalstategie;
import fr.uvsq.pglp.roguelike.personnage.Personnage;
import fr.uvsq.pglp.roguelike.personnage.Pnj;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.fusesource.jansi.Ansi.Color;

/** Classe pour la génération d'un donjon. */
public class DonjonGeneartion implements Strategie {

  public int random;
  private DonjonObject[][] map;
  private final Random rand = new Random();
  int nbRooms = 3;
  int roomSize = 6;
  int nbrfloors = 3;
  int profondeur = (nbrfloors * roomSize) + 2 + (nbrfloors - 1);
  int largeur = (nbRooms * roomSize) + 2 + nbRooms - 1;
  int indice;
  List<RoomDonjon> roomsDonjon = new ArrayList<>();
  private Personnage pj;
  private PersonnageDonjon pjDonjon;
  private List<Pnj> pnjList;
  private List<PnjDonjon> pnjDonjonList;

  private Map<Point2D, DonjonObject> allDonjonObjects;

  private List<MagasinDonjon> magasinsDonjon;

  /**
   * Constructeur de la classe DonjonGeneration.
   *
   * @param pj le personnage à placer dans le donjon.
   */
  public DonjonGeneartion(Personnage pj) {
    this.pj = pj;
    //        this.pnjList = pnjList ;
    magasinsDonjon = new ArrayList<>();
    pnjDonjonList = new ArrayList<>();
    allDonjonObjects = new HashMap<>();
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
    initPiece();
    initPiege();
    initMagasin();
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
        for (indice = 1; indice < nbrfloors; indice++) {
          Point2D point2D = new Point2D.Double((roomSize + 1) * indice, j);
          ComponentDonjon componentDonjon =
              new ComponentDonjon(
                  new Point2D.Double(i, j), Color.CYAN, DonjonComponentType.OBSTACLE);
          map[(roomSize + 1) * indice][j] = componentDonjon;
          this.addToHashMap(point2D, componentDonjon);
        }
      }
      for (indice = 1; indice < nbRooms; indice++) {
        Point2D point2D = new Point2D.Double(i, (roomSize + 1) * indice);
        ComponentDonjon componentDonjon =
            new ComponentDonjon(
                new Point2D.Double(i, (roomSize + 1) * indice),
                Color.CYAN,
                DonjonComponentType.OBSTACLE);
        map[i][(roomSize + 1) * indice] = componentDonjon;
        this.addToHashMap(point2D, componentDonjon);
      }
    }
  }

  private void createportealeatoire() {
    for (int level = 1; level < nbrfloors; level++) {
      for (indice = 1; indice <= nbRooms; indice++) {
        random =
            rand.nextInt((roomSize * indice) - roomSize * (indice - 1) - 1)
                + roomSize * (indice - 1)
                + indice;
        Point2D point2D = new Point2D.Double((roomSize + 1) * level, random);
        ComponentDonjon componentDonjon =
            new ComponentDonjon(
                new Point2D.Double((roomSize + 1) * level, random),
                Color.YELLOW,
                DonjonComponentType.PORTE);
        map[(roomSize + 1) * level][random] = componentDonjon;
        this.addToHashMap(point2D, componentDonjon);
      }
    }
    for (int room = 1; room < nbRooms; room++) {
      for (indice = 1; indice <= nbrfloors; indice++) {
        random =
            rand.nextInt((roomSize * indice) - roomSize * (indice - 1) - 1)
                + roomSize * (indice - 1)
                + indice;
        Point2D point2D = new Point2D.Double(random, (roomSize + 1) * room);
        ComponentDonjon componentDonjon =
            new ComponentDonjon(
                new Point2D.Double(random, (roomSize + 1) * room),
                Color.YELLOW,
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
    List<ArmeContactType> armeContactTypes = Arrays.asList(ArmeContactType.values());
    List<ArmeDistanceType> armeDistanceTypes = Arrays.asList(ArmeDistanceType.values());
    int cpt = 0;
    for (RoomDonjon roomDonjon : roomsDonjon) {
      ArmeContactType armeContactType =
          armeContactTypes.get(new Random().nextInt(armeContactTypes.size()));
      ArmeDistanceType armeDistanceType =
          armeDistanceTypes.get(new Random().nextInt(armeDistanceTypes.size()));
      ArmeContact armeContact = new ArmeContact(armeContactType);
      ArmeDistance armeDistance = new ArmeDistance(armeDistanceType);
      Personnage.Builder builder = new Personnage.Builder("za3im");
      Pnj pnj = new Pnj(builder);
      if (cpt % 2 == 0) {
        Agreesifstrategy agreesifstrategy = new Agreesifstrategy(pnj, armeContact);
        pnj.setStrategy(agreesifstrategy);
      } else {
        Agreesifstrategy agreesifstrategy = new Agreesifstrategy(pnj,armeDistance);
        pnj.setStrategy(agreesifstrategy);
      }
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

      PnjDonjon pnjDonjon = new PnjDonjon(pnj, " A ", point2D);
      pnjDonjonList.add(pnjDonjon);

      this.ajoutMap(pnjDonjon);
      this.addToHashMap(point2D, pnjDonjon);
      cpt++;
    }
    for (RoomDonjon roomDonjon : roomsDonjon) {

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
      Personnage.Builder builder = new Personnage.Builder("OUSSAMA");
      Pnj pnj = new Pnj(builder);
      Amicalstategie amicalstategie =
          new Amicalstategie(this.map, this.roomSize, this.roomsDonjon, point2D);
      pnj.setStrategy(amicalstategie);

      PnjDonjon pnjDonjon = new PnjDonjon(pnj, " T ", point2D);
      pnjDonjonList.add(pnjDonjon);

      this.ajoutMap(pnjDonjon);
      this.addToHashMap(point2D, pnjDonjon);
    }
  }

  private boolean validateposition(Point2D point2D) {
    return allDonjonObjects.get(point2D).getAsciiChar() == DonjonComponentType.SOL.getAsciiChar();
  }

  private void addToHashMap(Point2D key, DonjonObject value) {
    this.allDonjonObjects.put(key, value);
  }

  private void initPiece() {
    for (RoomDonjon roomDonjon : roomsDonjon) {
      for (int k = 0; k < 2; k++) {
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
        Piece piece = new Piece(point2D);
        this.ajoutMap(piece);
        this.addToHashMap(point2D, piece);
      }
    }
  }

  private void initPiege() {
    for (RoomDonjon roomDonjon : roomsDonjon) {
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
      Piege piege = new Piege(point2D);
      this.ajoutMap(piege);
      this.addToHashMap(point2D, piege);
    }
  }

  private void initMagasin() {
    int cpt = 0;
    for (RoomDonjon roomDonjon : roomsDonjon) {
      if (cpt % 2 == 0) {
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
        MagasinDonjon magasinDonjon = new MagasinDonjon(point2D);
        this.ajoutMap(magasinDonjon);
        this.magasinsDonjon.add(magasinDonjon);
        this.addToHashMap(point2D, magasinDonjon);
      }
      cpt++;
    }
  }

  public PersonnageDonjon getPjDonjon() {
    return pjDonjon;
  }

  public List<PnjDonjon> getPnjDonjonList() {
    return pnjDonjonList;
  }

  public Map<Point2D, DonjonObject> getAllDonjonObjects() {
    return allDonjonObjects;
  }

  public List<MagasinDonjon> getMagasinsDonjon() {
    return magasinsDonjon;
  }
}
