package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Pnj;
import java.awt.geom.Point2D;
import java.util.Map;
import org.fusesource.jansi.Ansi.Color;

/** La classe PnjDonjon représente un personnage non joueur dans le donjon. */
public class PnjDonjon extends Creature {

  private Pnj pnj;
  String ascichar;

  /**
   * Constructeur de la classe PnjDonjon.
   *
   * @param pnj le personnage non joueur associé
   * @param ascichar Caractère ASCII représentant le composant dans le monde.
   * @param position la position du Caractère sur la carte.
   */
  public PnjDonjon(Pnj pnj, String ascichar, Point2D position) {
    super(position, ascichar, Color.CYAN);
    this.pnj = pnj;
    this.ascichar = ascichar;
  }

  @Override



  public boolean canMoveTo(Point2D newPosition, Map<Point2D, DonjonObject> map,Donjon donjon) {
    if (map.get(newPosition).getAsciiChar()!=DonjonComponentType.SOL.getAsciiChar()) {

      return false;
    }
    return true;
  }

  /**
   * Déplace l'instance à la position donnée sur la carte.
   *
   * @param newPosition
   * @param donjon
   */
  public void moveTo(Point2D newPosition, Donjon donjon) {
    if (canMoveTo(newPosition, donjon.getAllElements(),donjon)) {
      donjon.swapObjects(this, donjon.getObject(newPosition));
    }
  }
}
