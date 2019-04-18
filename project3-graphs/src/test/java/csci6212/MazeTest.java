package csci6212;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public final class MazeTest {

    @Test
    public void oneRowsfiveColumsPathExists(){
        int[] start = {0,0};
        int[] end = {0,4};
        Maze myMaze = new Maze(
            new int[][]{
                {0, 0, 0, 0, 0}
            }, start, end);
        
        assertEquals(true, myMaze.pathExists());  
    }

    @Test
    public void fourRowsfiveColumsPathExists(){
        int[] start = {3,0};
        int[] end = {3,4};
        Maze myMaze = new Maze(
            new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0}
            }, start, end);
        
        assertEquals(true, myMaze.pathExists());  
    }

    @Test
    public void sixRowsfiveColumsPathExists(){
        int[] start = {5,0};
        int[] end = {0,4};
        Maze myMaze = new Maze(
            new int[][]{
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0}
            }, start, end);
        
        assertEquals(false, myMaze.pathExists());  
    }


}
