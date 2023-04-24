package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

/**
 * La classe qui représente un composant d'un donjon.
 */
public class ComponentDonjon extends DonjonObject {
  private DonjonComponentType donjonComponentType;

  /**
   * constructeur de ComponentDonjon.
   *
   * @param position du composant dans le donjon
   * @param color du composant.
   * @param donjonComponentType le type de composant de donjon.
   */
  public ComponentDonjon(Point2D position, Color color, DonjonComponentType donjonComponentType) {
    super(position, donjonComponentType.getAsciiChar(), color);
    this.donjonComponentType = donjonComponentType;
  }

  public DonjonComponentType getDonjonComponentType() {
    return donjonComponentType;
  }
}
