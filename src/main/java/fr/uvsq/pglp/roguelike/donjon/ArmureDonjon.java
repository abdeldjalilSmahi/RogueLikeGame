package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.Armure;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi;

public class ArmureDonjon extends DonjonObject {

  private ArmureDonjType armureDonjType;
  private Armure armure;

  public ArmureDonjon(Point2D position, Ansi.Color color, ArmureDonjType armureDonjType) {
    super(position, armureDonjType.getAsciiChar(), color);
    this.armureDonjType = armureDonjType;
    this.armure = armureDonjType.getArmure();
  }

  public ArmureDonjType getArmureDonjType() {
    return armureDonjType;
  }

  public Armure getArmure() {
    return armure;
  }
}
