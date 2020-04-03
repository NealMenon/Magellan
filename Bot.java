
public class Bot {
    String path;
    final char dot = '•';
    final char cloud = '☁';
    public Bot() {
        path = "";
    }

    public void explore(Map map, int X[], int Y[]){
        // System.out.println("Bot is at " + map.X[0] + " " + map.X[1]);
        Map sol = new Map(map.dim);
        if(solver(map, X, Y, sol) == false) {
            System.out.println("Solution DNE!");
            return;
        }
        sol.printMap();
        /*if(X[0] == Y[0] && X[1] == Y[1]) {
            // WE HAVE ARRIVED
            this.path = curJourney;
            System.out.println("Found by traversing: "+ this.path);
            return;
        }
        if(X[0] + 1 < dim && map[X[0] + 1][x[1]] != cloud && map[X[0] + 1][x[1]] != 'o') {
            X[0]++;
            map[X[0]][x[1]] = 'o';
            explore(map, X, Y, dim, curJourney + "D");
        }
        if(X[0] - 1 >= 0 && map[X[0] - 1][x[1]] != cloud && map[X[0] - 1][x[1]] != 'o') {
            X[0]--;
            map[X[0]][x[1]] = 'o';
            explore(map, X, Y, dim, curJourney + "U");
        }
        if(X[1] + 1 < dim && map[X[0]][x[1] + 1] != cloud && map[X[0]][x[1] + 1] != 'o') {
            X[1]++;
            map[X[0]][x[1]] = 'o';
            explore(map, X, Y, dim, curJourney + "R");
        }
        if(X[1] - 1 >= 0 && map[X[0]][x[1] - 1] != cloud && map[X[0]][x[1] - 1] != 'o') {
            X[1]--;
            map[X[0]][x[1]] = 'o';
            explore(map, X, Y, dim, curJourney + "L");
        }*/
    }

    public boolean solver(Map map, int X[], int Y[] Map sol)
}
