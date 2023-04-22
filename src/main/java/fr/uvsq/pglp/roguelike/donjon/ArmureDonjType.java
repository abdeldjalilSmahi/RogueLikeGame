package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.Armure;
import fr.uvsq.pglp.roguelike.equipement.ArmureEnum;


public class ArmureDonjType {
  PETIT_BOUCLIER(new Armure(ArmureEnum)),
  CUIR(),
  GRAND_BOUCLIER(),
  CUIR_RENFORCE(),
  DEMI_PLAQUE();

  Armure armure;
  String asciiChar;

  public ArmureDonjType(Armure armure, String asciiChar) {
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
