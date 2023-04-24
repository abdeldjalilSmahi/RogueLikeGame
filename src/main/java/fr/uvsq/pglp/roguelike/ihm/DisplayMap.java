package fr.uvsq.pglp.roguelike.ihm;

import static org.fusesource.jansi.Ansi.ansi;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import org.fusesource.jansi.Ansi;

/** Classe qui permet d'afficher la carte d'un donjon. */
public class DisplayMap {
  /**
   * Affiche la carte du donjon.
   *
   * @param donjon Le donjon dont on veut afficher la carte.
   */
  public static void dispaly(Donjon donjon) {
    System.out.println();
    System.out.println(
        ansi().fg(Ansi.Color.WHITE).a("Rogue-Like Game Enjoy").bold().fgBright(Ansi.Color.WHITE));
    System.out.println("Current Health : " + donjon.getPersonnageDonjon().getPersonnage().getPv());
    System.out.println(
        "You have " + donjon.getPersonnageDonjon().getPersonnage().getPieces() + " coins");
    if (donjon.getPersonnageDonjon().getPersonnage().getCurrentArme() == null) {
      System.out.println("You don't have a weapon");
    } else {
      System.out.println(
          "Your current weapon is "
              + donjon.getPersonnageDonjon().getPersonnage().getCurrentArme().armeName());
    }
    System.out.println(
        ansi()
            .fg(Ansi.Color.MAGENTA)
            .a("******************************************************************d" + "")
            .reset());
    for (int i = 0; i < donjon.getMap().length; i++) {
      for (int j = 0; j < donjon.getMap()[0].length; j++) {
        System.out.print(
            ansi()
                .fg(donjon.getMap()[i][j].getColor())
                .a(donjon.getMap()[i][j].getAsciiChar())
                .reset());
      }
      System.out.println();
    }
  }
}
