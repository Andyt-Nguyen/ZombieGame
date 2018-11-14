import java.util.*;
import java.io.*;

class ZombieGame {
    public final static  int PLAYER = 1;
    public final static int ZOMBIE  = 50; // Has to be greater than 50 or equal to
    public final static int BULLETS = 3;
    public final static int KEY     = 4;
    public final static int WALL    = 5;
    public final static int DOOR    = 6;
    public final static int APPLE   = 20;
    public final static int STEAK   = 21;
    public final static int SPECIAL_KEY = 25;
    public final static int FINAL_DOOR = 26;
    public final static String FILE_NAME = "ZombieGameSave.txt";
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        
        File file = new File(FILE_NAME);
        Map map = new Map();
        Person player = new Person();
        Zombie [] zombieArr = new Zombie[10];
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
            do{
                username = IR5.getString("Please choose a username.(Case Sensitive)");
                password = IR5.getString("Please choose a password.(Case Sensitive)");
                for(int i = 0; i < playerList.size(); i++){
                    if(playerList.get(i).getUsername().equals(username)
                    && playerList.get(i).getPassword().equals(password)){
                        newUser = false;
                    }
                    newUser = true;
                    player.setUsername(username);
                    player.setPassword(password);
                }
            }while(!newUser);
                // Set Grid
                //Map map = new Map();
                map.setGrid(20,30);
                // NPC Array
                //NPC [] npcArr = new NPC[3];
                NPC npc1 = new NPC(30, "Geffory", 5, 0);

                // Creating Npcs
                npcArr[0] = npc1;


                // Set Npc Options Question to NPC
                npc1.setQAOptions(3);
                npc1.setOptionsQ(0, "What is this place?");
                npc1.setOptionsQ(1, "Who are you?");
                npc1.setOptionsQ(2, "Is there anything I can do to get out of here?");
                // Set Npc Answer to Answer the user
                npc1.setOptionsA(0, "This place has been abandon years ago. I found you and kept you safe cause there aren't many people around except a few. This may sound crazy but becareful around these parts there are some dead people walking around");
                npc1.setOptionsA(1, "My name is goomba goomba Geffory");
                npc1.setOptionsA(2, "Yes! Actually I have a key to enter into the hospital. It will be at the end of the hallway heading east right after the end of the door. I don't have the key to unlock the door west of me unfortunatly to get us both out. You'll have to enter the building to search for the key. I hope you the best");


                // Zombie Array
                //Zombie [] zombieArr = new Zombie[4];
                // Creating Zombies
                Zombie zombie =  new Zombie(55, 30, 9, 0);
                Zombie zombie2 = new Zombie(57, 50, 2, 2);

                // Add Zombies To Array
                zombieArr[0] = zombie;
                zombieArr[1] = zombie2;

                //Set Wall Position
                map.setPos(1, 5, WALL);
                map.setPos(2, 5, WALL);
                map.setPos(3, 5, WALL);
                map.setPos(4, 5, WALL);
                map.setPos(5, 5, WALL);
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
        //Set Door Position
                map.setPos(0, 5, DOOR);
                map.setPos(6, 2, DOOR);
                map.setPos(2, 18, DOOR);
                map.setPos(28, 5, DOOR);
                map.setPos(13, 2, DOOR);
                map.setPos(21, 2, DOOR);
                map.setPos(0,3, FINAL_DOOR);

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
                map.setPos(5, 5, DOOR);
                map.setPos(7, 8, KEY);
                map.setPos(12, 13, WALL);
                map.setPos(10, 10, SPECIAL_KEY);
                map.setPos(10, 13, FINAL_DOOR);

                ProjectFileIO_v2.writeNewPlayer(
                    username, 
                    password, 
                    player.getHp(), 
                    player.getBulletCount(), 
                    player.getKnifeCount(), 
                    player.getAppleCount(), 
                    player.getSteakCount(), 
                    player.getKeyCount() , 
                    player.getXpos(), 
                    player.getYpos(), 
                    player.getSpecialKey()
                );
                ProjectFileIO_v2.writeFile();

      

                //ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, ZOMBIE, BULLETS, SPECIAL_KEY, KEY, APPLE, STEAK, WALL, DOOR, FINAL_DOOR, map.getGrid(), zombieArr, npcArr, player);
        } else if(menuOption == 2) {
            do {
            // boolean existingFile;
            username = IR5.getString("Please enter your username.(Case Sensitive)");
            password = IR5.getString("Please enter your password.(Case Sensitive)");

            player = ProjectFileIO_v2.getPlayer(username, password);

            } while(player == null);
        } else if(menuOption == 3) {
            System.exit(-1);
        }
        
        ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, ZOMBIE, BULLETS, SPECIAL_KEY, KEY, APPLE, STEAK, WALL, DOOR, FINAL_DOOR, map.getGrid(), zombieArr, npcArr, player);
        String userInput = "";
        while(player.getHp() > 0 && !userInput.equals("ex") && (menuOption == 1 || menuOption == 2)) {
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