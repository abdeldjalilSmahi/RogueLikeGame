package fr.uvsq.pglp.roguelike.donjon;


import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Donjon {

  private Strategie strategie;
   private Map<Point2D, DonjonObject> allElements;
   private List<RoomDonjon> rooms ;
   private PersonnageDonjon personnageDonjon ;
   private List<PnjDonjon> pnjDonjonList;
   private List<MagasinDonjon> magasinsDonjon;
   private DonjonObject[][] map;

  public Donjon(){
    this.allElements = new HashMap<>();
    this.rooms = new ArrayList<>();
    this.pnjDonjonList = new ArrayList<>();
    this.magasinsDonjon = new ArrayList<>();
  }

  public void setStrategie(Strategie strategie) {
    this.strategie = strategie;
  }

  public void genererDonjon() {
    strategie.makedonjon();
    this.map = this.strategie.getMap();
    this.allElements = this.strategie.getAllDonjonObjects();
    this.magasinsDonjon = this.strategie.getMagasinsDonjon();
    this.personnageDonjon = this.strategie.getPjDonjon();
    this.pnjDonjonList = this.strategie.getPnjDonjonList();
  }
  public void swapObjects(DonjonObject obj1, DonjonObject obj2){
    Point2D temp = obj1.getPosition();
    obj1.setPosition(obj2.getPosition());
    obj2.setPosition(temp);
    addObject(obj1.getPosition(),obj1);
    addObject(obj2.getPosition(),obj2);
    updateMap();
  }
  public void addObject(Point2D point2D, DonjonObject donjonObject){
    this.allElements.put(point2D, donjonObject);
  }
  private void ajoutMap(DonjonObject donjonObject) {
    this.map[(int) donjonObject.position.getX()][(int) donjonObject.position.getY()] = donjonObject;
  }
  private void removeObject(DonjonObject donjonObject){
    this.allElements.remove(donjonObject.getPosition());
  }

  public void updateMap(){
    for (Point2D key : allElements.keySet()) {
      int x = (int)key.getX();
      int y = (int)key.getY();
      this.map[x][y] = allElements.get(key);
    }
  }

  public Map<Point2D, DonjonObject> getAllElements() {
    return allElements;
  }
  public DonjonObject getObject(Point2D objectPosition){
    return allElements.get(objectPosition);
  }

  public PersonnageDonjon getPersonnageDonjon() {
    return personnageDonjon;
  }

  public DonjonObject[][] getMap() {
    return map;
  }

  public List<PnjDonjon> getPnjDonjonList() {
    return pnjDonjonList;
  }
}
