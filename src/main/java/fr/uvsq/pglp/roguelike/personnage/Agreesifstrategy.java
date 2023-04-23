package fr.uvsq.pglp.roguelike.personnage;

import fr.uvsq.pglp.roguelike.equipement.Arme;
import fr.uvsq.pglp.roguelike.equipement.ArmeContact;

/** Classe représentant le comportement agressif. */
public class Agreesifstrategy implements Strategy {

  private Pnj pnj;
  private Personnage personnage;
  private Arme arme;

  /**
   * Constructeur de la classe {@link Agreesifstrategy}.
   *
   * @param pnj , personnage pour construire le personnage.
   */
  public Agreesifstrategy(Pnj pnj, Arme arme) {
    this.pnj = pnj;
  }

  public void setPersonnage(Personnage personnage) {
    this.personnage = personnage;
  }

  public Personnage getPersonnage() {
    return personnage;
  }

  /** la méthode implémenté de l'interface qui sert à executer le comportement agressif du pnj. */
  @Override
  public void execute() {
    attack();
  }

  private void attack() {
    if (arme instanceof ArmeContact) {
      this.personnage.setPv(
          this.personnage.getPv()
              - (arme.calculDamage()
                  + pnj.getScoreDeCaracteristiqueMap().get(Caracteristique.FOR).mod()));
    } else {
      this.personnage.setPv(this.personnage.getPv() - arme.calculDamage());
    }
  }
}
