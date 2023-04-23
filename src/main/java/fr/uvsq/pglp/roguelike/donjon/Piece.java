package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import java.util.Random;
import org.fusesource.jansi.Ansi.Color;

public class Piece extends DonjonObject{
  private int value ;

  public Piece(Point2D position, String asciiChar, Color color) {
    super(position, " € ", color);
    this.value = new Random().nextInt(15)+1;
  }

  public int getValue() {
    return value;
  }
}
