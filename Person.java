public class Person {
    private int username;
    private int hp = 100;
    private int endurance = 100;
    private int[] inventory = new int[10];
    private int bulletCount = 0;
    private int knifeCount = 0;
    public  int xpos = 0;
    public  int ypos = 0;


    public void displayHp() {
        System.out.println(this.hp);
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int xpos) {
        this.xpos = xpos;
    }
    
    public void decreaseHp(int num) {
        this.hp -= num;
    }

    public void increaseBulletCount() {
        this.bulletCount++;
    }

    public void increaseHp(int num) {
        this.hp += num;
    }

    public double getUserHp() {
        return this.hp;
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

    public void removeFromInventory(int item) {
        for(int i = 0; i < this.inventory.length; i++) {
            if(this.inventory[i] == item) {
                this.inventory[i] = 0;
            }
        }
    }

    public void swapFromInventory(int item) {
        for(int i = 0; i < this.inventory.length; i++) {
            if(this.inventory[i] == item) {
                this.inventory[i] = item;
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