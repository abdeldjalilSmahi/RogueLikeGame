package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

/** la classe Arme contact dans le donjon. */
public class ArmeConDonjon extends DonjonObject {
  /** arme de contact a enrichir par une position. */
  private ArmeContact armeContact;

  private ArmeConDonjType armeConDonjType;

  /**
   * constructeur de ArmeCondonjn.
   *
   * @param position de l'arme de contact dans le donjon.
   * @param color la couleur de l'arme contact.
   * @param armeConDonjType le type de l'arme contact.
   */
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
