public class HallWay extends Room {
    private int lamp;
    private int window;
    // private List<String> hallwayKeywords = new ArrayList<String>();

    public HallWay() {
        super();
        this.lamp = 0;
        this.window = 0;
    }

    @Override
    public void checkOut(String item) {
        if(item.equals("lamp")) {
            System.out.println("There seems to be a letter under the lamp");
            System.out.println("Look at the window");
        } else {
            super.getItem(item);
        }
    }

}