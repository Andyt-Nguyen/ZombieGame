public class Vault {
    private boolean isOpen;
    private int vaultHp;
    private int knife;
    private int food;
    private int key;
    private String note;
    private boolean doesExist;
    private String passcode;

    public Vault() {
        doesExist = false;
    }

    public Vault(boolean isOpen,String passcode, int knife, int food, int key, String note) {
        this.vaultHp = 5;
        this.isOpen = isOpen;
        this.knife = knife;
        this.food = food;
        this.note = note;
        this.passcode = passcode;
        this.key = key;
        doesExist = true;
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
        if(isOpen) {
            if(food > 0 || knife > 0 || !note.equals("") || key > 0) {
                
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
                System.out.println("There isn't anything here");
            }
        } else {
            System.out.println("Looks like a nice closed vault");
        }
    }

    public int breakInto() {
        if(vaultHp <= 0) {
            isOpen = true;
            System.out.println("You hear a click and the vault became loose");
            System.out.println("but took some damage.");
            return IR5.getRandomNumber(2, 7);
        } else {
            vaultHp--;
            System.out.println("You hear the vault click but did not open. Your knife broke and you took some damage");
            return IR5.getRandomNumber(12,15);
        }
    }

    public boolean unlock(String usercode) {
        if(passcode.equals("")) {
            isOpen = true;
            return true;
        } else {
            if(passcode.equals(usercode)) {
                isOpen = true;
                System.out.println("\nSystem processing...");
                System.out.println("** Access Granted **\n");
                System.out.println("The vault door slowly opens...");
                return true;
            } else {
                System.out.println("\nSystem processing..");
                System.out.println("! Access Denied !\n");
                return false;
            }
        }
    }

    public void open() {
        if(this.isOpen) {
            System.out.println("Vault is already open");
        } else {
            System.out.println("You try to open the vault like a monster but it does not open");
        }
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

    public void examine() {
        System.out.println("Ooo I wonder if that valut has some treasure. I'm excited!");
    }

    public boolean getDoesExist() {
        return doesExist;
    }

}