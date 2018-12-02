public class Vault {
    private boolean isOpen;
    private int knife;
    private int food;
    private String note;
    private boolean doesExist;
    private String passcode;

    public Vault() {
        doesExist = false;
    }

    public Vault(boolean isOpen,String passcode, int knife, int food, String note) {
        this.isOpen = isOpen;
        this.knife = knife;
        this.food = food;
        this.note = note;
        this.passcode = passcode;
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
            if(food > 0 || knife > 0 || !note.equals("")) {
                if(food > 0) {
                    System.out.println("You found some scraps of food in the frideg");
                    System.out.println("The food looks filthy! But I kind of want it");
                }
                if(knife > 0) {
                    System.out.println("There is a sharp metal knife in here");
                }

                if(!note.equals("")) {
                    System.out.println("There is a note it is written in english");
                }

            } else {
                System.out.println("There isn't anything here");
            }
        } else {
            System.out.println("Looks like a nice closed vault");
        }
    }

    public int breakInto() {
        int chances = IR5.getRandomNumber(1, 5);
        if(chances >= 3) {
            isOpen = false;
            System.out.println("You hear a click and the vault became loose");
            System.out.println("but took some damage.");
            return IR5.getRandomNumber(5, 8);
        } else {
            System.out.println("Your knife broke and you took some damage");
            return IR5.getRandomNumber(12,15);
        }
    }

    public void unlock(String usercode) {
        if(passcode.equals("")) {
            isOpen = true;
        } else {
            if(passcode.equals(usercode)) {
                isOpen = true;
                System.out.println("System processing...");
                System.out.println("** Access Granted **");
            } else {
                System.out.println("System processing..");
                System.out.println("! Access Denied !");
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