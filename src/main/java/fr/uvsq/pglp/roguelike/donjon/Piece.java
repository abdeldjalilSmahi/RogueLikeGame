package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import java.util.Random;
import org.fusesource.jansi.Ansi.Color;

/**
 * Classe représentant une pièce dans un donjon.
 */
public class Piece extends DonjonObject {
  public int value;

  public Piece(Point2D position) {
    super(position, " € ", Color.RED);
    this.value = new Random().nextInt(15) + 5;
  }

  public int getValue() {
    return value;
  }
}
