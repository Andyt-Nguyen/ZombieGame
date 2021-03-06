import java.util.*;
import java.io.*;

class ZombieGame {
    public final static int PLAYER = 1;
    public final static int KITCHEN = 10;
    public final static int BEDROOM = 20;
    public final static int MASTER_BEDROOM = 30;
    public final static int WALL = 100;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        /**
         * The Player construcotr
         * Player(String username, String password, String notes, int hp, int keyCount,int knifeCount, int foodCount, int xpos, int ypos)
         */

        Player player = new Player( "username",  "password", "", 100, 0, 0, 0, 1,1);

        /**
         * The objects inside room constructors here for reference
         * 
         * Bed(boolean isSheets, int knife, int food, int key, String note) 
         * Closet(boolean isOpen, int knife, int food, int key)
         * Vault(boolean isOpen,String passcode, int knife, int food, int key, String note)
         * Fridge(boolean isOpen, int knife, int food, int key,String note)
         * Desk(boolean isDrawer, int knife, int food, int key, String note)
         */
        
        
        /**
           * The SuperRoom constructor here for reference
           * SuperRoom(int id, String name, 
                     int keysToUnlock, int doorDamage,
                     boolean isDoor, boolean isLocked, boolean isToxic, 
                     Bed bed, Closet closet, Fridge fridge, Vault vault, Desk desk)
           * 
           * if new Object() is denoted that means it does not exist in the room
        */


        // westwestBedroom1 (1KEY)
        // Bed(boolean isSheets, int knife, int food, int key, String note) 
        Bed westBedroom1 = new Bed(false, 1, 0, 1,
            "You need to get of here now! I know you don't know me" +
            "\nbut you are trapped in this place... Listen closely" +
            "\nthere is a combination of four numbers you have to..." +
            "\n(The note ends there)\nWeird I wonder what happen in here.");

        Closet westBedroomCloset1 = new Closet(false, 2,0,0, "");
        SuperRoom westwestBedroom1 = new SuperRoom(
            BEDROOM + 1,
            "Bedroom", 0, 5,
            false, false, false,
            westBedroom1, westBedroomCloset1, new Fridge(), new Vault(), new Desk()
        ); // westwestBedroom1



        // East Bedroom (1KEY)
        Bed eastBed1 =              new Bed(false, 0, 0, 0, "Beware of the Master Bedroom... Breath fast and run.");
        Closet eastBedroomCloset1 = new Closet(false, 1,1,1, "");
        SuperRoom eastBedroom1 =    new SuperRoom(
            BEDROOM + 2,
            "Bedroom", 0, 5,
            false, false, false,
            eastBed1, eastBedroomCloset1, new Fridge(), new Vault(), new Desk()
        ); // East Bedroom key



        // northKitchen kitchen (vault)
        Closet northKitchenCloset1 = new Closet(false, 2, 2, 0, "");
        Fridge northFridge1 =        new Fridge(false, 2, 2, 0,
            "it doesn't interest Me\n" +
            "what you do for A living.\n" +
            "i want to know\n" +
            "what you ache for\n" +
            "and if you Dare to dream\n" +
            "of meeting your heart's longing.\n" +
            "\n- Oriah Mountain Dreamer");
        Vault northVault1 =    new Vault(false, "MAD",1, 1, 0,"21");
        SuperRoom northKitchen = new SuperRoom(
            KITCHEN + 1,
            "Kitchen", 1, 5,
            false, true, false,
            new Bed(), northKitchenCloset1, northFridge1, northVault1, new Desk()
        ); //  northKitchen(vault)



        // westKitchen1 kitchen (locked key)
        Closet westKitchenCloset1 = new Closet(false, 0, 10, 0, "Out of this room. Move all east.\nParadise awaits you.");
        Fridge westFridge1 =        new Fridge(false, 0, 4, 1,"The owner of this building really loved JoEscraBshacK. It was always the owners favorite restaurant");
        SuperRoom westKitchen1 =    new SuperRoom(
            KITCHEN + 2,
            "Kitchen", 1, 3,
            false, true, true,
            new Bed(), westKitchenCloset1, westFridge1, new Vault(), new Desk()
        ); //  westKitchen1 kitchen (locked key)


        // southEastKitchen1 kitchen (locked key)
        Closet southEastKitchenCloset1 = new Closet(false, 0, 3, 0, "");
        Fridge southEastFridge1 =        new Fridge(false, 0, 2, 1,"");
        SuperRoom southEastKitchen1 =    new SuperRoom(
            KITCHEN + 3,
            "Kitchen", 2, 5,
            false, true, false,
            new Bed(), southEastKitchenCloset1, southEastFridge1, new Vault(), new Desk()
        ); //  westKitchen1 kitchen (locked key)

        
        


