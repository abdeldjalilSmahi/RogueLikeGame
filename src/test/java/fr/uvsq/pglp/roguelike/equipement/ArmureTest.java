package fr.uvsq.pglp.roguelike.equipement;

import static fr.uvsq.pglp.roguelike.equipement.ArmureEnum.PETIT_BOUCLIER;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class ArmureTest {
    @Test
    public void testGetBonusArmure(){
        Armure armure = new Armure(PETIT_BOUCLIER);
        assertEquals(8, armure.getBonus());
    }
}
