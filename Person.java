public class Person {
    private int username;
    private int hp = 100;
    private int endurance = 100;
    private int[] inventory = new int[10];
    public  int xpos = 0;
    public  int ypos = 0;

    public void displayHp() {
        System.out.println(this.hp);
    }

    public void decreaseHp(int num) {
        this.hp -= num;
    }

    public void increaseHp(int num) {
        this.hp += num;
    }

    public void moveForward() {
        this.xpos++;
    }

    public void moveDown() {
        this.ypos++;
    }

    public void moveLeft() {
        this.xpos--;
    }

    public void moveUp() {
        this.ypos--;
    }

    public void getXPos() {
        System.out.println(xpos);
    }

    public void removeFromInventory(int item) {
        for(int i = 0; i < this.inventory.length; i++) {
            if(inventory[i] == item) {
                inventory[i] = 0;
            }
        }
    }

    public void swapFromInventory(int item) {
        for(int i = 0; i < this.inventory.length; i++) {
            if(inventory[i] == item) {
                inventory[i] = item;
            }
        }
    }

    public void addToInventory(int item) {
        if(!isInventoryFull()) {
            for(int i = 0; i < this.inventory.length; i++) {
                if(this.inventory[i] == 0) {
                    this.inventory[i] = item;
                    break;
                }
            }
        } else {
            System.out.println("Inventory is full");
        }
    }

    public boolean isInventoryFull() {
        int counter = 0;
        for(int i = 0; i < this.inventory.length; i++) {
            if(this.inventory[i] != 0) {
                counter++;
            }
        }
        return counter == inventory.length;
    }


}