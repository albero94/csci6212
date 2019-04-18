package csci6212;
import java.util.LinkedList;

public final class Maze {

    private int [][] maze;
    private boolean [][] visited;
    private int rows;
    private int columns;
    private LinkedList<Position> queue;
    private Position [] movements;
    private Position start;
    private Position end;


    Maze(int [][] map, int[] start, int[] end){
        
        this.rows = map.length;
        this.columns = map[0].length;
        this.start = new Position(start[0], start[1]);
        this.end = new Position(end[0], end[1]);
        // if (rows > 0) this.columns = map[0].length;
        // else System.out.println("I will have to throw exception here");

        this.queue = new LinkedList<>();
        this.maze = new int [rows][columns];
        this.visited = new boolean [rows][columns];
        movements = new Position []{
            new Position(0, 1),
            new Position(0, -1),
            new Position(1, 0),
            new Position(-1, 0)
        };
        for (int i =0; i<rows; i++){
            for (int j=0; j<columns; j++){
                this.maze[i][j] = map[i][j];
                this.visited[i][j] = false;
            }
        }
    }


    public class Position{
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

        boolean isWall(){
            return this.x<0 || this.y<0 || this.x>rows-1 || this.y>columns-1 || maze[this.x][this.y] == 1;
        }

        boolean isVisited(){
            return visited[this.x][this.y] == true;
        }

        boolean isSamePositionAs(Position p){
            return this.x == p.x && this.y == p.y;
        }
    }
    

    public boolean pathExists(){
        Position currentPosition = new Position (start.x, start.y);
        queue.add(start);
        visited[start.x][start.y] = true;
        while(queue.peekFirst() != null){
            currentPosition = queue.remove();
            for (Position movement:movements){                
                Position newPosition = new Position(currentPosition.x, currentPosition.y);
                newPosition.add(movement);
                if(!newPosition.isWall() && !newPosition.isVisited()){
                    if (newPosition.isSamePositionAs(end)) return true;
                    queue.add(newPosition);
                    visited[newPosition.x][newPosition.y] = true;
                }                
            }
        }

        return false;
    }



}