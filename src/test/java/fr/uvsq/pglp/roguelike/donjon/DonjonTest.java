
package fr.uvsq.pglp.roguelike.donjon;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.uvsq.pglp.roguelike.personnage.Caracteristique;
import fr.uvsq.pglp.roguelike.personnage.Personnage;
import fr.uvsq.pglp.roguelike.personnage.Personnage.Builder;
import fr.uvsq.pglp.roguelike.personnage.Pnj;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
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
  @Test
  public void testAttaque() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder)method.invoke(builder, new Random(1999));
    Personnage personnage = builder.build();
    // ************************************************
    Builder builder1 = new Builder("Test");
    Method method1 = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method1.setAccessible(true);
    builder1 = (Builder)method1.invoke(builder1, new Random(1999));
    Pnj pnj = new Pnj(builder1);
    /** **/
    Strategie strategie = new DonjonGeneartion(personnage);



    Donjon donjon1 = new Donjon();
    donjon1.setStrategie(strategie);
    donjon1.genererDonjon();
    assertTrue(donjon1.testAttaque(new Random(1999),personnage.getScoreDeCaracteristiqueMap().get(Caracteristique.FOR).mod(), pnj.getDefense()));


  }

  @Test
  public void testAttaque2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder)method.invoke(builder, new Random(1999));
    Personnage personnage = builder.build();
    // ************************************************
    Builder builder1 = new Builder("Test");
    Method method1 = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method1.setAccessible(true);
    builder1 = (Builder)method1.invoke(builder1, new Random(1999));
    Pnj pnj = new Pnj(builder1);
    /** **/
    Strategie strategie = new DonjonGeneartion(personnage);



    Donjon donjon1 = new Donjon();
    donjon1.setStrategie(strategie);
    donjon1.genererDonjon();
    assertFalse(donjon1.testAttaque(new Random(1999),personnage.getScoreDeCaracteristiqueMap().get(Caracteristique.FOR).mod(), pnj.getDefense()+100));


  }



}