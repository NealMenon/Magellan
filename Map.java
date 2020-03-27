
public class Map {
    char grid[][];
    int dim;
    double cloudDensity; // between 0 and 0.5
    int X[];
    int Y[];
    public Map(int dimension, double density) {
        grid = new char[dimension][dimension];
        X = new int[2];
        Y = new int[2];

    }
}
