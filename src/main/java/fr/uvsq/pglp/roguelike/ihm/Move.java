package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;

import java.awt.geom.Point2D;

public class Move implements Command {
    private Donjon donjon;
    private Point2D point2D;
    public Move(Donjon donjon,Point2D point2D) {
        this.donjon=donjon;
        this.point2D=point2D;
    }

    @Override
    public Command inputuser(String inputuser) {
        return null;
    }

    @Override
    public void controleMap() {

    }
}
