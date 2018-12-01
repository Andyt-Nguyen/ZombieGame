public class Bedroom extends Room {
    private boolean isUnconvered;
    private String note;
    private boolean isDoor;

    public Bedroom() {
        super("Bedroom", true);
        this.isUnconvered = false;
        this.isDoor = false;
        this.note = "";
    }

    public Bedroom(boolean isUnconvered, String note, boolean isDoor) {
        super("Bedroom", true);
        this.isUnconvered = isUnconvered;
        this.note = note;
        this.isDoor = isDoor;
    }

    public void open(String object) {
        isDoor = true;
        System.out.println("With the strength of a thousand dragons");
        System.out.println("You turn the door knob and the door opens");
    }

    public void unCover(String object) {
        if(isDoor && super.getEnter()) {
            if(object.equals("sheets")) {
                if(isUnconvered == false) {
                    isUnconvered = true;
                    System.out.println("With great force you unconver the bed sheets");
                } else {
                    System.out.println("You already have unconvered the sheets");
                }
            }
        } else {
            if(isDoor) {
                System.out.println("You going to go in or something?");
            } else {
                System.out.println("There's an angry door in your way");
            }
        }
    }

    public void search(String item) {
        if(isDoor && super.getEnter()) {
            if(item.equals("bed")) {
                if(isUnconvered) {
                    System.out.println("You found a note with words written on it.");
                    System.out.println("Looks like english");
                } else {
                    System.out.println("You find nothing on the bed but you notice");
                    System.out.println("something white under the sheets");
                }
            }
        } else {
            if(isDoor) {
                System.out.println("You going to get in there or what?");
            } else {
                System.out.println("There's a lovely door in your way");
            }
        }
    }

    @Override
    public void read(String item) {
        if(isDoor && super.getEnter()) {
            if(item.equals("note")) {
                System.out.println(note);
            } else {
                super.read(item);
            }
        } else {
            if(isDoor) {
                System.out.println("You going to go in there or what?");
            } else {
                System.out.println("This magnificent piece of wood is in your way");
            }
        }
    }
    
    public void examine(String item) {
        if(item.equals("bed")) {
            System.out.println("Bed has two pillows and a blanket");
        } else if(item.equals("pillows")) {
            System.out.println("Looks like they use tide to clean the pillows");
            System.out.println("It smells fantastic");
        } else if(item.equals("blanket")) {
            System.out.println("Blanket has a lot of flowery designs on it");
        } else {
            super.examine(item);
        }
    }

    public void lookAround() {
        if(isDoor && super.getEnter()) {
            System.out.println("This room does not contain much");
            System.out.println("Only contains a bed.");  
        } else {
            System.out.println("");
        }
    }


}