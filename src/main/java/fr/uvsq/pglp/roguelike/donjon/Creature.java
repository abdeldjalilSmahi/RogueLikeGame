package fr.uvsq.pglp.roguelike.donjon;

import org.fusesource.jansi.Ansi;

import java.awt.geom.Point2D;

public abstract class Creature extends DonjonObject{
    public Creature(Point2D position, String asciiChar, Ansi.Color color) {
        super(position, asciiChar, color);
    }
    public abstract boolean canMoveTo(Point2D position);
}
