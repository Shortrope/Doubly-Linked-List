import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DblLListTest {

    private DblLList<String> sList;
    private DblLList<Integer> iList;

    @org.junit.Before
    public void setUp() throws Exception {
        sList = new DblLList<String>();
        sList.add("5th");
        sList.add("4th");
        sList.add("3rd");
        sList.add("2nd");
        sList.add("1st");

        iList = new DblLList<Integer>();
        iList.add(5);
        iList.add(4);
        iList.add(3);
        iList.add(2);
        iList.add(1);
    }


    @Test
    public void testSize_and_testClear() {
        assertEquals(5, sList.size());
        sList.clear();
        assertEquals(0, sList.size());

        assertEquals(5, iList.size());
        iList.clear();
        assertEquals(0, iList.size());

        // clear an empty sList
        sList.clear();
        assertEquals(0, sList.size());
        iList.clear();
        assertEquals(0, iList.size());
    }

    @Test
    public void testAdd_and_testAddFirst_to_non_empty_list() {
        assertEquals("1st", sList.getFirst());
        sList.add("New 1st");
        assertEquals("New 1st", sList.getFirst());
        assertEquals("2nd", sList.get(2));

        assertEquals((Integer)1, iList.getFirst());
        iList.addFirst(11);
        assertEquals((Integer)11, iList.getFirst());
        assertEquals((Integer)2, iList.get(2));
    }
    @Test
    public void testAdd_and_testAddFirst_to_empty_list() {
        sList.clear();
        assertNull(sList.getFirst());
        sList.add("New 1st");
        assertEquals("New 1st", sList.getFirst());

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
        assertEquals((Integer)101, iList.getFirst());
        assertEquals(1, iList.size());
    }
    @Test
    public void testAdd_item_at_valid_index() {
        assertEquals((Integer)3, iList.get(2));
        assertEquals((Integer)4, iList.get(3));
        assertEquals(5, iList.size());
        iList.add(404, 3);
        assertEquals((Integer)3, iList.get(2));
        assertEquals((Integer)404, iList.get(3));
        assertEquals((Integer)4, iList.get(4));
        assertEquals(6, iList.size());

    }
    @Test
    public void testAdd_item_at_invalid_index() {
        assertEquals("5th", sList.get(4));
        sList.add("New Item", -1);
        assertEquals("5th", sList.get(4));
        sList.add("New Item", 5);
        assertEquals("5th", sList.get(4));
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

}