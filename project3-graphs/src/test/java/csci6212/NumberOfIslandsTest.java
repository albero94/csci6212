package csci6212;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public final class NumberOfIslandsTest{

    static NumberOfIslands myMap;

    @Test
    public void twoNumberOfIslands(){
        myMap = new NumberOfIslands(
            new int[][]{
                {1, 1, 0, 1, 1},
            }, 1, 5);
        
        assertEquals(2, myMap.calculateNumberOfIslands());  
    }

    @Test
    public void threeNumberOfIslands(){
        myMap = new NumberOfIslands(
            new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
            }, 4, 5);
        
        assertEquals(3, myMap.calculateNumberOfIslands());  
    }

    @Test
    public void oneNumberOfIslands(){
        myMap = new NumberOfIslands(
            new int[][]{
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
            }, 4, 5);
        
        assertEquals(1, myMap.calculateNumberOfIslands());  
    }

    @Test
    public void zeroNumberOfIslands(){
        myMap = new NumberOfIslands(
            new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
            }, 2, 5);
        
        assertEquals(0, myMap.calculateNumberOfIslands());  
    }
}
