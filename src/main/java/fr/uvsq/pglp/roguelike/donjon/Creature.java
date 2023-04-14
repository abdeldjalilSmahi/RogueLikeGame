package fr.uvsq.pglp.roguelike.donjon;

import org.fusesource.jansi.Ansi;

import java.awt.geom.Point2D;

public abstract class Creature extends DonjonObject{
    public Creature(Point2D object, String asciiChar, Ansi.Color color) {
        super(object, asciiChar, color);
    }
    public abstract boolean canMoveTo(Point2D position);
}
