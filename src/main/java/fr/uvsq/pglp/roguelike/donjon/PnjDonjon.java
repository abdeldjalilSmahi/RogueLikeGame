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
  public boolean canMoveTo(Point2D position, Map<Point2D, DonjonObject> map) {
    return false;
  }
}
