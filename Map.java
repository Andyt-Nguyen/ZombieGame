public class Map {
    private int rows;
    private int cols;
    private int names;
    private int[][] grid;

    public void setGrid(int num) {
        this.grid = new int[num][num];
    }

    public void displayMap() {
        System.out.println("--------------------------------");
        System.out.println("              Map");
        System.out.println("--------------------------------");
        for(int i = 0; i < this.grid.length; i++) {
            System.out.print("[");
            for(int j = 0; j < this.grid[i].length; j++) {
                if(j < this.grid.length - 1) System.out.print(grid[i][j] + ", ");
                else System.out.print(grid[i][j]); 
            }
            System.out.print("]");
            System.out.println("");
        }
        System.out.println("--------------------------------");
    }


    public void prevPostion(int x, int y, int val) {
        this.grid[y][x] = val;
    }

    public void setPos(int x, int y, int val) {
        this.grid[y][x] = val;
    }

    public int[][] getGrid() {
        return this.grid;
    }

}