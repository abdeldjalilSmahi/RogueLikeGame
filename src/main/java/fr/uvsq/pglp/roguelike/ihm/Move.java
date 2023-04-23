package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;

import java.awt.geom.Point2D;

public class Move implements Command {
    private Donjon donjon;
    private Point2D point2D;

    private PersonnageDonjon personnageDonjon;
    public Move(Donjon donjon,Point2D point2D) {
        this.donjon=donjon;
        this.point2D=point2D;
        this.personnageDonjon=donjon.getPersonnageDonjon();
    }



    @Override
    public void execut() {
        this.personnageDonjon.moveTo(this.point2D,donjon);
    }
}
