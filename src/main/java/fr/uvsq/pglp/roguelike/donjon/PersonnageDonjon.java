package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import java.awt.geom.Point2D;
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
  public boolean canMoveTo(Point2D position) {
    return false;
  }
}
