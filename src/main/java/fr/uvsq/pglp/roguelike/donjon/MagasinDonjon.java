package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.fusesource.jansi.Ansi;

/** Classe représentant un magasin dans un donjon. */
public class MagasinDonjon extends DonjonObject {
  private List<ArmureDonjType> armuresDonj;
  private List<ArmeDistDonjType> armesDist;
  private List<ArmeConDonjType> armesCont;
  private Personnage pj;

  /**
   * Constructeur de la classe MagasinDonjon.
   *
   * @param position du magasin dans le donjon.
   */
  public MagasinDonjon(Point2D position) {
    super(position, " M ", Ansi.Color.MAGENTA);
    this.armesCont = Arrays.asList(ArmeConDonjType.values());
    this.armesDist = Arrays.asList(ArmeDistDonjType.values());
    this.armuresDonj = Arrays.asList(ArmureDonjType.values());
  }

  public Personnage getPj() {
    return pj;
  }

  public void setPj(Personnage pj) {
    this.pj = pj;
  }

  /**
   * Affiche la liste des objets disponibles à la vente dans le magasin, permet au pj de choisir un
   * objet et l'achète si le personnage a suffisamment de pièces d'or.
   */
  public void presenter() {
    //        // Afficher la liste des objets disponibles à la vente et demander à l'acheteur de
    // choisir
    System.out.println("Objets disponibles à la vente:");
    System.out.println("Les armes contacts");
    for (ArmeConDonjType armeConDonjType : armesCont) {
      System.out.println(
          armeConDonjType.getArmeContact().getArmeContactType().name()
              + " - "
              + armeConDonjType.getAsciiChar()
              + " - "
              + armeConDonjType.getArmeContact().getPrix()
              + " pièces d'or");
    }
    System.out.println("------------------------------");
    System.out.println("Les armes distants");
    for (ArmeDistDonjType armeDistDonjType : armesDist) {
      System.out.println(
          armeDistDonjType.getArmeDistance().getArmeDistanceType().name()
              + " - "
              + armeDistDonjType.getAsciiChar()
              + " - "
              + armeDistDonjType.getArmeDistance().getPrix()
              + " pièces d'or");
    }
    System.out.println("------------------------------");
    System.out.println("Les armures");
    for (ArmureDonjType armureDonjType : armuresDonj) {
      System.out.println(
          armureDonjType.getArmure().getArmureType().name()
              + " - "
              + armureDonjType.getAsciiChar()
              + " - "
              + armureDonjType.getArmure().getPrix()
              + " pièces d'or");
    }
    acheter();
  }

  private void acheter() {

    Scanner scanner = new Scanner(System.in);

    // Demander à l'acheteur de choisir un objet
    System.out.println("Quel objet souhaitez-vous acheter?");
    String nomObjet = scanner.nextLine();

    // Rechercher l'objet dans les listes d'objets disponibles à la vente
    ArmeConDonjType armeContact = null;
    for (ArmeConDonjType armeConDonjType : armesCont) {
      if (armeConDonjType.getArmeContact().getArmeContactType().name().equalsIgnoreCase(nomObjet)) {
        armeContact = armeConDonjType;
        break;
      }
    }

    ArmeDistDonjType armeDistance = null;
    for (ArmeDistDonjType armeDistDonjType : armesDist) {
      if (armeDistDonjType
          .getArmeDistance()
          .getArmeDistanceType()
          .name()
          .equalsIgnoreCase(nomObjet)) {
        armeDistance = armeDistDonjType;
        break;
      }
    }

    ArmureDonjType armure = null;
    for (ArmureDonjType armureDonjType : armuresDonj) {
      if (armureDonjType.getArmure().getArmureType().name().equalsIgnoreCase(nomObjet)) {
        armure = armureDonjType;
        break;
      }
    }

    // Vérifier si l'objet a été trouvé et s'il peut être acheté
    if (armeContact == null && armeDistance == null && armure == null) {
      System.out.println("L'objet " + nomObjet + " n'est pas disponible à la vente.");
    } else {
      int prixObjet = 0;
      if (armeContact != null) {
        prixObjet = armeContact.getArmeContact().getPrix();
      } else if (armeDistance != null) {
        prixObjet = armeDistance.getArmeDistance().getPrix();
      } else {
        prixObjet = armure.getArmure().getPrix();
      }

      if (this.getPj().getPieces() >= prixObjet) {
        this.getPj().setPieces(this.getPj().getPieces() - prixObjet);
        System.out.println("L'objet " + nomObjet + " a été acheté avec succès.");
        if (armeContact != null) {
          getPj().getArmes().add(armeContact.armeContact);
        } else if (armeDistance != null) {
          getPj().getArmes().add(armeDistance.armeDistance);
        } else {
          getPj().getArmures().add(armure.getArmure());
        }
      } else {
        System.out.println("Vous n'avez pas assez d'or pour acheter l'objet " + nomObjet + ".");
      }
    }
  }
}
