import java.util.Scanner;
class ZombieGame {
    public static final int PLAYER = 1;
    public static final int ZOMBIE = 50;
    public static final int BULLETS = 3;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        
        // Set Grid
        Map map = new Map();
        map.setGrid(10,20);
        int[][] grid = map.getGrid();

        
        // Player
        Person player = new Person("Sacmctap", 0, 0);
       
        // Zombie Array
        Zombie [] zombieArr = new Zombie[4];
        Zombie zombie =  new Zombie(55, 30, 9, 0);
        Zombie zombie2 = new Zombie(57, 50, 2, 2);

        // Add Zombies To Array
        zombieArr[0] = zombie;
        zombieArr[1] = zombie2;


        // Set Player Position
        map.setPos(player.xpos,  player.ypos,  PLAYER);

        // Set Zombie position
        map.setPos(zombieArr[0].xpos, zombieArr[0].ypos, zombieArr[0].getId());
        map.setPos(zombieArr[1].xpos, zombieArr[1].ypos, zombieArr[1].getId());


        // Set Items
        map.setPos(3, 0, BULLETS);


        String userInput = "";
        while(player.getHp() > 0 && !userInput.equals("101")) {
            map.displayMap();

            userInput = getString("Your move (type 5 to view full options): ").toLowerCase();
            switch(userInput) {

                case "d": // Move forward
                    zombieEncounterR(player, zombieArr, grid);
                    //Zombie Moves
                    break;

                case "a": // Move left
                    zombieEncounterL(player, zombieArr, grid);
                    //Zombie Moves
                    break;

                case "w": // Move up
                    zombieEncounterU(player, zombieArr, grid);
                    //Zombie Moves
                    break;

                case "s": // Move downward
                    zombieEncounterD(player, zombieArr, grid);
                    //Zombie Moves
                    break;

                case "5": // displays user options
                    displayUserOptions();
                    //Zombie Moves
                    break;
                
                case "6": // View inventory
                    viewInventory(player);
                    break;
                
                case "101": // exit program
                    break;
                
                default: 
                    System.out.println("* Those were not any of the selections");
            }            
            
        }  
    }

    // When a user encounters a zombie moving forward
    public static void zombieEncounterR(Person player, Zombie[] zombieArr, int[][] grid) {
        // Player Moves
        if(player.xpos + 1 > grid[0].length - 1) {
            System.out.println("* You hit a wall");
        } else {

            if(grid[player.ypos][player.xpos + 1] == BULLETS) {
                System.out.println("* You've picked up a bullet");
                player.addToBullets();
                playerMovements(player, grid, "right");
            } 
            
            else if(grid[player.ypos][player.xpos + 1] >= ZOMBIE) {
                for(int i = 0; i < zombieArr.length; i++) {
                    if(zombieArr[i].getId() == grid[player.ypos][player.xpos + 1]) {
                        zombieFightOutcome(player,zombieArr[i], grid, "right");
                        break;
                    }
                }
            } 
             
            else {
                if(player.xpos + 2 < grid[0].length) {
                    if(grid[player.ypos][player.xpos + 2] >= ZOMBIE) mvmAndMsg("* You hear deep breaths", "right", grid, player);
                    else mvmAndMsg("* You take a step right", "right", grid, player);
                } else mvmAndMsg("* You take a step right", "right", grid, player);
            }
        }
    }

    // When a user encounters a zombie moving backwards        
    public static void zombieEncounterL(Person player, Zombie[] zombieArr, int[][] grid) {
        if(player.xpos - 1 < 0) {
            System.out.println("* You hit a wall");
        } else {

            if(grid[player.ypos][player.xpos - 1] == BULLETS) {
                System.out.println("* You've picked up a bullet");
                player.addToBullets();
                playerMovements(player, grid, "left");
            } 
            
            else if(grid[player.ypos][player.xpos - 1] >= ZOMBIE) {
                for(int i = 0; i < zombieArr.length; i++) {
                    if(zombieArr[i].getId() == grid[player.ypos][player.xpos - 1]) {
                        zombieFightOutcome(player,zombieArr[i], grid, "left");
                        break;
                    }
                }
            } 


            else {
                if(player.xpos - 2 > 0) {
                    if(grid[player.ypos][player.xpos - 2] > 50) mvmAndMsg("* You hear deep breaths", "left", grid, player);
                    else mvmAndMsg("* You take a step left", "left", grid, player);
                }
                else mvmAndMsg("* You take a step left", "left", grid, player);
            }

            
        }
    }


    // When a user encounters a zombie moving upwards                
    public static void zombieEncounterU(Person player, Zombie[] zombieArr, int[][] grid) {
        if(player.ypos - 1 < 0) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos - 1][player.xpos] == BULLETS) {
                System.out.println("* You've picked up a bullet");
                player.addToBullets();
                playerMovements(player, grid, "up");
            } 
            
            else if(grid[player.ypos - 1][player.xpos] >= ZOMBIE) {
                for(int i = 0; i < zombieArr.length; i++) {
                    if(zombieArr[i].getId() == grid[player.ypos - 1][player.xpos]) {
                        zombieFightOutcome(player,zombieArr[i], grid, "up");
                        break;
                    }
                }
            }  
            
            
            else {
                if(player.ypos - 2 < grid[0].length) {
                    if(grid[player.ypos - 2][player.xpos] >= ZOMBIE) mvmAndMsg("* You hear deep breaths", "up", grid, player);
                    else mvmAndMsg("* You take a step up", "up", grid, player);
                }
                else mvmAndMsg("* You take a step up", "up", grid, player);
            }
        }
    }


    // When a user encounters a zombie moving downwards                
    public static void zombieEncounterD(Person player, Zombie[] zombieArr, int[][] grid) {
        if(player.ypos + 1 > grid[0].length - 1) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos + 1][player.xpos] == BULLETS) {
                System.out.println("* You've picked up a bullet");
                player.addToBullets();
                playerMovements(player, grid, "down");
            } 
            
            else if(grid[player.ypos + 1][player.xpos] >= ZOMBIE) {
                for(int i = 0; i < zombieArr.length; i++) {
                    if(zombieArr[i].getId() == grid[player.ypos + 1][player.xpos]) {
                        zombieFightOutcome(player,zombieArr[i], grid, "down");
                        break;
                    }
                }
            }  
            
            
            else {
                if(player.ypos + 2 < grid[0].length) {
                    if(grid[player.ypos + 2][player.xpos] >= ZOMBIE) mvmAndMsg("* You hear deep breaths", "down", grid, player);
                    else mvmAndMsg("* You take a step down", "down", grid, player);
                }
                else mvmAndMsg("* You take a step down", "down", grid, player);
            }
        }
    }

  
    // Displays the selection of guns the user can use to fight the zombie
    public static void pZInteraction(Person player, Zombie zombie) {
        displayWeaponOfChoice(player.getBulletCount(), player.getKnifeCount());
        while(true) {
            int weaponChoice = getInteger("* Select weapon of choice: ");
            if(weaponChoice == 1) {
                System.out.println("* You swiftly pull out your gun and shoot in the dead of night!");
                int zmbAtk = zombie.atk();
                int userAtk = player.atkGun();
                if(zmbAtk == 0) {
                    System.out.println("The zombie missed you");
                } else {
                    System.out.println("* Zombie made a quick swipe at you!");
                    zombie.decreaseHp(userAtk);
                    System.out.println("* You suffered " + zmbAtk + " points from your hp");
                }
                player.decreaseHp(zmbAtk);
                break;
            } else if(weaponChoice == 2) {
                System.out.println("* You stabbed the zombie");
                int zmbAtk = zombie.atk();
                int userAtk = player.atkKnife();
                zombie.decreaseHp(userAtk);
                player.decreaseHp(zmbAtk);
                System.out.println("* Zombie made a quick swipe at you!");
                System.out.println("* You suffered " + zmbAtk + " points from your hp");
                break;
            } else if(weaponChoice == 3) {
                System.out.println("* You attacked with your bare bloody hands");
                int zmbAtk = zombie.atk();
                int userAtk = player.atkHands();
                zombie.decreaseHp(userAtk);
                player.decreaseHp(zmbAtk);
                System.out.println("* Zombie made a quick swipe at you!");
                System.out.println("* You suffered " + zmbAtk + " points from your hp");
                break;
            } 
        }
    }

            
    // User option to fight zombie
    public static int zombieFight(Person player, Zombie zombie) {
        System.out.println("** You've encountered a zombie do you fight or run? **");
        fighterMenu(player.getHp());
        int fightingOption = getInteger("* Choose option: ");
        
        while(player.getHp() > 0 && zombie.getHp() > 0) {
            System.out.println("Zombie hp: " + zombie.getHp());
            if(fightingOption == 1) {
                pZInteraction(player, zombie);
            } else if(fightingOption == 2) {
                return 2;
            }
            if(player.getHp() > 0 && zombie.getHp() > 0) {
                fighterMenu(player.getHp());
                fightingOption = getInteger("* Select option: ");
            } else {break;}
        }
        
        if(player.getHp() <= 0) {
            return 1;
        } else {
            return 3;
        }  
    }

    public static void zombieFightOutcome(Person player,Zombie zombie, int[][] grid, String dir) {
        int isFight = zombieFight(player, zombie);
        if(isFight == 1) {
            gameOverMsg();
            return;
        } else if(isFight == 2) {
            System.out.println("* You ran from the zombie for now but he will be back for more");                    
        } else {
            if(dir.equals("right")) playerMovements(player, grid, "right");
            else if(dir.equals("left")) playerMovements(player, grid, "left");
            else if(dir.equals("up")) playerMovements(player, grid, "up");
            else if(dir.equals("down")) playerMovements(player, grid, "down");
            eliminationMsg();
        }
    }

    // Moves player downward and erases last previous step        
    public static void playerMovements(Person player, int[][] grid, String dir) {
        grid[player.ypos][player.xpos] = 0;
        if(dir.equals("left")) player.moveLeft();
        else if(dir.equals("right")) player.moveRight();
        else if(dir.equals("up")) player.moveUp();
        else if(dir.equals("down")) player.moveDown();
        grid[player.ypos][player.xpos] = PLAYER;
    }

    public static void mvmAndMsg(String msg, String mvm, int[][] grid, Person player) {
        System.out.println(msg);
        playerMovements(player, grid, mvm);
    }

    

    // Displays msg when zombie is eliminated
    public static void eliminationMsg() {
        System.out.println("\n-----------------------");
        System.out.println("-- ZOMBIE ELIMINATED --");
        System.out.println("-----------------------");
        System.out.println("* You step over the zombies dead courpse in disgust in a sigh of relief\n");
    }


    // Msg game over
    public static void gameOverMsg() {
        System.out.println("* You have gone unconcious and feeling your flesh");
        System.out.println(" being pulled away from you piece By piece");
        System.out.println("Game Over");
    }

    // Msg to display options can choose from and their current health
    public static void fighterMenu(double hp) {
        System.out.println("                                       -------------------");
        System.out.println("                                       Current Hp: " + hp);
        System.out.println("                                       1. Fight");
        System.out.println("                                       2. Run");
        System.out.println("                                       3. Inventory");
        System.out.println("                                       -------------------");
    }
    
    // Msg to display the options 
    public static void displayUserOptions() {
        System.out.println("");
        System.out.println("                                       ----------------------------------");
        System.out.println("                                                     Options             ");
        System.out.println("                                        1. Move right                    ");
        System.out.println("                                        2. Move left                     ");
        System.out.println("                                        3. Move up                       ");
        System.out.println("                                        4. Move down                     ");
        System.out.println("                                        5. Display map                   ");
        System.out.println("                                        6. View inventory                ");
        System.out.println("                                        101. Exit                        ");
        System.out.println("                                       ----------------------------------");
    }

    // Msg to display the weapon of choices
    public static void displayWeaponOfChoice(int bulletCount, int knifeCount) {
        System.out.println("                                   ----------------------------------------- ");
        System.out.println("                                   |             WEAPON OF CHOICE           |");
        System.out.println("                                   ----------------------------------------- ");
        System.out.println("                                   |  Weapon        |   DMG    | Durability |");
        System.out.println("                                   ----------------------------------------- ");
        System.out.println("                                   | 1. Gun         |  25-50  |     " + bulletCount + "       |");
        System.out.println("                                   | 2. Rusty Knife |   5-7   |     " + knifeCount  + "       |");
        System.out.println("                                   | 3. Hands       |   2-5   | unlimited   |");
        System.out.println("                                   ----------------------------------------- ");
    }

    // MSG to view inventory
    public static void viewInventory(Person player) {
        System.out.println("----------------------------");
        System.out.println("|        Inventory         |");
        System.out.println("----------------------------");
        System.out.println("| Item         |   Amount  |");
        System.out.println("----------------------------");
        System.out.println("| Apple        |     " + player.getAppleCount() + "     |");
        System.out.println("| Steak        |     " + player.getSteakCount() + "     |");
        System.out.println("| Gun          |     " + player.getBulletCount()    + "     |");
        System.out.println("| Rusty Knife  |     " + player.getKnifeCount()      + "     |");
    }



    // Manipulated IR5 method
    public static int getInteger(String msg) {
        int userInput;
        System.out.print(msg);
        while (true) {
            try {
                userInput = Integer.parseInt(scanner.nextLine());
                break;
            } catch(Exception e) {
                System.err.println("* Number must be an integer. Try again. ");
            }
        }
        return userInput;
    }

    public static String getString(String msg) {
        String answer = "";
        System.out.print(msg);
        try {
           answer = scanner.nextLine(); 
        }
        catch (Exception e) {
           System.err.println("Error reading input from user. Ending program.");
           System.exit(-1);
        } 
        
        while (answer.replace(" ", "").equals("")) {
           System.err.println("Error: Missing input.");
           try {
              System.out.println(msg);
              answer = scanner.nextLine(); 
           }
           catch (Exception e) {
              System.err.println("Error reading input from user. Ending program.");
              System.exit(-1);
           } 
        }
        return answer;            
     }

}