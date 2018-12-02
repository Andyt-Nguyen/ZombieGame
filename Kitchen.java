public class Kitchen extends Room {
    private Fridge fridge;
    private Closet closet;
    private Vault vault;
    private String objectInPlay;

    public Kitchen() {
        super(0,"Kitchen", true, false);
        fridge = new Fridge();
        closet = new Closet();
        this.objectInPlay = "";
    }

    public Kitchen(int id, Fridge fridge, Closet closet, Vault vault,boolean isLocked) {
        super(id, "Kitchen", false, isLocked);
        this.fridge = fridge;
        this.closet = closet;
        this.vault = vault;
        this.objectInPlay = "";
    }

    public void lookAround() {
        if(super.getEnter() && super.getIsDoorOpen()) {
            System.out.println("You look around and you see...");
            if(fridge.getDoesExist() || closet.getDoesExist() || vault.getDoesExist()) {
                if(fridge.getDoesExist()) {
                    System.out.println("A fridge with dirty red marks all of over it");
                }
    
                if(closet.getDoesExist()) {
                    System.out.println("A closet bigger than your average bear");
                }
    
                if(vault.getDoesExist()) {
                    System.out.println("There a small little vault here");
                }
            } else {
                System.out.println("There nothing in this room");
            }

        } else {
            System.out.println("This door is a pleasure to look at");
        }
    }

    @Override
    public void setObjectInPlay(String objectInPlay) {
        if(super.getEnter()) {
            if(objectInPlay.equals("fridge") && fridge.getDoesExist()) {
                this.objectInPlay = objectInPlay;
                System.out.println("You walked to the " + objectInPlay);
            } else if(objectInPlay.equals("closet") && closet.getDoesExist()) {
                this.objectInPlay = objectInPlay;
                System.out.println("You walked to the " + objectInPlay);
            } else if(objectInPlay.equals("vault") && vault.getDoesExist()) {
                this.objectInPlay = objectInPlay;
                System.out.println("You walked to the " + objectInPlay);
            } else {
                super.setObjectInPlay("");       
            }
        } else {
            System.out.println("I can't go to that. I'm still at the door");
        }
    }

    @Override
    public void open(String item) {
        if(super.getIsDoorOpen()) {
            if(super.getEnter()) {
                if(item.equals("fridge") && objectInPlay.equals("fridge")) {
                    fridge.open();
                } else if(item.equals("closet") && objectInPlay.equals("closet")) {
                    closet.open();
                } else if(item.equals("vault") && objectInPlay.equals("vault")) {
                    vault.open();
                } else {
                    super.open(item);
                }
            } else {
                super.open(item);
            }
        } else {
            super.open(item);            
        }
    }
    
    @Override
    public int breakInto(String noun) {
        if(noun.equals("vault")) {
            vault.breakInto();
            return -1;
        } else {
            return super.breakInto(noun);
        }
    }

    @Override
    public void unlock(String noun) {
        if(noun.equals("vault")) {
            System.out.println("A prompt shows up on the vault");
            String userPasscode = ZombieGame.getString("Enter Passcode: ");
            vault.unlock(userPasscode);
        } else {
            super.unlock(noun);
        }
    }

    @Override
    public void getItem(String item, Player player) {
        if(super.getEnter() && super.getIsDoorOpen()) {
            if(objectInPlay.equals("fridge")) {
                fridge.getItem(item, player);
            } else if(objectInPlay.equals("closet")) {
                closet.getItem(item, player);
            } else if(objectInPlay.equals("vault")) {
                fridge.getItem(item, player);
            } else {
                super.getItem(item, player);
            }
        }
    }

    @Override
    public void search(String object) {
        if(object.equals("fridge")) {
            fridge.search();
        } else if(object.equals("closet")) {
            System.out.println("Ther's cobweb all over this thing.");                
            closet.search();
        } else if(object.equals("vault")) {
            vault.search();
        } else super.search(object);
    }

    @Override
    public void examine(String item) {
        if(item.equals("fridge")) {
            fridge.examine();
        } else if(item.equals("closet")) {
            closet.examine();
        } else {
            super.examine(item);
        }
    }

    @Override
    public void leave(String noun) {
        objectInPlay = "";
        super.leave(noun);
    }

}