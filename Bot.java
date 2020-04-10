import java.util.*;
public class Bot {
    Map sol;
    final char dot = '•';
    final char cloud = '☁';

    public Bot(int size) {
        sol = new Map(size);
    }

    public void explore(Map map, int X[], int Y[]){
        /*
        // System.out.println("Bot is at " + map.X[0] + " " + map.X[1]);
        // sol = new Map(map.dim);
        // System.out.println("Solution created");
        // sol.printMap();
        if(!solver(map, X[0], X[1], Y, sol)) {
            System.out.println("Solution DNE!");
            return;
        }*/




        if(findPath(map, sol, X[0], X[1], Y)) {
            System.out.println("Solution Found!");
            sol.grid[X[0]][X[1]] = 'Ⓧ';
            sol.grid[Y[0]][Y[1]] = 'Ⓨ';
            sol.printMap();
            // System.out.println("orig map!");
            // map.printMap();
            System.out.println("Solution Above!");
        } else {
            System.out.println("Solution DNE!");
            map.printMap();
        }
    }




    public boolean findPath(Map map, Map sol, int x, int y, int[] fin) {
        if(x == fin[0] && y == fin[1]) { //we have reached
			sol.grid[x][y] = 1;
			return true;
		}

        if(isSafe(map, x, y)) {
            // System.out.println("I'm at " + x + " " + y);
            sol.grid[x][y] = dot;
            // 0d 1r 2u 3l
            // DOWN = 0
            // RIGHT = 1
            // UP = 2
            // LEFT = 3
            if(isSafe(map, x+1, y) && sol.grid[x+1][y] != dot && findPath(map, sol, x+1, y, fin)) { //go down
				return true;
			}

            if(isSafe(map, x, y+1) && sol.grid[x][y+1] != dot && findPath(map, sol, x, y+1, fin)) { //go right
                return true;
            }
            if(isSafe(map, x-1, y) && isSafe(sol, x, y+1) && sol.grid[x-1][y] != dot && findPath(map, sol, x-1, y, fin)) { //go up
				return true;
			}
            if(isSafe(map, x, y-1) && sol.grid[x][y-1] != dot && findPath(map, sol, x, y-1, fin)) { //go left
				return true;
			}

            sol.grid[x][y] = cloud;
        }
        return false;
    }





    public boolean isSafe(Map map, int x, int y) {
        return (x >= 0 &&
                x < map.dim &&
                y >= 0 &&
                y < map.dim &&
                map.grid[x][y] != cloud);
        // if (ret)
        //     System.out.println(x + " " + y + " is safe");
        // else
        //     System.out.println(x + " " + y + " is not safe");
        // return ret;
    }

    public boolean isSafe2(Map map, int x, int y, Map sol) {
        boolean ret = (x >= 0 &&
        x < map.dim &&
        y >= 0 &&
        y < map.dim &&
        (map.grid[x][y] == dot ||
        map.grid[x][y] == 'Ⓧ' ||
        map.grid[x][y] == 'Ⓨ') && sol.grid[x][y] != dot) ;
        if (ret)
            System.out.println(x + " " + y + " is safe");
        else System.out.println(x + " " + y + " is not safe");
        return ret;
    }

    public boolean solver(Map map, int x, int y, int fin[], Map sol) {
        // if (x, y is goal) return true
        // System.out.println("I'm at " + x + " " + y);
        int N = map.dim;
        if (x == fin[0] && y == fin[1]) {
            sol.grid[x][y] = dot;
            return true;
        }

        // Check if map[x][y] is valid
        if (isSafe2(map, x, y, sol)) {
            // mark x, y as part of solution path
            sol.grid[x][y] = dot;
            sol.printMap();

            if (solver(map, x + 1, y, fin, sol))
                return true;

            if (solver(map, x, y + 1, fin, sol))
                return true;

            if (solver(map, x - 1, y, fin, sol))
                return true;

            if (solver(map, x, y - 1, fin, sol))
                return true;

            sol.grid[x][y] = cloud; // this position was not useful
            return false;
        }
        return false;
    }
}
