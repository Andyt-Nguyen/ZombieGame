public class SuperRoom  {
    private int id;
    private String name;
    private boolean isDoorOpen;
    private boolean isEnter;
    private boolean isLocked;
    private Bed bed;
    private Closet closet;
    private Vault vault;
    private Fridge fridge;
    private String objectInPlay;

    public SuperRoom() {
        this.id = 0;
        this.name = "";
        this.isDoorOpen = false;
        this.isEnter = false;
        this.isLocked = false;
        this.objectInPlay = "";
        this.bed = new Bed();
        this.closet = new Closet();
        this.vault = new Vault();
        this.fridge = new Fridge();
    }
    
    
    public SuperRoom(int id, String name, boolean isDoor, boolean isLocked, Bed bed, Closet closet, Fridge fridge, Vault vault) {
        this.id = id;
        this.name = name;
        this.isDoorOpen = false;
        this.isLocked = isLocked;
        this.isEnter = false;
        this.objectInPlay = "";
        this.bed = bed;
        this.closet = closet;
        this.vault = vault;
        this.fridge = fridge;
    }


    public void setObjectInPlay(String objectInPlay) {
        if(isEnter) {
            if(objectInPlay.equals("bed") && bed.getDoesExist()) {
                this.objectInPlay = objectInPlay;
                System.out.println("You walked to the " + objectInPlay);
                this.objectInPlay = objectInPlay;
            } else if(objectInPlay.equals("fridge") && fridge.getDoesExist()) {
                this.objectInPlay = objectInPlay;
                System.out.println("You walked to the " + objectInPlay);
            } else if(objectInPlay.equals("closet") && closet.getDoesExist()) {
                this.objectInPlay = objectInPlay;
                System.out.println("You walked to the " + objectInPlay);
            } else if(objectInPlay.equals("vault") && vault.getDoesExist()) {
                System.out.println("You walked to the " + objectInPlay);
                this.objectInPlay = objectInPlay;
            } else {
                System.out.println("That isn't a place you can walk to");    
            }
        } else {
            System.out.println("I can't go to that. I'm still at the door");
        }
    }


    public void getItem(String item, Player player) {
        if(isEnter && isDoorOpen) {
            if(objectInPlay.equals("bed")) {
                bed.getItem(item, player);
            } else if(objectInPlay.equals("closet")) {
                closet.getItem(item, player);
            } else if(objectInPlay.equals("vault")) {
                vault.getItem(item, player);
            } else if(objectInPlay.equals("fridge")) {
                System.out.println("FRIDGEEE");
                fridge.getItem(item, player);
            } else {
                System.out.println("Theres nothing there to pick up");
            }
        }
    }

    public void lookAround() {
        if(isDoorOpen && isEnter) {
            System.out.println("You look around and you see...");

            if(bed.getDoesExist() || closet.getDoesExist() || vault.getDoesExist() || fridge.getDoesExist()) {
                if(bed.getDoesExist()) {
                    System.out.println("A bed with some sheets over it.");  
                }
                if(closet.getDoesExist()) {
                    System.out.println("A closet bigger than the average bear.");
                }
    
                if(vault.getDoesExist()) {
                    System.out.println("Theres a big metal vault in the room.");
                }
                
                if(fridge.getDoesExist()) {
                    System.out.println("A fridge with dirty red marks all of over it");
                }
            } else {
                System.out.println("Ther isn't anything in here");
            }

        } else {
            System.out.println("You're looking at the " + name + " from the outside");
        }
    }


    public void open(String item) {
        if(isDoorOpen) {
            if(isEnter) {
                if(item.equals("closet") && objectInPlay.equals("closet")) {
                    closet.open();
                } else if(item.equals("fridge")) {
                    fridge.open();
                } else if(item.equals("vault") && objectInPlay.equals("vault")) {
                    vault.open();
                } 
                else {
                    openDoor(item);
                }
            } else {
                openDoor(item);
            }
        } else {
            openDoor(item);           
        }
    }

    public void openDoor(String object) {
        if(isLocked) {
            System.out.println("the door is locked");
        } else {
            if(!isDoorOpen) {
                if(object.equals("door")) {
                    System.out.println("You turn the door knob and the door opens");
                    isDoorOpen = true;
                } else {
                    System.out.println("You can't open that!");
                } 
            } else {
                System.out.println("Door is open for bussiness");
            }
        }
    }

    public void unCover(String object) {
        if(isDoorOpen && isEnter) {
            if(object.equals("bed") && objectInPlay.equals("bed")) {
                bed.unCoverBed();
            }
        } else {
            if(isDoorOpen) {
                System.out.println("You going to go in or something?");
            } else {
                System.out.println("There's an angry door in your way");
            }
        }
    }
    

    public int breakInto(String noun) {
        if(noun.equals("vault")) {
            vault.breakInto();
            return -1;
        } else {
            if(noun.equals("door")) {
                int chances = IR5.getRandomNumber(1, 5);
                if(chances >= 3) {
                    isLocked = false;
                    System.out.println("You hear a click and the doorknob is loose");
                    System.out.println("but took some damage.");
                    return IR5.getRandomNumber(5, 8);
                } else {
                    System.out.println("Your knife broke and you took some damage");
                    return IR5.getRandomNumber(12,15);
                }
            } else {
                System.out.println("You can't break into there");
                return -1;
            }
        }
    }


    public void unlock(String noun) {
        if(noun.equals("vault")) {
            System.out.println("A prompt shows up on the vault");
            String userPasscode = ZombieGame.getString("Enter Passcode: ");
            vault.unlock(userPasscode);
        } else {
            isLocked = false;
            System.out.println("You have unlocked the " + noun);
        }
    }



    public void search(String item) {
        if(isDoorOpen && isEnter) {
            if(item.equals("bed")) { 
                bed.search();
            } else if(item.equals("closet")) {
                closet.search();
            } else if(item.equals("vault")) {
                vault.search();
            } else if(item.equals("fridge")) {
                fridge.search();
            }
        } else {
            if(isDoorOpen) {
                System.out.println("You going to get in there or what?");
            } else {
                System.out.println("There's a lovely door in your way");
            }
        }
    }



    public void read(String item) {
        if(isDoorOpen && isEnter) {
            if(item.equals("note") && objectInPlay.equals("bed")) {
                bed.read();
            } else if(item.equals("note") && objectInPlay.equals("vault")) { 
                vault.read();
            } else {
                System.out.println("You can't read that!");
            }
        }
    }

    public void leave(String noun) {
        if(noun.equals(name.toLowerCase())) {
            isEnter = false;
            System.out.println("You have left the " + name.toLowerCase());
            System.out.println("and back in the hallway");
        } else {
            System.out.println("What?");
        }
    }


    public void examine(String item) {
        if(item.equals("bed")) {
            bed.examine();
        } else if(item.equals("closet")){
            closet.examine();
        } else if(item.equals("vault")) {
            vault.examine();
        } else if(item.equals("fridge")) {
            fridge.examine();
        } else {
            System.out.println("The door has strange markings. Looks like a " + this.name.toLowerCase());
        }
    }

    public void enter(String noun) {
        if(noun.equals(name.toLowerCase())) {
            if(isLocked) {
                System.out.println("The door is locked");
            } else {
                isEnter = true;
                System.out.println("You have entered the " + name.toLowerCase());
            }
        } else {
            System.out.println("You can't enter into that friend");
        }
    }

    public void kick() {
        System.out.println("Hey! You can't kick that.");
    }



    public boolean getIsDoorOpen() {
        return isDoorOpen;
    }
    /**
     * @return the bed
     */
    public Bed getBed() {
        return bed;
    }

    /**
     * @return the closet
     */
    public Closet getCloset() {
        return closet;
    }

    /**
     * @return the fridge
     */
    public Fridge getFridge() {
        return fridge;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the objectInPlay
     */
    public String getObjectInPlay() {
        return objectInPlay;
    }

    /**
     * @return the vault
     */
    public Vault getVault() {
        return vault;
    }

    /**
     * @param bed the bed to set
     */
    public void setBed(Bed bed) {
        this.bed = bed;
    }

    /**
     * @param closet the closet to set
     */
    public void setCloset(Closet closet) {
        this.closet = closet;
    }

    /**
     * @param fridge the fridge to set
     */
    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }


    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * @param isDoorOpen the isDoorOpen to set
     */
    public void setIsDoorOpen(boolean isDoorOpen) {
        this.isDoorOpen = isDoorOpen;
    }

    /**
     * @param isEnter the isEnter to set
     */
    public void setIsEnter(boolean isEnter) {
        this.isEnter = isEnter;
    }

    /**
     * @param isLocked the isLocked to set
     */
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param vault the vault to set
     */
    public void setVault(Vault vault) {
        this.vault = vault;
    }

    


}