package fr.uvsq.pglp.roguelike.personnage;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistance;
import fr.uvsq.pglp.roguelike.equipement.Armure;
import fr.uvsq.pglp.roguelike.equipement.Equipement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Classe représentant un personnage du jeu.
 */
public class Personnage {

  /**
   * Le nom du personnage.
   */
  private String name;
  /**
   * Les points de vie du personnage.
   */
  private int pv;
  /**
   * L'initiative du personnage, utilisée pour déterminer l'ordre d'fttaque en combat.
   */
  private int init;
  /**
   * La valeur de défense du personnage, qui réduit les dégâts subis lors d'une attaque.
   */
  private int defense;

  private Equipement currentarme;
  /**
   * Une table de hachage associant chaque caractéristique du personnage à son score de
   * caractéristique correspondant.
   */
  private Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap;
  /**
   * Map identifie le type d'attaque de joueur.
   */
  private Map<TypeDattaque, Integer> typeDattaque;
  /**
   * List des equipements du joueur.
   */
  private List<Equipement> equipements;

  /**
   * Constructeur de la classe {@link Personnage}.
   *
   * @param builder pour construire le personnage.
   */
  protected Personnage(Builder builder) {
    this.name = builder.name;
    this.pv = builder.pv;
    this.defense = builder.defense;
    this.init = builder.init;
    this.scoreDeCaracteristiqueMap = builder.scoreDeCaracteristiqueMap;
    this.typeDattaque = builder.scoreAttaque;
    this.equipements = builder.equipements;
    this.currentarme = null;
  }

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

