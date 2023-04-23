package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import fr.uvsq.pglp.roguelike.personnage.Pnj;
import org.fusesource.jansi.Ansi.Color;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private Personnage pj ;
    private PersonnageDonjon pjDonjon;
    private List<Pnj> pnjList;
    private List<PnjDonjon> pnjDonjonList;

    public DonjonGeneartion(Personnage pj, List<Pnj> pnjList) {
        this.pj = pj;
        this.pnjList = pnjList ;
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
    }
    private void generatepiecefixe(){
    map = new DonjonObject[profondeur][largeur];
    //creer des salles
    for (int i = 0; i < profondeur; i++) {
        for (int j = 0; j < largeur; j++) {
            if (i == 0 || i == profondeur - 1 || j == 0 || j == largeur - 1) {
                map[i][j] = new ComponentDonjon(new Point2D.Double(i, j), Color.CYAN, DonjonComponentType.OBSTACLE);
            } else map[i][j] = new ComponentDonjon(new Point2D.Double(i, j), Color.CYAN, DonjonComponentType.SOL);
            for (k = 1; k < nbrfloors; k++) {
                map[(roomSize + 1) * k][j] =
                        new ComponentDonjon(new Point2D.Double(i, j), Color.CYAN, DonjonComponentType.OBSTACLE);
            }
        }
        for (k = 1; k < nbRooms; k++) {
            map[i][(roomSize + 1) * k] =
                    new ComponentDonjon(new Point2D.Double(i, (roomSize + 1) * k), Color.CYAN, DonjonComponentType.OBSTACLE);
        }
    }
}

    private void createportealeatoire() {
        for(int level=1;level<nbrfloors;level++){
            for (k = 1; k <= nbRooms; k++) {
                random = rand.nextInt((roomSize * k) - roomSize*(k-1)-1) + roomSize*(k-1)+k;
                map[(roomSize + 1) * level][random] =
                        new ComponentDonjon(new Point2D.Double((roomSize + 1) * level, random), Color.CYAN, DonjonComponentType.PORTE);
            }
        }
        for(int room=1;room<nbRooms;room++){
            for (k = 1; k <= nbrfloors; k++) {
                random = rand.nextInt((roomSize * k) - roomSize*(k-1) - 1) + roomSize*(k-1)+k;
                map[random][(roomSize + 1) * room] =
                        new ComponentDonjon(new Point2D.Double(random, (roomSize + 1) * room), Color.CYAN, DonjonComponentType.PORTE);
            }
        }
    }

    private void determinateRoom() {
        for (int i = 0; i < profondeur-roomSize; i = i + roomSize+1) {
            for (int j = 0; j < largeur-roomSize; j=j+roomSize+1) {
                int hgI = i + 1;
                int hdI = hgI;
                int bgI = i+roomSize;
                int bdI = bgI;

                int hgJ = j+1;
                int hdJ = roomSize+j;
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
    private void initPj(){
        this.pjDonjon=new PersonnageDonjon(pj,new Point2D.Double(1,1));
        ajoutMap(this.pjDonjon);

    }
    private void ajoutMap(DonjonObject donjonObject){
        this.map[(int)donjonObject.position.getX()][(int)donjonObject.position.getY()]=donjonObject;
    }
    private void initPnj(){
        for(Pnj pnj: this.pnjList){
            PnjDonjon pnjDonjon = new PnjDonjon(pnj, );
        }
     for (RoomDonjon roomDonjon : roomsDonjon){

         }
     }

}
