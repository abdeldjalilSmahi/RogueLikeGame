package fr.uvsq.pglp.roguelike.donjon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.ArmeContactType;
import java.awt.geom.Point2D;
import org.fusesource.jansi.Ansi.Color;
import org.junit.jupiter.api.Test;

public class ArmeConDonTest {
  @Test
  public void armeConDonjonTest(){
    ArmeConDonjon armeConDonjon = new ArmeConDonjon(new Point2D.Double(1,1), Color.CYAN, ArmeConDonjType.BATON_FEREE);
    ArmeContact armeContact = new ArmeContact(ArmeContactType.BATON_FEREE);
    assertEquals(armeContact.getArmeContactType(), ArmeContactType.BATON_FEREE);

  }

}
