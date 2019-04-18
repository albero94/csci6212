package csci6212;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public final class BipartiteTest {

    @Test
    public void fourNodesIsBipartite(){
        ArrayList<ArrayList<Integer>> myListofList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(3);
        myListofList.add(myList);
        myList = new ArrayList<>();
        myList.add(0);
        myList.add(2);
        myListofList.add(myList);
        myList = new ArrayList<>();
        myList.add(1);
        myList.add(3);
        myListofList.add(myList);
        myList = new ArrayList<>();
        myList.add(0);
        myList.add(2);
        myListofList.add(myList);
        
        Bipartite myGraph = new Bipartite(myListofList);
        assertEquals(true, myGraph.isBipartite());  
    }


    @Test
    public void fourNodesNoBipartite(){
        ArrayList<ArrayList<Integer>> myListofList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(3);
        myListofList.add(myList);
        myList = new ArrayList<>();
        myList.add(0);
        myList.add(2);
        myListofList.add(myList);
        myList = new ArrayList<>();
        myList.add(1);
        myList.add(3);
        myListofList.add(myList);
        myList = new ArrayList<>();
        myList.add(0);
        myList.add(2);
        myList.add(1);
        myListofList.add(myList);
        
        Bipartite myGraph = new Bipartite(myListofList);
        assertEquals(false, myGraph.isBipartite());  
    }
}
