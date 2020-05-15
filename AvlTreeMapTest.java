package hw6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * In addition to the tests in BinarySearchTreeMapTest (and in OrderedMapTest & MapTest),
 * we add tests specific to AVL Tree.
 */
@SuppressWarnings("All")
public class AvlTreeMapTest extends BinarySearchTreeMapTest {

  @Override
  protected Map<String, String> createMap() {
    return new AvlTreeMap<>();
  }

  @Test
  public void insertLeftRotation() {
    map.insert("1", "a");
    // System.out.println(avl.toString());
    // must print
    /*
        1:a
     */

    map.insert("2", "b");
    // System.out.println(avl.toString());
    // must print
    /*
        1:a,
        null 2:b
     */

    map.insert("3", "c"); // it must do a right rotation here!
    // System.out.println(avl.toString());
    // must print
    /*
        2:b,
        1:a 3:c
     */

    String[] expected = new String[]{
        "2:b",
        "1:a 3:c"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void insertRightRotation() {
    map.insert("3", "c");
    map.insert("2", "b");
    map.insert("1", "a");
    String[] expected = new String[]{
        "2:b",
        "1:a 3:c"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());

  }

  @Test
  public void insertLeftRightRotationCase1() {
    map.insert("15", "o");
    map.insert("02", "b");
    map.insert("16", "p");
    map.insert("01", "a");
    map.insert("04", "d");
    map.insert("03", "c");
    String[] expected = new String[]{
        "04:d",
        "02:b 15:o",
        "01:a 03:c null 16:p"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());

  }

  @Test
  public void insertLeftRightRotationCase2() {
    map.insert("15", "o");
    map.insert("02", "b");
    map.insert("16", "p");
    map.insert("01", "a");
    map.insert("04", "d");
    map.insert("05", "e");
    String[] expected = new String[]{
        "04:d",
        "02:b 15:o",
        "01:a null 05:e 16:p"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void insertRightLeftRotationCase1() {
    map.insert("02", "b");
    map.insert("01", "a");
    map.insert("09", "i");
    map.insert("07", "g");
    map.insert("10", "j");
    map.insert("06", "f");
    String[] expected = new String[]{
        "07:g",
        "02:b 09:i",
        "01:a 06:f null 10:j"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void insertRightLeftRotationCase2() {
    map.insert("02", "b");
    map.insert("01", "a");
    map.insert("09", "i");
    map.insert("07", "g");
    map.insert("10", "j");
    map.insert("08", "h");
    String[] expected = new String[]{
        "07:g",
        "02:b 09:i",
        "01:a null 08:h 10:j"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void removeLeftRotation() {
    map.insert("03", "c");
    map.insert("01", "a");
    map.insert("04", "d");
    map.insert("05", "e");
    map.remove("01");
    String[] expected = new String[]{
        "04:d",
        "03:c 05:e"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void removeRightRotation() {
    map.insert("03", "c");
    map.insert("04", "d");
    map.insert("02", "b");
    map.insert("01", "a");
    map.remove("04");
    String[] expected = new String[]{
        "02:b",
        "01:a 03:c"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void removeRightLeftRotationCase1() {
    map.insert("03", "c");
    map.insert("02", "b");
    map.insert("09", "i");
    map.insert("01", "a");
    map.insert("07", "g");
    map.insert("10", "j");
    map.insert("06", "f");
    map.remove("01");
    String[] expected = new String[]{
        "07:g",
        "03:c 09:i",
        "02:b 06:f null 10:j"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void removeRightLeftRotationCase2() {
    map.insert("03", "c");
    map.insert("02", "b");
    map.insert("09", "i");
    map.insert("01", "a");
    map.insert("07", "g");
    map.insert("10", "j");
    map.insert("08", "h");
    map.remove("01");
    String[] expected = new String[]{
        "07:g",
        "03:c 09:i",
        "02:b null 08:h 10:j"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void removeLeftRightRotationCase1() {
    map.insert("15", "o");
    map.insert("02", "b");
    map.insert("16", "p");
    map.insert("01", "a");
    map.insert("04", "d");
    map.insert("17", "q");
    map.insert("03", "c");
    map.remove("17");
    String[] expected = new String[]{
        "04:d",
        "02:b 15:o",
        "01:a 03:c null 16:p"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());

  }

  @Test
  public void removeLeftRightRotationCase2() {
    map.insert("15", "o");
    map.insert("02", "b");
    map.insert("16", "p");
    map.insert("01", "a");
    map.insert("04", "d");
    map.insert("17", "q");
    map.insert("05", "e");
    map.remove("17");
    String[] expected = new String[]{
        "04:d",
        "02:b 15:o",
        "01:a null 05:e 16:p"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }
}
