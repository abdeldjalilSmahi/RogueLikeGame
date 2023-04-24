package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.Armure;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi;

/** la classe des armures dans le donjon. */
public class ArmureDonjon extends DonjonObject {
  /** armure a enrichir par une position. */
  private ArmureDonjType armureDonjType;

  private Armure armure;

  /**
   * consructeur de ArmureDonjon.
   *
   * @param position de l'armure dans le donjon.
   * @param color de l'armure dans le donjon.
   * @param armureDonjType de l'armure.
   */
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
