    package fr.uvsq.pglp.roguelike;

    import fr.uvsq.pglp.roguelike.donjon.*;
    import fr.uvsq.pglp.roguelike.ihm.Command;
    import fr.uvsq.pglp.roguelike.ihm.DisplayMap;
    import fr.uvsq.pglp.roguelike.ihm.Interaction;

    import fr.uvsq.pglp.roguelike.personnage.Personnage;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;

    import java.util.Scanner;

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
          Personnage pj = new Personnage.Builder("abdjalil").setPieces(15).build();
          Strategie strategie = new DonjonGeneartion(pj);
          Donjon donjon = new Donjon();
          donjon.setStrategie(strategie);
          donjon.genererDonjon();
          Scanner sc = new Scanner(System.in);
          String c;
          DisplayMap.dispaly(donjon);
          Command cmd;
          Interaction interaction;
          while(true){
              c= sc.nextLine();
              System.out.println(c);
              interaction = new Interaction(c,donjon);
              cmd=interaction.getCommande();
              if(cmd==null) {
                  DisplayMap.dispaly(donjon);
                  System.out.println("Veuillez entrer une commande valide");
              }
              else{
                  interaction.executecmd(cmd);
                  DisplayMap.dispaly(donjon);
              }
          }



      }
      }
