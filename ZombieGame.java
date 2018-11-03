import java.util.Scanner;

class ZombieGame {
    public final static  int PLAYER = 1;
    public final static int ZOMBIE  = 50; // Has to be greater than 50 or equal to
    public final static int BULLETS = 3;
    public final static int KEY     = 4;
    public final static int WALL    = 5;
    public final static int DOOR    = 6;
    public final static int APPLE   = 20;
    public final static int STEAK   = 21;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        
        // Set Grid
        Map map = new Map();
        map.setGrid(15,30);
        // Player
        Person player = new Person("Sacmctap", 0, 0);
       
        // NPC Array
        NPC [] npcArr = new NPC[3];
        NPC npc1 = new NPC(30, "Geffory","You need to go eat your peas", 5, 0);
        // Creating Npcs
        npcArr[0] = npc1;


        // Set Npc Options
        npc1.setQAOptions(3);
        npc1.setOptionsQ(0, "What is this place?");
        npc1.setOptionsQ(1, "Who are you?");
        npc1.setOptionsQ(2, "Is there anything I can do to get out of here?");

        npc1.setOptionsA(0, "This place has been abandon years ago. I found you and kept you safe cause there aren't many people around except a few. This may sound crazy but becareful around these parts there are some dead people walking around");
        npc1.setOptionsA(1, "I am sargent bitch tits and I don't really know who I am");
        npc1.setOptionsA(2, "Yes! Actually I have a key to enter into the hospital. It will be at the end of the hallway heading east right after the end of the door. I don't have the key to unlock the door west of me unfortunatly to get us both out. You'll have to enter the building to search for the key. I hope you the best");


        // Zombie Array
        Zombie [] zombieArr = new Zombie[4];
        // Creating Zombies
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
        map.setPos(3, 3, APPLE);

        // Set NPC Position
        map.setPos(npc1.getXpos(), npc1.getYpos(), npc1.getId());


        // Set Item Positions
        map.setPos(3, 0, BULLETS);

        ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, ZOMBIE, BULLETS, KEY, APPLE, STEAK, WALL, DOOR, map.getGrid(), zombieArr, npcArr, player);

        String userInput = "";
        while(player.getHp() > 0 && !userInput.equals("ex")) {
            map.displayMap();
            userInput = getString("Your move (type o to view full options): ").toLowerCase();
            switch(userInput) {
                case "d": // Move right
                    zombieEncounters.moveRight();
                    //Zombie Moves
                    break;

                case "a": // Move left
                    zombieEncounters.moveLeft();
                    //Zombie Moves
                    break;

                case "w": // Move up
                    zombieEncounters.moveUp();
                    //Zombie Moves
                    break;

                case "s": // Move down
                    zombieEncounters.moveDown();
                    //Zombie Moves
                    break;

                case "o": // displays user options
                    zombieEncounters.displayUserOptions();
                    //Zombie Moves
                    break;
                
                case "i": // View inventory
                    zombieEncounters.viewInventory();
                    break;
                
                case "ex": // exit program
                    break;
                
                default: 
                    System.out.println("* Those were not any of the selections");
            }            
            
        }  
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