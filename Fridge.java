public class Fridge {
    private String note;
    private int knife;
    private int food;
    private int key;
    private boolean isOpen;
    private boolean doesExist;

    public Fridge() {
        doesExist = false;
    }

    public Fridge(boolean isOpen, int knife, int food, int key,String note) {
        this.isOpen = isOpen;
        this.knife = knife;
        this.food = food;
        this.note = note;
        this.key = key;
        doesExist = true;
    }

    public void getItem(String item, Player player) {
        if(item.equals("knife")) {
            System.out.println("Oooo so nice and shiny.");
            player.addToItem(item, knife);
            knife = 0;
        } else if(item.equals("food")) {
            String[] foodPickupString = {
                "Hey you picked up a piece of food. Yummy yummy",
                "Yummy yummy food for me tummy",
                "Yum yum tum tum",
                "Kinda looks like a burger or a hotdog? I don't know lets put that in the pocket"
            };
            System.out.println(foodPickupString[IR5.getRandomNumber(0, foodPickupString.length -1)]);
            player.addToItem("food", food);
            food = 0;
        } else if(item.equals("key")) {
            String[] keyPickupString = {
                "You picked up the key nice!",
                "This nice shiny will go into my pocket",
                "Key is in pocket. Let me check...\nYep it's there",
                "I got the key!"
            };
            System.out.println(keyPickupString[IR5.getRandomNumber(0, keyPickupString.length -1)]);
            player.addToItem("key", key);
            key = 0;
        } else {
            System.out.println("You can't pick that up");
        }
    }

    public void search() {
        if(isOpen) {
            if(food > 0 || knife > 0 || !note.equals("") || key > 0) {
                
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

                if(key > 0) {
                    String[] findingKey = {
                        "There's a key here!",
                        "There's a piece of metal that has a unique design. It's a key",
                        "There is a key that rains down with happiness",
                        "This key looks like it can be used to open stuff right? Yea okay."
                    };
                    System.out.println(findingKey[IR5.getRandomNumber(0, findingKey.length - 1)]);
                }
                
                if(food > 0) {
                    String[] findingFood = {
                        "I'm so hungry. Luckily there is food here",
                        "I smell food and there is food!",
                        "I want the food now because there is food right there",
                        "There is food in here"
                    };
                    System.out.println(findingFood[IR5.getRandomNumber(0, findingFood.length - 1)]);

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