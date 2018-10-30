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
        Zombie zombie2 = new Zombie(50, 2, 2);
        map.setGrid(10);

        int[][] grid = map.getGrid();
        map.setPos(player.xpos, player.ypos, PLAYER);
        map.setPos(zombie.xpos, zombie.ypos, ZOMBIE);
        map.setPos(zombie2.xpos, zombie2.ypos, ZOMBIE);
        map.setPos(3, 0, BULLETS);

        int userInput = 0;
        while(player.getUserHp() > 0 && userInput != 101) {
            map.displayMap();
            

            userInput = getInteger("Your move(type 5 to view full options): ");
            switch(userInput) {

                case 1: // Move forward
                    zombieEncounterF(player, zombie, grid);
                    //Zombie Moves
                    break;

                case 2: // Move left
                    zombieEncounterB(player, zombie, grid);
                    break;

                case 3: // Move up
                    zombieEncounterU(player, zombie, grid);
                    break;

                case 4: // Move downward
                    zombieEncounterD(player, zombie, grid);
                    break;

                case 5: // displays user options
                    displayUserOptions();
                    break;
                
                case 101: // exit program
                    break;
                
                default: 
                    System.out.println("* Those were not any of the selections");
            }            
            
        }  
    }

    // When a user encounters a zombie moving forward
     public static void zombieEncounterF(Person player, Zombie zombie, int[][] grid) {
            // Player Moves
            if(player.xpos + 1 > grid[0].length - 1) {
                System.out.println("* You hit a wall");
            } else {
                if(grid[player.ypos][player.xpos + 1] == BULLETS) {
                    System.out.println("* You've picked up a bullet");
                    player.addToBullets();
                    playerMoveForward(player, grid);
                } else if(grid[player.ypos][player.xpos + 1] == ZOMBIE) {
                    int isFight = zombieFight(player, zombie);
                    if(isFight == 1) {
                        gameOverMsg();
                        return;
                    } else if(isFight == 2) {
                        System.out.println("* You ran from the zombie for now but he will be back for more");                    
                    } else {
                        playerMoveForward(player, grid);
                        eliminationMsg();
                    }

                } else {
                    if(player.xpos + 2 < grid[0].length) {
                        if(grid[player.ypos][player.xpos + 2] == ZOMBIE) {
                            System.out.println("* You hear a deep breaths");
                            playerMoveForward(player, grid);
                        } else {
                            System.out.println("* You take a step forward");                        
                            playerMoveForward(player, grid);
                        }
                    } else {
                        System.out.println("* You take a step forward");
                        playerMoveForward(player, grid);
                    }
                }
            }
        }


    // When a user encounters a zombie moving backwards        
    public static void zombieEncounterB(Person player, Zombie zombie, int[][] grid) {
        if(player.xpos - 1 < 0) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos][player.xpos - 1] == BULLETS) {
                System.out.println("* You've picked up a bullet");
                player.addToBullets();
                playerMoveBackward(player, grid);
            } else if(grid[player.ypos][player.xpos - 1] == ZOMBIE) {
                int isFight = zombieFight(player, zombie);
                if(isFight == 1) {
                    gameOverMsg();
                    return;
                } else if(isFight == 2) {
                    System.out.println("* You ran from the zombie for now but he will be back for more");                    
                } else {
                    playerMoveBackward(player, grid);
                    eliminationMsg();
                }

            } else {
                if(player.xpos - 2 > 0) {
                    if(grid[player.ypos][player.xpos - 2] == ZOMBIE) {
                        System.out.println("* You hear a deep breaths");
                        playerMoveBackward(player, grid);

                    } else {
                        System.out.println("* You take a step back");
                        playerMoveBackward(player, grid);

                    }
                } else {
                    System.out.println("* You take a step back");
                    playerMoveBackward(player, grid);
                }
            }
        }
    }

        // When a user encounters a zombie moving upwards                
    public static void zombieEncounterU(Person player, Zombie zombie, int[][] grid) {
        if(player.ypos - 1 < 0) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos - 1][player.xpos] == BULLETS) {
                System.out.println("* You've picked up a bullet");
                player.addToBullets();
                playerMoveUpward(player, grid);
            } else if(grid[player.ypos - 1][player.xpos] == ZOMBIE) {
                int isFight = zombieFight(player, zombie);
                if(isFight == 1) {
                    gameOverMsg();
                    return;
                } else if(isFight == 2) {
                    System.out.println("* You ran from the zombie for now but he will be back for more");                    
                } else {
                    playerMoveUpward(player, grid);
                    eliminationMsg();
                }

            } else {
                if(player.ypos - 2 > 0) {
                    if(grid[player.ypos - 2][player.xpos] == ZOMBIE) {
                        System.out.println("* You hear a deep breaths");
                        playerMoveUpward(player, grid);

                    } else {
                        System.out.println("* You take a step up");
                        playerMoveUpward(player, grid);

                    }
                } else {
                    System.out.println("* You take a step up");
                    playerMoveUpward(player, grid);
                }
            }
        }
    }

    // When a user encounters a zombie moving downwards                
    public static void zombieEncounterD(Person player, Zombie zombie, int[][] grid) {
        if(player.ypos + 1 > grid[0].length - 1) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos + 1][player.xpos] == BULLETS) {
                System.out.println("* You've picked up a bullet");
                player.addToBullets();
                playerMoveDownward(player, grid);
            } else if(grid[player.ypos + 1][player.xpos] == ZOMBIE) {
                int isFight = zombieFight(player, zombie);
                if(isFight == 1) {
                    System.out.println("* You have gone unconcious and feeling your flesh");
                    System.out.println(" being pulled away from you piece By piece");
                    System.out.println("Game Over");
                    return;
                } else if(isFight == 2) {
                    System.out.println("* You ran from the zombie for now but he will be back for more");                    
                } else {
                    playerMoveDownward(player, grid);
                    eliminationMsg();
                }

            } else {
                if(player.ypos + 2 < grid[0].length) {
                    if(grid[player.ypos + 2][player.xpos] == ZOMBIE) {
                        System.out.println("* You hear a deep breaths");
                        playerMoveDownward(player, grid);

                    } else {
                        System.out.println("* You take a step down");
                        playerMoveDownward(player, grid);

                    }
                } else {
                    System.out.println("* You take a step down");
                    playerMoveDownward(player, grid);
                }
            }
        }
    }


        
        
        // Displays the selection of guns the user can use to fight the zombie
    public static void weaponary(Person player, Zombie zombie) {
        displayWeaponOfChoice();
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
        fighterMenu(player.getUserHp());
        int fightingOption = getInteger("* Choose option: ");
        
        while(player.getUserHp() > 0 && zombie.getHp() > 0) {
            System.out.println("Zombie hp: " + zombie.getHp());
            if(fightingOption == 1) {
                weaponary(player, zombie);
            } else if(fightingOption == 2) {
                return 2;
            }
            if(player.getUserHp() > 0 && zombie.getHp() > 0) {
                fighterMenu(player.getUserHp());
                fightingOption = getInteger("* Select option: ");
            } else {break;}
        }
        
        if(player.getUserHp() <= 0) {
            return 1;
        } else {
            return 3;
        }  
    }
        
        
    // Moves player forward and erases last previous step
    public static void playerMoveForward(Person player, int[][] grid) {
        grid[player.ypos][player.xpos] = 0;
        player.moveForward();
        grid[player.ypos][player.xpos] = PLAYER;
    }
    
    // Moves player backward and erases last previous step        
    public static void playerMoveBackward(Person player, int[][] grid) {
        grid[player.ypos][player.xpos] = 0;
        player.moveLeft();
        grid[player.ypos][player.xpos] = PLAYER;
    }
    
    // Moves player upward and erases last previous step        
    public static void playerMoveUpward(Person player, int[][] grid) {
        grid[player.ypos][player.xpos] = 0;
        player.moveUp();
        grid[player.ypos][player.xpos] = PLAYER;
    }
    
    // Moves player downward and erases last previous step        
    public static void playerMoveDownward(Person player, int[][] grid) {
        grid[player.ypos][player.xpos] = 0;
        player.moveDown();
        grid[player.ypos][player.xpos] = PLAYER;
    }
    
    
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
        System.out.println("                                        1. Move forward                  ");
        System.out.println("                                        2. Move backward                 ");
        System.out.println("                                        3. Move upward                   ");
        System.out.println("                                        4. Move downward                 ");
        System.out.println("                                        5. Display map                   ");
        System.out.println("                                        6. View inventory                ");
        System.out.println("                                        101. Exit                        ");
        System.out.println("                                       ----------------------------------");
    }

    // Msg to display the weapon of choices
    public static void displayWeaponOfChoice() {
        System.out.println("                                   -----------------------------------------   ");
        System.out.println("                                   |             WEAPON OF CHOICE           |  ");
        System.out.println("                                   -----------------------------------------   ");
        System.out.println("                                   |  Weapon        |   DMG    | Durability |  ");
        System.out.println("                                   -----------------------------------------   ");
        System.out.println("                                   | 1. Gun         |  25-50  |     1       |  ");
        System.out.println("                                   | 2. Rusty Knife |   5-7   |     3       |  ");
        System.out.println("                                   | 3. Hands       |   2-5   | unlimited   |  ");
        System.out.println("                                   -----------------------------------------   ");
    }
}