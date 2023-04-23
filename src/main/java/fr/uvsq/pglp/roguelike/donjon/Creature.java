package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import java.util.Map;
import org.fusesource.jansi.Ansi;

public abstract class Creature extends DonjonObject {
  public Creature(Point2D position, String asciiChar, Ansi.Color color) {
    super(position, asciiChar, color);
  }

  public abstract boolean canMoveTo(Point2D newPosition, Map<Point2D, DonjonObject> map);



}


