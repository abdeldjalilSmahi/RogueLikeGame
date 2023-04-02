package fr.uvsq.pglp.roguelike.equipement;
import static fr.uvsq.pglp.roguelike.equipement.ArmeDistanceType.ARBALETE_LEGERE;
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

public class ArmeDistanceTest {
  @Test
  
  public void testCalculDamage() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    ArmeDistance arme = new ArmeDistance(ArmeDistanceType.ARBALETE_LEGERE);
    Method method0 = ArmeDistance.class.getDeclaredMethod("setRandom", Random.class);
    method0.setAccessible(true);
    arme = (ArmeDistance) method0.invoke(arme, new Random(15));
    Method method = ArmeDistance.class.getDeclaredMethod("calculDamage");
    method.setAccessible(true);
    int damage = (int) method.invoke(arme);
//    System.out.println(damage);
    assertEquals(3, damage);
  }
  @Test
  public void testCalculDamage2() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    ArmeDistance arme = new ArmeDistance(ArmeDistanceType.ARBALETE_LEGERE);
    Method method0 = ArmeDistance.class.getDeclaredMethod("setRandom", Random.class);
    method0.setAccessible(true);
    arme = (ArmeDistance) method0.invoke(arme, new Random(1854));
    Method method = ArmeDistance.class.getDeclaredMethod("calculDamage");
    method.setAccessible(true);
    int damage = (int) method.invoke(arme);
//    System.out.println(damage);
    assertEquals(6, damage);

  }

}
