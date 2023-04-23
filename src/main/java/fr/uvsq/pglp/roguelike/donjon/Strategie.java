package fr.uvsq.pglp.roguelike.donjon;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;

public interface Strategie {
  void makedonjon();
  PersonnageDonjon getPjDonjon();
  List<PnjDonjon> getPnjDonjonList();
  Map<Point2D, DonjonObject> getAllDonjonObjects();
  List<MagasinDonjon> getMagasinsDonjon();
  DonjonObject[][] getMap();


}
