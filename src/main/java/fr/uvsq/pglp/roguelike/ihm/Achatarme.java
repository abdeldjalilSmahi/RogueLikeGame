package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.MagasinDonjon;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;

import java.awt.geom.Point2D;

public class Achatarme implements Command {
    private Donjon donjon;
    private PersonnageDonjon personnageDonjon;
    public Achatarme(Donjon donjon) {
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
            if (donjon.getAllElements().get(adjacentPosition) instanceof MagasinDonjon) {
                MagasinDonjon magasinDonjon = (MagasinDonjon) donjon.getAllElements().get(adjacentPosition);
                magasinDonjon.setPj(personnageDonjon.getPersonnage());
                magasinDonjon.presenter();

            }
        }
    }
}
