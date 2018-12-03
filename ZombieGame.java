import java.util.*;
import java.io.*;

class ZombieGame {
    public final static int PLAYER = 1;
    public final static int KITCHEN = 10;
    public final static int BEDROOM = 20;
    public final static int MASTER_BEDROOM = 30;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        /**
         * The Player construcotr
         * Player(String username, String password, String notes, int hp, int keyCount,int knifeCount, int foodCount, int xpos, int ypos)
         */

        Player player = new Player( "username",  "password", "", 100, 1, 1,1, 1,1);

        /**
         * The objects inside room constructors here for reference
         * 
         * Bed(boolean isSheets, int knife, int food, String note)
         * Closet(boolean isOpen, int knife, int food)
         * Vault(boolean isOpen,string passcode, int knife, int food, String note)
         * Fridge(boolean isOpen, int knife, int food)
         * Desk(boolean isDrawer, int knife, int food, int key, String note)
         */
        
        
        /**
           * The SuperRoom constructor here for reference
           * SuperRoom(int id, boolean isDoor, boolean isLocked, Bed bed, Closet closet, Fridge fridge, Vault vault, Desk desk)
           * if new Object() is denoted that means it does not exist in the room
        */


        // SuperRoom 1
        Vault v1 = new Vault(false, "jackblack",1, 1, "1");
        SuperRoom superRoom = new SuperRoom(
            BEDROOM + 1,
            "Bedroom",
            false, true,
            new Bed(), new Closet(), new Fridge(), v1, new Desk()
        ); // SuperRoom 1


        // SuperRoom 2
        Bed b2 = new Bed(false, 1, 1,"\nYou need to get of here now! I know you don't know me" +
        "\nbut you are trapped in this place... Once you get out here there is room 5 steps south and 3 steps east " +
        "\nbut listen closely there is combination of four numbers you have to...\n(The note ends there)\nWeird I wonder what happen in here.");
        Closet c2 = new Closet(false, 1,1);
        SuperRoom superRoom2 = new SuperRoom(
            BEDROOM + 2,
            "Bedroom",
            false, false,
            b2, c2, new Fridge(), new Vault(), new Desk()
        ); // SuperRoom 2


        // SuperRoom 3
        Closet c3 = new Closet(false, 0, 0);
        Fridge f3 = new Fridge(false, 1, 0, "This is a note");
        Lamp l3 = new Lamp("#blackjack");
        Vault v3 = new Vault(false, "blackjack",1, 1, "1");
        Desk d3 = new Desk(false, 0, 0, 1,"", l3);
        SuperRoom superRoom3 = new SuperRoom(
            KITCHEN + 3,
            "Kitchen",
            false, false,
            new Bed(), c3, f3, v3, d3
        ); // SuperRoom 3


        // SuperRoom 4
        Bed b4 = new Bed(false, 0, 0, "");
        Vault v4 = new Vault(false, "nuggets", 0,0,"5");
        Fridge f4 = new Fridge(false, 1, 1, "Its in this room. Wooden has four legs and stands");
        Closet c4 = new Closet(false, 1,1);
        Desk d4 = new Desk(false, 0, 0, 0,"\n#nuggets", new Lamp());
        SuperRoom superRoom4 = new SuperRoom(
            MASTER_BEDROOM + 1,
            "Master Bedroom",
            false, false,
            b4, c4, f4, v4, d4
        ); // SuperRoom 4


        // SuperRoom Array
        SuperRoom[] superRoomsArr = {superRoom, superRoom2, superRoom3, superRoom4};
        
        
        // Map layout
        Map map = new Map();        
        map.setGrid(10,10);
        map.setPos(player.getYpos(),  player.getXpos(),  PLAYER);
        map.setPos(2, 1, superRoom.getId());
        map.setPos(0, 1, superRoom2.getId());
        map.setPos(1, 0, superRoom3.getId());
        map.setPos(3, 0, superRoom4.getId());
        
        // Setup for game
        ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, map.getGrid(), player, superRoomsArr);

        //Initialize game
        PlayGame.initalizeGame(zombieEncounters, map, player);
    }    

}
