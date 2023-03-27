package fr.uvsq.pglp.roguelike.equipement;

public class Armure implements Equipement{
  private ArmureType armureType ;
  private ArmureTypes typeArmure;
  private int bonusDef;
  private int prix ;



  public Armure(ArmureType armureType) {
    this.armureType = armureType;
    this.typeArmure = armureType.armureTypes ;
    this.bonusDef = armureType.bonusDef;
    this.prix = armureType.prix;
  }


  @Override
  public int getBonus() {
    return this.bonusDef;
  }
}
