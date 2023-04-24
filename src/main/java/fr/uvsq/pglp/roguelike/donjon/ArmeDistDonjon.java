package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.ArmeDistance;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

/** la classe des armes de distance dans le donjon. */
public class ArmeDistDonjon extends DonjonObject {
  /** arme de distance  a enrichir par une position. */
  private ArmeDistDonjType armeDistDonjType;

  private ArmeDistance armeDistance;

  /**
   * le constructeur de ArmeDisDonjon.
   *
   * @param position de l'arme de distance dans le donjon.
   * @param color de l'arme distance.
   * @param armeDistDonjType type de l'arme de distance.
   */
  public ArmeDistDonjon(Point2D position, Color color, ArmeDistDonjType armeDistDonjType) {
    super(position, armeDistDonjType.getAsciiChar(), color);
    this.armeDistDonjType = armeDistDonjType;
    this.armeDistance = armeDistDonjType.getArmeDistance();
  }

  public ArmeDistDonjType getArmeDistDonjType() {
    return armeDistDonjType;
  }

  public ArmeDistance getArmeDistance() {
    return armeDistance;
  }

  public int getDamage() {
    return this.armeDistance.calculDamage();
  }
}
