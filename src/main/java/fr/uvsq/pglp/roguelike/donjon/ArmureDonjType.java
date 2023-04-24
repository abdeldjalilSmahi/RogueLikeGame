package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.Armure;
import fr.uvsq.pglp.roguelike.equipement.ArmureType;

/**
 * une enumeration qui enumere les type des armes de contact.
 */
public enum ArmureDonjType {
  PETIT_BOUCLIER(new Armure(ArmureType.PETIT_BOUCLIER), " o "),
  CUIR(new Armure(ArmureType.CUIR), " c "),
  GRAND_BOUCLIER(new Armure(ArmureType.GRAND_BOUCLIER), " O "),
  CUIR_RENFORCE(new Armure(ArmureType.CUIR_RENFORCE), " C "),
  DEMI_PLAQUE(new Armure(ArmureType.DEMI_PLAQUE), " ^ ");

  Armure armure;
  String asciiChar;

  ArmureDonjType(Armure armure, String asciiChar) {
    this.armure = armure;
    this.asciiChar = asciiChar;
  }

  public Armure getArmure() {
    return armure;
  }

  public String getAsciiChar() {
    return asciiChar;
  }
}
