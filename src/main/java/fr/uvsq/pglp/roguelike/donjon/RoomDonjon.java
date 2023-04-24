package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;

/**
 * La classe RoomDonjon représente une pièce dans le donjon.
 */
public class RoomDonjon {
  private Point2D hautGauche;
  private Point2D hautDroit;
  private Point2D basGauche;
  private Point2D basDroit;

  /**
   *La classe RoomDonjon représente une pièce du donjon délimitée par quatre coins.
   *
   * @param hautGauche le coin supérieur gauche de la pièce
   * @param hautDroit le coin supérieur droit de la pièce
   * @param basGauche le coin inferieur(en bas) gauche de la pièce
   * @param basDroit le coin inferieur(en bas) droit de la pièce
   */
  public RoomDonjon(Point2D hautGauche, Point2D hautDroit, Point2D basGauche, Point2D basDroit) {
    this.hautGauche = hautGauche;
    this.hautDroit = hautDroit;
    this.basGauche = basGauche;
    this.basDroit = basDroit;
  }

  public Point2D getHautGauche() {
    return hautGauche;
  }

  public Point2D getHautDroit() {
    return hautDroit;
  }

  public Point2D getBasGauche() {
    return basGauche;
  }

  public Point2D getBasDroit() {
    return basDroit;
  }
}
