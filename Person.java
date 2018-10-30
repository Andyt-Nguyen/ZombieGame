public class Person {
    private String username;
    private int hp = 100;
    private int endurance;
    private int[] inventory = new int[10];
    private int bulletCount;
    private int knifeCount;
    private int appleCount;
    private int steakCount;
    public  int xpos;
    public  int ypos;

    public Person() {
        this.username = "Unknown";
        hp = 10;
        bulletCount = 0;
        bulletCount = 0;
        knifeCount = 0;
        appleCount = 0;
        steakCount = 0;
        xpos = 0;
        ypos = 0;
    }

    public Person(String username, int xpos, int ypos) {
        this.username = username;
        this.xpos = xpos;
        this.ypos = ypos;
        hp = 100;
        bulletCount = 0;
        bulletCount = 0;
        knifeCount = 0;
        appleCount = 0;
        steakCount = 0;
    }

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

    public void addToBullets() {
        bulletCount++;
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

    public int atkHands() {
        return IR5.getRandomNumber(0,2);
    }

    public int atkGun() {
        return IR5.getRandomNumber(25,50);
    }

    public int atkKnife() {
        return IR5.getRandomNumber(5,7);
    }


}