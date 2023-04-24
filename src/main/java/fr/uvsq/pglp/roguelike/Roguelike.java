package fr.uvsq.pglp.roguelike;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.DonjonGeneartion;
import fr.uvsq.pglp.roguelike.donjon.Strategie;
import fr.uvsq.pglp.roguelike.ihm.Command;
import fr.uvsq.pglp.roguelike.ihm.DisplayMap;
import fr.uvsq.pglp.roguelike.ihm.Interaction;
import fr.uvsq.pglp.roguelike.personnage.Personnage;
import java.io.IOException;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for the application.
 *
 * @author hal
 * @version jan 2023
 */
public enum Roguelike {
  APPLICATION;

  private static final Logger logger = LoggerFactory.getLogger(Roguelike.class);

  /*
   * Main method of the program.
   * @param args command line arguments
   */
  private void run(String[] args) {
    logger.info("Début de l'exécution");
    // Do something...
    logger.info("Fin de l'exécution");
  }

  /**
   * Class method called by Java VM when starting the application.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    Personnage pj = new Personnage.Builder("abdjalil").setPieces(15).build();
    Strategie strategie = new DonjonGeneartion(pj);
    Donjon donjon = new Donjon();
    donjon.setStrategie(strategie);
    donjon.genererDonjon();
    Scanner sc = new Scanner(System.in);
    String c;
    Command cmd;
    Interaction interaction;
    DisplayMap.dispaly(donjon);
    while (true) {
      c = sc.nextLine();
      interaction = new Interaction(c, donjon);
      cmd = interaction.getCommande();
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      interaction.executecmd(cmd);
      DisplayMap.dispaly(donjon);
    }
  }
}
