
public class Bot {
    String path;
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
        if(X[0] + 1 < dim) {
            // move right
        }

    }
}
