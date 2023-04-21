package fr.uvsq.pglp.roguelike.donjon;

public class Donjon {
    private Strategie strategie;

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    public void genererDonjon() {
        strategie.setup();
        strategie.createportealeatoire();

    }
}
