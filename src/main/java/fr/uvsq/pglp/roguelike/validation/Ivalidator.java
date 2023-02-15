package fr.uvsq.pglp.roguelike.validation;

/**
 * L'interface Ivalidator représente une entité capable de valider d'autres entités ou objets en
 * fonction des règles spécifiques définies par l'implémentation de la méthode "validate()". Cette
 * interface définit une méthode "validate()" qui valide une entité ou un objet en fonction de ces
 * règles spécifiques. Si l'entité ou l'objet ne répond pas à ces règles, une exception de type
 * IllegalArgumentException peut être levée pour indiquer une validation invalide. Il est important
 * de noter que les règles de validation peuvent varier en fonction de l'implémentation de cette
 * méthode. Les classes qui implémentent cette interface doivent fournir leur propre implémentation
 * de la méthode "validate()".
 */
public interface Ivalidator {

  /**
   * Valide une entité ou un objet selon des règles spécifiques définies par l'implémentation de
   * cette méthode. Si l'entité ou l'objet ne répond pas à ces règles, une exception peut être levée
   * pour indiquer une validation invalide.
   *
   * @throws IllegalArgumentException si l'entité ou l'objet ne répond pas aux règles de validation
   *     définies
   */
  void validate();
}
