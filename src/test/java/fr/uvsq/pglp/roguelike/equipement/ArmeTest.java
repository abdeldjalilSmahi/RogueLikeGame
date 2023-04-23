package fr.uvsq.pglp.roguelike.equipement;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import fr.uvsq.pglp.roguelike.personnage.Personnage;
//import fr.uvsq.pglp.roguelike.personnage.Personnage.Builder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class ArmeTest {
  @Test
  public void showTypeTest(){
    List<Arme> armes = new ArrayList<>();
    armes.add(new ArmeDistance(ArmeDistanceType.ARBALETE_LEGERE));
    armes.add(new ArmeContact(ArmeContactType.GOURDIN));
    armes.add(new ArmeContact(ArmeContactType.BATON_FEREE));
    armes.remove(armes.get(0));
    System.out.println(armes.get(0).getTypeDattaque().toString());

  }

}
