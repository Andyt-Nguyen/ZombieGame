public class Room {
    private int id;
    private String name;
    private boolean isDoorOpen;
    private boolean isEnter;
    private boolean isLocked;
    
    public Room(int id, String name, boolean isDoorOpen, boolean isLocked) {
        this.name = name;
        this.isDoorOpen = isDoorOpen;
        this.isEnter = false;
        this.id = id;
        this.isLocked = isLocked;
    }

 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getIsDoorOpen() {
        return isDoorOpen;
    }

    public void setObjectInPlay(String objectInPlay) {
        System.out.println("That isn't a place you can walk to");
    }

    public void getItem(String item, Player player) {
        System.out.println("Theres nothing there to pick up");
    }

    public void open(String object) {
        if(isLocked) {
            System.out.println("the door is locked");
        } else {
            if(!isDoorOpen) {
                if(object.equals("door")) {
                    System.out.println("You turn the door knob");
                    System.out.println("You have opened the door");
                    isDoorOpen = true;
                } else {
                    System.out.println("You can't open that!");
                } 
            } else {
                System.out.println("Door is open for bussiness");
            }
        }
    }


    public void read(String item) {
        System.out.println("You can't read that!");
    }

    public void unCover(String object) {
        System.out.println("There is nothing to uncover");
    }

    public void search(String object) {
        System.out.println("There is nothing to search here");
    }

    public void lookAround() {
        System.out.println("Theres nothing around you");
    }

    public void enter(String noun) {
        if(noun.equals(name.toLowerCase())) {
            if(isLocked) {
                System.out.println("The door is locked");
            } else {
                isEnter = true;
                System.out.println("You have entered the " + name.toLowerCase());
            }
        } else {
            System.out.println("You can't enter into that friend");
        }
    }

    public void unlock(String noun) {
        isLocked = false;
        System.out.println("You have unlocked the " + noun);
    }

    public int breakInto(String noun) {
        if(noun.equals("door")) {
            int chances = IR5.getRandomNumber(1, 5);
            if(chances >= 3) {
                isLocked = false;
                System.out.println("You hear a click and the doorknob is loose");
                System.out.println("but took some damage.");
                return IR5.getRandomNumber(5, 8);
            } else {
                System.out.println("Your knife broke and you took some damage");
                return IR5.getRandomNumber(12,15);
            }
        } else {
            System.out.println("You can't break into there");
            return -1;
        }
    }

    public boolean getEnter() {
        return isEnter;
    }

    public void leave(String noun) {
        if(noun.equals(name.toLowerCase())) {
            isEnter = false;
            System.out.println("You have left the " + name.toLowerCase());
            System.out.println("and back in the hallway");
        } else {
            System.out.println("What?");
        }
    }

    public void kick() {
        System.out.println("Hey! You can't kick that.");
    }

    public void examine(String item) {
        if(item.equals("door")) {
            System.out.println("The door has strange markings. Looks like a " + this.name.toLowerCase());
        }
    }
}