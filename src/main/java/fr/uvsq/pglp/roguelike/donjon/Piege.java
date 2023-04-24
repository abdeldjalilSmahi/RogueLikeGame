package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import java.util.Random;
import org.fusesource.jansi.Ansi.Color;

/**
 * La classe Piege représente un objet qui peut causer des dégâts au joueur s'il y marche dessus.
 */
public class Piege extends DonjonObject {

  private int damage;

  public Piege(Point2D position) {
    super(position, " & ", Color.BLUE);
    this.damage = new Random().nextInt(2) + 1;
  }

  public int getDamage() {
    return damage;
  }
}
