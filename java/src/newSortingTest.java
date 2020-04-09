import org.junit.Test;

import static org.junit.Assert.*;

public class newSortingTest {

    @Test
    // even array
    // test passed
    // method will take and array and sort it correctly
    public void newSorting1() {
        newSorting test = new newSorting();
        int[] sort = {3,5,2,7,9,10};
        int[] exp = {2,3,5,7,9,10};
        test.newSorting(sort,1);
        assertArrayEquals(exp, sort);

    }
    @Test
    //odd array
    // test passed
    // method will take and array and sort it correctly
    public void newSorting2() {
        newSorting test = new newSorting();
        int[] sort = {3,5,2,7,9};
        int[] exp = {2,3,5,7,9};
        test.newSorting(sort,5);
        assertArrayEquals(exp, sort);
    }
    @Test
    //doubles
    // test passed
    // method will take and array and sort it correctly
    public void newSorting3() {
        newSorting test = new newSorting();
        int[] sort = {1,5,8,5,1,8};
        int[] exp = {1,1,5,5,8,8};
        test.newSorting(sort,4);
        assertArrayEquals(exp, sort);
    }
    @Test
    //array already sorted
    // test passed
    // method will just return the same array
    public void newSorting4() {
        newSorting test = new newSorting();
        int[] sort = {6,7,8,9,10};
        test.newSorting(sort,2);
        assertArrayEquals(sort, sort);
    }

    @Test
    //empty array
    // test passed
    // method will just return the empty array
    public void newSorting5() {
        newSorting test = new newSorting();
        int[] sort = {};
        test.newSorting(sort,4);
        assertArrayEquals(sort, sort);
    }
}
