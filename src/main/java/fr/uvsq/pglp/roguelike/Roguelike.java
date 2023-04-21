package fr.uvsq.pglp.roguelike;

import fr.uvsq.pglp.roguelike.donjon.DonjonGeneartion;
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
  public static void main(String[] args) {
    DonjonGeneartion donjon = new DonjonGeneartion();
    donjon.setup();

    for (int i = 0; i < donjon.getMap().length; i++) {
      for (int j = 0; j < donjon.getMap()[0].length; j++) {
        System.out.print(donjon.getMap()[i][j].getAsciiChar());
      }
      System.out.println();
    }
  }
}
