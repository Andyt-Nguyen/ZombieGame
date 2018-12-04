public class PlayGame {
    public static void initalizeGame(ZombieEncounters zombieEncounters, Map map, Player player) {
        String userInput = "";
        while(player.getHp() > 0 && !player.getisWin()) {
            map.displayMap();
            userInput = IR5Manipulate.getString("\n(type help to see commands) >> ").toLowerCase();
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
                    Menu.showHelpMenu();
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

                case "leave":
                System.out.println("AHAHAHAHA leave where? You are stuck in here!");
                System.out.println("What was that?");
                    break;
                
                
                case "exit": // exit program
                    break;
                
                default: 
                    System.out.println("* Those were not any of the selections");
            }            
            
        }
    }
}