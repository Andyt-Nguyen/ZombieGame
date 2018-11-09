public class Map {
    private int[][] grid;
    

    public void setGrid(int rows, int col) {
        this.grid = new int[rows][col];
    }

    public void displayMap() {
        System.out.println("\n                                       ---------------------------------------");
        System.out.println("                                                        Map");
        System.out.println("                                       ---------------------------------------");
        for(int i = 0; i < this.grid.length; i++) {
            System.out.print("                              ");
            for(int j = 0; j < this.grid[i].length; j++) {
                if(grid[i][j] > 50) { // anything greater than 50 is the enemy
                    System.out.print("Z  ");
                } else if(grid[i][j] == 5) {
                    System.out.print("W  ");
                } else if(grid[i][j] == 6) {
                    System.out.print("D  ");
                } else if(grid[i][j] == 4) {
                    System.out.print("K  ");
                } else if(grid[i][j] >= 30 && grid[i][j] <= 40) {
                    System.out.print("N  ");
                } else if(grid[i][j] == 1) {
                    System.out.print("P  ");
                } else if(grid[i][j] == 20) {
                    System.out.print("A  ");
                } else if(grid[i][j] == 21) {
                    System.out.print("S  ");
                } else if(grid[i][j] == 25) {
                    System.out.print("SK ");
                } else if(grid[i][j] == 26) {
                    System.out.print("FD ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println("");
        }
        System.out.println("                                       ----------------------------------------");
        System.out.println("                                        W-Wall I-Item P-Player Z-Zombie .-Empty");
        System.out.println("                                       ----------------------------------------");
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