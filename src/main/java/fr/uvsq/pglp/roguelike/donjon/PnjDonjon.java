package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Pnj;
import java.awt.geom.Point2D;
import java.util.Map;

import org.fusesource.jansi.Ansi.Color;

public class PnjDonjon extends Creature {

  private Pnj pnj;
  String ascichar;

  public PnjDonjon(Pnj pnj, String ascichar,Point2D position) {
    super(position, ascichar, Color.CYAN);
    this.pnj = pnj;
    this.ascichar=ascichar;
  }

  @Override
  public boolean canMoveTo(Point2D newPosition, Map<Point2D, DonjonObject> map,Donjon donjon) {
    if (map.get(newPosition).getAsciiChar()!=DonjonComponentType.SOL.getAsciiChar()) {
      return false;
    }
    return true;
  }

  public void moveTo(Point2D newPosition, Donjon donjon) {
    if (canMoveTo(newPosition, donjon.getAllElements(),donjon)) {
      donjon.swapObjects(this, donjon.getObject(newPosition));
    }

  }
}
