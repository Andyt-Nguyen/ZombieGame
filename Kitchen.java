public class Kitchen extends Room {
    private int knife;
    private boolean isFridge;
    private boolean isCloset;
    private int food;
    private boolean isDoor;
    
    public Kitchen() {
        super("Kitchen", true);
        this.knife = 0;
        this.isFridge = false;
        isCloset = false;
        this.food = 0;
        this.isDoor = false;
    }

    public Kitchen(int knife, boolean isFridge, boolean isCloset, int food) {
        super("Kitchen", true);
        this.knife = knife;
        this.isFridge = isFridge;
        this.isCloset = isCloset;
        this.food = food;
        this.isDoor = false;
    }

    public void lookAround() {
        if(super.getEnter() && isDoor) {
            System.out.println("There is a fridge with dirty red marks all of over it");
            System.out.println("and a closet");
        } else {
            super.lookAround();
        }
    }

    public void open(String item) {
        if(isDoor) {
            if(super.getEnter()) {
                if(item.equals("fridge")) {
                    if(isFridge) {
                       System.out.println("Fridge already opened"); 
                    } else {
                        isFridge = true;
                        System.out.println("You have opened the fridge");
                    }
                } else if(item.equals("closet")) {
                    if(isCloset) {
                        System.out.println("Counter already open");
                    } else {
                        isCloset = true;
                        System.out.println("You have successfully open the drawer congratulations");
        
                    }
                } else {
                    super.open(item);
                }
            }
        } else {
            isDoor = true;
            System.out.println("You have opened the kitchen door");            
        }
    }
    
    @Override
    public void getItem(String item, Player player) {
        if(super.getEnter() && isDoor) {
            if(item.equals("knife")) {
                if(this.knife != 0 && isCloset) {
                    System.out.println("Oooo so nice an shiny.");
                    player.addToItem("knife", knife);
                    knife = 0;
                } else {
                    super.getItem(item, player);
                }
            } else if(item.equals("food")) {
                if(food != 0 && isFridge) {
                    System.out.println("Nice you put that piece of food in your pocket.");
                    System.out.println("Are you proud of that? Might eat it for later.");
                    player.addToItem("food", food);
                    food = 0;
                } else {
                    super.getItem(item, player);
                }
            } else {
                super.getItem(item, player);
            }
        }
    }

    @Override
    public void search(String object) {
        if(isFridge) {
            if(object.equals("fridge")) {
                if(food != 0) {
                    System.out.println("You found some scraps of food in the frideg");
                    System.out.println("The food looks filthy! But I kind of want it");
                } else {
                    super.search(object);
                }
            } else if(object.equals("closet")) {
                if(knife != 0) {
                    System.out.println("Ther's cobweb all over this thing.");
                    System.out.println("Look at that there is one knife in here");
                    System.out.println("Everything else looks in it looks empty");
                } else {
                    super.search((object));
                }
            }
        } else {
            super.search(object);
        }
    }

    @Override
    public void examine(String item) {
        if(item.equals("fridge")) {
            System.out.println("The fridge looks interesting");
            System.out.println("I want to build one");
        } else if(item.equals("closet")) {
            System.out.println("Ooo I wonder if that closet has cereal. I'm starving!");
        } else {
            super.examine(item);
        }
    }

}