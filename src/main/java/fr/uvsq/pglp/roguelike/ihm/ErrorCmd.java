package fr.uvsq.pglp.roguelike.ihm;

/**
 * Classe implémentant l'interface Command, indiquant une mauvaise commande.
 */
public class ErrorCmd implements Command {

  @Override
  public void execut() {
    System.out.println("Une commande éronnéé");
  }
}
