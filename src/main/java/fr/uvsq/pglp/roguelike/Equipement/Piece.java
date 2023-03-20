/**

 Classe définissant une pièce.
 Implémente l'interface Equipement.
 */
package fr.uvsq.pglp.roguelike.Equipement;
public class Piece implements Equipement {

  /** Le nombre de pièces disponibles. */
  private int nbr = 5;

  /**

   Constructeur pour l'initialisation d'une pièce.
   */
  public Piece() {
  }
  /**

   Méthode privée pour la dépense d'un certain montant de pièces.
   @param prix Le prix à dépenser.
   */
  private void depense(int prix) {
    this.nbr = this.nbr - prix;
  }
  /**

   Méthode privée pour la collecte d'un certain nombre de pièces.
   @param piece Le nombre de pièces à collecter.
   */
  private void collect(int piece) {
    this.nbr = this.nbr + piece;
  }
  /**

   Méthode pour obtenir le nombre de pièces disponibles.
   @return Le nombre de pièces disponibles.
   */
  public int getNbr() {
    return nbr;
  }
}