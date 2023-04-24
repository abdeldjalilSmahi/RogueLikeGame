package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.*;
import org.fusesource.jansi.Ansi;

import java.awt.geom.Point2D;

public class Franchirporte implements Command {

    Donjon donjon;
    private PersonnageDonjon personnageDonjon;
    public Franchirporte(Donjon donjon) {
        this.donjon=donjon;
        this.personnageDonjon=donjon.getPersonnageDonjon();
    }

    @Override
    public void execut() {

        if (donjon.getAllElements().get(new Point2D.Double(personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() + 1)).getAsciiChar()==" P ") {
            Point2D point2D = new Point2D.Double(personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() + 2);
            personnageDonjon.moveTo(point2D,donjon);
            return;
        }
        if (donjon.getAllElements().get(new Point2D.Double(personnageDonjon.getPosition().getX()+1, personnageDonjon.getPosition().getY())).getAsciiChar()==" P ") {
            Point2D point2D = new Point2D.Double(personnageDonjon.getPosition().getX()+2, personnageDonjon.getPosition().getY() );
            personnageDonjon.moveTo(point2D,donjon);
            return;
        }
        if (donjon.getAllElements().get(new Point2D.Double(personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() - 1)).getAsciiChar()==" P ") {
            Point2D point2D = new Point2D.Double(personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() -2);
            personnageDonjon.moveTo(point2D,donjon);
            return;
        }
        if (donjon.getAllElements().get(new Point2D.Double(personnageDonjon.getPosition().getX()-1, personnageDonjon.getPosition().getY())).getAsciiChar()==" P ") {
            Point2D point2D = new Point2D.Double(personnageDonjon.getPosition().getX()-2, personnageDonjon.getPosition().getY() );
            personnageDonjon.moveTo(point2D,donjon);
            return;
        }
    }
}
