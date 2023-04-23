package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.*;
import fr.uvsq.pglp.roguelike.personnage.Personnage;
import org.fusesource.jansi.Ansi;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MgasinDonjon extends DonjonObject{
    private List<ArmeContact> armeContacts;
    private List<ArmeDistance> armeDistances;
    private List<Armure> armures;
    private Personnage pj;
    public MgasinDonjon(Point2D position) {
        super(position, " M ", Ansi.Color.MAGENTA);
        this.armeContacts =
                Arrays.asList(ArmeContactType.values()).stream()
                        .map(e -> new ArmeContact(e))
                        .collect(Collectors.toList());
        this.armeDistances =
                Arrays.asList(ArmeDistanceType.values()).stream()
                        .map(e -> new ArmeDistance(e))
                        .collect(Collectors.toList());
        this.armures =
                Arrays.asList(ArmureType.values()).stream()
                        .map(e -> new Armure(e))
                        .collect(Collectors.toList());
    }
    public Personnage getPj() {
        return pj;
    }

    public void setPj(Personnage pj) {
        this.pj = pj;
    }
    public void presenter() {
        // Afficher la liste des objets disponibles à la vente et demander à l'acheteur de choisir
        System.out.println("Objets disponibles à la vente:");
        for (ArmeContact objet : armeContacts) {
            System.out.println(objet.getArmeContactType().name() + " - " + objet.getPrix() + " pièces d'or");
        }
        for (ArmeDistance objet : armeDistances) {
            System.out.println(objet.getArmeDistanceType().name() + " - " + objet.getPrix() + " pièces d'or");
        }
        for (Armure objet : armures) {
            System.out.println(objet.getArmureType().name() + " - " + objet.getPrix() + " pièces d'or");
        }
        System.out.println("Quel objet voulez-vous acheter? (entrez le numéro de l'objet ou 0 pour annuler)");

    }
}
