public class Room {
    private String name;
    private boolean isDoor;
    private boolean isEnter;
    
    public Room(String name, boolean isDoor) {
        this.name = name;
        this.isDoor = isDoor;
        this.isEnter = false;
    }

    public String getName() {
        return name;
    }

    public boolean haveDoor() {
        return isDoor;
    }

    public void getItem(String item, Player player) {
        System.out.println("Theres nothing there to pick up");
    }

    public void open(String object) {
        System.out.println("You can't open that!");
    }

    public void checkOut(String object) {
        System.out.println("There' s nothing to checkout");
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
            isEnter = true;
            System.out.println("You have entered the " + name.toLowerCase());
        } else {
            System.out.println("You can't enter into that friend");
        }
    }

    public boolean getEnter() {
        return isEnter;
    }

    public void leave(String noun) {
        if(noun.equals(name.toLowerCase())) {
            isEnter = false;
            System.out.println("You have left the " + name.toLowerCase());
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