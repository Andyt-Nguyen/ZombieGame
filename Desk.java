public class Desk {
    private boolean isDrawer;
    private int knife;
    private int food;
    private String note;
    private boolean doesExist;
    private int key;
    private Lamp lamp;
    
    public Desk() {
        doesExist = false;
    }

    public Desk(boolean isDrawer, int knife, int food, int key, String note, Lamp lamp) {
        this.knife = knife;
        this.food = food;
        this.note = note;
        this.isDrawer = false;
        this.lamp = lamp;
        this.key = key;
        doesExist = true;
    }

    public void open() {
        if(isDrawer) {
            System.out.println("You already opened the drawer");
        } else {
            isDrawer = true;
            System.out.println("You have opened the drawer");
        }
    }

    public void lookUnder(String noun) {
        if(noun.equals("lamp")) {
            lamp.lookUnder();
        }
    }
    public void getItem(String item, Player player) {
        if(knife > 0 || food > 0 || key > 0) {
            if(item.equals("knife") && knife > 0) {
                System.out.println("Oooo so nice and shiny.");
                player.addToItem(item, knife);
                knife = 0;
            } else if(item.equals("food") && food > 0) {
                String[] foodPickupString = {
                    "Hey you picked up a piece of food. Yummy yummy",
                    "Yummy yummy food for me tummy",
                    "Yum yum tum tum",
                    "Kinda looks like a burger or a hotdog? I don't know lets put that in the pocket"
                };
                System.out.println(foodPickupString[IR5.getRandomNumber(0, foodPickupString.length -1)]);
                player.addToItem("food", food);
                food = 0;
            } else if(item.equals("key") && key > 0) {
                String[] keyPickupString = {
                    "You picked up the key nice!",
                    "This nice shiny will go into my pocket",
                    "Key is in pocket. Let me check. Yep it's there",
                    "I got the key!"
                };
                System.out.println(keyPickupString[IR5.getRandomNumber(0, keyPickupString.length -1)]);
                player.addToItem("key", key);
                key = 0;
            } else {
                System.out.println("There is no item of that here");
            }
        } else {
            System.out.println("There's nothing in here");
        }
    }

    public void search() {
        if(isDrawer) {
            if(!note.equals("") || knife > 0 || key > 0 || food > 0) {

                if(!note.equals("")) {
                    String[] findingNote = {
                        "You found a note with words written on it. Looks like english",
                        "A note was found and it has letters combined to it to make words. I wonder what it says.",
                        "OH boyy you found a note!",
                        "The note has writing on it. Sweet!"
                    };
                    System.out.println(findingNote[IR5.getRandomNumber(0, findingNote.length - 1)]);
                }
    
                if(knife > 0) {
                    String[] findingKnife = {
                        "There is a knife just laying there. Weird.",
                        "This thing looks shiny and has a handle. Oh my gosh it's a knife!",
                        "It looks like the knife that has been used to open soup cans with.\nYou know what I'm talking. Ok I'll stop talking.",
                        "Is that David Bowie's knife? The bowie knife? Eh probably not."
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
                System.out.println("There is nothing in here");
            }
        } else {
            if(!note.equals("") || knife > 0 ) {
                String[] hintDrawer = {
                    "Oh look there's a drawer here",
                    "Hmm I wonder whats in that drawer",
                    "A drawer is in the midst of this desk",
                    "That drawer looks pretty interesting"
                };
                System.out.println(hintDrawer[IR5.getRandomNumber(0, hintDrawer.length - 1)]);
            } else {
                if(lamp.getDoesExist()) {
                    String[] findingLamp = {
                        "Oh look there is a lamp here",
                        "That lamp is really bright",
                        "The lamp is really brightens up the room",
                        "I wonder why this lamp turns on and off sometimes. I don't think it can be fixed"
                    };
        
                    System.out.println(findingLamp[IR5.getRandomNumber(0, findingLamp.length - 1)]);
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
    }

    public void read() {
        if(lamp.getDoesExist() && lamp.isLookUnder()) {
            lamp.read();
        } else if(note.equals("")) {
            System.out.println("There's nothing here");
        } else {
            if(isDrawer) {
                System.out.println(note);
            } else {
                System.out.println("I cant read anything");
            }
        }
    }

    public void examine(String item) {
        if(item.equals("lamp")) {
            lamp.examine();
        } else {
            System.out.println("This desk looks and unfashionable and I like it.");
            System.out.println("This desk has drawer.");
        }
    }

    public boolean getDoesExist() {
        return doesExist;
    }

}