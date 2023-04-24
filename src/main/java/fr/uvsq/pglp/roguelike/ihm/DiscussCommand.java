package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.DonjonObject;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;
import fr.uvsq.pglp.roguelike.donjon.PnjDonjon;
import fr.uvsq.pglp.roguelike.donjon.RoomDonjon;
import fr.uvsq.pglp.roguelike.personnage.Amicalstategie;
import fr.uvsq.pglp.roguelike.personnage.Strategy;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.List;

/** Classe implémentant l'interface {@link Command}. */
public class DiscussCommand implements Command {
  private Donjon donjon;
  private PersonnageDonjon player;
  private DonjonObject[][] map;
  private int roomSize;
  private List<RoomDonjon> roomsDonjon;

  /**
   * Constructeur de la classe.
   *
   * @param donjon le donjon de jeu.
   */
  public DiscussCommand(Donjon donjon) {
    this.donjon = donjon;
    this.player = donjon.getPersonnageDonjon();
    this.map = donjon.getMap();
    roomsDonjon = donjon.getRooms();
  }

  @Override
  public void execut() {
    PnjDonjon nearbyAmical = findNearbyAmical(player, donjon);
    if (nearbyAmical != null) {
      Point2D point2D = nearbyAmical.getPosition();
      Strategy amicalStrategy = new Amicalstategie(this.map, 6, roomsDonjon, point2D);
      nearbyAmical.getPnj().setStrategy(amicalStrategy);
      nearbyAmical.getPnj().performAction();
    }
  }

  /**
   * Méthode qui trouve le pnj amical le plus proche.
   *
   * @param player le player pour chercher son proche.
   * @param world le donjon dans leqeul évolue le player.
   * @return le pnjDonjon le plus proche.
   */
  public PnjDonjon findNearbyAmical(PersonnageDonjon player, Donjon world) {
    int x = (int) player.getPosition().getX();
    int y = (int) player.getPosition().getY();

    // Vérifier les cases adjacentes
    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (i == x && j == y) {
          continue;
        }
        DonjonObject object = donjon.getObject(new Double(i, j));
        if (object instanceof PnjDonjon) {
          if (object.getAsciiChar().equals(" T ")) {
            return (PnjDonjon) object;
          } else {
            System.out.println("Il s'agit pas d'un Pnj Amical");
          }
        }
      }
    }

    // Aucun monstre trouvé
    return null;
  }
}
