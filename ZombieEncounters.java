
public class ZombieEncounters {
    private Player player;
    private int PLAYER;
    private int[][] grid;
    private SuperRoom[] superRooms;

    public ZombieEncounters(int PLAYER, int[][] grid, Player player, SuperRoom[] superRooms) {
        this.PLAYER = PLAYER;
        this.grid = grid;
        this.player = player;
        this.superRooms = superRooms;
    }

    // When a user encounters a zombie moving backwards
    public void moveLeft() {
        if (player.getXpos() - 1 < 0) {
            System.out.println("You ran into a wall. You unforunately took damage");
            player.decreaseHp(IR5.getRandomNumber(5, 10));
        } else {
            int playerPos = grid[player.getYpos()][player.getXpos() - 1];
            if (playerPos >= 10 && playerPos <= 50) objectEncounter(grid, player, findId(superRooms, playerPos));
            else if(playerPos == 100) {
                System.out.println("You ran into a wall. You unforunately took damage");
                player.decreaseHp(IR5.getRandomNumber(5, 10));
            }
            // else if(playerPos >= 20 && playerPos < 30) objectEncounter(grid, player, findId(superRooms, playerPos));
            else mvmAndMsg("* You move west", "left");
        }
    }

    // When a user encounters a zombie moving forward
    public void moveRight() {
        // Player Moves
        if (player.getXpos() + 1 > grid[0].length - 1) {
            System.out.println("You ran into a wall. You unforunately took damage");
            player.decreaseHp(IR5.getRandomNumber(5, 10));
        } else {
            int playerPos = grid[player.getYpos()][player.getXpos() + 1];
            if (playerPos >= 10 && playerPos <= 50) objectEncounter(grid, player, findId(superRooms, playerPos));
            else if(playerPos == 100) {
                System.out.println("You ran into a wall. You unforunately took damage");
                player.decreaseHp(IR5.getRandomNumber(5, 10));
            }
            // else if (playerPos >= 20 && playerPos < 30)objectEncounter(grid, player, findId(superRooms, playerPos));
            else mvmAndMsg("* You move east", "right");
        }
    }

    // When a user encounters a zombie moving upwards
    public void moveUp() {
        if (player.getYpos() - 1 < 0) {
            System.out.println("You ran into a wall. You unforunately took damage");
            player.decreaseHp(IR5.getRandomNumber(5, 10));
        } else {
            int playerPos = grid[player.getYpos() - 1][player.getXpos()];
            if (playerPos >= 10 && playerPos <= 50) objectEncounter(grid, player, findId(superRooms, playerPos));
            else if(playerPos == 100) {
                System.out.println("You ran into a wall. You unforunately took damage");
                player.decreaseHp(IR5.getRandomNumber(5, 10));
            }
            // else if(playerPos >= 20 && playerPos < 30)objectEncounter(grid, player, findId(superRooms, playerPos));
            else mvmAndMsg("* You move north", "up");
        }
    }

    // When a user encounters a zombie moving downwards
    public void moveDown() {
        if (player.getYpos() + 1 > grid.length - 1) {
            System.out.println("* You hit a wall");
        } else {
            int playerPos = grid[player.getYpos() + 1][player.getXpos()];
            if (playerPos >= 10 && playerPos <= 50) objectEncounter(grid, player, findId(superRooms, playerPos));
            else if(playerPos == 100) {
                System.out.println("You ran into a wall. You unforunately took damage");
                player.decreaseHp(IR5.getRandomNumber(0, 10));
            }
            // else if(playerPos >= 20 && playerPos < 30)objectEncounter(grid, player, findId(superRooms, playerPos));
            else mvmAndMsg("* You move south", "down");
        }
    }

