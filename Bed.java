public class Bed {
    private boolean isSheets;
    private int knife;
    private int food;
    private int key;
    private String note;
    private boolean doesExist;
    
    public Bed() {
        doesExist = false;
    }

    public Bed(boolean isSheets, int knife, int food, int key, String note) {
        this.isSheets = isSheets;
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
                "Key is in pocket. Let me check...\n Yep it's there",
                "I got the key!"
            };
            System.out.println(keyPickupString[IR5.getRandomNumber(0, keyPickupString.length -1)]);
            player.addToItem("key", key);
            key = 0;
        } else {
            System.out.println("You can't pick that up");
        }
    }

    public void unCoverBed() {
        if(isSheets) {
            System.out.println("You already uncovered the sheets");
        } else {
            isSheets = true;
            String[] uncoverStrings = {
                "With great force you uncovered the bed sheets.",
                "You roll on the bed and rap yourself like a burrito and unconver the bed.",
                "You take your hands and grab the end of the sheet and rolled it in a shape of a churro.",
                "You take the sheet and kicked it across the bed. Leaving the bed open."
            };
            System.out.println(uncoverStrings[IR5.getRandomNumber(0, uncoverStrings.length - 1)]);
        }
    }

    public void search() {
        if(isSheets) {
            if(!note.equals("") || knife > 0 || key > 0) {
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
            }
        } else {
            if(!note.equals("") || knife > 0) {
                String[] underTheBedStrings = {
                    "The bed looks like it has something on it",
                    "Oh my gosh is there something under the bed. I'm afraid to look",
                    "Is someone under that bed?",
                    "The bed has a hump on it."
                };
                System.out.println(underTheBedStrings[IR5.getRandomNumber(0, underTheBedStrings.length - 1)]);
            } else {
                String[] nothingHereStrings = {
                    "Nope nothing over here",
                    "I don't see anything over here",
                    "There is nothing over here",
                    "Nothing suspicious here"
                };
                System.out.println(nothingHereStrings[IR5.getRandomNumber(0, nothingHereStrings.length - 1)]);
            }
        }
    }

    public void read() {
        if(note.equals("")) {
            System.out.println("There's nothing here");
        } else {
            if(isSheets) {
                System.out.println(note);
            } else {
                System.out.println("I cant read anything");
            }
        }
    }

    public void examine() {
        System.out.println("Bed has a nice textured blanket");
    }

    public boolean getDoesExist() {
        return doesExist;
    }

}