  public void setPv(int pv) {
    this.pv = pv;
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

  public Map<TypeDattaque, Integer> getTypeDattaque() {
    return typeDattaque;
  }

  public List<Equipement> getEquipements() {
    return equipements;
  }

  public void setEquipements(List<Equipement> equipements) {
    this.equipements = equipements;
  }

  public void setEquipement(Equipement equipement) {
    this.equipements.add(equipement);
  }

  public void changearme() {
    boolean matchTest = equipements.stream()
        .anyMatch(c -> (c instanceof ArmeDistance || c instanceof ArmeContact));
    if (matchTest) {
      {
        for (Equipement equipement : equipements) {
          if (equipement instanceof Armure) {
            continue;
          }
          Equipement temp = equipement;
          equipements.add(currentarme);
          equipements.remove(equipement);
          currentarme = temp ;
          return;
        }
      }
    }
  }

  /**
   * Classe interne permettant de construire un objet Personnage.
   */
  public static class Builder {

    private final String name;
    private Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap;
    private Map<TypeDattaque, Integer> scoreAttaque = new EnumMap<>(TypeDattaque.class);
    private List<Caracteristique> defaultPriorite =
        new ArrayList<>(Arrays.asList(Caracteristique.values()));
    private int pv;
    private int init;
    private int defense;
    private List<Equipement> equipements;

    private Random random = new Random(new Random().nextInt());

    /**
     * Constructeur prenant en paramètre le nom du personnage.
     *
     * @param name Le nom du personnage.
     */
    public Builder(String name) {
      this.name = name;
      this.scoreDeCaracteristiqueMap = generateCaracMap(this.random);
      generateOtherScores();
      this.equipements = new ArrayList<>();
    }

    /**
     * Cette méthode est didiée pour faire les test unitaires elle sera invoqué juste lorsqu'on veut
     * faire les tests unitaires pour contourner le Random.
     */
    private Builder setRandom(Random random) {
      this.random = random;
      this.scoreDeCaracteristiqueMap = generateCaracMap(this.random);
      generateOtherScores();
      return this;
    }

    /**
     * return La valeur générée pour la caractéristique. Cette méthode génère une valeur aléatoire
     * pour une caractéristique en utilisant une limite de 4 valeurs générées aléatoirement et en
     * retournant la somme des deuxièmes, troisièmes et quatrièmes valeurs.
     *
     * @return La valeur générée pour la caractéristique.
     */
    private int generateRandomCaracValue(Random random) {
      int[] randomIntsArray = IntStream.generate(() -> random.nextInt(6) + 1).limit(4).toArray();
      Arrays.sort(randomIntsArray);
      //      System.out.println(Arrays.toString(randomIntsArray));
      return randomIntsArray[1] + randomIntsArray[2] + randomIntsArray[3];
    }

    /**
     * return Un tableau de valeurs pour les différentes caractéristiques. Cette méthode génère les
     * valeurs pour les différentes caractéristiques en utilisant la méthode
     * generateRandomCaracValue(). Elle génère des valeurs jusqu'à ce que la somme de ces valeurs ne
     * doit pas dépasser 80 et doit être supérieure à 65.
     *
     * @return Un tableau de valeurs pour les différentes caractéristiques.
     */
    private int[] generateCarcValues(Random random) {
      // test unitaire urgent  !
      int sum = 0;
      int[] randomIntsArray = {};
      while (sum < 65 || sum > 80) {
        randomIntsArray =
            IntStream.generate(() -> generateRandomCaracValue(random)).limit(6).toArray();
        sum = Arrays.stream(randomIntsArray).sum();
      }
      Arrays.sort(randomIntsArray);
      return randomIntsArray;
    }

    /**
     * Cette méthode remplit la map {@link #scoreDeCaracteristiqueMap} avec les caractéristiques et
     * leurs valeurs générées.
     */
    private Map generateCaracMap(Random random) {
      Map<Caracteristique, ScoreDeCaracteristique> scoreDeCaracteristiqueMap =
          new EnumMap<>(Caracteristique.class);
      int[] valuesArray = generateCarcValues(random);
      int i = 5;
      for (Caracteristique caracteristique : defaultPriorite) {
        scoreDeCaracteristiqueMap.put(caracteristique, new ScoreDeCaracteristique(valuesArray[i]));
        i--;
      }
      return scoreDeCaracteristiqueMap;
    }

    /**
     * Définit la priorité des caractéristiques utilisées pour calculer le score.
     *
     * @param caracteristiquePrioritie Une liste de valeurs de {@link Caracteristique} représentant
     *                                 la priorité des caractéristiques.
     * @return Une instance du {@link Builder} avec la priorité des caractéristiques mise à jour.
     * @throws IllegalArgumentException si la liste ne contient pas exactement 6 caractéristiques ou
     *                                  si une ou plusieurs caractéristiques de la liste ne sont pas
     *                                  valides.
     */
    public Builder priorite(List<Caracteristique> caracteristiquePrioritie) {
      validate(caracteristiquePrioritie);
      Map<Caracteristique, ScoreDeCaracteristique> copyOfScoreCaracMap =
          new EnumMap<>(scoreDeCaracteristiqueMap);
      int i = 0;
      for (Caracteristique caracteristique : caracteristiquePrioritie) {
        scoreDeCaracteristiqueMap.replace(
            caracteristique, copyOfScoreCaracMap.get(defaultPriorite.get(i)));
        i++;
      }
      generateOtherScores();
      return this;
    }

    /**
     * Vérifie si une liste de caractéristiques est valide.
     *
     * @param caracteristiquePrioritie Une liste de valeurs de {@link Caracteristique} à vérifier.
     * @throws IllegalArgumentException si la liste ne contient pas exactement 6 caractéristiques ou
     *                                  si une ou plusieurs caractéristiques de la liste ne sont pas
     *                                  valides.
     */
    private void validate(List<Caracteristique> caracteristiquePrioritie) {
      if (caracteristiquePrioritie.size() != 6) {
        throw new IllegalArgumentException("Il faut mettre tous les 6 caracteristiques");
      }
      Caracteristique[] caracteristiques = Caracteristique.values();
      for (Caracteristique caracteristique : caracteristiques) {
        if (!(caracteristiquePrioritie.contains(caracteristique))) {
          throw new IllegalArgumentException(
              "La caracteristique: " + caracteristique + " N'existe pas dans ta liste");
        }
      }
    }

    private void validate(Caracteristique caracteristique) {
      if (!(Arrays.asList(Caracteristique.values())).contains(caracteristique)) {
        throw new IllegalArgumentException("La caracteristique que vous avez passer est incorrect");
      }
    }

    /**
     * Affecte une valeur à une caractéristique spécifique du personnage. La méthode valide d'abord
     * si la caractéristique passée en paramètre est correcte. Si la caractéristique est correcte,
     * la méthode vérifie si la valeur passée en paramètre n'est pas supérieure à 21 ou inférieure à
     * 1. Si la valeur est valide, la méthode met à jour la valeur de la caractéristique dans la
     * carte des scores de caractéristiques.
     *
     * @param caracteristique la caractéristique à laquelle affecter une valeur
     * @param valeur          la valeur à affecter à la caractéristique
     * @return l'instance courante de Builder pour permettre un appel fluide de méthodes
     * @throws IllegalArgumentException si la caractéristique passée en paramètre est incorrecte, si
     *                                  la valeur est supérieure à 21 ou inférieure à 1
     */
    public Builder valeur(Caracteristique caracteristique, int valeur) {
      // vaut mieux faire une autre méthode validate({@link Caracteristique, valeur}
      validate(caracteristique);
      ScoreDeCaracteristique.validate(valeur);
      this.scoreDeCaracteristiqueMap.replace(caracteristique, new ScoreDeCaracteristique(valeur));
      generateOtherScores();
      return this;
    }

    /**
     * Génère les scores de points de vie, d'initiative et de défense en fonction des
     * caractéristiques de la créature. Les scores de points de vie, d'initiative et de défense sont
     * stockés dans les champs 'pv', 'init' et 'defense' de l'objet. Les scores sont calculés en
     * utilisant les caractéristiques de la créature stockées dans le champ
     * 'scoreDeCaracteristiqueMap'. Les scores de points de vie, d'initiative et de défense sont
     * calculés de la manière suivante :
     *
     * <p>pv = 20 + modificateur(CON) init = modificateur(DEX) defense = 10 + modificateur(DEX)
     *
     * <p>Le modificateur d'une caractéristique est calculé en utilisant la méthode 'mod()' de
     * l'objet 'ScoreDeCaracteristique'. Cette méthode renvoie la valeur du score de la
     * caractéristique après avoir appliqué les éventuels bonus et malus. Si les scores de
     * caractéristiques n'ont pas été initialisés avant d'appeler cette méthode, une exception sera
     * levée.
     *
     * @throws IllegalStateException si les scores de caractéristiques n'ont pas été initialisés
     *                               avant d'appeler cette méthode.
     */
    public void generateOtherScores() {
      this.pv = profil(this.random) + scoreDeCaracteristiqueMap.get(Caracteristique.CON).mod();
      this.init = scoreDeCaracteristiqueMap.get(Caracteristique.DEX).val();
      this.defense = 10 + scoreDeCaracteristiqueMap.get(Caracteristique.DEX).mod();
      this.scoreAttaque.put(
          TypeDattaque.AttaqueContact, scoreDeCaracteristiqueMap.get(Caracteristique.FOR).mod());
      this.scoreAttaque.put(
          TypeDattaque.AttaqueDistance, scoreDeCaracteristiqueMap.get(Caracteristique.DEX).mod());
    }

    /**
     * Calcule la valeur aléatoire de point de vie.
     *
     * @return pv
     */

    public int profil(Random random) {
      return 2 * (random.nextInt(5) + 2);
    }

    public Personnage build() {
      return new Personnage(this);
    }
  }
}
