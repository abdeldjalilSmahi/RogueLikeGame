package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

public class ArmeConDonjon extends DonjonObject {
  private ArmeContact armeContact;
  private ArmeConDonjType armeConDonjType;

  public ArmeConDonjon(Point2D position, Color color, ArmeConDonjType armeConDonjType) {
    super(position, armeConDonjType.getAsciiChar(), color);
    this.armeConDonjType = armeConDonjType;
    this.armeContact = armeConDonjType.getArmeContact();
  }

  public ArmeContact getArmeContact() {
    return armeContact;
  }

  public ArmeConDonjType getArmeConDonjType() {
    return armeConDonjType;
  }

  @Override
  public String toString() {
    return this.armeConDonjType.getAsciiChar();
  }
}
