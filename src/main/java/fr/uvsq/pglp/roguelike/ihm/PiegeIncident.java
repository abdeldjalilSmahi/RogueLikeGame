package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.*;
import org.fusesource.jansi.Ansi;

import java.awt.geom.Point2D;

public class PiegeIncident implements Command{

    Donjon donjon;
    private PersonnageDonjon personnageDonjon;
    public PiegeIncident(Donjon donjon) {
        this.donjon=donjon;
        this.personnageDonjon=donjon.getPersonnageDonjon();
    }
    @Override
    public void execut() {
        Point2D.Double[] adjacentPositions = {
                new Point2D.Double(personnageDonjon.getPosition().getX() + 1, personnageDonjon.getPosition().getY()),
                new Point2D.Double(personnageDonjon.getPosition().getX() - 1, personnageDonjon.getPosition().getY()),
                new Point2D.Double(personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() - 1),
                new Point2D.Double(personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() + 1)
        };
        for (Point2D.Double adjacentPosition : adjacentPositions) {
            if (donjon.getAllElements().get(adjacentPosition).getAsciiChar()==" & ") {
                Piege piege = (Piege)  donjon.getAllElements().get(adjacentPosition);
                donjon.getAllElements().put(adjacentPosition,
                        new ComponentDonjon(new Point2D.Double(adjacentPosition.getX(), adjacentPosition.getY()), Ansi.Color.CYAN, DonjonComponentType.SOL));
                personnageDonjon.getPersonnage().setPv(personnageDonjon.getPersonnage().getPv()-piege.getDamage());
                System.out.println("Attention un piége !!");
                donjon.updateMap();
            }
        }

    }
}
