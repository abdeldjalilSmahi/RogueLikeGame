package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Donjon {


    private Strategie strategie;
    //private Map <DonjonObject, Point2D>allElements;

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    public void genererDonjon() {
        strategie.setup();
        strategie.createportealeatoire();
        strategie.determinateRoom();
    }
}
