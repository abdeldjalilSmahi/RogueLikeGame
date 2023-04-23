package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import java.awt.geom.Point2D;
import java.util.Map;
import javax.sound.midi.Soundbank;
import org.fusesource.jansi.Ansi;

public class PersonnageDonjon extends Creature {
  private Personnage personnage;

  public PersonnageDonjon(Personnage personnage, Point2D position) {
    super(position, " @ ", Ansi.Color.CYAN);
    this.personnage = personnage;
  }

  public Personnage getPersonnage() {
    return personnage;
  }

  @Override
  public boolean canMoveTo(Point2D newPosition, Map<Point2D, DonjonObject> map) {
    if(map.get(newPosition).getAsciiChar() != DonjonComponentType.SOL.getAsciiChar()){
      System.out.println("Il s'agit d'un obstacle, tu peux pas bouger !! ");
      return false;
    }
    return true ;
  }
  public void moveTo(Point2D newPosition, Donjon donjon){
    if(canMoveTo(newPosition, donjon.getAllElements())){
      donjon.swapObjects(this, donjon.getObject(newPosition));
    }

  }
}
