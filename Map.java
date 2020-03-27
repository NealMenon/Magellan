
public class Map {
    char grid[][];
    int dim;
    // double cloudDensity; // between 0 and 0.5
    int X[];
    int Y[];
    public Map(int dimension, double density) {
        dim = dimension;
        density = Math.abs(density);
        density = Math.min(density, 0.4);

        // cloudDensity = density;

        grid = new char[dim][dim];
        X = new int[2];
        Y = new int[2];

        this.initMap();
        this.cloudify(density);
        this.setX();
        this.setY();
        System.out.println("Map init: ");
        this.printMap();

    }

    public void cloudify(double den) {
        int cloudsPlaced = 0;
        while(cloudsPlaced < (dim*dim) * den) {
            int randX = (int)(Math.random() * dim);
            int randY = (int)(Math.random() * dim);
            if(grid[randX][randY] == 'o') {
                grid[randX][randY] = '#';
                cloudsPlaced++;
            }
        }
    }

    public void setX() {
        while(true) {
            int randX = (int)(Math.random() * dim);
            int randY = (int)(Math.random() * dim);
            if(grid[randX][randY] == 'o') {
                grid[randX][randY] = 'X';
                X = new int[]{randX, randY};
                break;
            }
        }
    }
    public void setY() {
        while(true) {
            int randX = (int)(Math.random() * dim);
            int randY = (int)(Math.random() * dim);
            if(grid[randX][randY] == 'o') {
                grid[randX][randY] = 'Y';
                Y = new int[]{randX, randY};
                break;
            }
        }
    }

    public void initMap() {
        for(int i = 0; i < dim; i++)
            for(int j = 0; j < dim; j++)
                grid[i][j] = 'o';
    }


    public void printMap() {
        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}
