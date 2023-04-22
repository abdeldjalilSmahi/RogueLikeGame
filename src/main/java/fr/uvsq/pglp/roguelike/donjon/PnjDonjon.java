package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Pnj;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

public class PnjDonjon extends Creature{

  private Pnj pnj;

  public PnjDonjon(Point2D position, String asciiChar, Color color) {
    super(position, asciiChar, color);
  }

  @Override
  public boolean canMoveTo(Point2D position) {
    return false;
  }
}
