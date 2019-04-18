package csci6212;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Bipartite {

    private Node [] graphNodes;
    private ArrayList<ArrayList<Integer>>graph;
    private LinkedList<Integer> queue;
    private int numberOfNodes;


    Bipartite(ArrayList<ArrayList<Integer>>graph){
        this.numberOfNodes = graph.size();
        this.queue = new LinkedList<>();
        this.graphNodes = new Node[numberOfNodes];
        for (int i=0; i<numberOfNodes; i++){
            graphNodes[i] = new Node(i);
        }
        this.graph = graph;        
    }

    private class Node{
        public int value;
        public boolean visited;
        public int color;

        Node(int value){
            this.value = value;
            this.color = -1;
            this.visited = false;
        }
    }

    boolean isBipartite(){

        if (numberOfNodes <= 1) return true;

        queue.add(0);
        graphNodes[0].visited = true;
        graphNodes[0].color = 0;
        while(queue.peekFirst() != null){
            int currentNode = queue.remove();
            for(int i= 0; i<graph.get(currentNode).size(); i++){
                int neighbourNode = graph.get(currentNode).get(i);
                if(graphNodes[neighbourNode].color == graphNodes[currentNode].color) return false;
                if(!graphNodes[neighbourNode].visited){
                    queue.add(neighbourNode);
                    graphNodes[neighbourNode].color = 1-graphNodes[currentNode].color;
                    graphNodes[neighbourNode].visited = true;
                }

            }
        }

        return true;
    }

}
