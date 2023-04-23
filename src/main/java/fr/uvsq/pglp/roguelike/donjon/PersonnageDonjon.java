package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import java.awt.geom.Point2D;
import java.util.Map;
import org.fusesource.jansi.Ansi;

/**
 * La classe personnage dans le donjon.
 */
public class PersonnageDonjon extends Creature {

  /** Personnage a enrichir par une position. */
  private Personnage personnage;

  /**
   * Constructeur de personnageDonjon.
   *
   * @param personnage le personage.
   * @param position la position du personnage.
   */
  public PersonnageDonjon(Personnage personnage, Point2D position) {
    super(position, " @ ", Ansi.Color.CYAN);
    this.personnage = personnage;
  }

  public Personnage getPersonnage() {
    return personnage;
  }

  @Override
  public boolean canMoveTo(Point2D newPosition, Map<Point2D, DonjonObject> map) {
    if (map.get(newPosition).getAsciiChar() != DonjonComponentType.SOL.getAsciiChar()) {
      System.out.println("yeah");
      return false;
    }
    return true;
  }

  /**
   * Méthode permet de bouger le joueur.
   *
   * @param newPosition la nvl position.
   * @param donjon le donjon courant.
   */
  public void moveTo(Point2D newPosition, Donjon donjon) {
    if (canMoveTo(newPosition, donjon.getAllElements())) {
      donjon.swapObjects(this, donjon.getObject(newPosition));
    }
  }
}
