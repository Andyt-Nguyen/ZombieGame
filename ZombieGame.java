class ZombieGame {
    public static void main(String args[]) {
        Map map = new Map();
        Person player = new Person();
        map.setGrid(10);
        map.getGrid();

        player.moveDown();
        player.moveForward();
        map.setPlayerPos(player.xpos, player.ypos);
        System.out.println("");
        map.getGrid();
    }
}