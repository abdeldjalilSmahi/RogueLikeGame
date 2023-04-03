package fr.uvsq.pglp.roguelike.personnage;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.Equipement;

public class Agreesifstrategy implements Strategy {
  private Pnj pnj;
  private Personnage personnage ;
  private Equipement equipement;

  public Agreesifstrategy(Pnj pnj, Personnage personnage) {
    this.pnj = pnj;
    this.personnage = personnage;
    this.equipement=pnj.getCurrentarme();
  }

  @Override
  public void execute() {
   if (equipement instanceof ArmeContact)
     this.personnage.setPv(this.personnage.getPv()-(equipement.getBonus()+pnj.getScoreDeCaracteristiqueMap().get(Caracteristique.FOR).mod()));
   else this.personnage.setPv(this.personnage.getPv()-equipement.getBonus());
  }
}