        //  westwestMasterBedroom1 (vault) (2keys)
        Bed westMasterBed1 = new Bed(false, 0, 0, 0,
            "Please do me a favor\n"           +
            "Keep lying to me\n"               +
            "Until I can no longer breathe\n"  +
            "I want to depart\n"               +
            "Not knowing the real you\n"       +
            "My spirits draw well\n"           +
            "Without knowing the truth\n"      +
            "But, if it should leak out\n"     +
            "Then I will breathe no more\n"    +
            "I'm like a stubborn child\n"      +
            "I refuse to see certain things\n" +
            "Lie to me, thats all I need from you\n" +
            "Lie to me, your words will be true\n"   +
            "Ignorance will keep me around\n"        +
            "Convince me that I'm sick\n"            +
            "Someone please close the door\n"        +
            "I know it's only a trick\n"             +
            "But why can't I breathe no more.\n"     +
            "- Victor Osorio");
        Fridge westMasterFridge1 = new Fridge(false, 1, 1, 1,"I am under so full of light, but always in shade");
        Closet westMasterCloset1 = new Closet(false, 1, 1, 0, "For those who have stepped in this room and have lived this long to see this note.\n" +
        "This room is dangerous it is highly toxic any mistakes whatsoever will cost you your life.\n" + 
        "Get out of here fast!");
        Desk westMasterDesk1 =        new Desk(false, 0, 0, 0,"", new Lamp("nuggets"));
        Vault westMasterVault1 =      new Vault(false, "nuggets", 0, 0, 1, "5");
        SuperRoom westMasterBedroom1 = new SuperRoom(
            MASTER_BEDROOM + 1,
            "Master Bedroom", 1, 5,
            false, true, true,
            westMasterBed1, westMasterCloset1, westMasterFridge1, westMasterVault1, westMasterDesk1
        ); //  westwestMasterBedroom1 (vault)



        
        //  southMasterBedroom1 (vault)
        Bed southMasterBed1 =           new Bed(false, 0, 0, 0,"");
        Fridge soutMasterFridge1 =      new Fridge(false, 1, 1, 0,"");
        Closet southMasterCloset1 =     new Closet(false, 1, 1, 0, "");
        Desk southMasterDesk1 =         new Desk(false, 0, 0, 0,"What is 6x7", new Lamp(""));
        Vault southMasterVault1 =       new Vault(false, "fortytwo", 0, 0, 0, "4");
        SuperRoom southMasterBedroom1 = new SuperRoom(
            MASTER_BEDROOM + 2,
            "Master Bedroom", 1, 5,
            false, true, true,
            southMasterBed1, southMasterCloset1, soutMasterFridge1, southMasterVault1, southMasterDesk1
        ); //  southMasterBedroom1 (vault)



        //  finalRoom (vault)
        Bed finalRoomMasterBed =       new Bed(false, 0, 0, 0,"");
        Fridge finalMasterFridge =     new Fridge(false, 0, 0, 0,"");
        Closet finalRoomMasterCloset = new Closet(false, 0, 0, 0, "");
        Desk finalRoomMasterDesk =     new Desk(false, 0, 0, 0,"", new Lamp(""));
        Vault finalRoomMasterVault =   new Vault(false, "1254", 0, 0, 0, "");
        SuperRoom finalRoom =          new SuperRoom(
            MASTER_BEDROOM + 5,
            "Master Bedroom", 3, 10,
            false, true, true,
            finalRoomMasterBed, finalRoomMasterCloset, finalMasterFridge, finalRoomMasterVault, finalRoomMasterDesk
        ); //  finalRoom (vault)


        
        // SuperRoom Array
        SuperRoom[] superRoomsArr = {westwestBedroom1, northKitchen, southMasterBedroom1, eastBedroom1, westMasterBedroom1,westKitchen1, southEastKitchen1, finalRoom};
        
        
        // Map layout
        Map map = new Map();        
        map.setGrid(6,6);
        map.setPos(player.getYpos(),  player.getXpos(),  PLAYER);
        map.setPos(2, 1, WALL);
        map.setPos(0, 2, WALL);
        map.setPos(2,5, WALL);
        map.setPos(2,3, WALL);
        map.setPos(0,5, WALL);
        map.setPos(1,5, WALL);
        map.setPos(4,3, WALL);
        map.setPos(5,3, WALL);
        map.setPos(0, 1, westwestBedroom1.getId());
        map.setPos(1, 0, northKitchen.getId());
        map.setPos(0, 3, westMasterBedroom1.getId());
        map.setPos(2,2,  eastBedroom1.getId());
        map.setPos(0,4,  westKitchen1.getId());
        map.setPos(3,3,  southMasterBedroom1.getId());
        map.setPos(3,5,  southEastKitchen1.getId());
        map.setPos(5,5,  finalRoom.getId());
        
        // Setup for game
        ZombieEncounters zombieEncounters = new ZombieEncounters(PLAYER, map.getGrid(), player, superRoomsArr);

        //Initialize game
        PlayGame.initalizeGame(zombieEncounters, map, player);
    }    

}
