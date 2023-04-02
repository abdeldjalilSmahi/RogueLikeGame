package fr.uvsq.pglp.roguelike.equipement;
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
public class ArmeContactTest {
  @Test
  public void testCalculDamage() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    ArmeContact arme = new ArmeContact(ArmeContactType.BATON);
    Method method0 = ArmeContact.class.getDeclaredMethod("setRandom", Random.class);
    method0.setAccessible(true);
    arme = (ArmeContact) method0.invoke(arme, new Random(15));
    Method method = ArmeContact.class.getDeclaredMethod("calculDamage");
    method.setAccessible(true);
    int damage = (int) method.invoke(arme);
    System.out.println(damage);
    assertEquals(1, damage);
  }
  @Test
  public void testCalculDamage2() throws NoSuchMethodException, SecurityException,
      IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    ArmeContact arme = new ArmeContact(ArmeContactType.GOURDIN);
    Method method0 = ArmeContact.class.getDeclaredMethod("setRandom", Random.class);
    method0.setAccessible(true);
    arme = (ArmeContact) method0.invoke(arme, new Random(1854));
    Method method = ArmeContact.class.getDeclaredMethod("calculDamage");
    method.setAccessible(true);
    int damage = (int) method.invoke(arme);
    System.out.println(damage);
    assertEquals(3, damage);
  }

}
