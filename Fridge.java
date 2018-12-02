public class Fridge {
    private int knife;
    private int food;
    private boolean isOpen;
    private boolean doesExist;

    public Fridge() {
        knife = 0;
        food = 0;
        isOpen = false;
        doesExist = false;
    }

    public Fridge(boolean isOpen, int knife, int food) {
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
            player.addToItem("food", food);
            System.out.println("Are you proud of that? Might eat it for later.");
            food = 0;
        } else {
            System.out.println("You can't pick that up");
        }
    }

    public void search() {
        if(isOpen) {
            if(food > 0 || knife > 0) {
                if(food > 0) {
                    System.out.println("You found some scraps of food in the frideg");
                    System.out.println("The food looks filthy! But I kind of want it");
                }
                if(knife > 0) {
                    System.out.println("There is a sharp metal knife in here");
                }
    
            } else {
                System.out.println("There isn't anything here");
            }
        } else {
            System.out.println("Looks like a nice closed fridge");
        }
    }

    public void open() {
        if(isOpen) {
            System.out.println("Fridge is already open");
        } else {
            isOpen = true;
            System.out.println("You have opened the fridge");
        }
    }

    public void examine() {
        System.out.println("The fridge looks interesting");
        System.out.println("I want to build one.");
    }

    public boolean getDoesExist() {
        return doesExist;
    }

}