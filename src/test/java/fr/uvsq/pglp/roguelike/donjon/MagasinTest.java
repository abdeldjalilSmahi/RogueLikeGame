package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

public class MagasinTest {
    @Test
    public void TestTes(){
       MgasinDonjon magasin=new MgasinDonjon(new Point2D.Double(1,2));
       magasin.presenter();

    }
}
