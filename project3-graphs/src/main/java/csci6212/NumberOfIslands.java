package csci6212;

import java.util.LinkedList;

public final class NumberOfIslands {

    private int numberOfIslands;
    private int [][] map;
    private boolean [][] visited;
    private int rows;
    private int columns;
    private LinkedList<Position> stack;
    private Position [] movements;
    
    NumberOfIslands(int [][] map, int rows, int columns){
        this.numberOfIslands = 0;
        this.stack = new LinkedList<>();
        this.rows = rows;
        this.columns = columns;
        this.map = new int [rows][columns];
        this.visited = new boolean [rows][columns];
        movements = new Position []{
            new Position(0, 1),
            new Position(0, -1),
            new Position(1, 0),
            new Position(-1, 0)
        };
        for (int i =0; i<rows; i++){
            for (int j=0; j<columns; j++){
                this.map[i][j] = map[i][j];
                this.visited[i][j] = false;
            }
        }
    }

    public class Position {
        public int x;
        public int y;

        Position(){
            this.x = 0;
            this.y = 0;
        }
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void add(Position p1){
            this.x += p1.x;
            this.y += p1.y;
        }

        boolean isWater(){
            return this.x<0 || this.y<0 || this.x>rows-1 || this.y>columns-1 || map[this.x][this.y] == 0;
        }

        boolean isVisited(){
            return visited[this.x][this.y] == true;
        }
    }


//pop
//push()
//peekFirst()

    int calculateNumberOfIslands(){
        for (int i =0; i<rows; i++){
            for (int j=0; j<columns; j++){
                if (map[i][j] == 1 && !visited[i][j]){
                    exploreIsland(i, j);
                    numberOfIslands ++;
                }
            }
        }

        return numberOfIslands;
    }

    void exploreIsland(int i, int j){
        Position currentPosition = new Position(i, j);
        visited[i][j] = true;
        stack.push(currentPosition);

        while (stack.peekFirst() != null){
            boolean hasUnvisitedChildren = false;
            for (Position movement:movements){                
                Position newPosition = new Position(stack.peekFirst().x, stack.peekFirst().y);
                newPosition.add(movement);
                if(!newPosition.isWater() && !newPosition.isVisited()){
                    stack.push(newPosition);
                    visited[newPosition.x][newPosition.y] = true;
                    hasUnvisitedChildren = true;
                    break;
                }                
            }
            if(!hasUnvisitedChildren)   stack.pop();
        }
    }


    

}
