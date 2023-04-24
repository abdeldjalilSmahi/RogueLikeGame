package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.DonjonGeneartion;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;
import fr.uvsq.pglp.roguelike.donjon.Strategie;
import fr.uvsq.pglp.roguelike.personnage.Personnage;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.Scanner;

public class Movetest {
    @Test
    public void TestTes() {
        Personnage pj = new Personnage.Builder("abdjalil").setPieces(10).build();
        Strategie strategie = new DonjonGeneartion(pj);
        Donjon donjon = new Donjon();
        donjon.setStrategie(strategie);
        donjon.genererDonjon();
        PersonnageDonjon personnageDonjon = donjon.getPersonnageDonjon();
        Scanner sc = new Scanner(System.in);
        String c;
        for (int i = 0; i < donjon.getMap().length; i++) {
            for (int j = 0; j < donjon.getMap()[0].length; j++) {
                System.out.print(donjon.getMap()[i][j].getAsciiChar());
            }
            System.out.println();
        }
        Command cmd=new Move(donjon,new Point2D.Double(personnageDonjon.getPosition().getX(),personnageDonjon.getPosition().getY()+1));

        cmd.execut();
        cmd=new Move(donjon,new Point2D.Double(personnageDonjon.getPosition().getX(),personnageDonjon.getPosition().getY()+1));
        cmd.execut();
        for (int i = 0; i < donjon.getMap().length; i++) {
            for (int j = 0; j < donjon.getMap()[0].length; j++) {
                System.out.print(donjon.getMap()[i][j].getAsciiChar());
            }
            System.out.println();
        }
    }

}
