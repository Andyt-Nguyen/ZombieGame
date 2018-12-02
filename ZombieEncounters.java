import java.util.Scanner;

public class ZombieEncounters {
    private static Scanner scanner = new Scanner(System.in);
    private Player player;
    private int PLAYER;
    private int[][] grid;
    private Kitchen[] kiArr;
    private Bedroom[] bArr;

    public ZombieEncounters(int PLAYER, int[][] grid, Player player, Kitchen[] kiArr, Bedroom[] bArr) {
        this.PLAYER = PLAYER;
        this.grid = grid;
        this.player = player;
        this.kiArr = kiArr;
        this.bArr = bArr;
    }

    // When a user encounters a zombie moving backwards
    public void moveLeft() {
        if (player.getXpos() - 1 < 0) {
            System.out.println("* You hit a wall");
        } else {
            int playerPos = grid[player.getYpos()][player.getXpos() - 1];
            if (playerPos >= 10 && playerPos <= 20) objectEncounter(grid, player, findId(kiArr, playerPos));
            else if(playerPos >= 20 && playerPos < 30) objectEncounter(grid, player, findId(bArr, playerPos));
            else mvmAndMsg("* You move west", "left");
        }
    }

    // When a user encounters a zombie moving forward
    public void moveRight() {
        // Player Moves
        if (player.getXpos() + 1 > grid[0].length - 1) {
            System.out.println("* You hit a wall");
        } else {
            int playerPos = grid[player.getYpos()][player.getXpos() + 1];
            if (playerPos >= 10 && playerPos <= 20) objectEncounter(grid, player, findId(kiArr, playerPos));
            else if (playerPos >= 20 && playerPos < 30)objectEncounter(grid, player, findId(bArr, playerPos));
            else mvmAndMsg("* You move east", "right");
        }
    }

    // When a user encounters a zombie moving upwards
    public void moveUp() {
        if (player.getYpos() - 1 < 0) {
            System.out.println("* You hit a wall");
        } else {
            int playerPos = grid[player.getYpos() - 1][player.getXpos()];
            if (playerPos >= 10 && playerPos <= 20) objectEncounter(grid, player, findId(kiArr, playerPos));
            else if(playerPos >= 20 && playerPos < 30)objectEncounter(grid, player, findId(bArr, playerPos));
            else mvmAndMsg("* You move north", "up");
        }
    }

    // When a user encounters a zombie moving downwards
    public void moveDown() {
        if (player.getYpos() + 1 > grid.length - 1) {
            System.out.println("* You hit a wall");
        } else {
            int playerPos = grid[player.getYpos() + 1][player.getXpos()];
            if (playerPos >= 10 && playerPos <= 20) objectEncounter(grid, player, findId(kiArr, playerPos));
            else if(playerPos >= 20 && playerPos < 30)objectEncounter(grid, player, findId(bArr, playerPos));
            else mvmAndMsg("* You move south", "down");
        }
    }

    public void objectEncounter(int[][] grid, Player player, Room room) {
        if(room.haveDoor()) {
            System.out.println("You slammed your head against a door");
            System.out.println("and you take second to look at it");
        }
        String userInput = "";
        while (player.getHp() > 0) {
            userInput = ZombieGame.getString("\n(type help to see commands)>> ");
            String[] splitUserInput = userInput.split(" ");
            String object = "";
            if (splitUserInput.length == 2) {
                String verb = splitUserInput[0];
                String noun = splitUserInput[1];
                if (verb.equals("pickup")) {
                    if(object.equals("")) room.getItem(noun, player);
                    else room.getItem(noun, player);
                } else if(verb.equals("goto")) {
                    room.setObjectInPlay(noun);
                } else if (verb.equals("open")) {
                    room.open(noun);
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
                    room.enter(noun);
                } else if(verb.equals("leave")) {
                    room.leave(noun);
                    break;
                } else if(verb.equals("readmy") && noun.equals("notes")) {
                    System.out.println(player.getNotes());
                } else if(verb.equals("writedown")) {
                    player.writeNote(noun);
                } else if(verb.equals("examine")) {
                    room.examine(noun);
                } else if(verb.equals("walk")) {
                    if(noun.equals("east") ||
                       noun.equals("west") ||
                       noun.equals("north") ||
                       noun.equals("south")) {
                           System.out.println("You back away from the door and now in the hallway");
                        break;
                        }
                }
            } else {
                String verb = splitUserInput[0];
                if (verb.equals("lookaround")) {
                    room.lookAround();
                } else if(verb.equals("inventory")) {
                    player.getInventory();
                } else if(verb.equals("clearnotes")) {
                    player.clearNotes();
                } else if(verb.equals("eat")) {
                    player.eat();
                } else if(verb.equals("help")) {
                    ZombieGame.showHelpMenu();
                } else {
                    System.out.println("I've never heard of this before");
                }
            }
        }
    }

