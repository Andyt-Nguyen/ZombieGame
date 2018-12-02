public class Kitchen extends Room {
    private boolean isDoor;
    private Fridge fridge;
    private Closet closet;
    private String objectInPlay;

    public Kitchen() {
        super(0,"Kitchen", true);
        this.isDoor = false;
        fridge = new Fridge();
        closet = new Closet();
        this.objectInPlay = "";
    }

    public Kitchen(int id, Fridge fridge, Closet closet) {
        super(id, "Kitchen", true);
        this.isDoor = false;
        this.fridge = fridge;
        this.closet = closet;
        this.objectInPlay = "";
    }

    public void lookAround() {
        if(super.getEnter() && isDoor) {
            System.out.println("You look around and you see...");
            if(fridge.getDoesExist()) {
                System.out.println("A fridge with dirty red marks all of over it");
            }

            if(closet.getDoesExist()) {
                System.out.println("A closet bigger than your average bear");
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
            } else {
                super.setObjectInPlay("");       
            }
        } else {
            System.out.println("I can't go to that. I'm still at the door");
        }
    }
    
    public void open(String item) {
        if(isDoor) {
            if(super.getEnter()) {
                if(item.equals("fridge") && objectInPlay.equals("fridge")) {
                    fridge.open();
                } else if(item.equals("closet") && objectInPlay.equals("closet")) {
                    closet.open();
                } else {
                    super.open(item);
                }
            } else {
                System.out.println("I'm looking at door right now");
            }
        } else {
            isDoor = true;
            System.out.println("You have opened the kitchen door");            
        }
    }
    
    @Override
    public void getItem(String item, Player player) {
        if(super.getEnter() && isDoor) {
            if(objectInPlay.equals("fridge")) {
                fridge.getItem(item, player);
            } else if(objectInPlay.equals("closet")) {
                closet.getItem(item, player);
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