package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

/**
 * La classe DonjonObject représente un objet dans un donjon.
 */
public class DonjonObject {
  protected Point2D position;
  protected String asciiChar;
  protected Color color;

  /**
   * Construit un objet DonjonObject avec les informations données.
   *
   * @param position La position de l'objet.
   * @param asciiChar Le caractère ASCII représentant l'objet.
   * @param color  La couleur de l'objet.
   */
  public DonjonObject(Point2D position, String asciiChar, Color color) {
    this.position = position;
    this.asciiChar = asciiChar;
    this.color = color;
  }

  public Point2D getPosition() {
    return position;
  }

  public void setPosition(Point2D position) {
    this.position = position;
  }

  public String getAsciiChar() {
    return asciiChar;
  }

  public void setAsciiChar(String asciiChar) {
    this.asciiChar = asciiChar;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }


}
