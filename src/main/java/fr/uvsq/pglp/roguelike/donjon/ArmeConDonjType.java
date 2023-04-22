package fr.uvsq.pglp.roguelike.donjon;

import fr.uvsq.pglp.roguelike.equipement.ArmeContact;
import fr.uvsq.pglp.roguelike.equipement.ArmeContactType;

public enum ArmeConDonjType {
  GOURDIN(new ArmeContact(ArmeContactType.GOURDIN), " ? "),
  BATON(new ArmeContact(ArmeContactType.BATON), " | "),
  BATON_FEREE(new ArmeContact(ArmeContactType.BATON_FEREE), " \\ "),
  EPEE_BATARDE(new ArmeContact(ArmeContactType.EPEE_BATARDE)," ¥ "),
  HACHE(new ArmeContact(ArmeContactType.HACHE), " / ");

  ArmeContact armeContact;
  String asciiChar ;
  ArmeConDonjType(ArmeContact armeContact, String asciiChar){
    this.armeContact = armeContact;
    this.asciiChar = asciiChar;
  }
  ArmeContact getArmeContact(){
    return this.armeContact;
  }
  String getAsciiChar(){
    return this.asciiChar ;
  }
}
