public class Closet {
    private boolean isOpen;
    private int knife;
    private int food;
    private boolean doesExist;

    public Closet() {
        doesExist = false;
    }

    public Closet(boolean isOpen, int knife, int food) {
        this.isOpen = isOpen;
        this.knife = knife;
        this.food = food;
        doesExist = true;
    }

    public void getItem(String item, Player player) {
        if(item.equals("knife")) {
            System.out.println("Oooo so nice and shiny.");
            player.addToItem(item, knife);
            knife = 0;
        } else if(item.equals("food")) {
            System.out.println("Nice you put that piece of food in your pocket.");
            System.out.println("Are you proud of that? Might eat it for later.");
            player.addToItem("food", food);
            food = 0;
        } else {
            System.out.println("You can't pick that up");
        }
    }

    public void search() {
        if(isOpen) {
            if(food > 0 || knife > 0) {
                if(food > 0) {
                    System.out.println("You find meat rotting in the closet.");
                    System.out.println("The food looks filthy! But I kind of want it");
                }
                if(knife > 0) {
                    System.out.println("There is a sharp metal knife in here");
                }
    
            } else {
                System.out.println("There isn't anything here");
            }
        } else {
            System.out.println("Looks like a nice closed closet");
        }
    }

    public void open() {
        if(this.isOpen) {
            System.out.println("Closet is already open");
        } else {
            isOpen = true;
            System.out.println("You have opened the closet");
        }
    }

    public void examine() {
        System.out.println("Ooo I wonder if that closet has cereal. I'm starving!");
    }

    public boolean getDoesExist() {
        return doesExist;
    }

}