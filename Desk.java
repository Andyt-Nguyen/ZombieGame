public class Desk {
    private boolean isSheets;
    private int knife;
    private int food;
    private String note;
    private boolean doesExist;
    
    public Desk() {
        doesExist = false;
    }

    public Desk(boolean isSheets, int knife, int food, String note) {
        this.isSheets = isSheets;
        this.knife = knife;
        this.food = food;
        this.note = note;
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

    public void unCoverBed() {
        if(isSheets) {
            System.out.println("You already uncovered the sheets");
        } else {
            isSheets = true;
            System.out.println("With great force you uncovered the bed sheets");
        }
    }

    public void search() {
        if(isSheets) {
            if(!note.equals("") || knife > 0) {
                if(!note.equals("")) {
                    System.out.println("You found a note with words written on it. Looks like english");
                }
    
                if(knife > 0) {
                    System.out.println("Look at that there seems to be a knife stabbed into the sheets");
                }
            }
        } else {
            if(!note.equals("") || knife > 0) {
                System.out.println("The bed has a hump on it.");
            } else {
                System.out.println("Nothing suspicious here");
            }
        }
    }

    public void read() {
        if(note.equals("")) {
            System.out.println("There's nother here");
        } else {
            if(isSheets) {
                System.out.println(note);
            } else {
                System.out.println("I cant read anything");
            }
        }
    }

    public void examine() {
        System.out.println("Desk has a nice textured blanket");
    }

    public boolean getDoesExist() {
        return doesExist;
    }

}