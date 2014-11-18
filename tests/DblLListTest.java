import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DblLListTest {

    private DblLList<String> sList;
    private DblLList<Integer> iList;

    // These are Collections to use for addAll() testing
    private ArrayList<String> sAList;

    @org.junit.Before
    public void setUp() throws Exception {
        sList = new DblLList<String>();
        sList.add("1st");
        sList.add("2nd");
        sList.add("3rd");
        sList.add("4th");
        sList.add("5th");

        iList = new DblLList<Integer>();
        iList.add(1);
        iList.add(2);
        iList.add(3);
        iList.add(4);
        iList.add(5);

        sAList = new ArrayList<String>();
        sAList.add("ArrayList #1");
        sAList.add("ArrayList #2");
        sAList.add("ArrayList #3");
    }


    @Test
    public void testSize_and_testClear() {
        assertEquals(5, sList.size());
        sList.clear();
        assertEquals(0, sList.size());
        assertNull(sList.get());

        assertEquals(5, iList.size());
        iList.clear();
        assertEquals(0, iList.size());
        assertNull(iList.getFirst());

        // clear an empty sList
        sList.clear();
        assertEquals(0, sList.size());
        iList.clear();
        assertEquals(0, iList.size());
    }

    @Test
    public void testAdd_to_non_empty_list() {
        assertEquals("5th", sList.getLast());
        sList.add("New Last");
        assertEquals("New Last", sList.getLast());
        assertEquals("5th", sList.get(4));
    }

    @Test
    public void testAdd_to_empty_list() {
        sList.clear();
        assertNull(sList.getFirst());
        sList.add("New item");
        assertEquals("New item", sList.getFirst());
        assertEquals("New item", sList.getLast());
    }

    @Test
    public void testAddFirst_to_non_empty_list() {
        sList.addFirst("New First");
        assertEquals("New First", sList.getFirst());
        assertEquals(6, sList.size());
    }

    @Test
    public void testAddFirst_to_empty_list() {
        iList.clear();
        assertNull(iList.getFirst());
        iList.addFirst(11);
        assertEquals(11, (int)iList.getFirst());
    }

    @Test
    public void testAddLast_to_non_empty_list() {
        assertEquals("5th", sList.getLast());
        assertEquals(5, sList.size());
        sList.addLast("6th");
        assertEquals("6th", sList.getLast());
        assertEquals("5th", sList.get(4));
        assertEquals(6, sList.size());
    }

    @Test
    public void testAddLast_to_empty_list() {
        iList.clear();
        assertNull(iList.getLast());
        assertEquals(0, iList.size());
        iList.addLast(101);
        assertEquals((Integer)101, iList.getLast());
        assertEquals((Integer) 101, iList.getFirst());
        assertEquals(1, iList.size());
    }

    @Test
    public void testAdd_item_at_valid_index() {
        assertEquals((Integer)3, iList.get(2));
        assertEquals((Integer)4, iList.get(3));
        assertEquals(5, iList.size());
        iList.add(3, 404);
        assertEquals((Integer)3, iList.get(2));
        assertEquals((Integer)404, iList.get(3));
        assertEquals((Integer)4, iList.get(4));
        assertEquals(6, iList.size());
    }

    @Test
    public void testAdd_item_at_invalid_index() {
        assertEquals("5th", sList.get(4));
        sList.add(-1, "New Item");
        assertEquals("5th", sList.get(4));
        sList.add(5, "New Item");
        assertEquals("5th", sList.get(4));
    }

    @Test
    public void testAdd_item_at_index_zero() {
        assertEquals(5, sList.size());
        assertEquals("1st", sList.get(0));
        sList.add(0, "New 1st");
        assertEquals("New 1st", sList.get(0));
        assertEquals("1st", sList.get(1));
        assertEquals("5th", sList.getLast());
        assertEquals(6, sList.size());
    }

    @Test
    public void testAdd_item_at_last_index() {
        assertEquals(5, sList.size());
        assertEquals("5th", sList.get(4));
        sList.add(4, "New Item");
        assertEquals("New Item", sList.get(4));
        assertEquals("5th", sList.get(5));
        assertEquals("5th", sList.getLast());
        assertEquals(6, sList.size());
    }

    @Test
    public void testAdd_item_at_last_index_plus_1() {
        // Allows an item to be added to end of the list using
        // an index.
        assertEquals(5, sList.size());
        assertEquals("5th", sList.getLast());
        sList.add(sList.size(), "New Item");
        assertEquals("New Item", sList.getLast());
        assertEquals("5th", sList.get(4));
        assertEquals(6, sList.size());
    }

    @Test
    public void testAddAll() {
        //addAll() appends to end of list
        assertEquals(5, sList.size());
        assertEquals("5th", sList.getLast());
        assertEquals("5th", sList.get(4));
        sList.addAll(sAList);
        assertEquals(8, sList.size());
        assertEquals("ArrayList #3", sList.getLast());
        assertEquals("5th", sList.get(4));
    }

    @Test
    public void testAddAll_to_empty_list() {
        sList.clear();
        assertEquals(0, sList.size());
        assertNull(sList.getFirst());
        sList.addAll(sAList);
        assertEquals("ArrayList #1", sList.getFirst());
        assertEquals("ArrayList #3", sList.getLast());
        assertEquals(3, sList.size());
    }

    @Test
    public void testAddAll_at_valid_index() {
        assertEquals(5, sList.size());
        assertEquals("5th", sList.getLast());
        assertEquals("3rd", sList.get(2));
        // add to middle of list
        sList.addAll(2, sAList);
        assertEquals(8, sList.size());
        assertEquals("5th", sList.getLast());
        assertEquals("ArrayList #1", sList.get(2));
        // add to end of list using the highest valid index + 1
        // in other words, using size() as the index
        System.out.println(sList.size());
        sList.addAll(sList.size(), sAList);
        assertEquals(11, sList.size());
        assertEquals("5th", sList.get(7));
        assertEquals("ArrayList #3", sList.getLast());
    }

    @Test
    public void testAddAll_at_invalid_index() {
        assertEquals(5, sList.size());
        assertEquals("1st", sList.getFirst());
        assertEquals("3rd", sList.get(2));
        assertEquals("5th", sList.getLast());
        sList.addAll(-1, sAList);
        assertEquals(5, sList.size());
        assertEquals("1st", sList.getFirst());
        assertEquals("3rd", sList.get(2));
        assertEquals("5th", sList.getLast());
        sList.addAll(6, sAList);
        assertEquals(5, sList.size());
        assertEquals("1st", sList.getFirst());
        assertEquals("3rd", sList.get(2));
        assertEquals("5th", sList.getLast());
    }

    @Test
    public void testAddAll_with_index_to_empty_list() {
        sList.clear();
        assertEquals(0, sList.size());
        assertNull(sList.getFirst());
        sList.addAll(0, sAList);
        assertEquals(3, sList.size());
        assertEquals("ArrayList #1", sList.getFirst());
        assertEquals("ArrayList #3", sList.getLast());
    }

    @Test
    public void testConstructor_passing_in_a_collection() {
        DblLList<String> collectionList = new DblLList<String>(sAList);
        assertEquals(3, collectionList.size());
        assertEquals("ArrayList #1", collectionList.getFirst());
        assertEquals("ArrayList #3", collectionList.getLast());
    }

    @Test
    public void testSet_item_at_valid_index() {
        assertEquals(5, iList.size());
        assertEquals((Integer)2, iList.get(1));
        iList.set(202, 1);
        assertEquals((Integer)202, iList.get(1));
        assertEquals(5, iList.size());
    }

    @Test
    public void testSet_item_at_invalid_index() {
        assertEquals(5, iList.size());
        assertEquals((Integer)2, iList.get(1));
        iList.set(202, -1);
        assertEquals((Integer)2, iList.get(1));
        assertEquals(5, iList.size());
        iList.set(202, 5);
        assertEquals((Integer)5, iList.getLast());
        assertEquals(5, iList.size());
    }

    @Test
    public void testRemove_from_non_empty_list() {
        assertEquals(5, iList.size());
        assertEquals((Integer)1, iList.remove());
        assertEquals((Integer) 2, iList.getFirst());
        assertEquals(4, iList.size());
    }

    @Test
    public void testRemove_from__empty_list() {
        sList.clear();
        assertEquals(0, sList.size());
        assertNull(sList.remove());
        assertEquals(0, sList.size());
    }

    @Test
    public void testRemove_from_list_with_one_node() {
        sList.clear();
        sList.add("Only item");
        assertEquals(1, sList.size());
        assertEquals("Only item", sList.remove());
        assertEquals(0, sList.size());
    }

    @Test
    public void testRemoveFirst_from_non_empty_list() {
        assertEquals(5, sList.size());
        assertEquals("1st", sList.removeFirst());
        assertEquals("2nd", sList.getFirst());
        assertEquals(4, sList.size());

    }

    @Test
    public void testRemoveFirst_from__empty_list() {
        iList.clear();
        assertEquals(0, iList.size());
        assertNull(iList.removeFirst());
        assertEquals(0, iList.size());
    }

    @Test
    public void testRemoveLast_from_non_empty_list() {
        assertEquals(5, sList.size());
        assertEquals("5th", sList.getLast());
        assertEquals("5th", sList.removeLast());
        assertEquals("4th", sList.getLast());
        assertEquals(4, sList.size());
    }

    @Test
    public void testRemoveLast_from_empty_list() {
        sList.clear();
        assertEquals(0, sList.size());
        assertNull(sList.removeLast());
        assertEquals(0, sList.size());
    }

    @Test
    public void testRemoveLast_from_list_with_only_one_node() {
        sList.clear();
        sList.add("I'm an orphan");
        assertEquals(1, sList.size());
        assertEquals("I'm an orphan", sList.removeLast());
        assertEquals(0, sList.size());
        assertNull(sList.getLast());
    }

    @Test
    public void testRemove_index_from_non_empty_list() {
        assertEquals(5, iList.size());
        assertEquals((Integer)3, iList.remove(2));
        assertEquals((Integer)4, iList.get(2));
        assertEquals((Integer)2, iList.get(1));
        assertEquals((Integer)5, iList.getLast());
        assertEquals(4, iList.size());
    }

    @Test
    public void testRemove_index_from_empty_list() {
        sList.clear();
        assertEquals(0, sList.size());
        assertNull(sList.remove(0));
        assertNull(sList.remove(3));
    }

    @Test
    public void testRemove_index_from_list_with_only_one_node() {
        sList.clear();
        sList.add("Only item");
        assertEquals(1, sList.size());
        assertEquals("Only item", sList.remove(0));
        assertEquals(0, sList.size());
        assertNull(sList.remove(0));
    }

    @Test
    public void testRemove_with_invalid_index() {

        assertEquals(5, sList.size());
        assertNull(sList.remove(-1));
        assertNull(sList.remove(5));
        assertEquals(5, sList.size());
    }

   @Test
    public void testClone() {
       DblLList<String> clonedList = sList.clone(sList);
       assertEquals(5, clonedList.size());
       assertFalse(clonedList == sList);
       assertTrue(clonedList.getFirst() == sList.getFirst());
   }



}