package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;

/**
 * L'interface Strategie permet de définir le comportement du Pnj dans donjon.
 */
public interface Strategie {
  void makedonjon();

  PersonnageDonjon getPjDonjon();

  List<PnjDonjon> getPnjDonjonList();

  Map<Point2D, DonjonObject> getAllDonjonObjects();

  List<MagasinDonjon> getMagasinsDonjon();

  DonjonObject[][] getMap();

  List<RoomDonjon> getRoomsDonjon();
}
