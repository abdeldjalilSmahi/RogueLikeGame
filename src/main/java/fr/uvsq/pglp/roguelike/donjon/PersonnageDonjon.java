package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.Arme;
import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistance;
import fr.uvsq.pglp.roguelike.ihm.PiegeIncident;
import fr.uvsq.pglp.roguelike.personnage.Caracteristique;
import fr.uvsq.pglp.roguelike.personnage.Personnage;
import fr.uvsq.pglp.roguelike.personnage.Pnj;
import java.awt.geom.Point2D;
import java.util.Map;
import java.util.Random;
import org.fusesource.jansi.Ansi;

/** La classe personnage dans le donjon. */
public class PersonnageDonjon extends Creature {

  /** Personnage a enrichir par une position. */
  private Personnage personnage;

  private Arme arme;

  /**
   * Constructeur de personnageDonjon.
   *
   * @param personnage le personage.
   * @param position la position du personnage.
   */
  public PersonnageDonjon(Personnage personnage, Point2D position) {
    super(position, " @ ", Ansi.Color.GREEN);
    this.personnage = personnage;
    this.arme = personnage.getCurrentArme();
  }

  public Personnage getPersonnage() {
    return personnage;
  }

  @Override
  public boolean canMoveTo(Point2D newPosition, Map<Point2D, DonjonObject> map, Donjon donjon) {
    if (map.get(newPosition).getAsciiChar() != DonjonComponentType.SOL.getAsciiChar()) {
      PiegeIncident piegeIncident = new PiegeIncident(donjon);
      piegeIncident.execut();
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
    if (canMoveTo(newPosition, donjon.getAllElements(), donjon)) {
      donjon.swapObjects(this, donjon.getObject(newPosition));
    }
  }

  /** Méthode d'attack. */
  public void attackContact(PnjDonjon pnjon) {
    Random rand = new Random();
    int modFor = this.personnage.getScoreDeCaracteristiqueMap().get(Caracteristique.FOR).mod();
    int defense = pnjon.getPnj().getDefense();

    if (Donjon.testAttaque(rand, modFor, defense)) {
      Arme personArme = personnage.getCurrentArme();
      if (personArme == null) {
        System.out.println("Vous n'avez aucune arme");
        return;
      }
      int damage = personArme.calculDamage();
      if (personArme instanceof ArmeContact) {
        Pnj pnj = pnjon.getPnj();
        pnj.setPv(pnj.getPv() - (damage + modFor));
      }
      if (personArme instanceof ArmeDistance) {
        Pnj pnj = pnjon.getPnj();
        pnj.setPv(pnj.getPv() - (damage));
      }
    } else {
      System.out.println("Tu ne peux pas attaquer, test d'attaque a échoué.");
    }
  }
}
