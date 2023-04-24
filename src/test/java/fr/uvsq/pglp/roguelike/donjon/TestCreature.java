package fr.uvsq.pglp.roguelike.donjon;

import static org.junit.jupiter.api.Assertions.assertFalse;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import java.awt.geom.Point2D;
import org.junit.jupiter.api.Test;

public class TestCreature {
  @Test
  public void testCanMoveTo(){
    Personnage pj = new Personnage.Builder("abdjalil").setPieces(0).build();
    Strategie strategie = new DonjonGeneartion(pj);



    Donjon donjon1 = new Donjon();
    donjon1.setStrategie(strategie);
    donjon1.genererDonjon();
    PersonnageDonjon personnageDonjon = donjon1.getPersonnageDonjon();
    Point2D point = new Point2D.Double(1,0);
    assertFalse(personnageDonjon.canMoveTo(point, donjon1.getAllElements(), donjon1));

  }
  @Test
  public void testCanMoveTo2(){
    Personnage pj = new Personnage.Builder("abdjalil").setPieces(0).build();
    Strategie strategie = new DonjonGeneartion(pj);



    Donjon donjon1 = new Donjon();
    donjon1.setStrategie(strategie);
    donjon1.genererDonjon();
    PersonnageDonjon personnageDonjon = donjon1.getPersonnageDonjon();
    Point2D point = new Point2D.Double(0,0);
    assertFalse(personnageDonjon.canMoveTo(point, donjon1.getAllElements(), donjon1));

  }

}
