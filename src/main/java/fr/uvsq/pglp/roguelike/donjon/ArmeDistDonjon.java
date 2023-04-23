package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.ArmeDistance;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

public class ArmeDistDonjon extends DonjonObject {
  private ArmeDistDonjType armeDistDonjType;
  private ArmeDistance armeDistance;

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
