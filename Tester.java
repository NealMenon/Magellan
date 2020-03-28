
public class Tester {
    public static void main(String args[]) {
        // init Magellan
        Bot magellan = new Bot();
        // init Map
        Map map = new Map(10, 1);
        // map.printMap();
        magellan.explore(map, map.X, map.Y,map.dim, "");


    }
}
