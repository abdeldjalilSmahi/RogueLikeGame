package fr.uvsq.pglp.roguelike.personnage;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.ArmeContactType;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistance;
import fr.uvsq.pglp.roguelike.equipement.ArmeDistanceType;
import fr.uvsq.pglp.roguelike.equipement.Armure;
import fr.uvsq.pglp.roguelike.equipement.ArmureType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Amicalstategie implements Strategy {

  private List<ArmeContact> armeContacts;
  private List<ArmeDistance> armeDistances;
  private List<Armure> armures;
  private Personnage pj;

  public Amicalstategie() {
    this.armeContacts =
        Arrays.asList(ArmeContactType.values()).stream()
            .map(e -> new ArmeContact(e))
            .collect(Collectors.toList());
    this.armeDistances =
        Arrays.asList(ArmeDistanceType.values()).stream()
            .map(e -> new ArmeDistance(e))
            .collect(Collectors.toList());
    this.armures =
        Arrays.asList(ArmureType.values()).stream()
            .map(e -> new Armure(e))
            .collect(Collectors.toList());
  }

  public Personnage getPj() {
    return pj;
  }

  public void setPj(Personnage pj) {
    this.pj = pj;
  }

  @Override
  public void execute() {}
}
