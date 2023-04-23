package fr.uvsq.pglp.roguelike.ihm;

import fr.uvsq.pglp.roguelike.donjon.Donjon;

public class Start implements Command {

    Donjon donjon ;
    public Start(Donjon donjon) {
        this.donjon=donjon;
    }

    @Override
    public void controleMap() {

    }
    @Override
    public Command inputuser(String inputuser) {
        switch (inputuser.toLowerCase()) {
            case "d":
                return new Move(donjon, 0, 1);
            case "q":
                return new Move(donjon, 0, -1);
            case "z":
                return new Move(donjon, -1, 0);
            case "w":
                return new Move(donjon, 1, 0);

        }
    }

}
