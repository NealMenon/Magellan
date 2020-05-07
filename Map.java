
public class Map {
    char grid[][];
    int dim;
    static int X[];
    static int Y[];
    final char dot = '•';
    final char cloud = '☁';

    public Map(int dimension, double density) {
        dim = dimension;
        // double cloud Density between 0 and 0.4
        density = Math.min(Math.abs(density), 0.4);
        grid = new char[dim][dim];
        X = new int[2];
        Y = new int[2];

        this.initMap();
        this.cloudify(density);
        this.setX();
        this.setY();
        this.printMap();

    }
    public Map(int dimension) {
        this.dim = dimension;
        grid = new char[this.dim][this.dim];
        this.initSol();
        // this.printMap();
    }



    public void cloudify(double den) {
        int cloudsPlaced = 0;
        while(cloudsPlaced < Math.floor((dim*dim) * den)) {
            int randX = (int)(Math.random() * dim);
            int randY = (int)(Math.random() * dim);
            if(grid[randX][randY] == dot) {
                grid[randX][randY] = cloud;
                cloudsPlaced++;
            }
        }
    }

    public void setX() {
        while(true) {
            int randX = (int)(Math.random() * dim);
            int randY = (int)(Math.random() * dim);
            if(grid[randX][randY] == dot) {
                grid[randX][randY] = 'Ⓧ';
                X = new int[]{randX, randY};
                // System.out.println("x: " + X[0] + " " + X[1]);
                break;
            }
        }
    }
    public void setY() {
        while(true) {
            int randX = (int)(Math.random() * dim);
            int randY = (int)(Math.random() * dim);
            if(grid[randX][randY] == dot) {
                grid[randX][randY] = 'Ⓨ';
                Y = new int[]{randX, randY};
                // System.out.println("y: " + Y[0] + " " + Y[1]);
                break;
            }
        }
    }

    public void initMap() {
        for(int i = 0; i < dim; i++)
            for(int j = 0; j < dim; j++)
                grid[i][j] = dot;
    }

    public void initSol() {
        for(int i = 0; i < dim; i++)
            for(int j = 0; j < dim; j++)
                grid[i][j] = cloud;
        // System.out.println("Sol grid init");
        // this.printMap();
    }

    public void printMap() {
        System.out.println("Map state: ");
        for(int i = 0; i < this.dim; i++) {
            for(int j = 0; j < this.dim; j++)
                System.out.print(this.grid[i][j] + " ");
            System.out.println();
        }
    }
}
