package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.*;
import fr.uvsq.pglp.roguelike.personnage.Personnage;
import org.fusesource.jansi.Ansi;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MgasinDonjon extends DonjonObject{
    private List<ArmureDonjType> armuresDonj;
    private List<ArmeDistDonjType> armesDist;
    private List<ArmeConDonjType> armesCont;
    private Personnage pj;
    public MgasinDonjon(Point2D position) {
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
    public void presenter() {
//        // Afficher la liste des objets disponibles à la vente et demander à l'acheteur de choisir
        System.out.println("Objets disponibles à la vente:");
        System.out.println("Les armes contacts");
        for (ArmeConDonjType armeConDonjType : armesCont) {
            System.out.println(armeConDonjType.getArmeContact().getArmeContactType().name() + " - "+ armeConDonjType.getAsciiChar() + " - " + armeConDonjType.getArmeContact().getPrix() + " pièces d'or");
        }
        System.out.println("------------------------------");
        System.out.println("Les armes distants");
        for (ArmeDistDonjType armeDistDonjType : armesDist) {
            System.out.println(armeDistDonjType.getArmeDistance().getArmeDistanceType().name() + " - "+ armeDistDonjType.getAsciiChar() + " - " + armeDistDonjType.getArmeDistance().getPrix() + " pièces d'or");
        }
        System.out.println("------------------------------");
        System.out.println("Les armures");
        for (ArmureDonjType armureDonjType : armuresDonj) {
            System.out.println(armureDonjType.getArmure().getArmureType().name() + " - "+ armureDonjType.getAsciiChar() + " - " + armureDonjType.getArmure().getPrix() + " pièces d'or");
        }

    }

}
