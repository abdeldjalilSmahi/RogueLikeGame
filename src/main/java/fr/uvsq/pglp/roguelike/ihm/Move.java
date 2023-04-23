package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;
import fr.uvsq.pglp.roguelike.donjon.PnjDonjon;

import java.awt.geom.Point2D;
import java.util.Random;

public class Move implements Command {
    private Donjon donjon;
    private Point2D point2D;
    public int random;
    private Random rand = new Random();

    private PersonnageDonjon personnageDonjon;
    public Move(Donjon donjon,Point2D point2D) {
        this.donjon=donjon;
        this.point2D=point2D;
        this.personnageDonjon=donjon.getPersonnageDonjon();
    }



    @Override
    public void execut() {
        this.personnageDonjon.moveTo(this.point2D,donjon);
        System.out.println(donjon.getPnjDonjonList().size());
        for(PnjDonjon pnjDonjon : donjon.getPnjDonjonList()){
            int i = rand.nextInt(4);
            switch (i){
               case 0 :{ pnjDonjon.moveTo(new Point2D.Double(pnjDonjon.getPosition().getX()+1,pnjDonjon.getPosition().getY()),donjon); break;}
               case 1 :{ pnjDonjon.moveTo(new Point2D.Double(pnjDonjon.getPosition().getX()-1,pnjDonjon.getPosition().getY()),donjon);break;}
               case 2 : {pnjDonjon.moveTo(new Point2D.Double(pnjDonjon.getPosition().getX(),pnjDonjon.getPosition().getY()+1),donjon);break;}
               case 3 : {pnjDonjon.moveTo(new Point2D.Double(pnjDonjon.getPosition().getX(),pnjDonjon.getPosition().getY()-1),donjon);break;}
            }
        }
    }
}
