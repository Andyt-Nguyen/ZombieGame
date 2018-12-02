import java.util.*;
import java.io.*;

class ZombieGame {
    public final static int PLAYER = 1;
    public final static int KITCHEN = 10;
    public final static int BEDROOM = 20;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        /**
         * The Player construcotr
         * Player(String username, String password, String notes, int hp, int keyCount,int knifeCount, int foodCount, int xpos, int ypos)
         */
        Player player = new Player( "username",  "password", "", 100, 1, 1,1, 1,1);

        /**
         * The objects inside room constructors here for reference
         * Bed(boolean isSheets, int knife, int food, String note)
         * Closet(boolean isOpen, int knife, int food)
         * Vault(boolean isOpen,string passcode, int knife, int food, String note)
         * Fridge(boolean isOpen, int knife, int food)
         */
        Closet closet1 = new Closet(false, 1,1);
        Fridge kitchen1 = new Fridge(false, 1, 1);
        Vault kitchen2 = new Vault(false, "blackjack",1, 1, "1");
        // Kitchen k1 = new Kitchen(1 + KITCHEN, kitchen1, closet1, kitchen2, false);

        Vault vault1 = new Vault(false, "jackblack",1, 1, "1");
        Closet closet2 = new Closet(false, 1,1);
        
        Bed bed1 = new Bed(false, 1, 1,"You need to get of here now! I know you don't know me" +
        "\nbut you are trapped in this place... Once you get out here there is room 5 steps south and 3 steps east " +
        "\nbut listen closely there is combination of four numbers you have to...\n(The note ends there)\nWeird I wonder what happen in here.");

        // Bedroom b1 = new Bedroom(1 + BEDROOM, false, new Bed(), new Closet(), vault1, true);
        // Bedroom b2 = new Bedroom(2 + BEDROOM, false, bed1, closet2, new Vault(), true);
        

        // Bedroom[] bArr = {b1,b2};
        // Kitchen[] kArr = {k1};


        /**
           * The SuperRoom constructor here for reference
           * SuperRoom(int id, boolean isDoor, boolean isLocked, Bed bed, Closet closet, Fridge fridge, Vault vault)
        */


        SuperRoom superRoom = new SuperRoom(
            BEDROOM + 1,
            "Bedroom",
            false, true,
            new Bed(), new Closet(), new Fridge(), vault1
        );

        SuperRoom superRoom2 = new SuperRoom(
            BEDROOM + 2,
            "Bedroom",
            false, false,
            bed1, closet2, new Fridge(), new Vault()
        );

        SuperRoom superRoom3 = new SuperRoom(
            KITCHEN + 1,
            "Kitchen",
            false, false,
            new Bed(), closet1, kitchen1, kitchen2
        );

        SuperRoom[] superRoomsArr = {superRoom, superRoom2, superRoom3};
        
        // Set Grid
        Map map = new Map();        
        map.setGrid(10,10);
        map.setPos(player.getYpos(),  player.getXpos(),  PLAYER);
        map.setPos(1, 0, superRoom3.getId());
        map.setPos(2, 1, superRoom.getId());
        map.setPos(0, 1, superRoom2.getId());
        



        ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, map.getGrid(), player, superRoomsArr);
        String userInput = "";
        while(player.getHp() > 0) {
            map.displayMap();
            userInput = getString("\n(type help to see commands) >> ").toLowerCase();
            switch(userInput) {
                case "walk east": // Move right
                    zombieEncounters.moveRight();
                    break;

                case "walk west": // Move left
                    zombieEncounters.moveLeft();
                    break;

                case "walk north": // Move up
                    zombieEncounters.moveUp();
                    break;

                case "walk south": // Move down
                    zombieEncounters.moveDown();
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
                
                case "checkhealth":
                    player.checkHealth();
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
        System.out.println(" enter [room name      |        to go into rooms");
        System.out.println(" leave [room name      |        to leave rooms");
        System.out.println(" writedown [text]      |        write down in your notes");
        System.out.println(" code vault            |        getting into the vault");
        System.out.println(" breakinto [object]    |        you would use your knife to break into something");
        System.out.println(" readmy notes          |        read your notes");
        System.out.println(" lookaround            |        look around your area");
        System.out.println(" inventory             |        view your inventory");
        System.out.println(" checkhealth           |        check your hp");
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
