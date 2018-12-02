import java.util.*;
import java.io.*;

class ZombieGame {
    public final static int PLAYER = 1;
    public final static int KITCHEN = 10;
    public final static int BEDROOM = 20;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        /**
         * The objects inside room constructors here for reference
         * Bed(boolean isSheets, int knife, int food, String note)
         * Closet(boolean isOpen, int knife, int food)
         * Vault(boolean isOpen, int knife, int food, String note)
         * Fridge(boolean isOpen, int knife, int food)
         */

         /**
          * The Room constructor here for reference
          * Kitchen(int id, Fridge fridge, Closet closet)
          * Bedroom(int id, boolean isDoor, Bed bed, Closet closet, Vault vault) 
          */

        Map map = new Map();
        Closet kC1 = new Closet(false, 1,1);
        Fridge kF1 = new Fridge(false, 1, 1);
        Kitchen k1 = new Kitchen(1 + KITCHEN, kF1, kC1);

        Vault b1Vault = new Vault(false, 1, 1, "1");
        Closet b2Closet = new Closet(false, 1,1);
        
        Bed b2Bed = new Bed(false, 1, 1,"You need to get of here now! I know you don't know me" +
        "\nbut you are trapped in this place... Once you get out here there is room 5 steps south and 3 steps east " +
        "\nbut listen closely there is combination of four numbers you have to...\n(The note ends there)\nWeird I wonder what happen in here.");

        Bedroom b1 = new Bedroom(1 + BEDROOM, false, new Bed(), new Closet(), b1Vault);
        Bedroom b2 = new Bedroom(2 + BEDROOM, false, b2Bed, b2Closet, new Vault());
        



        Bedroom[] bArr = {b1,b2};
        Kitchen[] kArr = {k1};



        Player player = new Player( "username",  "password", "",100, 1,1, 1,1);
        
        
        // Set Grid
        map.setGrid(10,10);
        map.setPos(player.getYpos(),  player.getXpos(),  PLAYER);
        map.setPos(1, 0, k1.getId());
        map.setPos(2, 1, b2.getId());
        map.setPos(0, 1, b1.getId());
        



        ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, map.getGrid(), player, kArr, bArr);
        String userInput = "";
        while(player.getHp() > 0) {
            map.displayMap();
            userInput = getString("\n(type help to see commands) >> ").toLowerCase();
            switch(userInput) {
                case "walk east": // Move right
                    zombieEncounters.moveRight();
                    //Zombie Moves
                    break;

                case "walk west": // Move left
                    zombieEncounters.moveLeft();
                    //Zombie Moves
                    break;

                case "walk north": // Move up
                    zombieEncounters.moveUp();
                    //Zombie Moves
                    break;

                case "walk south": // Move down
                    zombieEncounters.moveDown();
                    //Zombie Moves
                    break;
                
                case "lookaround": // Look around room
                    zombieEncounters.lookAround(player, map.getGrid());
                    break;

                case "help":
                    showHelpMenu();
                    break;
                
                case "scream":
                    player.scream();
                    break;
                
                case "eat":
                    player.eat();
                    break;

                case "inventory":
                    player.getInventory();
                    break;
                
                
                case "exit": // exit program
                    break;
                
                default: 
                    System.out.println("* Those were not any of the selections");
            }            
            
        }
        
        
        

    }

    public static void showHelpMenu() {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("                      Help");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("  Commands             |        Actions");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" open [object]         |        to open things");
        System.out.println(" search [object]       |        to search item");
        System.out.println(" pickup [object]       |        to pick up items");
        System.out.println(" examine [object]      |        to get more detail from things");
        System.out.println(" read [object]         |        to read");
        System.out.println(" uncover [object]      |        to uncover");
        System.out.println(" enter [object]        |        to go into rooms");
        System.out.println(" leave [object]        |        to leave rooms");
        System.out.println(" writedown [object]    |        write down one note at a time");
        System.out.println(" readmy notes          |        read your notes");
        System.out.println(" lookaround            |        look around your area");
        System.out.println(" inventory             |        view your inventory(this displays everything)");
        System.out.println(" eat                   |        eat one food item in your inventory");
        System.out.println(" walk north            |        to move north (also to leave hook)");
        System.out.println(" walk west             |        to move west (also to leave hook)");
        System.out.println(" walk east             |        to move east (also to leave hook)");
        System.out.println(" walk south            |        to move south (also to leave hook)");
        System.out.println("------------------------------------------------------------------------");
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
