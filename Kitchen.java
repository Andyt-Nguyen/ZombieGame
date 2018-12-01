public class Kitchen extends Room {
    private int knife;
    private boolean isFridge;
    private int food;
    private ArrayList<String> kitchenKeywords = new ArrayList<String>();

    public Kitchen() {
        super();
        this.knife = 0;
        this.isFridge = false;
        this.food = 0;
    }

    public Kitchen(int knife, boolean isFridge, int food) {
        super();
        this.knife = knife;
        this.isFridge = isFridge;
        this.food = food;
    }

    public void open(String item) {
        if(item.equals("fridge")) {
            isFridge = true;
            System.out.println("You have opened the fridge");
        } else {
            super.open(item);
        }
    }   

    public void getItem(String item) {
        if(item.equals("knife")) {
            knife--;
            System.out.println("You have picked up a shiny sharp knife");
        } else if(item.equals("food")) {
            food--;
            System.out.println("Nice you put that food in your small pocket");
        } else {
            super.getItem(item);
        }
    }

}