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
        if(isDrawer) {
            if(!note.equals("") || knife > 0) {

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
                        "There's is a piece of metal that has a unique design. It's a key",
                        "There is a key that rains down with happiness",
                        "This key looks like it can be used to open stuff right? Yea okay."
                    };
                    System.out.println(findingKey[IR5.getRandomNumber(0, findingKey.length - 1)]);
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