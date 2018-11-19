import java.util.*;
import java.io.*;

class ZombieGame {
    public final static  int PLAYER = 1;
    public final static int ZOMBIE  = 50; // Has to be greater than 50 or equal to
    public final static int BULLETS = 3;
    public final static int KEY     = 4;
    public final static int WALL    = 5;
    public final static int DOOR    = 6;
    public final static int BARRICADE = 7;
    public final static int APPLE   = 20;
    public final static int STEAK   = 21;
    public final static int SPECIAL_KEY = 25;
    public final static int FINAL_DOOR = 26;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        
        Map map = new Map();
        Person player = new Person();
        Person player1 = new Person();
        //Person player2 = new Person();
        //Person player3 = new Person();
        Zombie [] zombieArr = new Zombie[15];
        NPC [] npcArr = new NPC[5];
        String username;
        String password;
        ProjectFileIO_v2.readFile();
        ArrayList<Person> playerList = new ArrayList<Person>();

        int menuOption;
        boolean newUser = false;

        menuOption = getValidMenuOption("-------------------------------------------" +
                                        "\nPlease enter a menu option." + 
                                        "\n1. New Game" + 
                                        "\n2. Load Game" +
                                        "\n3. Quit Game" +
                                        "\n-------------------------------------------");
        if(menuOption == 1){
                username = IR5.getString("Please choose a username.(Case Sensitive)");
                password = IR5.getString("Please choose a password.(Case Sensitive)");
                player1 = ProjectFileIO_v2.checkPlayer(username);
            while(player1 != null){   
                System.out.println("\nSorry, that name has already been taken!");
                username = IR5.getString("Please choose a new username.(Case Sensitive)");
                password = IR5.getString("Please choose a password.(Case Sensitive)");
                player1 = ProjectFileIO_v2.checkPlayer(username);
            
            }

                player.setUsername(username);
                player.setPassword(password);

                // Set Grid
                //Map map = new Map();
                map.setGrid(20,30);
                // NPC Array
                //NPC [] npcArr = new NPC[3];
                NPC npc1 = new NPC(30, "Geoff", 5, 0);
                NPC npc2 = new NPC(31, "Rick", 7, 0);
                NPC npc3 = new NPC(32, "Josh", 29, 18);
                NPC npc4 = new NPC(33, "John", 28, 19);

                // Creating Npcs
                npcArr[0] = npc1;
                npcArr[1] = npc2;
                npcArr[2] = npc3;
                npcArr[3] = npc4;



                // Set Npc Options Question to NPC
                npc1.setQAOptions(3);
                npc1.setOptionsQ(0, "What is this place?");
                npc1.setOptionsQ(1, "Who are you?");
                npc1.setOptionsQ(2, "Is there anything I can do to get out of here?");
                // Set Npc Answer to Answer the user
                npc1.setOptionsA(0, "This place was run down when the apocolypse hit.. I found you and kept you safe cause there aren't many people around except a few. This may sound crazy but becareful around these parts there are some dead people walking around, and they aren't friendly.");
                npc1.setOptionsA(1, "My name is Geoff");
                npc1.setOptionsA(2, "Yes! Actually I have a key to enter this next room. I don't have the key to unlock the door west of me unfortunatly to get us both out. You'll have to enter the building to search for the key. I wish for you the best");


                // Zombie Array
                //Zombie [] zombieArr = new Zombie[4];
                // Creating Zombies
                Zombie zombie =  new Zombie(55, 30, 11, 0);
                Zombie zombie1 = new Zombie(56, 30, 15, 2);
                Zombie zombie2 = new Zombie(57, 30, 18, 4);
                Zombie zombie3 = new Zombie(58, 30, 24, 3);
                Zombie zombie4 = new Zombie(59, 30, 26, 0);
                Zombie zombie5 = new Zombie(60, 30, 27, 4);

                

                // Add Zombies To Array
                zombieArr[0] = zombie;
                zombieArr[1] = zombie1;
                zombieArr[2] = zombie2;                
                zombieArr[3] = zombie3;                
                zombieArr[4] = zombie4;                
                zombieArr[5] = zombie5;                

                //Set Wall Position
                map.setPos(1, 5, WALL);
                map.setPos(2, 5, WALL);
                map.setPos(3, 5, WALL);
                map.setPos(4, 5, WALL);
                map.setPos(5, 5, WALL);
                //map.setPos(12, 13, WALL);
                map.setPos(6, 5, WALL);
                map.setPos(6, 0, WALL);
                map.setPos(6, 1, WALL);
                map.setPos(6, 3, WALL);
                map.setPos(6, 4, WALL);
                map.setPos(2, 6, WALL);
                map.setPos(2, 7, WALL);
                map.setPos(2, 8, WALL);
                map.setPos(2, 9, WALL);
                map.setPos(2, 10, WALL);
                map.setPos(2, 11, WALL);
                map.setPos(2, 12, WALL);
                map.setPos(2, 13, WALL);
                map.setPos(2, 14, WALL);
                map.setPos(2, 15, WALL);
                map.setPos(2, 16, WALL);
                map.setPos(2, 17, WALL);
                map.setPos(2, 19, WALL);
                map.setPos(7, 5, WALL);
                map.setPos(8, 5, WALL);
                map.setPos(9, 5, WALL);
                map.setPos(10, 5, WALL);
                map.setPos(11, 5, WALL);
                map.setPos(12, 5, WALL);
                map.setPos(13, 5, WALL);
                map.setPos(14, 5, WALL);
                map.setPos(15, 5, WALL);
                map.setPos(16, 5, WALL);
                map.setPos(17, 5, WALL);
                map.setPos(18, 5, WALL);
                map.setPos(19, 5, WALL);
                map.setPos(20, 5, WALL);
                map.setPos(21, 5, WALL);
                map.setPos(22, 5, WALL);
                map.setPos(23, 5, WALL);
                map.setPos(24, 5, WALL);
                map.setPos(25, 5, WALL);
                map.setPos(26, 5, WALL);
                map.setPos(27, 5, WALL);
                map.setPos(13, 0, WALL);
                map.setPos(13, 1, WALL);
                map.setPos(13, 3, WALL);
                map.setPos(13, 4, WALL);
                map.setPos(13, 5, WALL);
                map.setPos(21, 0, WALL);
                map.setPos(21, 1, WALL);
                map.setPos(21, 3, WALL);
                map.setPos(21, 4, WALL);
                map.setPos(21, 5, WALL);
                map.setPos(29, 5, WALL);
                map.setPos(6, 6, WALL);
                map.setPos(6, 7, WALL);
                map.setPos(6, 8, WALL);
                map.setPos(6, 9, WALL);
                map.setPos(6, 11, WALL);
                map.setPos(6, 12, WALL);
                map.setPos(6, 13, WALL);
                map.setPos(6, 14, WALL);
                map.setPos(6, 15, WALL);
                map.setPos(6, 16, WALL);
                map.setPos(6, 17, WALL);
                map.setPos(6, 18, WALL);
                map.setPos(6, 19, WALL);
                map.setPos(3, 14, WALL);
                map.setPos(5, 14, WALL);
                map.setPos(6, 14, WALL);
                //Set Door Position
                map.setPos(5, 5, DOOR);
                map.setPos(0, 5, DOOR);
                map.setPos(6, 2, DOOR);
                map.setPos(2, 18, DOOR);
                map.setPos(28, 5, DOOR);
                map.setPos(13, 2, DOOR);
                map.setPos(21, 2, DOOR);
                map.setPos(4, 14, DOOR);
                map.setPos(6, 10, DOOR);
                map.setPos(0,3, FINAL_DOOR);
                //Set Barricades
                map.setPos(7, 1, BARRICADE);
                map.setPos(8, 0, BARRICADE);
                map.setPos(8, 1, BARRICADE);
                map.setPos(27, 19, BARRICADE);
                map.setPos(27, 18, BARRICADE);
                map.setPos(27, 17, BARRICADE);
                map.setPos(28, 17, BARRICADE);
                map.setPos(29, 17, BARRICADE);
                map.setPos(10, 10, BARRICADE);
                map.setPos(11, 10, BARRICADE);
                map.setPos(12, 10, BARRICADE);
                map.setPos(13, 10, BARRICADE);
                map.setPos(14, 10, BARRICADE);
                map.setPos(15, 10, BARRICADE);
                map.setPos(16, 10, BARRICADE);
                map.setPos(17, 10, BARRICADE);
                map.setPos(18, 10, BARRICADE);
                map.setPos(19, 10, BARRICADE);
                map.setPos(20, 10, BARRICADE);
                map.setPos(21, 10, BARRICADE);
                map.setPos(22, 10, BARRICADE);
                map.setPos(23, 10, BARRICADE);
                map.setPos(10, 15, BARRICADE);
                map.setPos(11, 15, BARRICADE);
                map.setPos(12, 15, BARRICADE);
                map.setPos(13, 15, BARRICADE);
                map.setPos(14, 15, BARRICADE);
                map.setPos(15, 15, BARRICADE);
                map.setPos(16, 15, BARRICADE);
                map.setPos(17, 15, BARRICADE);
                map.setPos(18, 15, BARRICADE);
                map.setPos(19, 15, BARRICADE);
                map.setPos(20, 15, BARRICADE);
                map.setPos(21, 15, BARRICADE);
                map.setPos(22, 15, BARRICADE);
                map.setPos(23, 15, BARRICADE);

                // Set Player Position
                map.setPos(player.xpos,  player.ypos,  PLAYER);

                // Set Zombie position
                map.setPos(zombieArr[0].xpos, zombieArr[0].ypos, zombieArr[0].getId());
                map.setPos(zombieArr[1].xpos, zombieArr[1].ypos, zombieArr[1].getId());
                map.setPos(zombieArr[2].xpos, zombieArr[2].ypos, zombieArr[2].getId());
                map.setPos(zombieArr[3].xpos, zombieArr[3].ypos, zombieArr[3].getId());
                map.setPos(zombieArr[4].xpos, zombieArr[4].ypos, zombieArr[4].getId());
                map.setPos(zombieArr[5].xpos, zombieArr[5].ypos, zombieArr[5].getId());

                // Set NPC Position
                map.setPos(npc1.getXpos(), npc1.getYpos(), npc1.getId());
                map.setPos(npc2.getXpos(), npc2.getYpos(), npc2.getId());
                map.setPos(npc3.getXpos(), npc3.getYpos(), npc3.getId());
                map.setPos(npc4.getXpos(), npc4.getYpos(), npc4.getId());
                
                
                // Set Item Positions
                map.setPos(3, 3, APPLE);
                map.setPos(28, 4, APPLE);
                map.setPos(14, 4, APPLE);
                map.setPos(19, 3, STEAK);
                map.setPos(3, 0, BULLETS);
                map.setPos(12, 0, BULLETS);
                map.setPos(7, 4, BULLETS);
                map.setPos(14, 0, BULLETS);
                map.setPos(29, 0, BULLETS);
                map.setPos(29, 4, BULLETS);
                map.setPos(22, 0, BULLETS);
                map.setPos(7, 8, KEY);
                //map.setPos(10, 10, SPECIAL_KEY);
                //map.setPos(10, 13, FINAL_DOOR);

                    //playerList.add(player1);
                    ProjectFileIO_v2.addNewPlayer(player);
                    ProjectFileIO_v2.writeFile();
      

                //ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, ZOMBIE, BULLETS, SPECIAL_KEY, KEY, APPLE, STEAK, WALL, DOOR, FINAL_DOOR, map.getGrid(), zombieArr, npcArr, player);
        } else if(menuOption == 2) {
            if(playerList.size() == 0){
                System.out.println("There are currently no saved games, please select new game.");
                return;
            }
            do {
            // boolean existingFile;
            username = IR5.getString("Please enter your username.(Case Sensitive)");
            password = IR5.getString("Please enter your password.(Case Sensitive)");

            player = ProjectFileIO_v2.getPlayer(username, password);

            } while(player == null);
        } else if(menuOption == 3) {
            System.exit(-1);
        }
        
        ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, ZOMBIE, BULLETS, SPECIAL_KEY, KEY, APPLE, STEAK, WALL, DOOR, BARRICADE, FINAL_DOOR, map.getGrid(), zombieArr, npcArr, player);
        String userInput = "";
        while(player.getHp() > 0 && !userInput.equals("ex") && (menuOption == 1 || menuOption == 2)) {
            // map.displayMap();
            System.out.println("RECEPTION ROOM");
            userInput = getString("Your move (type o to view full options): ").toLowerCase();
            switch(userInput) {
                case "move east": // Move right
                    zombieEncounters.moveRight();
                    //Zombie Moves
                    break;

                case "move west": // Move left
                    zombieEncounters.moveLeft();
                    //Zombie Moves
                    break;

                case "move north": // Move up
                    zombieEncounters.moveUp();
                    //Zombie Moves
                    break;

                case "move south": // Move down
                    zombieEncounters.moveDown();
                    //Zombie Moves
                    break;

                case "o": // displays user options
                    zombieEncounters.displayUserOptions();
                    //Zombie Moves
                    break;
                
                case "inventory": // View inventory
                    zombieEncounters.viewInventory();
                    break;
                
                case "exit": // exit program
                    break;
                
                default: 
                    System.out.println("* Those were not any of the selections");
            }            
            
        }  

        ProjectFileIO_v2.writeFile();
    }

    public static int getValidMenuOption(String msg){
        int newValue;
        newValue = IR5.getInteger(msg);
        while(newValue != 1 && newValue != 2 && newValue != 3){
            System.out.println("\nPlease enter a valid menu option.");
            newValue = IR5.getInteger(msg);
        }
        return newValue;
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