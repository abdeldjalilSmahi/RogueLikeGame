package fr.uvsq.pglp.roguelike.equipement;
import static fr.uvsq.pglp.roguelike.equipement.ArmureType.PLAQUE_COMPLETE;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import fr.uvsq.pglp.roguelike.personnage.Personnage.Builder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.Test;
public class ArmureTest {
    @Test
    public void testGetBonusArmure(){
        Armure armure = new Armure(PLAQUE_COMPLETE);
        assertEquals(8, armure.getBonus());
    }
}
