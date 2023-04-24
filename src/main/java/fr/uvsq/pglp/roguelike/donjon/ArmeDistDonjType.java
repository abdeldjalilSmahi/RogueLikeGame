package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.ArmeDistance;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistanceType;

/**
 * une enumeration qui enmere  les type des armes de distance.
 */
public enum ArmeDistDonjType {
  ARBALETE_LEGERE(new ArmeDistance(ArmeDistanceType.ARBALETE_LEGERE), " ) "),
  ARBALETE_LOURDE(new ArmeDistance(ArmeDistanceType.ARBALETE_LOURDE), " ( "),
  ARC_LONG(new ArmeDistance(ArmeDistanceType.ARC_LONG), " } "),
  MOUSQUET(new ArmeDistance(ArmeDistanceType.MOUSQUET), " { ");
  ArmeDistance armeDistance;
  String asciiChar;

  ArmeDistDonjType(ArmeDistance armeDistance, String asciiChar) {
    this.armeDistance = armeDistance;
    this.asciiChar = asciiChar;
  }

  public ArmeDistance getArmeDistance() {
    return armeDistance;
  }

  public String getAsciiChar() {
    return asciiChar;
  }
}
