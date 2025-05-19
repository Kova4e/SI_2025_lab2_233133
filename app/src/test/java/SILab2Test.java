import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        // TC1 - allItems is null
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567812345678"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // TC2 - item with null name
        List<Item> items2 = List.of(new Item(null, 1, 100, 0.0));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, "1234567812345678"));
        assertEquals("Invalid item!", ex2.getMessage());

        // TC3 - normal item without discount
        List<Item> items3 = List.of(new Item("Soap", 2, 100, 0.0));
        assertEquals(200.0, SILab2.checkCart(items3, "1234567812345678"));

        // TC4 - item with price > 300 and discount
        List<Item> items4 = List.of(new Item("Monitor", 1, 400, 0.2));
        assertEquals(290.0, SILab2.checkCart(items4, "1234567812345678"));

        // TC5 - invalid card character
        List<Item> items5 = List.of(new Item("Book", 1, 50, 0.0));
        RuntimeException ex5 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items5, "1234abcd12345678"));
        assertEquals("Invalid character in card number!", ex5.getMessage());

        // TC6 - card number not 16 digits
        List<Item> items6 = List.of(new Item("Pen", 1, 10, 0.0));
        RuntimeException ex6 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items6, "1234"));
        assertEquals("Invalid card number!", ex6.getMessage());
    }

    @Test
public void testMultipleCondition() {
    // MC1 - false false false
    List<Item> items1 = List.of(new Item("Item1", 5, 200, 0.0));
    assertEquals(1000.0, SILab2.checkCart(items1, "1234567812345678"));

    // MC2 - true false false
    List<Item> items2 = List.of(new Item("Item2", 1, 400, 0.0));
    assertEquals(370.0, SILab2.checkCart(items2, "1234567812345678"));

    // MC3 - false true false
    List<Item> items3 = List.of(new Item("Item3", 1, 200, 0.2));
    assertEquals(130.0, SILab2.checkCart(items3, "1234567812345678"));

    // MC4 - false false true
    List<Item> items4 = List.of(new Item("Item4", 20, 10, 0.0));
    assertEquals(170.0, SILab2.checkCart(items4, "1234567812345678"));

    // MC5 - true true true
    List<Item> items5 = List.of(new Item("Item5", 15, 400, 0.5));
    assertEquals(2970.0, SILab2.checkCart(items5, "1234567812345678"));

    // MC6 - true false true
    List<Item> items6 = List.of(new Item("Item6", 20, 400, 0.0));
    assertEquals(7970.0, SILab2.checkCart(items6, "1234567812345678"));

    // MC7 - false true true
    List<Item> items7 = List.of(new Item("Item7", 20, 200, 0.1));
    assertEquals(3570.0, SILab2.checkCart(items7, "1234567812345678"));

    // MC8 - true true false
    List<Item> items8 = List.of(new Item("Item8", 5, 400, 0.25));
    assertEquals(1470.0, SILab2.checkCart(items8, "1234567812345678"));
}