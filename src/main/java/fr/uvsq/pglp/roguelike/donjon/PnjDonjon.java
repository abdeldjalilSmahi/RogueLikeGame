package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Pnj;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

public class PnjDonjon extends Creature {

  private Pnj pnj;

  public PnjDonjon(Pnj pnj, Point2D position) {
    super(position, " $ ", Color.CYAN);
    this.pnj = pnj;
  }

  @Override
  public boolean canMoveTo(Point2D position) {
    return false;
  }
}
