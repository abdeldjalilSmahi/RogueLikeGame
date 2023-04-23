
package fr.uvsq.pglp.roguelike.donjon;
        import static org.junit.jupiter.api.Assertions.assertArrayEquals;
        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertThrows;
        import static org.junit.jupiter.api.Assertions.assertTrue;

        import fr.uvsq.pglp.roguelike.personnage.Personnage;
        import org.junit.jupiter.api.Test;

public class DonjonTestGen {
    @Test
    public void TestTes(){
        Personnage pj = new Personnage.Builder("abdjalil").setPieces(0).build();
        DonjonGeneartion donjon = new DonjonGeneartion(pj);
        donjon.makedonjon();

        for (int i = 0; i < donjon.getMap().length; i++) {
            for (int j = 0; j < donjon.getMap()[0].length; j++) {
                System.out.print(donjon.getMap()[i][j].getAsciiChar());
            }
            System.out.println();
        }
    }

}