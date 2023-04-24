package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;

public class Changearme implements Command{
    Donjon donjon;
    private PersonnageDonjon personnageDonjon;
    public Changearme(Donjon donjon) {
        this.donjon=donjon;
        this.personnageDonjon=donjon.getPersonnageDonjon();
    }
    @Override
    public void execut() {
        personnageDonjon.getPersonnage().changeArme();
    }
}
