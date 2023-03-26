package fr.uvsq.pglp.roguelike.personnage;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class PersonnageTest {

  @Test
  public void testGenerateRandomCaracValue() throws Exception {
    // ce test fonctionnne après avoir revu le code.
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(15));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateRandomCaracValue", Random.class);
    privateMethod.setAccessible(true);
    int result = (Integer) privateMethod.invoke(builder, new Random(15));
    assertEquals(13, result);
  }

  @Test
  public void secondTestGenerateRandomCaracValue() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateRandomCaracValue", Random.class);
    privateMethod.setAccessible(true);
    int result = (Integer) privateMethod.invoke(builder, new Random(1999));
    assertEquals(15, result);
  }

  @Test
  public void testGenerateCarcValues() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateCarcValues", Random.class);
    privateMethod.setAccessible(true);
    int[] result = (int[]) privateMethod.invoke(builder, new Random(1999));
    int[] expectedResult = {10, 12, 13, 13, 15, 15};
    assertArrayEquals(expectedResult, result);
  }

  @Test
  public void testGenerateCarcValuesSum() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateCarcValues", Random.class);
    privateMethod.setAccessible(true);
    int[] result = (int[]) privateMethod.invoke(builder, new Random(1999));
    int sum = Arrays.stream(result).sum();
    assertTrue(sum > 65 );
    assertTrue(sum < 80);
  }

  @Test
  public void testGenerateCaracMap() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateCaracMap", Random.class);
    privateMethod.setAccessible(true);
    EnumMap<Caracteristique, ScoreDeCaracteristique> result =
        (EnumMap<Caracteristique, ScoreDeCaracteristique>)
            privateMethod.invoke(builder, new Random(1999));
    assertEquals(15, (result.get(Caracteristique.CON)).val());
  }

  @Test
  public void secondTestGenerateCaracMap() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateCaracMap", Random.class);
    privateMethod.setAccessible(true);
    EnumMap<Caracteristique, ScoreDeCaracteristique> result =
        (EnumMap<Caracteristique, ScoreDeCaracteristique>)
            privateMethod.invoke(builder, new Random(1999));
    assertEquals(15, (result.get(Caracteristique.FOR)).val());
  }

  @Test
  public void thirdTestGenerateCaracMap() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateCaracMap", Random.class);
    privateMethod.setAccessible(true);
    EnumMap<Caracteristique, ScoreDeCaracteristique> result =
        (EnumMap<Caracteristique, ScoreDeCaracteristique>)
            privateMethod.invoke(builder, new Random(1999));
    assertEquals(13, (result.get(Caracteristique.DEX).val()));
  }

  @Test
  public void fourthTestGenerateCaracMap() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateCaracMap", Random.class);
    privateMethod.setAccessible(true);
    EnumMap<Caracteristique, ScoreDeCaracteristique> result =
        (EnumMap<Caracteristique, ScoreDeCaracteristique>)
            privateMethod.invoke(builder, new Random(1999));
    assertEquals(13, (result.get(Caracteristique.CHAR).val()));
  }

  @Test
  public void fifthTestGenerateCaracMap() throws Exception {
    Builder builder = new Builder("Test");
    //    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    //    method.setAccessible(true);
    //    builder = (Builder)method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateCaracMap", Random.class);
    privateMethod.setAccessible(true);
    EnumMap<Caracteristique, ScoreDeCaracteristique> result =
        (EnumMap<Caracteristique, ScoreDeCaracteristique>)
            privateMethod.invoke(builder, new Random(1999));
    assertEquals(12, (result.get(Caracteristique.INT).val()));
  }

  @Test
  public void sixthTestGenerateCaracMap() throws Exception {
    Builder builder = new Builder("Test");
    //    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    //    method.setAccessible(true);
    //    builder = (Builder)method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("generateCaracMap", Random.class);
    privateMethod.setAccessible(true);
    EnumMap<Caracteristique, ScoreDeCaracteristique> result =
        (EnumMap<Caracteristique, ScoreDeCaracteristique>)
            privateMethod.invoke(builder, new Random(1999));
    assertEquals(10, (result.get(Caracteristique.SAG).val()));
  }

  @Test
  void validate_withValidArguments_shouldNotThrowException()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Builder obj = new Builder("Test");
    List<Caracteristique> caracteristiquePrioritie = Arrays.asList(Caracteristique.values());
    Method validateMethod = obj.getClass().getDeclaredMethod("validate", List.class);
    validateMethod.setAccessible(true);
    validateMethod.invoke(obj, caracteristiquePrioritie);
  }

  @Test
  public void testChangePriorities() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    List<Caracteristique> priorities =
        new ArrayList<>(
            Arrays.asList(
                Caracteristique.SAG,
                Caracteristique.INT,
                Caracteristique.CHAR,
                Caracteristique.DEX,
                Caracteristique.FOR,
                Caracteristique.CON));
    builder = builder.priorite(priorities);
    Personnage personnage = builder.build();
    Map<Caracteristique, ScoreDeCaracteristique> result = personnage.getScoreDeCaracteristiqueMap();
    assertEquals(15, (result.get(Caracteristique.SAG).val()));
  }

  @Test
  public void secondTestChangePriorities() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    List<Caracteristique> priorities =
        new ArrayList<>(
            Arrays.asList(
                Caracteristique.SAG,
                Caracteristique.INT,
                Caracteristique.CHAR,
                Caracteristique.DEX,
                Caracteristique.FOR,
                Caracteristique.CON));
    builder = builder.priorite(priorities);
    Personnage personnage = builder.build();
    Map<Caracteristique, ScoreDeCaracteristique> result = personnage.getScoreDeCaracteristiqueMap();
    assertEquals(15, (result.get(Caracteristique.INT).val()));
  }

  @Test
  public void thirdTestChangePriorities() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    List<Caracteristique> priorities =
        new ArrayList<>(
            Arrays.asList(
                Caracteristique.SAG,
                Caracteristique.INT,
                Caracteristique.CHAR,
                Caracteristique.DEX,
                Caracteristique.FOR,
                Caracteristique.CON));
    builder = builder.priorite(priorities);
    Personnage personnage = builder.build();
    Map<Caracteristique, ScoreDeCaracteristique> result = personnage.getScoreDeCaracteristiqueMap();
    assertEquals(13, (result.get(Caracteristique.CHAR).val()));
  }

  @Test
  public void fourthTestChangePriorities() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    List<Caracteristique> priorities =
        new ArrayList<>(
            Arrays.asList(
                Caracteristique.SAG,
                Caracteristique.INT,
                Caracteristique.CHAR,
                Caracteristique.DEX,
                Caracteristique.FOR,
                Caracteristique.CON));
    builder = builder.priorite(priorities);
    Personnage personnage = builder.build();
    Map<Caracteristique, ScoreDeCaracteristique> result = personnage.getScoreDeCaracteristiqueMap();
    assertEquals(13, (result.get(Caracteristique.DEX).val()));
  }

  @Test
  public void fifthTestChangePriorities() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    List<Caracteristique> priorities =
        new ArrayList<>(
            Arrays.asList(
                Caracteristique.SAG,
                Caracteristique.INT,
                Caracteristique.CHAR,
                Caracteristique.DEX,
                Caracteristique.FOR,
                Caracteristique.CON));
    builder = builder.priorite(priorities);
    Personnage personnage = builder.build();
    Map<Caracteristique, ScoreDeCaracteristique> result = personnage.getScoreDeCaracteristiqueMap();
    assertEquals(12, (result.get(Caracteristique.FOR).val()));
  }

  @Test
  public void sixthTestChangePriorities() throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    List<Caracteristique> priorities =
        new ArrayList<>(
            Arrays.asList(
                Caracteristique.SAG,
                Caracteristique.INT,
                Caracteristique.CHAR,
                Caracteristique.DEX,
                Caracteristique.FOR,
                Caracteristique.CON));
    builder = builder.priorite(priorities);
    Personnage personnage = builder.build();
    Map<Caracteristique, ScoreDeCaracteristique> result = personnage.getScoreDeCaracteristiqueMap();
    assertEquals(10, (result.get(Caracteristique.CON).val()));
  }

  @Test
  public void testValeur() throws Exception {
    Builder builder = new Builder("Test");
    builder = builder.valeur(Caracteristique.CON, 15);
    Personnage personnage = builder.build();
    Map<Caracteristique, ScoreDeCaracteristique> result = personnage.getScoreDeCaracteristiqueMap();
    assertEquals(15, (result.get(Caracteristique.CON).val()));
  }
  @Test
  public void testGetNamePersonnage(){
    Personnage personnage = new Personnage.Builder("Djalil").build();
    assertEquals("Djalil", personnage.getName());
  }
  @Test
  public void testMapPersonnage()throws Exception {
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder)method.invoke(builder, new Random(1999));
    Personnage personnage = builder.build();
    assertEquals("Test", personnage.getName());
    Map<Caracteristique, ScoreDeCaracteristique> scores = personnage.getScoreDeCaracteristiqueMap();
    int[] values = {15, 15, 13, 13, 12, 10};
    int i = 0 ;
    for(Caracteristique caracteristique: Caracteristique.values()){
      assertEquals(values[i++], scores.get(caracteristique).val());
    }
  }

  @Test
  public void testProfil() throws Exception{
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder) method.invoke(builder, new Random(1999));
    Method privateMethod =
        Personnage.Builder.class.getDeclaredMethod("profil", Random.class);
    privateMethod.setAccessible(true);
    int result = (int)(privateMethod.invoke(builder, new Random(1999)));
    assertEquals(12, result);

  }

  @Test
  public void testPv() throws Exception{
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder)method.invoke(builder, new Random(1999));
    Personnage personnage = builder.build();
    assertEquals("Test", personnage.getName());
    assertEquals(14, personnage.getPv()); // 20 + 3
  }
  @Test
  public void testInit() throws Exception{
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder)method.invoke(builder, new Random(1999));
    Personnage personnage = builder.build();
    assertEquals("Test", personnage.getName());
    assertEquals(13, personnage.getInit());
  }
  @Test
  public void testDefense() throws Exception{
    Builder builder = new Builder("Test");
    Method method = Builder.class.getDeclaredMethod("setRandom", Random.class);
    method.setAccessible(true);
    builder = (Builder)method.invoke(builder, new Random(1999));
    Personnage personnage = builder.build();
    assertEquals("Test", personnage.getName());
    assertEquals(11, personnage.getDefense());
  }

}
