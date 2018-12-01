import java.util.*;
import java.io.*;

class ZombieGame {
    public final static int PLAYER = 1;
    public final static int KITCHEN = 10;
    public final static int BEDROOM = 11;
    public final static int DOOR = 12;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        
        Map map = new Map();
        Kitchen ki = new Kitchen( 2, false, false, 4);
        Bedroom b = new Bedroom(false, "You need to get of here now!I know you don't know me\nbut listen closely there is combination of four numbers you have to...\n(The note ends there)\nWeird I wonder what happen in here.", false);
        // Door d = new Door(false);
        Player player = new Player( "username",  "password", 100, 1, 1);

        // Set Grid
        //Map map = new Map();
        map.setGrid(10,10);
        map.setPos(player.getYpos(),  player.getXpos(),  PLAYER);
        map.setPos(1, 0, KITCHEN);
        map.setPos(0, 1, BEDROOM);
        // map.setPos(1, 2, DOOR);
        // Set Player Position
        
        ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, map.getGrid(), player, ki, b);
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
                
                
                case "exit": // exit program
                    break;
                
                default: 
                    System.out.println("* Those were not any of the selections");
            }            
            
        }
        
        
        

    }

    public static void showHelpMenu() {
        System.out.println("\n*******************************************************");
        System.out.println("                       Help");
        System.out.println("*******************************************************");
        System.out.println(" open [object]        to open things");
        System.out.println(" search [object]      to search things");
        System.out.println(" examine [object]     to get more detail from things");
        System.out.println(" read [object]        to read something");
        System.out.println(" uncover [object]     to unconver something");
        System.out.println(" enter [object]       to go into rooms");
        System.out.println(" leave [object]       to leave rooms");
        System.out.println(" walk north           to move north (also to leave hook)");
        System.out.println(" walk west            to move west (also to leave hook)");
        System.out.println(" walk east            to move east (also to leave hook)");
        System.out.println(" walk south           to move south (also to leave hook)");
        System.out.println("*********************************************************");
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
