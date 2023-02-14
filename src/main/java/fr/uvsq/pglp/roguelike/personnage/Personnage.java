package fr.uvsq.pglp.roguelike.personnage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Classe représentant un personnage du jeu.
 */
public class Personnage {

  private String name;
  private int pv;
  private int init;
  private int defense;
  private int scoreattaque;
  private Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap;

  /**
   * Retourne le nom du personnage.
   *
   * @return Le nom du personnage.
   */
  public String getName() {
    return name;

  }

  /**
   * Retourne la map contenant les scores des caractéristiques du personnage.
   *
   * @return La map contenant les scores des caractéristiques du personnage.
   */
  public Map<Caracteristique, ScoreDeCaracteristique> getScoreDeCaracteristiqueMap() {
    return scoreDeCaracteristiqueMap;
  }

  /**
   * Retourne le nombre de points de vie du personnage.
   *
   * @return Le nombre de points de vie du personnage.
   */
  public int getPv() {
    return pv;
  }

  /**
   * Retourne le score d'initiative du personnage.
   *
   * @return Le score d'initiative du personnage.
   */
  public int getInit() {
    return init;
  }

  /**
   * Retourne le score de défense du personnage.
   *
   * @return Le score de défense du personnage.
   */
  public int getDefense() {
    return defense;
  }

  /**
   * Retourne le score d'attaque du personnage.
   *
   * @return Le score d'attaque du personnage.
   */
  public int getScoreattaque() {
    return scoreattaque;
  }

  /**
   * Classe interne permettant de construire un objet Personnage.
   */
  public static class Builder {

    private String name;
    private Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap;
    private List<Caracteristique> defaultPriorite =
        new ArrayList<>(Arrays.asList(Caracteristique.CON, Caracteristique.FOR,Caracteristique.DEX,Caracteristique.CHAR,Caracteristique.INT,Caracteristique.SAG));

    /**
     * Constructeur prenant en paramètre le nom du personnage.
     *
     * @param name Le nom du personnage.
     */
    public Builder(String name) {
      this.name = name;
      this.scoreDeCaracteristiqueMap = generateCaracMap();
    }

    /**
     * return La valeur générée pour la caractéristique. Cette méthode génère une valeur aléatoire pour une caractéristique en utilisant une limite de 4 valeurs générées aléatoirement et en retournant la somme des deuxièmes, troisièmes et quatrièmes valeurs.
     *
     * @return La valeur générée pour la caractéristique.
     */
    private int generateRandomCaracValue() {
      int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(6) + 1).limit(4)
          .toArray();
      Arrays.sort(randomIntsArray);
      return randomIntsArray[1] + randomIntsArray[2] + randomIntsArray[3];
    }

    /**
     * return Un tableau de valeurs pour les différentes caractéristiques. Cette méthode génère les valeurs pour les différentes caractéristiques en utilisant la méthode {@link #generateRandomCaracValue()}. Elle génère des valeurs jusqu'à ce que la somme de ces valeurs ne doit pas dépasser 80 et doit être supérieure à 65.
     *
     * @return Un tableau de valeurs pour les différentes caractéristiques.
     */
    private List generateCarcValues() {
      int sum;
      int[] randomIntsArray;
      do {
        randomIntsArray = IntStream.generate(() -> generateRandomCaracValue()).limit(6)
            .toArray();
        sum = Arrays.stream(randomIntsArray).sum();
      } while (sum <= 80 && sum >= 65);
      List values = Arrays.asList(randomIntsArray);
      Collections.sort(values, Collections.reverseOrder());
      return values;
    }

    /**
     * Cette méthode remplit la map {@link #scoreDeCaracteristiqueMap} avec les caractéristiques et leurs valeurs générées.
     */
    private Map generateCaracMap() {
      Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap =
          new EnumMap<>(Caracteristique.class);
      List<Integer> valuesArray = generateCarcValues();
      int i = 0;
      for (Caracteristique caracteristique : defaultPriorite) {
        scoreDeCaracteristiqueMap
            .put(caracteristique, new ScoreDeCaracteristique(valuesArray.get(i++)));
      }
      return scoreDeCaracteristiqueMap;
    }
  }
}
