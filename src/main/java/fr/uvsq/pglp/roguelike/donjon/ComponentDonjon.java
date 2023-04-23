package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;

public class ComponentDonjon extends DonjonObject {
  private DonjonComponentType donjonComponentType;

  public ComponentDonjon(Point2D position, Color color, DonjonComponentType donjonComponentType) {
    super(position, donjonComponentType.getAsciiChar(), color);
    this.donjonComponentType = donjonComponentType;
  }

  public DonjonComponentType getDonjonComponentType() {
    return donjonComponentType;
  }
}
