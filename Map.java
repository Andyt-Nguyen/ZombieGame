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
            System.out.print("                  ");
            for(int j = 0; j < this.grid[i].length; j++) {
                int curr = grid[i][j];
                if(curr == 10)  System.out.print("K  ");
                else if(curr == 1) System.out.print("P  ");
                else if(curr == 11) System.out.print("B  ");
                else if(curr == 12) System.out.print("D  ");
                else System.out.print(".  ");
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