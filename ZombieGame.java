class ZombieGame {
    public static void main(String args[]) {
        Map map = new Map();
        Person player = new Person();
        // int GRID_AMOUNT = 10;
        map.setGrid(10);
        while(player.getUserHp() > 0) {
            System.out.println("");
            System.out.println("**********************************");
            System.out.println("*             Options            *");
            System.out.println("* 0. Move forward                *");
            System.out.println("* 1. Move downward               *");
            System.out.println("* 2. Move upward                 *");
            System.out.println("* 3. Move backward               *");
            System.out.println("* 4. Display map                 *");
            System.out.println("**********************************");
            int userInput = IR5.getInteger("Selction option");
            System.out.println("");
            switch(userInput) {
                case 0: // Move forward
                    if(player.xpos + 1 > map.getGrid()[0].length -1) {
                        System.out.println("You hit a wall");
                        break;
                    } else {
                        map.prevPostion(player.xpos, player.ypos, 0);
                        player.moveForward();
                        map.setPlayerPos(player.xpos, player.ypos);
                        break;
                    }
                case 1: // Move downward
                    if(player.ypos > map.getGrid()[0].length - 1) {
                        System.out.println("You hit a wall");
                        break;
                    } else {
                        map.prevPostion(player.xpos, player.ypos, 0);
                        player.moveDown();
                        map.setPlayerPos(player.xpos, player.ypos);
                        break;
                    }
                case 2: // Move up
                    if(player.ypos - 1 < 0) {
                        System.out.println("You hit a wall");
                        break;
                    } else {
                        map.prevPostion(player.xpos, player.ypos, 0);
                        player.moveUp();
                        map.setPlayerPos(player.xpos, player.ypos);
                        break;
                    }
                case 3: // Move left
                    if(player.xpos  - 1 < 0) {
                        System.out.println("You hit a wall");
                        break;
                    } else {
                        map.prevPostion(player.xpos, player.ypos, 0);
                        player.moveLeft();
                        map.setPlayerPos(player.xpos, player.ypos);
                        break;
                    }
                case 4: // displays map
                    map.displayMap();
                    System.out.println("");
                    break;
                
                default: 
                    System.out.println("Those were not any of the selections");
            }
        }
    }
}