
public class Bot {
    String path;
    final char dot = '•';
    final char cloud = '☁';
    public Bot() {
        path = "";
    }

    public void explore(Map map, int X[], int Y[], int dim, String curJourney){
        // System.out.println("Bot is at " + map.X[0] + " " + map.X[1]);
        if(X[0] == Y[0] && X[1] == Y[1]) {
            // WE HAVE ARRIVED
            this.path = curJourney;
            System.out.println("Found by traversing: "+ this.path);
            return;
        }
        if(X[0] + 1 < dim && map[X[0] + 1][x[1]] != cloud) {
            X[0]++;
            explore(map, X, Y, dim, curJourney + "D");
        }
        if(X[0] - 1 >= 0) {
            X[0]--;
            explore(map, X, Y, dim, curJourney + "U");
        }
        if(X[1] + 1 < dim) {
            X[1]++;
            explore(map, X, Y, dim, curJourney + "R");
        }
        if(X[1] - 1 >= 0) {
            X[1]--;
            explore(map, X, Y, dim, curJourney + "L");
        }
    }
}
