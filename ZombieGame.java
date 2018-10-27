class ZombieGame {
    public static final int PLAYER = 1;
    public static final int ZOMBIE = 2;
    public static void main(String args[]) {
        Map map = new Map();
        Person player = new Person();
        Zombie zombie = new Zombie();

        map.setGrid(10);
        int[][] grid = map.getGrid();

        player.setXpos(0);
        player.setYpos(0);
        zombie.setXpos(9);
        zombie.setYpos(0);

        map.setPos(player.xpos, player.ypos, PLAYER);
        map.setPos(zombie.xpos, zombie.ypos, ZOMBIE);

        while(player.getUserHp() > 0) {
            System.out.println("");
            System.out.println("**********************************");
            System.out.println("*             Options            *");
            System.out.println("* 1. Move forward                *");
            System.out.println("* 2. Move backward               *");
            System.out.println("* 3. Move upward                 *");
            System.out.println("* 4. Move downward               *");
            System.out.println("* 5. Display map                 *");
            System.out.println("**********************************");
            

            int userInput = IR5.getInteger("Selction option");
            System.out.println("");
            switch(userInput) {

                case 1: // Move forward
                    if(player.xpos + 1 > map.getGrid()[0].length -1) {
                        System.out.println("You hit a wall");
                    } else {
                        if(grid[player.ypos][player.xpos + 1] == 2) {
                            System.out.println("You've encountered a zombie do you fight or run?");
                            /**
                             * Display Menu
                             */

                        } else {
                            grid[player.ypos][player.xpos] = 0;
                            player.moveForward();
                            grid[player.ypos][player.xpos] = PLAYER;
                        }
                    }
                    break;


                case 2: // Move left
                    if(player.xpos  - 1 < 0) {
                        System.out.println("You hit a wall");
                    } else {
                        if(grid[player.ypos][player.xpos - 1] == 2) {
                            System.out.println("You've encountered a zombie do you fight or run?");
                            /**
                             * Display Menu
                             */

                        } else {
                            grid[player.ypos][player.xpos] = 0;
                            player.moveLeft();
                            grid[player.ypos][player.xpos] = PLAYER;
                        }
                    }
                    break;


                case 3: // Move up
                    if(player.ypos - 1 < 0) {
                        System.out.println("You hit a wall");
                    } else {
                        if(grid[player.ypos - 1][player.xpos] == 2) {
                            System.out.println("You've encountered a zombie do you fight or run?");
                            /**
                             * Display Menu
                             */

                        } else {
                            grid[player.ypos][player.xpos] = 0;
                            player.moveUp();
                            grid[player.ypos] [player.xpos] = PLAYER;
                        }
                    }
                    break;


                case 4: // Move downward
                    if(player.ypos + 1 > map.getGrid()[0].length - 1) {
                        System.out.println("You hit a wall");
                    } else {
                        if(grid[player.ypos + 1][player.xpos] == 2) {
                            System.out.println("You've encountered a zombie do you fight or run?");
                            /**
                             * Display Menu
                             */

                        }
                        grid[player.ypos][player.xpos] = 0;
                        player.moveDown();
                        grid[player.ypos][player.xpos] = PLAYER;
                    }
                    break;


                case 5: // displays map
                    map.displayMap();
                    System.out.println("");
                    break;
                
                default: 
                    System.out.println("Those were not any of the selections");
            }            
            
        }
    }
}