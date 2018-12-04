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
        if(player.getHp() < 0) {
            System.out.println(
            "Let me die a youngman's death\n" +
            "not a clean and inbetween\n"     +
            "the sheets holywater death\n"    +
            "not a famous-last-words\n"       +
            "peaceful out of breath death\n"  +
            "\nWhen I'm 73\n"                 +
            "and in constant good tumour\n"   +
            "may I be mown down at dawn\n"    +
            "by a bright red sports car\n"    +
            "on my way home\n"                +
            "from an allnight party\n"        +
            
            "\nOr when I'm 91\n"                   +
            "with silver hair\n"                   +
            "and sitting in a barber's chair\n"    +
            "may rival gangsters\n"                +
            "with hamfisted tommyguns burst in\n"    +
            "and give me a short back and insides\n" +
            
            "\nOr when I'm 104\n"                    +
            "and banned from the Cavern\n"           +
            "may my mistress\n"                      +
            "catching me in bed with her daughter\n" +
            "and fearing for her son\n"              +
            "cut me up into little pieces\n"         +
            "and throw away every piece but one\n"   +
            
            "\nLet me die a youngman's death\n"      +
            "not a free from sin tiptoe in\n"        +
            "candle wax and waning death\n"          +
            "not a curtains drawn by angels borne\n" +
            "'what a nice way to go' death\n"        +
            "- Dylan Thomas");
            System.out.println("\nGame over");
        }
    }
}