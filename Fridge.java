public class Fridge {
    private String note;
    private int knife;
    private int food;
    private boolean isOpen;
    private boolean doesExist;

    public Fridge() {
        doesExist = false;
    }

    public Fridge(boolean isOpen, int knife, int food, String note) {
        this.isOpen = isOpen;
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
            System.out.println("Are you proud of that? Might eat it for later.");
            player.addToItem("food", food);
            food = 0;
        } else {
            System.out.println("You can't pick that up");
        }
    }

    public void search() {
        if(isOpen) {
            if(food > 0 || knife > 0 || !note.equals("")) {
                if(food > 0) {
                    String[] findFood = {
                        "You found some food in this fridge",
                        "Hey look it that there's a piece of food",
                        "That food looks gross but at same time looks good",
                        "Food!"
                    };
                    System.out.println(findFood[IR5.getRandomNumber(0, findFood.length- 1)]);
                }
                if(!note.equals("")) {
                    String[] findingNote = {
                        "You found a note with words written on it. Looks like english",
                        "A note was found and it has letters combined to it to make words. I wonder what it says.",
                        "OH boyy you found a note!",
                        "The note has writing on it. Sweeeet"
                    };
                    System.out.println(findingNote[IR5.getRandomNumber(0, findingNote.length - 1)]);
                }
    
                if(knife > 0) {
                    String[] findingKnife = {
                        "There is a knife just laying there. Weird.",
                        "This thing looks shiny and has a handle. Oh my gosh it's a knife!",
                        "The knife of thousands knives lies on this bed",
                        "Look at that there seems to be a knife stabbed into the sheets"
                    };
                    System.out.println(findingKnife[IR5.getRandomNumber(0, findingKnife.length - 1)]);
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
        System.out.println("There are weird marks on it probably not that important");
    }

    public boolean getDoesExist() {
        return doesExist;
    }

    public void read() {
        if(note.equals("")) {
            System.out.println("There's nother here");
        } else {
            if(isOpen) {
                System.out.println(note);
                System.out.println("I might need to take note of this.");;
            } else {
                System.out.println("I cant read anything");
            }
        }
    }
}