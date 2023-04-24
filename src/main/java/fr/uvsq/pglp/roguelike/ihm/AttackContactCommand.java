package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.DonjonObject;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;
import fr.uvsq.pglp.roguelike.donjon.PnjDonjon;
import fr.uvsq.pglp.roguelike.equipement.Arme;
import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.personnage.Personnage;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class AttackContactCommand implements Command{

  private Donjon donjon;
  private PersonnageDonjon player;

  public AttackContactCommand(Donjon donjon) {
    this.donjon = donjon;
    this.player = donjon.getPersonnageDonjon();
  }

  @Override
  public void execut() {
    PnjDonjon monster = findNearbyMonster(player, donjon);
    if (monster != null) {
      player.attackContact(monster);
  } else {
    System.out.println("Y a pas de monstre à l'entours ! ");
  }
  }


  public PnjDonjon findNearbyMonster(PersonnageDonjon player, Donjon world) {
    int x = (int)player.getPosition().getX();
    int y = (int)player.getPosition().getY();

    // Vérifier les cases adjacentes
    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (i == x && j == y) {
          continue;
        }
        DonjonObject object = donjon.getObject(new Double(i,j));
        if (object instanceof PnjDonjon) {
          return (PnjDonjon) object;
        }
      }
    }

    // Aucun monstre trouvé
    return null;
  }
}