    public void lookAround(Player player, int[][]grid) {
        if (player.getXpos() - 1 < 0) {
            System.out.print("");
        } else {
            int playerPos = grid[player.getYpos()][player.getXpos() - 1];
            if (playerPos >= 10 && playerPos <= 20)  System.out.println("There is a door west of you");
            else if(playerPos >= 20 && playerPos < 30)System.out.println("There is a door west of you");
        }

        if (player.getXpos() + 1 > grid[0].length - 1) {
            System.out.print("");
        } else {
            int playerPos = grid[player.getYpos()][player.getXpos() + 1];
            if (playerPos >= 10 && playerPos <= 20) System.out.println("There is a door east of you");
            else if (playerPos >= 20 && playerPos < 30)System.out.println("There is a door east of you");
        }

        if (player.getYpos() - 1 < 0) {
            System.out.print("");
        } else {
            int playerPos = grid[player.getYpos() - 1][player.getXpos()];
            if (playerPos >= 10 && playerPos <= 20) System.out.println("There is a door north of you");
            else if(playerPos >= 20 && playerPos < 30)System.out.println("There is a door north of you");
        }

        if (player.getYpos() + 1 > grid.length - 1) {
            System.out.print("");
        } else {
            int playerPos = grid[player.getYpos() + 1][player.getXpos()];
            if (playerPos >= 10 && playerPos <= 20) System.out.println("There is a door south of your");
            else if(playerPos >= 20 && playerPos < 30)System.out.println("There is a door south of you");
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

    private Room findId(Room[] room, int id) {
        for(int i = 0; i < room.length; i++) {
            if(room[i].getId() == id) {
                return room[i];
            }
        }
        return null;
    }
}











               // else if (verb.equals("move")) {
                //     if (noun.equals("east")) {
                //         if (player.getXpos() + 2 <= grid[0].length - 1) {
                //             if (grid[player.getYpos()][player.getXpos() + 2] == 0) {
                //                 System.out.println("You take a step out of the " + room.getName());
                //                 System.out.println("And move east");
                //                 grid[player.getYpos()][player.getXpos()] = 0;
                //                 player.moveRight(2);
                //                 break;
                //             }
                //         } else {
                //             System.out.println("You walked into the " + room.getName() + " wall");
                //             System.out.println("and slammed your head. Ouch!");
                //         }
                //     } else if (noun.equals("west")) {
                //         if (player.getXpos() - 2 >= 0) {
                //             if (grid[player.getYpos()][player.getXpos() - 2] == 0) {
                //                 System.out.println("You take a step out of the " + room.getName());
                //                 System.out.println("And move west");
                //                 grid[player.getYpos()][player.getXpos()] = 0;
                //                 player.moveLeft(2);
                //                 break;
                //             }
                //         } else {
                //             System.out.println("You walked into the " + room.getName() + " wall");
                //             System.out.println("and slammed your head. Ouch!");
                //         }
                //     } else if (noun.equals("south")) {
                //         if (player.getYpos() + 2 <= grid[0].length - 1) {
                //             if (grid[player.getYpos() + 2][player.getXpos()] == 0) {
                //                 System.out.println("You take a step out of the " + room.getName());
                //                 System.out.println("And move south");
                //                 grid[player.getYpos()][player.getXpos()] = 0;
                //                 player.moveDown(2);
                //                 break;
                //             }
                //         } else {
                //             System.out.println("You walked into the " + room.getName() + " wall");
                //             System.out.println("and slammed your head. Ouch!");
                //         }
                //     } else if (noun.equals("north")) {
                //         if (player.getYpos() - 2 >= 0) {
                //             if (grid[player.getYpos() - 1][player.getXpos()] == 0) {
                //                 System.out.println("You take a step out of the " + room.getName());
                //                 System.out.println("And move south");
                //                 grid[player.getYpos()][player.getXpos()] = 0;
                //                 player.moveUp(2);
                //                 break;
                //             }
                //         } else {
                //             System.out.println("You walked into the " + room.getName() + " wall");
                //             System.out.println("and slammed your head. Ouch!");
                //         }
                //     } else {
                //         System.out.println("I don't know that noun");
                //     }
                // }