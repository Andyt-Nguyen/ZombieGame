import java.util.Scanner;

public class ZombieEncounters {
    private static Scanner scanner = new Scanner(System.in);
    private int PLAYER;
    private int ZOMBIE;
    private int BULLETS;
    private int KEY;
    private int WALL;
    private int DOOR;
    private int BARRICADE;
    private int STEAK;
    private int APPLE;
    private int SPECIAL_KEY;
    private int[][] grid;
    private Zombie[] zombieArr;
    private NPC[] npcArr;
    private Person player;
    private int FINAL_DOOR;

    public ZombieEncounters(int PLAYER, int ZOMBIE, int BULLETS, int SPECIAL_KEY, int KEY, int APPLE, int STEAK, int WALL, int DOOR, int BARRICADE, int FINAL_DOOR, int[][] grid, Zombie[] zombieArr, NPC[] npcArr,Person player) {
        this.PLAYER  = PLAYER;
        this.ZOMBIE  = ZOMBIE;
        this.BULLETS = BULLETS;
        this.STEAK   = STEAK;
        this.APPLE   = APPLE;
        this.SPECIAL_KEY = SPECIAL_KEY;
        this.KEY     = KEY;
        this.WALL    = WALL;
        this.BARRICADE = BARRICADE;
        this.DOOR    = DOOR;
        this.grid    = grid;
        this.zombieArr = zombieArr;
        this.npcArr = npcArr;
        this.player = player;
        this.FINAL_DOOR = FINAL_DOOR;
    }

