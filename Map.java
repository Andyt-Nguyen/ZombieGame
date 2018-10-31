public class Map {
    private int[][] grid;
    

    public void setGrid(int rows, int col) {
        this.grid = new int[rows][col];
    }

    public void displayMap() {
        System.out.println("\n----------------------------");
        System.out.println("              Map");
        System.out.println("----------------------------");
        for(int i = 0; i < this.grid.length; i++) {
            for(int j = 0; j < this.grid[i].length; j++) {
                if(grid[i][j] == 3) {
                    System.out.print("B ");
                } else if(grid[i][j] > 50) { // change this back to > 50 
                    System.out.print("Z ");
                } else if(grid[i][j] == 1) {
                    System.out.print("P ");
                } else {
                    // System.out.print(grid[i][j] + " ");
                    System.out.print(". ");
                }
            }
            System.out.println("");
        }
        System.out.println("----------------------------");
        System.out.println(" W=Wall I=Item P=Player Z=Zombie .=Empty");
        System.out.println("----------------------------");
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