package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.ComponentDonjon;
import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.DonjonComponentType;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;
import fr.uvsq.pglp.roguelike.donjon.Piece;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi;

/**
 *une Classe permet de ramasser une pièce à partir d'une position donnée dans le donjon.
 */
public class RamasserPiece implements Command {
  Donjon donjon;
  private PersonnageDonjon personnageDonjon;

  public RamasserPiece(Donjon donjon) {
    this.donjon = donjon;
    this.personnageDonjon = donjon.getPersonnageDonjon();
  }

  @Override
  public void execut() {
    Point2D.Double[] adjacentPositions = {
      new Point2D.Double(
          personnageDonjon.getPosition().getX() + 1, personnageDonjon.getPosition().getY()),
      new Point2D.Double(
          personnageDonjon.getPosition().getX() - 1, personnageDonjon.getPosition().getY()),
      new Point2D.Double(
          personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() - 1),
      new Point2D.Double(
          personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() + 1)
    };
    for (Point2D.Double adjacentPosition : adjacentPositions) {
      if (donjon.getAllElements().get(adjacentPosition).getAsciiChar() == " € ") {
        Piece piece = (Piece) donjon.getAllElements().get(adjacentPosition);
        donjon
            .getAllElements()
            .put(
                adjacentPosition,
                new ComponentDonjon(
                    new Point2D.Double(adjacentPosition.getX(), adjacentPosition.getY()),
                    Ansi.Color.CYAN,
                    DonjonComponentType.SOL));
        personnageDonjon
            .getPersonnage()
            .setPieces(personnageDonjon.getPersonnage().getPieces() - piece.getValue());
        donjon.updateMap();
      }
    }
  }
}
