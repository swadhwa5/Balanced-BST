package hw6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * In addition to the tests in BinarySearchTreeMapTest (and in OrderedMapTest & MapTest),
 * we add tests specific to Treap.
 */
@SuppressWarnings("All")
public class TreapMapTest extends BinarySearchTreeMapTest {

  @Override
  protected Map<String, String> createMap() {
    return new TreapMap<>(40);
  }

  // TODO Add tests
  //  (think about how you might write tests while randomness is involved in TreapMap implementation!)

  @Test
  public void insertRightRotation() {
    map.insert("07", "g");
    map.insert("02", "b");
    String[] expected = new String[]{
        "02:b:-1749212617",
        "null 07:g:-1170874532"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void insertLeftRotation() {
    map.insert("07", "g");
    map.insert("02", "b");
    map.insert("01", "a");
    map.insert("08", "h");
    String[] expected = new String[]{
        "02:b:-1749212617",
        "01:a:95830475 08:h:-1502686769",
        "null null 07:g:-1170874532 null"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void insertHierarchicalRotationsDueToAnInsert() {
    map.insert("07", "g");
    map.insert("04", "d");
    map.insert("03", "c");
    map.insert("08", "h");
    map.insert("01", "a");
    map.insert("00", "z");
    map.insert("02", "b");
    String[] expected = new String[]{
        "04:d:-1749212617",
        "02:b:-680157218 08:h:-1502686769",
        "00:z:1702710456 03:c:95830475 07:g:-1170874532 null",
        "null 01:a:1929790192 null null null null null null"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void removeLeaf() {
    map.insert("07", "g");
    map.insert("04", "d");
    map.insert("03", "c");
    map.insert("08", "h");
    map.insert("01", "a");
    map.insert("00", "z");
    map.insert("02", "b");
    map.remove("07");
    String[] expected = new String[]{
        "04:d:-1749212617",
        "02:b:-680157218 08:h:-1502686769",
        "00:z:1702710456 03:c:95830475 null null",
        "null 01:a:1929790192 null null null null null null"

    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void removeNodeWithOneChild() {
    map.insert("07", "g");
    map.insert("04", "d");
    map.insert("03", "c");
    map.insert("08", "h");
    map.insert("01", "a");
    map.insert("00", "z");
    map.insert("02", "b");
    map.remove("08");
    String[] expected = new String[]{
        "04:d:-1749212617",
        "02:b:-680157218 07:g:-1170874532",
        "00:z:1702710456 03:c:95830475 null null",
        "null 01:a:1929790192 null null null null null null"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

  @Test
  public void removeNodeWithTwoChildren() {
    map.insert("07", "g");
    map.insert("04", "d");
    map.insert("03", "c");
    map.insert("08", "h");
    map.insert("01", "a");
    map.insert("00", "z");
    map.insert("02", "b");
    map.remove("02");
    String[] expected = new String[]{
        "04:d:-1749212617",
        "03:c:95830475 08:h:-1502686769",
        "00:z:1702710456 null 07:g:-1170874532 null",
        "null 01:a:1929790192 null null null null null null"
    };
    assertEquals((String.join("\n", expected) + "\n"), map.toString());
  }

}