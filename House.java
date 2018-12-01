public class House {
    private Bedroom bedRoom;
    private Kitchen kitchen;

    public House(Bedroom bedroom, Kitchen Kitchen) {
        this.bedRoom = bedroom;
        this.kitchen = kitchen;
    }

    /**
     * @return the bedRoom
     */
    public Bedroom getBedRoom() {
        return bedRoom;
    }

    /**
     * @return the kitchen
     */
    public Kitchen getKitchen() {
        return kitchen;
    }
}