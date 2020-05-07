
public class Tester {
    public static void main(String args[]) {
        // init Magellan
        final int mapSize = 8;
        Bot magellan = new Bot(mapSize);
        // init Map passing density
        Map map = new Map(mapSize, 0.4);
        // map.printMap();
        magellan.explore(map, map.X, map.Y);
    }
}
