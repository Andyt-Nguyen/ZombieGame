public class Map {
    private int[][] grid;
    

    public void setGrid(int rows, int col) {
        this.grid = new int[rows][col];
    }

    public void displayMap() {
        for(int i = 0; i < this.grid.length; i++) {
            System.out.print("                  ");
            for(int j = 0; j < this.grid[i].length; j++) {
                int curr = grid[i][j];
                if(curr == 1) System.out.print("P  ");
                else if(curr >= 10 && curr < 20) System.out.print("K  ");
                else if(curr >= 20 && curr < 30) System.out.print("B  ");
                else if(curr >= 30 && curr < 40) System.out.print("MB ");
                else System.out.print(".  ");
            }
            System.out.println("");
        }
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