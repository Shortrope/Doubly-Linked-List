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
    public void testAdd_to_non_empty_list() {
        assertEquals("1st", sList.getFirst());
        sList.add("New 1st");
        assertEquals("New 1st", sList.getFirst());
        assertEquals("2nd", sList.get(2));
    }
    @Test
    public void testAdd_to_empty_list() {
        sList.clear();
        assertNull(sList.getFirst());
        sList.add("New 1st");
        assertEquals("New 1st", sList.getFirst());
        assertEquals("1st", sList.get(1));

        iList.clear();
        assertNull(iList.getFirst());
        iList.add(11);
        assertEquals(11, (int)iList.getFirst());
        assertEquals(1, (int)iList.get(1));
    }




}