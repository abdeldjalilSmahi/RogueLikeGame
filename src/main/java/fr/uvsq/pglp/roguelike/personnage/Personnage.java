package fr.uvsq.pglp.roguelike.personnage;

import java.util.Map;

public class Personnage {
  private String name;
  private int PV ;
  private int defense ;
  private int score_caracteristique_force ;
  private Map<Caracteristique, ScoreDeCaracteristique> scores_caracteristique ;
}
