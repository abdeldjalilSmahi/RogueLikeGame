package fr.uvsq.pglp.roguelike.personnage;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.Equipement;

/**
 * Classe représentant le comportement agressif.
 */
public class Agreesifstrategy implements Strategy {

  private Pnj pnj;
  private Personnage personnage;
  private Equipement equipement;

  /**
   * Constructeur de la classe {@link Agreesifstrategy}.
   *
   * @param pnj , personnage pour construire le personnage.
   */
  public Agreesifstrategy(Pnj pnj, Personnage personnage) {
    this.pnj = pnj;
    this.personnage = personnage;
    this.equipement = pnj.getCurrentArme();
  }

  /**
   * la méthode implémenté de l'interface qui sert à executer le comportement agressif du pnj.
   *
   */
  @Override
  public void execute() {
    if (equipement instanceof ArmeContact) {
      this.personnage.setPv(
          this.personnage.getPv() - (equipement.getBonus() + pnj.getScoreDeCaracteristiqueMap()
              .get(Caracteristique.FOR).mod()));
    } else {
      this.personnage.setPv(this.personnage.getPv() - equipement.getBonus());
    }
  }
}
