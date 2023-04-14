package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.personnage.Personnage;
import org.fusesource.jansi.Ansi;

import java.awt.geom.Point2D;

public class PersonnageDonjon extends Creature{
    private Personnage personnage;
    public PersonnageDonjon(Personnage personnage, Point2D position) {
        super(position, " @ ", Ansi.Color.CYAN);
        this.personnage = personnage ;
    }

    @Override
    public boolean canMoveTo(Point2D position) {
        return false;
    }
}