    // When a user encounters a zombie moving backwards        
    public void moveLeft() {
        if(player.xpos - 1 < 0) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos][player.xpos - 1] != WALL) {
                if(grid[player.ypos][player.xpos - 1] == BULLETS) foundBullet("left");
                else if(grid[player.ypos][player.xpos - 1] == KEY) foundKey(grid, "left");
                else if(grid[player.ypos][player.xpos - 1] == STEAK) foundSteak("left");
                else if(grid[player.ypos][player.xpos - 1] == APPLE)  foundApple("left");
                else if(grid[player.ypos][player.xpos - 1] == SPECIAL_KEY) foundSpecialKey("left");
                else if(grid[player.ypos][player.xpos - 1] == DOOR) {
                    if(player.getKeyCount() < 1) System.out.println("* You have stumbled upon a closed door \n  You try to open it but it is locked.");
                    else unlockDoor(grid, "left");
                }


                else if(grid[player.ypos][player.xpos -1] == FINAL_DOOR) {
                    unlockFinalDoor();
                }

                else if(grid[player.ypos][player.xpos - 1] >= 30 && grid[player.ypos][player.xpos - 1] <= 40) {
                    for(int i = 0; i < npcArr.length; i++) {
                        if(npcArr[i].getId() == grid[player.ypos][player.xpos - 1]) {
                            pNInteraction(npcArr[i]);
                            break;
                        }
                    }
                }  
                
                else if(grid[player.ypos][player.xpos - 1] >= ZOMBIE) {
                    for(int i = 0; i < zombieArr.length; i++) {
                        if(zombieArr[i].getId() == grid[player.ypos][player.xpos - 1]) {
                            zombieFightOutcome(zombieArr[i], "left");
                            break;
                        }
                    }
                } 
                
                else {
                    if(player.xpos - 2 > 0) {
                        if(grid[player.ypos][player.xpos - 2] > 50) mvmAndMsg("* You hear deep breaths", "left");
                        else mvmAndMsg("* You take a step west", "left");
                    }
                    else mvmAndMsg("* You take a step left", "left");
                }
            } else {
                System.out.println("* You hit a wall");
            }
        }
    }
    
    
    // When a user encounters a zombie moving forward
    public void moveRight() {
        // Player Moves
        if(player.xpos + 1 > grid[0].length - 1) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos][player.xpos + 1] != WALL) {
                if(grid[player.ypos][player.xpos + 1]      == BULLETS) foundBullet("right");
                else if(grid[player.ypos][player.xpos + 1] == KEY) foundKey(grid, "right");
                else if(grid[player.ypos][player.xpos + 1] == STEAK) foundSteak("right");
                else if(grid[player.ypos][player.xpos + 1] == APPLE) foundApple("right");
                else if(grid[player.ypos][player.xpos + 1] == SPECIAL_KEY) foundSpecialKey("right");
                else if(grid[player.ypos][player.xpos + 1] == DOOR) {
                    if(player.getKeyCount() < 1) System.out.println("* You have stumbled upon a door \n  You try to open it but it is locked.");
                    else unlockDoor(grid, "right");
                }

                else if(grid[player.ypos][player.xpos + 1] == FINAL_DOOR) {
                    unlockFinalDoor();
                }

                else if(grid[player.ypos][player.xpos + 1] >= 30 && grid[player.ypos][player.xpos + 1] <= 40) { // interaction with npc
                    for(int i = 0; i < npcArr.length; i++) {
                        if(npcArr[i].getId() == grid[player.ypos][player.xpos + 1]) {
                            pNInteraction(npcArr[i]);
                            break;
                        }
                    }
                }                
                
                else if(grid[player.ypos][player.xpos + 1] >= ZOMBIE) {
                    for(int i = 0; i < zombieArr.length; i++) {
                        if(zombieArr[i].getId() == grid[player.ypos][player.xpos + 1]) { // interaction with zombie
                            zombieFightOutcome(zombieArr[i], "right");
                            break;
                        }
                    }
                } 
                    
                else {
                    if(player.xpos + 2 < grid[0].length) {
                        if(grid[player.ypos][player.xpos + 2] >= ZOMBIE) mvmAndMsg("* You hear deep breaths", "right");
                        else mvmAndMsg("* You take a step right", "right");
                    } else mvmAndMsg("* You take a step right", "right");
                }
            } else {
                System.out.println("* You hit a wall");
            }
        }
    }

    // When a user encounters a zombie moving upwards                
    public void moveUp() {
        if(player.ypos - 1 < 0) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos - 1][player.xpos] != WALL) {
                if(grid[player.ypos - 1][player.xpos]      == BULLETS) foundBullet("up");
                else if(grid[player.ypos - 1][player.xpos] == KEY) foundKey(grid, "up");
                else if(grid[player.ypos - 1][player.xpos] == STEAK) foundSteak("up");
                else if(grid[player.ypos - 1][player.xpos] == APPLE) foundApple("up");
                else if(grid[player.ypos - 1][player.xpos] == SPECIAL_KEY) foundSpecialKey("up");
                else if(grid[player.ypos - 1][player.xpos] == DOOR) {
                    if(player.getKeyCount() < 1) System.out.println("* You have stumbled upon a door \n  You try to open it but it is locked.");
                    else unlockDoor(grid, "up");   
                } 

                else if(grid[player.ypos - 1][player.xpos] == FINAL_DOOR) {
                    unlockFinalDoor();
                }

                else if(grid[player.ypos - 1][player.xpos] == SPECIAL_KEY) {
                    System.out.println("You found the Special key");
                    player.addSpecialKey();
                    mvmAndMsg("You found the special key!", "left");
                }

                else if(grid[player.ypos - 1][player.xpos] >= 30 && grid[player.ypos - 1][player.xpos] <= 40) { //interaction with npc
                    for(int i = 0; i < npcArr.length; i++) {
                        if(npcArr[i].getId() == grid[player.ypos - 1][player.xpos]) {
                            pNInteraction(npcArr[i]);
                            break;
                        }
                    }
                } 
                
                else if(grid[player.ypos - 1][player.xpos] >= ZOMBIE) { // interaction with zombie
                    for(int i = 0; i < zombieArr.length; i++) {
                        if(zombieArr[i].getId() == grid[player.ypos - 1][player.xpos]) {
                            zombieFightOutcome(zombieArr[i], "up");
                            break;
                        }
                    }
                }  
                
                else {
                    if(player.ypos - 2 > 0) {
                        if(grid[player.ypos - 2][player.xpos] >= ZOMBIE) mvmAndMsg("* You hear deep breaths", "up");
                        else mvmAndMsg("* You take a step up", "up");
                    }
                    else mvmAndMsg("* You take a step up", "up");
                }
            } else {
                System.out.println("* You hit a wall");
            }
        }
    }


    // When a user encounters a zombie moving downwards                
    public void moveDown() {
        if(player.ypos + 1 > grid.length - 1) {
            System.out.println("* You hit a wall");
        } else {
            if(grid[player.ypos + 1][player.xpos] != WALL) {
                if(grid[player.ypos + 1][player.xpos]     == BULLETS) foundBullet("down");
                else if(grid[player.ypos + 1][player.xpos] == STEAK) foundSteak("down");
                else if(grid[player.ypos + 1][player.xpos] == APPLE) foundApple("down");
                else if(grid[player.ypos + 1][player.xpos] == KEY) foundKey(grid, "down");
                else if(grid[player.ypos + 1][player.xpos] == SPECIAL_KEY) foundSpecialKey("down");
                else if(grid[player.ypos + 1][player.xpos] == DOOR) {
                    if(player.getKeyCount() < 1) System.out.println("\n* You have stumbled upon a door \n  You try to open it but it is locked.\n");
                    else unlockDoor(grid, "down");
                } 

                else if(grid[player.ypos + 1][player.xpos] == FINAL_DOOR) {
                    unlockFinalDoor();
                }

                else if(grid[player.ypos + 1][player.xpos] == SPECIAL_KEY) {
                    System.out.println("You found the Special key");
                    player.addSpecialKey();
                    mvmAndMsg("You found the special key!", "left");
                }

                else if(grid[player.ypos + 1][player.xpos] >= 30 && grid[player.ypos + 1][player.xpos] <= 40) { // interaction with npc
                    for(int i = 0; i < npcArr.length; i++) {
                        if(npcArr[i].getId() == grid[player.ypos + 1][player.xpos]) {
                            pNInteraction(npcArr[i]);
                            break;
                        }
                    }
                } 
                
                else if(grid[player.ypos + 1][player.xpos] >= ZOMBIE) { // interaction with zombie
                    for(int i = 0; i < zombieArr.length; i++) {
                        if(zombieArr[i].getId() == grid[player.ypos + 1][player.xpos]) {
                            zombieFightOutcome(zombieArr[i], "down");
                            break;
                        }
                    }
                }  
                
                else {
                    if(player.ypos + 2 < grid.length -1) {
                        if(grid[player.ypos + 2][player.xpos] >= ZOMBIE) mvmAndMsg("* You hear deep breaths", "down");
                        else mvmAndMsg("* You take a step down", "down");
                    }
                    else mvmAndMsg("* You take a step down", "down");
                }
            } else {
                System.out.println("* You hit a wall");
            }
        }
    }

    
    // Displays the selection of guns the user can use to fight the zombie
    private void pZInteraction(Zombie zombie) {
        displayWeaponOfChoice(player.getBulletCount(), player.getKnifeCount());
        while(true) {
            int weaponChoice = getInteger("* Select weapon of choice: ");
            if(weaponChoice == 1) {
                if(player.getBulletCount() > 0) {
                    System.out.println("\n* You swiftly pull out your gun and shoot in the dead of night!");
                    int zmbAtk = zombie.atk();
                    int userAtk = player.atkGun();
                    if(zmbAtk == 0) System.out.println("The zombie missed you");
                    displayHitMsg(userAtk, zmbAtk);
                    zombie.decreaseHp(userAtk);
                    player.decreaseHp(zmbAtk);
                    break;
                } else System.out.println("- You have no bullets");

            } else if(weaponChoice == 2) {
                if(player.getKnifeCount() > 0) {
                    System.out.println("\n* You stabbed the zombie");
                    int zmbAtk = zombie.atk();
                    int userAtk = player.atkKnife();
                    if(zmbAtk == 0) System.out.println("The zombie missed!");
                    zombie.decreaseHp(userAtk);
                    player.decreaseHp(zmbAtk);
                    displayHitMsg(userAtk, zmbAtk);
                    break;
                } else System.out.println("- You knife is too weak to cause any damage");
                
            } else if(weaponChoice == 3) {
                System.out.println("\n* You attacked with your bare bloody hands");
                int zmbAtk = zombie.atk();
                int userAtk = player.atkHands();
                if(zmbAtk == 0) System.out.println("The zombie missed!");
                zombie.decreaseHp(userAtk);
                player.decreaseHp(zmbAtk);
                displayHitMsg(userAtk, zmbAtk);
                break;
            } 
        }
    }

    private void pNInteraction(NPC npc) {
        if(player.getSpecialKey() > 0) {
            System.out.println("\n--------------------------------------------");
            System.out.println("* " + npc.getName() + " speaking: ");
            System.out.println("- " + npc.getName());
            System.out.println("- You found the special key! Let's get the heck out of here!");
            System.out.println("----------------------------------------------");
        }

        else {
            System.out.println("\n--------------------------------------------");
            System.out.println("* " + npc.getName() + " speaking: ");
            System.out.println("- Hello my good person my name is " + npc.getName());
            System.out.println("----------------------------------------------");
    
            // Looping through the npcs questions that are being asked
            int userAnswer = -100;
            while(userAnswer != -1) {
                System.out.println("\n--------------------------------------------");
                System.out.println("*  Question " + npc.getName());
                String[] q = npc.getQ();

                // Looping through the npcs questions that are being asked
                System.out.println("----------------------------------------------");
                for(int j = 0; j < q.length; j++) {
                    System.out.println("* " + (j + 1) + ". " + q[j]);
                }
                
                // Finds what the user typed to find the given answer
                while(true) {
                    userAnswer = getInteger("Choose question (type -1 to leave): ");
                    if(userAnswer < q.length + 1 && userAnswer > 0) {
                    System.out.println("\n----------------------------------------------");
                    System.out.println("*  " + npc.getName() + " speaking:");
                    System.out.println("----------------------------------------------");
                    String answer = npc.getA()[userAnswer - 1];
                    String[] parseAnswer = answer.split("");
                    System.out.print("-  ");
                    for(int i = 0; i < parseAnswer.length; i++) {
                        if(parseAnswer[i].equals(".")) {
                            parseAnswer[i] = ".\n- ";
                            }
                        }
                        answer = String.join("", parseAnswer);
                        System.out.println(answer);
                        System.out.println("----------------------------------------------");
                    break;

                    } else if(userAnswer == -1) break;
                    else {
                        System.out.println("Those were not one of the options. Try again.");
                    }
                }
            }
        }
        
    }

            
    // User option to fight zombie
    private int zombieFight(Zombie zombie) {
        System.out.println("** You've encountered a zombie do you fight or run? **");
        fighterMenu(player.getHp(), zombie.getHp());
        int fightingOption = getInteger("* Choose option: ");
        
        while(player.getHp() > 0 && zombie.getHp() > 0) {
            if(fightingOption == 1) {
                pZInteraction(zombie);
            } else if(fightingOption == 2) {
                return 2;
            } else if(fightingOption == 3) {
                viewInventory();
            }
            if(player.getHp() > 0 && zombie.getHp() > 0) {
                fighterMenu(player.getHp(), zombie.getHp());
                fightingOption = getInteger("* Select option: ");
            } else {break;}
        }
        
        if(player.getHp() <= 0) return 1;
        else return 3;
    }

    // When player encounters the enemy they have three outcomes. Death, run, win.
    private void zombieFightOutcome(Zombie zombie, String dir) {
        int isFight = zombieFight(zombie);
        if(isFight == 1) {
            gameOverMsg();
            return;
        } else if(isFight == 2) {
            System.out.println("* You ran from the zombie for now but he will be back for more");                    
        } else {
            if(dir.equals("right")) playerMovements("right");
            else if(dir.equals("left")) playerMovements("left");
            else if(dir.equals("up")) playerMovements("up");
            else if(dir.equals("down")) playerMovements("down");

            if(zombie.getItem() != 0) {
                if(zombie.getItem() == KEY) {
                    System.out.println("- You find something shiny inside the zombie");
                    System.out.println("- You found a key!");
                    player.addToKey();
                } else if(zombie.getItem() == BULLETS) {
                    System.out.println("- You find something shiny inside the zombie");
                    System.out.println("- You found a bullet!");
                    player.addToBullets();
                } else if(zombie.getItem() == SPECIAL_KEY) {
                    System.out.println("- You find something really shiny coming out of the beast");
                    System.out.println("- Oh crap! Its an apple!!");
                    System.out.println("- Jk");
                    System.out.println("- Its a special key");
                }
            }
            eliminationMsg();
        }
    }

    // Moves player downward and erases last previous step        
    private void playerMovements(String dir) {
        grid[player.ypos][player.xpos] = 0;
        if(dir.equals("left")) player.moveLeft();
        else if(dir.equals("right")) player.moveRight();
        else if(dir.equals("up")) player.moveUp();
        else if(dir.equals("down")) player.moveDown();
        grid[player.ypos][player.xpos] = PLAYER;
    }

    // Player movements and message
    private void mvmAndMsg(String msg, String mvm) {
        System.out.println("\nRECEPTION ROOM");
        System.out.println(msg);
        playerMovements(mvm);
        System.out.println("");
    }

    private void foundBullet(String mvm) {
        String userInput = IR5.getString("* You have stumbled upon what appears to be shell with gun powder covered all over it");
        if(userInput.equals("Pick up bullet")) {
            System.out.println("* You've picked up a bullet");
            player.addToBullets();
            playerMovements(mvm);
        } else {
            System.out.println("You have left the bullet");
        }
    }

    private void foundKey(int[][] grid, String mvm) {
        System.out.println("* You've picked up a key");
        player.addToKey();
        playerMovements(mvm);
    }
    
    private void foundSteak(String mvm) {
        player.addSteakCount();
        System.out.println("* You found a piece of steak!");
        System.out.println("* Steak added to inventory");
        playerMovements(mvm);
    }

    private void foundApple(String mvm) {
        player.addAppleCount();
        System.out.println("* You found an apple!");
        System.out.println("* Apple added to inventory");
        playerMovements(mvm);
    }

    private void foundSpecialKey(String mvm) {
        player.addSpecialKey();
        System.out.println("* You found the specail key!");
        playerMovements(mvm);
    }

    private void unlockDoor(int[][] grid, String mvm) {
        String userInput = IR5.getString("");
        if(userInput.equals("unlock door")) {
            System.out.println("* You have unlocked the door");
            player.removeKey();
            playerMovements(mvm);
        } else {
            System.out.println("You step away from the door");
        }
    }

    private void unlockFinalDoor() {
        if(player.getSpecialKey() > 0) {
            mvmAndMsg("- You did it you escaped from the hospital!", "left");
        } else {
            System.out.println("You dont have the right key to unlock this door");
        }
    }

    

    

    // Displays msg when zombie is eliminated
    private void eliminationMsg() {
        System.out.println("\n-----------------------");
        System.out.println("-- ZOMBIE ELIMINATED --");
        System.out.println("-----------------------");
        System.out.println("* You step over the zombies dead courpse in disgust in a sigh of relief\n");
    }


    // Msg game over
    private void gameOverMsg() {
        System.out.println("* You have gone unconcious and feeling your flesh");
        System.out.println("  being pulled away from you piece By piece");
        System.out.println("  Game Over");
    }

    // Msg to display options can choose from and their current health
    private static void fighterMenu(double hp, double zombieHp) {
        System.out.println("                                       -------------------");
        System.out.println("                                       Current Hp: " + hp);
        System.out.println("                                       Zombie  Hp: " + zombieHp);
        System.out.println("                                       1. Fight");
        System.out.println("                                       2. Run");
        System.out.println("                                       3. Inventory");
        System.out.println("                                       -------------------");
    }
    
    // Msg to display the options 
    public void displayUserOptions() {
        System.out.println("");
        System.out.println("                                       ----------------------------------");
        System.out.println("                                                     Options             ");
        System.out.println("                                        move north  - Move up                       ");
        System.out.println("                                        move west   - Move left                     ");
        System.out.println("                                        move south  - Move down                     ");
        System.out.println("                                        move east   - Move right                    ");
        System.out.println("                                        inventory   - View inventory                ");
        System.out.println("                                        exit        - Exit                        ");
        System.out.println("                                       ----------------------------------");
    }

    // Msg to display the weapon of choices
    private static void displayWeaponOfChoice(int bulletCount, int knifeCount) {
        System.out.println("                                   ----------------------------------------- ");
        System.out.println("                                   |             WEAPON OF CHOICE           |");
        System.out.println("                                   ----------------------------------------- ");
        System.out.println("                                   |  Weapon        |   DMG    | Durability |");
        System.out.println("                                   ----------------------------------------- ");
        System.out.println("                                   | 1. Gun         |  25-50  |     "  + bulletCount + "       |");
        System.out.println("                                   | 2. Rusty Knife |   7-15  |     " + knifeCount  + "       |");
        System.out.println("                                   | 3. Hands       |   0-5   | unlimited   |");
        System.out.println("                                   ----------------------------------------- ");
    }

    // MSG to view inventory
    public void viewInventory() {
        String userInput = "";
        while(!userInput.equals("exit")) {                              
            System.out.println("                                       ----------------------------");
            System.out.println("                                       |        Inventory         |");
            System.out.println("                                       ----------------------------");
            System.out.println("                                       | Item         |   Amount  |");
            System.out.println("                                       ----------------------------");
            System.out.println("                                       | ea. Apple    |     " + player.getAppleCount() + "     |");
            System.out.println("                                       | es. Steak    |     " + player.getSteakCount() + "     |");
            System.out.println("                                       | Bullets      |     " + player.getBulletCount()    + "     |");
            System.out.println("                                       | Rusty Knife  |     " + player.getKnifeCount()      + "     |");
            System.out.println("                                       | Keys         |     " + player.getKeyCount()      + "     |");
            System.out.println("                                       ----------------------------");
            System.out.println("                                               HP: " + player.getHp());
            System.out.println("                                       ----------------------------");
            userInput = getString("Choose option (type exit to leave inventory): ");
            if(userInput.equals("ea")) {
                if(player.getAppleCount() > 0) {
                    player.eatApple();
                    if(player.getHp() > 100) player.setHp(100);    
                    System.out.println("You have eaten an apple");
                    System.out.println("Hp is healed by 5pts");
                } else {
                    System.out.println("You no apples to eat.");
                }

            } else if(userInput.equals("es")) {
                if(player.getSteakCount() > 0) {
                    player.eatSteak();
                    if(player.getHp() > 100) player.setHp(100);
                    System.out.println("You have eaten a big ol steak");
                    System.out.println("Hp is healed by 20pts");
                } else {
                    System.out.println("You have no steaks to eat.");
                }
            }
        }
    }

    public void displayHitMsg(int userAtk, int zmbAtk) {
        System.out.println("* Zombie made a quick swipe at you!");
        System.out.println("* You damaged the zombie by " + userAtk + " points" );
        System.out.println("* You suffered " + zmbAtk + " points from your hp");
    }



    // Manipulated IR5 method
    private static int getInteger(String msg) {
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


    public static boolean getYorN(String msg) {
        String answer = getString(msg);
        
        while (answer.compareToIgnoreCase("y")   != 0 &&
               answer.compareToIgnoreCase("yes") != 0 &&
               answer.compareToIgnoreCase("n")   != 0 &&
               answer.compareToIgnoreCase("no")  != 0) {
           
           if (answer.replace(" ", "").equals("")) {
              System.err.println("Error: Missing y/n input.");
           } else {
              if (answer.compareToIgnoreCase("y")   != 0 &&
                  answer.compareToIgnoreCase("yes") != 0 &&
                  answer.compareToIgnoreCase("n")   != 0 &&
                  answer.compareToIgnoreCase("no")  != 0) {
                 System.err.println("Error: Unexpected input.");
              }
           }
           answer = getString(msg);
        } 
        
        if  (answer.compareToIgnoreCase("y")   == 0  || 
             answer.compareToIgnoreCase("yes") == 0) {
           return true;
        } 
        else {
           return false;
        }
     }
     
}
