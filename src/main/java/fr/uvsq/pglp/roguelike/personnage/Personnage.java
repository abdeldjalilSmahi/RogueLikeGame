package fr.uvsq.pglp.roguelike.personnage;

import java.util.Map;

public class Personnage {

  private String name;
  private int pv;
  private int init;
  private int defense;
  private int scoreattaque;

  public String getName() {
    return name;
  }

  public int getPv() {
    return pv;
  }

  public int getInit() {
    return init;
  }

  public int getDefense() {
    return defense;
  }

  public int getScoreattaque() {
    return scoreattaque;
  }
}
