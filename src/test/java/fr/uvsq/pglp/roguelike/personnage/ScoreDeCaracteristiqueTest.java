package fr.uvsq.pglp.roguelike.personnage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ScoreDeCaracteristiqueTest {
  @Test
  public void testInstanciationValSup() {
    assertThrows(IllegalArgumentException.class, () -> new ScoreDeCaracteristique(22));
  }

  @Test
  public void testInstanciationValInf() {
    assertThrows(IllegalArgumentException.class, () -> new ScoreDeCaracteristique(0));
  }

  @Test
  void testModForVal5() {
    ScoreDeCaracteristique scoreDeCaracteristique = new ScoreDeCaracteristique(5);
    assertEquals(-3, scoreDeCaracteristique.mod());
  }

  @Test
  void testModForVal6() {
    ScoreDeCaracteristique scoreDeCaracteristique = new ScoreDeCaracteristique(6);
    assertEquals(-2, scoreDeCaracteristique.mod());
    assertNotEquals(-3, scoreDeCaracteristique.mod());
  }
}
