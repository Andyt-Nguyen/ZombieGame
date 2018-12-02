public class Bedroom extends Room {
    private Bed bed;
    private Closet closet;
    private Vault vault;
    private String objectInPlay;

    public Bedroom() {
        super(0,"Bedroom", false, false);
        this.objectInPlay = "";
        this.bed = new Bed();
        this.closet = new Closet();
        this.vault = new Vault();
    }
    
    
    public Bedroom(int id, boolean isDoor, Bed bed, Closet closet, Vault vault, boolean isLocked) {
        super(id,"Bedroom", isDoor, isLocked);
        this.objectInPlay = "";
        this.bed = bed;
        this.closet = closet;
        this.vault = vault;
    }

    @Override
    public void setObjectInPlay(String objectInPlay) {
        if(super.getEnter()) {
            if(objectInPlay.equals("bed") && bed.getDoesExist()) {
                this.objectInPlay = objectInPlay;
                System.out.println("You walked to the " + objectInPlay);
            } else if(objectInPlay.equals("closet") && closet.getDoesExist()) {
                this.objectInPlay = objectInPlay;
                System.out.println("You walked to the " + objectInPlay);
            } else if(objectInPlay.equals("vault")) {
                System.out.println("You walked to the " + objectInPlay);
                this.objectInPlay = objectInPlay;
            } else {
                super.setObjectInPlay("");       
            }
        } else {
            System.out.println("I can't go to that. I'm still at the door");
        }
    }

    @Override
    public void getItem(String item, Player player) {
        if(super.getEnter() && super.getIsDoorOpen()) {
            if(objectInPlay.equals("bed")) {
                bed.getItem(item, player);
            } else if(objectInPlay.equals("closet")) {
                closet.getItem(item, player);
            } else {
                super.getItem(item, player);
            }
        }
    }

    public void lookAround() {
        if(super.getIsDoorOpen() && super.getEnter()) {
            System.out.println("You look around and you see...");

            if(bed.getDoesExist() || closet.getDoesExist() || vault.getDoesExist()) {
                if(bed.getDoesExist()) {
                    System.out.println("A bed with some sheets over it.");  
                }
                if(closet.getDoesExist()) {
                    System.out.println("A closet bigger than the average bear.");
                }
    
                if(vault.getDoesExist()) {
                    System.out.println("Theres a big metal vault in the room.");
                }
            }

        } else {
            super.getIsDoorOpen();
        }
    }

    @Override
    public void open(String item) {
        if(super.getIsDoorOpen()) {
            if(super.getEnter()) {

                if(item.equals("closet") && objectInPlay.equals("closet")) {
                    closet.open();
                } else if(item.equals("vault") && objectInPlay.equals("vault")) {
                    vault.open();
                } 
                else {
                    super.open(item);
                }
            } else {
                super.open(item);
            }
        } else {
            super.open(item);           
        }
    }

    public void unCover(String object) {
        if(super.getIsDoorOpen() && super.getEnter()) {
            if(object.equals("bed") && objectInPlay.equals("bed")) {
                bed.unCoverBed();
            }
        } else {
            if(super.getIsDoorOpen()) {
                System.out.println("You going to go in or something?");
            } else {
                System.out.println("There's an angry door in your way");
            }
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
        System.out.println("Noun: "+noun);
        if(noun.equals("vault")) {
            System.out.println("A prompt shows up on the vault");
            String userPasscode = ZombieGame.getString("Enter Passcode: ");
            vault.unlock(userPasscode);
        } else {
            super.unlock(noun);
        }
    }



    @Override
    public void search(String item) {
        if(super.getIsDoorOpen() && super.getEnter()) {
            if(item.equals("bed")) { 
                bed.search();
            } else if(item.equals("closet")) {
                closet.search();
            } else if(item.equals("vault")) {
                vault.search();
            }
        } else {
            if(super.getIsDoorOpen()) {
                System.out.println("You going to get in there or what?");
            } else {
                System.out.println("There's a lovely door in your way");
            }
        }
    }



    @Override
    public void read(String item) {
        if(super.getIsDoorOpen() && super.getEnter()) {
            if(item.equals("note") && objectInPlay.equals("bed")) {
                bed.read();
            } else if(item.equals("note") && objectInPlay.equals("vault")) { 
                vault.read();
            } else {
                super.read(item);
            }
        }
    }

    @Override
    public void leave(String noun) {
        objectInPlay = "";
        super.leave(noun);
    }


    public void examine(String item) {
        if(item.equals("bed")) {
            bed.examine();
        } else if(item.equals("closet")){
            closet.examine();
        } else if(item.equals("vault")) {
            vault.examine();
        } else {
            super.examine(item);
        }
    }


}