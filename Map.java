public class Map {
    private int rows;
    private int cols;
    private int names;
    private int[][] grid;

    public void setGrid(int num) {
        this.grid = new int[num][num];
    }

    public void getGrid() {
        for(int i = 0; i < this.grid.length; i++) {
            System.out.print("[");
            for(int j = 0; j < this.grid[i].length; j++) {
                if(j < this.grid.length - 1) System.out.print(grid[i][j] + ", ");
                else System.out.print(grid[i][j]); 
            }
            System.out.print("]");
            System.out.println("");
        }
    }

    public void setPlayerPos(int x, int y) {
        int curr = this.grid[x][y];
        this.grid[x][y] = 1;
    }

}