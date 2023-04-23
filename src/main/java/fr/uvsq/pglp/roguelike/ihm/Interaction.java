package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;
import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;

import java.awt.geom.Point2D;

public class Interaction {
    String input;
    Donjon donjon;
    PersonnageDonjon personnageDonjon;
    public Interaction(String input,Donjon donjon) {
        this.input=input;
        this.donjon=donjon;
        this.personnageDonjon=this.donjon.getPersonnageDonjon();
    }
    public Command getCommande(){
        Command cmd = null;
        switch (input.toLowerCase()) {
            case "d":
               cmd= new Move(donjon, new Point2D.Double(personnageDonjon.getPosition().getX()+0, personnageDonjon.getPosition().getY() + 1));
            case "q":
                cmd= new Move(donjon, new Point2D.Double(personnageDonjon.getPosition().getX()+0, personnageDonjon.getPosition().getY() - 1));
            case "z":
                cmd= new Move(donjon, new Point2D.Double(personnageDonjon.getPosition().getX() + 1, personnageDonjon.getPosition().getY()+0));
            case "w":
                cmd= new Move(donjon, new Point2D.Double(personnageDonjon.getPosition().getX() - 1, personnageDonjon.getPosition().getY()+0));
        }
       return cmd;
        }
    public void executecmd(Command cmd){
        cmd.execut();
    }


    }

