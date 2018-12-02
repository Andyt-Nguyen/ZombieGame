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
        
        Fridge kitchen1 = new Fridge(false, 1, 1);
        
        Vault kitchen2 = new Vault(false, "blackjack",1, 1, "1");
        Vault vault1 = new Vault(false, "jackblack",1, 1, "1");

        Closet closet1 = new Closet(false, 1,1);
        Closet closet2 = new Closet(false, 1,1);
        
        Bed b2Bed = new Bed(false, 1, 1,"You need to get of here now! I know you don't know me" +
        "\nbut you are trapped in this place... Once you get out here there is room 5 steps south and 3 steps east " +
        "\nbut listen closely there is combination of four numbers you have to...\n(The note ends there)\nWeird I wonder what happen in here.");
        
        // Kitchen k1 = new Kitchen(1 + KITCHEN, kitchen1, closet1, kitchen2, false);
        // Bedroom b1 = new Bedroom(1 + BEDROOM, false, new Bed(), new Closet(), vault1, true);
        // Bedroom b2 = new Bedroom(2 + BEDROOM, false, b2Bed, closet2, new Vault(), true);
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
            b2Bed, closet2, new Fridge(), new Vault()
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
        PlayGame.initalizeGame(zombieEncounters,map, player);
    }    

}
