public class SuperRoom  {
    private int id;
    private String name;
    private int keysToUnlock;
    private int doorDamage;
    private boolean isDoorOpen;
    private boolean isEnter;
    private boolean isToxic;
    private boolean isLocked;
    private Bed bed;
    private Closet closet;
    private Vault vault;
    private Fridge fridge;
    private Desk desk;
    private String objectInPlay;

    
    public SuperRoom(int id, String name, 
                     int keysToUnlock, int doorDamage,
                     boolean isDoor, boolean isLocked, boolean isToxic, 
                     Bed bed, Closet closet, Fridge fridge, Vault vault, Desk desk) {
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
        this.desk = desk;
        this.isToxic = isToxic;
        this.keysToUnlock = keysToUnlock;
        this.doorDamage = doorDamage;
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
            } else if(objectInPlay.equals("desk")) {
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
                fridge.getItem(item, player);
            } else if(objectInPlay.equals("desk")) {
                desk.getItem(item, player);
            } else {
                System.out.println("Theres nothing there to pick up");
            }
        }
    }

    public void lookAround() {
        if(isDoorOpen && isEnter) {
            System.out.println("You look around and you say to yourself");

            if(bed.getDoesExist() || closet.getDoesExist() || vault.getDoesExist() || fridge.getDoesExist() || desk.getDoesExist()) {
                if(bed.getDoesExist()) {
                    String[] bedFind = {
                        "There's a bed in this room",
                        "Look it that there is bed in this room",
                        "A bed with some sheets over it",
                        "Hey there's a bed in here"
                    };
                    System.out.println(bedFind[IR5.getRandomNumber(0, bedFind.length - 1)]);  
                }
                if(closet.getDoesExist()) {
                    String[] closetFind = {
                        "Whoa look at that closet",
                        "There's a closet!",
                        "This closet looks bigger than the average shark",
                        "A closet bigger than the average bear."
                    };
                    System.out.println(closetFind[IR5.getRandomNumber(0, closetFind.length -1)]);
                }
    
                if(vault.getDoesExist()) {
                    String[] vaultFind = {
                        "That vault looks mezmorizing. I think that's the word I'm thinking of.",
                        "That vault looks tiny",
                        "Hey-o I hit the jackpot there's a vault in here!",
                        "Theres a big metal vault in the room."
                    };
                    System.out.println(vaultFind[IR5.getRandomNumber(0, vaultFind.length-1)]);
                }
                
                if(fridge.getDoesExist()) {
                    String[] fridgeFind = {
                        "I'm hungry.. Oh hey there's a fridge",
                        "I want to go to that fridge now!",
                        "I wonder if there is food in that fridge",
                        "That fridge looks dirty I wonder what's inside it."
                    };
                    System.out.println(fridgeFind[IR5.getRandomNumber(0, fridgeFind.length - 1)]);
                }

                if(desk.getDoesExist()) {
                    String[] deskFind = {
                        "Theres a desk here",
                        "That desk looks ancient",
                        "There's a desk across the room",
                        "There a desk here"
                    };
                    System.out.println(deskFind[IR5.getRandomNumber(0, deskFind.length - 1)]);
                }
            } else {
                System.out.println("There isn't anything in here");
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
                } else if(item.equals("fridge") && objectInPlay.equals("fridge")) {
                    fridge.open();
                } else if(item.equals("vault") && objectInPlay.equals("vault")) {
                    vault.open();
                } else if(item.equals("desk") && objectInPlay.equals("desk")) {
                    desk.open();
                } else {
                    openDoor(item);
                }
            } else {
                openDoor(item);
            }
        } else {
            openDoor(item);           
        }
    }

    public void lookUnder(String item) {
        if(isDoorOpen) {
            if(isEnter) {
                if(objectInPlay.equals("desk")) {
                    desk.lookUnder(item);
                }
            } else {
                System.out.println("You can't look under that");
            }
        } else {
            System.out.println("You can't look under that");
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
                if(isDoorOpen && isEnter) {
                    System.out.println("You can't do that. You are not by the " + object);
                } else {
                    System.out.println("Door is open for bussiness");
                }
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
            return vault.breakInto();
        } else {
            if(noun.equals("door")) {
                if(keysToUnlock > 0) {
                    if(doorDamage > 0) {
                        doorDamage--;
                        System.out.println("You hear a click and the doorknob is became a little more loose");
                        System.out.println("Your knife broke in the process and has damaged you.");
                        return IR5.getRandomNumber(2, 5);
                    } else if(doorDamage == 0) {
                        isLocked = false;
                        System.out.println("You hear a rattle when breaking into the door. The doorknob is completely loose");
                        return 0;                        
                    } else {
                        return 0;
                    }
                }  else {
                    System.out.println("The door is alread unlocked");
                    return 0;
                }
            } else {
                System.out.println("You cannot break into that");
                return 0;
            }
        }
        
    }


    public boolean unlock(String noun) {
        if(noun.equals("vault")) {
            System.out.println("A prompt shows up on the vault");
            String userPasscode = IR5Manipulate.getString("Enter Passcode: ");
            boolean isUnlocked = vault.unlock(userPasscode);
            return isUnlocked;
        } else {
            keysToUnlock--;
            if(keysToUnlock <= 0) {
                isLocked = false;
                System.out.println("You have unlocked the " + noun);
                return true;
            } else {
                System.out.println("You hear the door unlock.");
                System.out.println("Looks like this door requires another key to unlock.");
                return false;
            }
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
            } else if(item.equals("desk")) {
                desk.search();
            } else {
                System.out.println("That object does not exist");
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
                System.out.println("The note reads:");
                bed.read();
            } else if(item.equals("note") && objectInPlay.equals("vault")) { 
                System.out.println("The note reads:");
                vault.read();
            } else if(item.equals("note") && objectInPlay.equals("desk")) {
                System.out.println("The note reads:");
                desk.read();
            } else if(item.equals("note") && objectInPlay.equals("fridge")) {
                System.out.println("The note reads:");
                fridge.read();
            } else if(item.equals("note") && objectInPlay.equals("closet")) {
                System.out.println("The note reads:");
                closet.read();
            } else {
                System.out.println("You can't read that!");
            }
        }
    }

    public void leave(String noun) {
            isEnter = false;
            System.out.println("You have left the " + name.toLowerCase());
            System.out.println("and back in the hallway");
    }


    public void examine(String item) {
        if(item.equals("bed") && objectInPlay.equals("bed")) {
            bed.examine();
        } else if(item.equals("closet") && objectInPlay.equals("closet")){
            closet.examine();
        } else if(item.equals("vault") && objectInPlay.equals("vault")) {
            vault.examine();
        } else if(item.equals("fridge") && objectInPlay.equals("fridge")) {
            fridge.examine();
        } else if(item.equals("desk") && objectInPlay.equals("desk")) {
            desk.examine(item);
        } else if(objectInPlay.equals("desk") && item.equals("lamp")) {
            desk.examine(item);
        } else {
            if(objectInPlay.toLowerCase().replace(" ", "").equals("kitchen")) {
                System.out.println("The " + this.name.toLowerCase() + " looks so clean the floors has a squary pattern a bright light\nThat lights the golden room");
            } else if(objectInPlay.toLowerCase().replace(" ", "").equals("bedroom")) {
                System.out.println("The " + this.name.toLowerCase() + " is awesome so simple and not too much inside. Though it is a little dark it is still pretty neat");
            } else if(objectInPlay.toLowerCase().replace(" ", "").equals("master bedroom")) {
                System.out.println("The " + this.name.toLowerCase() + " has windows on the side of with a nice carpet floor");
            } else {
                System.out.println("You cannot examine that.");
            }
        }
    }


    public void enter(String noun) {
        if(isDoorOpen) {
            if(noun.replace(" ", "").equals(name.toLowerCase().replace(" ", "")) || noun.replace(" ", "").equals("room")) {
                if(isLocked) {
                    System.out.println("The door is locked");
                } else {
                    isEnter = true;
                    System.out.println("You have entered the " + name.toLowerCase());
                }
            } else {
                System.out.println("You can't enter into that friend");
            }
        } else {
            System.out.println("You walked into the door. Ouch!");
        }
    }

    
    public void kick() {
        System.out.println("Hey! You can't kick that.");
    }


    public boolean getIsDoorOpen() {
        return isDoorOpen;
    }
   

    public Bed getBed() {
        return bed;
    }

   
    public Closet getCloset() {
        return closet;
    }

   
    public Fridge getFridge() {
        return fridge;
    }

  
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

 
    public String getObjectInPlay() {
        return objectInPlay;
    }


    public Vault getVault() {
        return vault;
    }

 
    public void setBed(Bed bed) {
        this.bed = bed;
    }

  
    public void setCloset(Closet closet) {
        this.closet = closet;
    }

  
    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setIsDoorOpen(boolean isDoorOpen) {
        this.isDoorOpen = isDoorOpen;
    }


    public void setIsEnter(boolean isEnter) {
        this.isEnter = isEnter;
    }

 
    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }


    public void setName(String name) {
        this.name = name;
    }

  
    public void setVault(Vault vault) {
        this.vault = vault;
    }

    public boolean getIsToxic() {
        return isToxic;
    }
    
    public boolean getIsEnter() {
        return isEnter;
    }


}