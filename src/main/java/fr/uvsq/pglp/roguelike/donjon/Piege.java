package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import java.util.Random;
import org.fusesource.jansi.Ansi.Color;

public class Piege extends DonjonObject{

  private int damage;
  public Piege(Point2D position, Color color) {
    super(position, " & ", color);
    this.damage = new Random().nextInt(4)+1;
  }

  public int getDamage() {
    return damage;
  }
}