    public void objectEncounter(int[][] grid, Player player, SuperRoom room) {
        if(!room.getIsDoorOpen()) {
            System.out.println("You slammed your head against a door");
            System.out.println("and you take second to look at it");
        } else {
            System.out.println("You are about to step into the " + room.getName());
        }
        String userInput = "";
        int toxicCounter = 0;
        while (player.getHp() > 0) {

            if(room.isToxic()) {
                toxicCounter++;
                if(toxicCounter == 1 || toxicCounter == 5) {
                    System.out.println("You breath heavily in this room.\n** Cough! Cough!");
                }

                if(player.getHp() < 40) {
                    System.out.println("You feel weak my breaths are becoming so heavy");
                }
                player.decreaseHp(IR5.getRandomNumber(5, 7));
            }
            userInput = IR5Manipulate.getString("\n(type help to see commands)>> ");
            String[] splitUserInput = userInput.split(" ");
            String object = "";
            if (splitUserInput.length >= 2) {
                String verb = splitUserInput[0];
                String noun = splitUserInput[1];
                if (verb.equals("pickup")) {
                    if(object.equals("")) room.getItem(noun, player);
                    else room.getItem(noun, player);
                } else if(verb.equals("goto")) {
                    room.setObjectInPlay(noun);
                } else if (verb.equals("open")) {
                    room.open(noun);
                } else if(verb.equals("lookunder")) {
                    room.lookUnder(noun);
                } else if(verb.equals("breakinto")) {
                    if(player.getKnifeCount() > 0) {
                        int damage = room.breakInto(noun);
                        player.decreaseHp(damage);
                        player.decreaseKnifeCount();
                    } else {
                        System.out.println("You look frivilously check your back and front pockets");
                        System.out.println("and alas you have no knife");
                    }
                } else if (verb.equals("uncover")) {
                    room.unCover(noun);
                } else if (verb.equals("search")) {
                    room.search(noun);
                } else if (verb.equals("read")) {
                    room.read(noun);
                } else if(verb.equals("scream")) {
                    player.scream();
                } else if(verb.equals("kick")) {
                    room.kick();
                } else if(verb.equals("enter")) {
                    String userRoom = "";
                    for(int i = 1; i < splitUserInput.length; i++) {
                        userRoom += splitUserInput[i] + " ";
                    }
                    room.enter(userRoom);
                } else if(verb.equals("leave")) {
                    room.leave(noun);
                    toxicCounter = 0;
                    break;
                } else if(verb.equals("unlock")) {
                    if(noun.equals("vault")) {
                        System.out.println("I can't unlock this thing it doesn't have any key holes");
                    } else {
                        if(player.getKeyCount() > 0) {
                            room.unlock(noun);
                            player.useKey();
                        } else {
                            System.out.println("You look in your back and front pockets");
                            System.out.println("and alas you have no key");
                        }
                    }
                } else if(verb.equals("writedown")) {
                    String userNotes = "";
                    for(int i = 1; i < splitUserInput.length; i++) {
                        userNotes += splitUserInput[i] + " ";
                    }
                    player.writeNote(userNotes + "\n");
                } else if(verb.equals("code")) {
                    room.unlock(noun);
                } else if(verb.equals("readmy") && noun.equals("notes")) {
                    System.out.println(player.getNotes());
                } else if(verb.equals("examine")) {
                    room.examine(noun);
                } else if(verb.equals("walk")) {
                    if(noun.equals("east") ||
                       noun.equals("west") ||
                       noun.equals("north") ||
                       noun.equals("south")) {
                           System.out.println("You walked " + noun + " and you found your self where you started where you entered the room");
                        break;
                        }
                } else {
                    System.out.println("I do not understand your command");
                }
            } else if(splitUserInput.length == 1) {
                String verb = splitUserInput[0];
                if (verb.equals("lookaround")) {
                    room.lookAround();
                } else if(verb.equals("checkhealth")) {
                    player.checkHealth();
                } else if(verb.equals("inventory")) {
                    player.getInventory();
                } else if(verb.equals("clearnotes")) {
                    player.clearNotes();
                } else if(verb.equals("eat")) {
                    player.eat();
                } else if(verb.equals("help")) {
                    Menu.showHelpMenu();
                } else {
                    System.out.println("I've never heard of this before");
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
                System.out.println("Game over");
            }
        }
    }

    public void lookAround(Player player, int[][]grid) {
        if (player.getXpos() - 1 < 0) {
            System.out.print("");
        } else {
            int playerPos = grid[player.getYpos()][player.getXpos() - 1];
            if (playerPos >= 10 && playerPos <= 20)  System.out.println("You smell something great at the same time disgusting west of you");
            else if(playerPos >= 20 && playerPos < 30) System.out.println("You hear sounds of children playing inside a room west of you");
            else if(playerPos >= 30 && playerPos < 40)System.out.println("You hear running water inside of a giant room west of you");
            else if(playerPos == 100) System.out.println("You sense that there is a wall west of you");
            else {
                System.out.println("There is nothing west of you");
            }
        }

        if (player.getXpos() + 1 > grid[0].length - 1) {
            System.out.print("");
        } else {
            int playerPos = grid[player.getYpos()][player.getXpos() + 1];
            if (playerPos >= 10 && playerPos <= 20) System.out.println("You smell something great at the same time disgusting east of you");
            else if (playerPos >= 20 && playerPos < 30) System.out.println("You hear sounds of children playing inside a room east of you");
            else if(playerPos >= 30 && playerPos < 40) System.out.println("You hear running water inside of a giant room east of you");
            else if(playerPos == 100) System.out.println("You sense that there is a wall east of you");
            else {
                System.out.println("There is nothing east of you");
            }
        }

        if (player.getYpos() - 1 < 0) {
            System.out.print("");
        } else {
            int playerPos = grid[player.getYpos() - 1][player.getXpos()];
            if (playerPos >= 10 && playerPos <= 20) System.out.println("You smell something great at the same time disgusting north of you"); 
            else if(playerPos >= 20 && playerPos < 30) System.out.println("You hear sounds of children playing inside a room north of you");
            else if(playerPos >= 30 && playerPos < 40)System.out.println("You hear running water inside of a giant room north of you");
            else if(playerPos == 100) System.out.println("You sense that there is a wall north of you");
            else {
                System.out.println("There is nothing north of you");
            }
        }

        if (player.getYpos() + 1 > grid.length - 1) {
            System.out.print("");
        } else {
            int playerPos = grid[player.getYpos() + 1][player.getXpos()];
            if (playerPos >= 10 && playerPos <= 20) System.out.println("You smell something great at the same time disgusting south of you"); 
            else if(playerPos >= 20 && playerPos < 30) System.out.println("You hear sounds of children playing inside a room south of you");
            else if(playerPos >= 30 && playerPos < 40)System.out.println("You hear running water inside of a giant room south of you");
            else if(playerPos == 100) System.out.println("You sense that there is a wall south of you");
            else {
                System.out.println("There is nothing south of you");
            }
        }
    }

    // Moves player downward and erases last previous step
    private void playerMovements(String dir) {
        grid[player.getYpos()][player.getXpos()] = 0;
        if (dir.equals("left"))
            player.moveLeft(0);
        else if (dir.equals("right"))
            player.moveRight(0);
        else if (dir.equals("up"))
            player.moveUp(0);
        else if (dir.equals("down"))
            player.moveDown(0);
        grid[player.getYpos()][player.getXpos()] = PLAYER;
    }

    // Player movements and message
    private void mvmAndMsg(String msg, String mvm) {
        System.out.println(msg);
        playerMovements(mvm);
        System.out.println("");
    }

    private SuperRoom findId(SuperRoom[] room, int id) {
        for(int i = 0; i < room.length; i++) {
            if(room[i].getId() == id) {
                return room[i];
            }
        }
        return null;
    }
}

