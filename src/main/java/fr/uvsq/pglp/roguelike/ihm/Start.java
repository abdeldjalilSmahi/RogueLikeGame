//package fr.uvsq.pglp.roguelike.ihm;
//
//import fr.uvsq.pglp.roguelike.donjon.Donjon;
//import fr.uvsq.pglp.roguelike.donjon.PersonnageDonjon;
//
//import java.awt.geom.Point2D;
//
//public class Start implements Command {
//
//    Donjon donjon;
//    PersonnageDonjon personnageDonjon;
//
//    public Start(Donjon donjon) {
//        this.donjon = donjon;
//        this.personnageDonjon=donjon.getPersonnageDonjon();
//    }
//    static void display(Donjon donjon) {
//        for (int i = 0; i < donjon.getMap().length; i++) {
//            for (int j = 0; j < donjon.getMap()[0].length; j++) {
//                System.out.print(donjon.getMap()[i][j].getAsciiChar());
//            }
//            System.out.println();
//        }
//    }
//
//    public void controleMap() {
//       display(donjon);
//    }
//
//    @Override
//    public void execute() {
////        switch (inputuser.toLowerCase()) {
////            case "d":
////                return new Move(donjon, new Point2D.Double(personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() + 1));
////            case "q":
////                return new Move(donjon, new Point2D.Double(personnageDonjon.getPosition().getX(), personnageDonjon.getPosition().getY() - 1));
////            case "z":
////                return new Move(donjon, new Point2D.Double(personnageDonjon.getPosition().getX() + 1, personnageDonjon.getPosition().getY()));
////            case "w":
////                return new Move(donjon, new Point2D.Double(personnageDonjon.getPosition().getX() - 1, personnageDonjon.getPosition().getY()));
////
////        }
////        return null;
//   }
//
//}
