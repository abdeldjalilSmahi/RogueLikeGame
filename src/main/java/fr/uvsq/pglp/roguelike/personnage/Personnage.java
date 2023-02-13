package fr.uvsq.pglp.roguelike.personnage;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class Personnage {

  private String name;
  private int pv;
  private int init;
  private int defense;
  private int scoreattaque;
  private Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap;

  public String getName() {
    return name;
  }

  public Map<Caracteristique, ScoreDeCaracteristique> getScoreDeCaracteristiqueMap() {
    return scoreDeCaracteristiqueMap;
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

  public static class Builder {

    private String name;
    private Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap;

    public Builder(String name) {
      this.name = name;

    }

    private int generateRandomCaracValue() {
      int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(6) + 1).limit(4)
          .toArray();
      Arrays.sort(randomIntsArray);
      return randomIntsArray[1] + randomIntsArray[2] + randomIntsArray[3];
    }

    private int[] generateCarcValues(){
      int sum;
      int[] randomIntsArray;
      do {
        randomIntsArray = IntStream.generate(() -> generateRandomCaracValue()).limit(6)
            .toArray();
         sum = Arrays.stream(randomIntsArray).sum();
      }while(sum<=80||sum>65);
      return randomIntsArray;
    }

    private void generateCaracMap(){
      int [] valuesArray=generateCarcValues();
      int i=0;
      for(Caracteristique caracteristique : Caracteristique.values()){
        scoreDeCaracteristiqueMap.put(caracteristique,new ScoreDeCaracteristique(valuesArray[i++]));
      }
    }

  }
}
