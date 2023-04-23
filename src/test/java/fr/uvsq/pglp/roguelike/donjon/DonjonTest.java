
package fr.uvsq.pglp.roguelike.donjon;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import org.junit.jupiter.api.Test;

public class DonjonTest {

  @Test
  public void TestTest() {
    Personnage pj = new Personnage.Builder("abdjalil").setPieces(0).build();
    Strategie strategie = new DonjonGeneartion(pj);



    Donjon donjon1 = new Donjon();
    donjon1.setStrategie(strategie);
    donjon1.genererDonjon();
    PersonnageDonjon personnageDonjon = donjon1.getPersonnageDonjon();

    for (int i = 0; i < donjon1.getMap().length; i++) {
      for (int j = 0; j < donjon1.getMap()[0].length; j++) {
        System.out.print(donjon1.getMap()[i][j].getAsciiChar());
      }
      System.out.println();
    }

    personnageDonjon.moveTo(new Double(1,2), donjon1);

    for (int i = 0; i < donjon1.getMap().length; i++) {
      for (int j = 0; j < donjon1.getMap()[0].length; j++) {
        System.out.print(donjon1.getMap()[i][j].getAsciiChar());
      }
      System.out.println();
    }
  }

}