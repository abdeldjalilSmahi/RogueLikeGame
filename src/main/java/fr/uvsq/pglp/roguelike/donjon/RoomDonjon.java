package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;

public class RoomDonjon {
    private Point2D hautGauche;
    private Point2D hautDroit;
    private Point2D basGauche;
    private Point2D basDroit;

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
