package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;
import java.awt.geom.Point2D;

/** La classe Interaction est responsable de l'interaction entre le joueur et le jeu. */
public class Interaction {

  String input;
  Donjon donjon;
  PersonnageDonjon personnageDonjon;

  /**
   * Constructeur de la classe Interaction.
   *
   * @param input Entrées du joueur.
   * @param donjon Donjon dans lequel se déroule l'interaction.
   */
  public Interaction(String input, Donjon donjon) {
    this.input = input;
    this.donjon = donjon;
    this.personnageDonjon = this.donjon.getPersonnageDonjon();
  }

  /**
   * Convertit l'entrée du joueur en commande exécutable par le jeu.
   *
   * @return La commande correspondant à l'entrée du joueur.
   */

  public Command getCommande() {
    switch (input.toLowerCase()) {
      case "d":
        return new Move(
            donjon,
            new Point2D.Double(
                personnageDonjon.getPosition().getX() + 0,
                personnageDonjon.getPosition().getY() + 1));
      case "q":
        return new Move(
            donjon,
            new Point2D.Double(
                personnageDonjon.getPosition().getX() + 0,
                personnageDonjon.getPosition().getY() - 1));
      case "z":
        return new Move(
            donjon,
            new Point2D.Double(
                personnageDonjon.getPosition().getX() - 1,
                personnageDonjon.getPosition().getY() + 0));
      case "s":
        return new Move(
            donjon,
            new Point2D.Double(
                personnageDonjon.getPosition().getX() + 1,
                personnageDonjon.getPosition().getY() + 0));
      case "acheter":
        return new Achatarme(donjon);
      case "ramasserpiece":
        return new RamasserPiece(donjon);
      case "changearme":
        return new Changearme(donjon);
      case "franchir":
        return new Franchirporte(donjon);
      default:
        return new ErrorCmd();
    }
    //    return cmd;
  }

  public void executecmd(Command cmd) {
    cmd.execut();
  }
}
