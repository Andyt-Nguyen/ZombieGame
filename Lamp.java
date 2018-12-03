public class Lamp {
    private boolean isLookUnder;
    private String note;
    private boolean doesExist;
    
    public Lamp() {
        doesExist = false;
    }

    public Lamp(String note) {
        this.note = note;
        this.isLookUnder = false;
        doesExist = true;
    }

    public void lookUnder() {
            if(!note.equals("")) {
                isLookUnder = true;
                if(!note.equals("")) {
                    String[] findingNote = {
                        "You found a note with words written on it. Looks like english",
                        "A note was found and it has letters combined to it to make words. I wonder what it says.",
                        "OH boyy you found a note!",
                        "The note has writing on it. Sweeeet"
                    };
                    System.out.println(findingNote[IR5.getRandomNumber(0, findingNote.length - 1)]);
                }
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

    public void read() {
        if(note.equals("")) {
            System.out.println("There's nothing here");
        } else {
            if(isLookUnder) {
                System.out.println(note);
            } else {
                System.out.println("I cant read anything");
            }
        }
    }

    public void examine() {
       System.out.println("Very off putting lamp. The lighting is bright.");
    }

    public boolean getDoesExist() {
        return doesExist;
    }

    /**
     * @return the isLookUnder
     */
    public boolean isLookUnder() {
        return isLookUnder;
    }

}