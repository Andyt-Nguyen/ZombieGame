import java.util.Scanner;
class ZombieGame {
    public static final int PLAYER = 1;
    public static final int ZOMBIE = 2;
    public static final int BULLETS = 3;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        Map map = new Map();
        Person player = new Person("Sacmctap", 0, 0);
        Zombie zombie = new Zombie(30, 9, 0);
        map.setGrid(10);

        int[][] grid = map.getGrid();
        map.setPos(player.xpos, player.ypos, PLAYER);
        map.setPos(zombie.xpos, zombie.ypos, ZOMBIE);
        map.setPos(3, 0, BULLETS);

        int userInput = 0;
        while(player.getUserHp() > 0 && userInput != 101) {
            System.out.println("");
            System.out.println("                                       **********************************");
            System.out.println("                                       *             Options            *");
            System.out.println("                                       * 1. Move forward                *");
            System.out.println("                                       * 2. Move backward               *");
            System.out.println("                                       * 3. Move upward                 *");
            System.out.println("                                       * 4. Move downward               *");
            System.out.println("                                       * 5. Display map                 *");
            System.out.println("                                       * 6. View inventory              *");
            System.out.println("                                       * 101. Exit                      *");
            System.out.println("                                       **********************************");
            

            userInput = getInteger("Select option: ");
            switch(userInput) {

                case 1: // Move forward
                    if(player.xpos + 1 > map.getGrid()[0].length -1) {
                        System.out.println("You hit a wall");
                    } else {

                        if(grid[player.ypos][player.xpos + 1] == BULLETS) {
                            System.out.println("You've picked up a bullet");
                            player.addToBullets();
                            grid[player.ypos][player.xpos] = 0;
                            player.moveForward();
                            grid[player.ypos][player.xpos] = PLAYER;
                        }

                        if(grid[player.ypos][player.xpos + 1] == ZOMBIE) {
                            System.out.println("You've encountered a zombie do you fight or run?");
                            /**
                             * Display Menu
                             */

                        } else if(grid[player.ypos][player.xpos + 2] == ZOMBIE) {
                            System.out.println("You hear deep heavy breaths");
                            grid[player.ypos][player.xpos] = 0;
                            player.moveForward();
                            grid[player.ypos][player.xpos] = PLAYER;

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
                        if(grid[player.ypos][player.xpos - 1] == ZOMBIE) {
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
                        if(grid[player.ypos - 1][player.xpos] == ZOMBIE) {
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
                        if(grid[player.ypos + 1][player.xpos] == ZOMBIE) {
                            System.out.println("You've encountered a zombie do you fight or run?");
                            /**
                             * Display Menu
                             */

                        } else {
                            grid[player.ypos][player.xpos] = 0;
                            player.moveDown();
                            grid[player.ypos][player.xpos] = PLAYER;
                        }
                    }
                    break;


                case 5: // displays map
                    map.displayMap();
                    break;
                
                case 101: // exit program
                    break;
                
                default: 
                    System.out.println("Those were not any of the selections");
            }            
            
        }  
    }

    public static int getInteger(String msg) {
        int userInput;
        System.out.print(msg);
        while (true) {
           try {
              userInput = Integer.parseInt(scanner.nextLine());
              break;
           } catch(Exception e) {
              System.err.println("Number must be an integer. Try again. ");
           }
        }
        return userInput;
     }
}