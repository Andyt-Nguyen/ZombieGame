public class Player {
    private String username;
    private String password;
    private int hp;
    private int xpos;
    private int ypos;
    private int knifeCount;
    private int foodCount;
    private int keyCount;
    private String notes;
    private boolean isWin;

    public Player() {
        this.username = "";
        this.password = "";
        this.hp = 100;
        this.knifeCount = 0;
        this.foodCount = 0;
        this.notes = "";
        this.keyCount = 0;
        xpos = 0;
        ypos = 0;
    }
    

    public Player(String username, String password, String notes, int hp, int keyCount,int knifeCount, int foodCount, int xpos, int ypos){
      this.username = username;
      this.password = password;
      this.hp = hp;
      this.xpos = xpos;
      this.ypos = ypos;
      this.knifeCount = knifeCount;
      this.foodCount = foodCount;
      this.keyCount = keyCount;
      this.notes = notes;
      this.isWin = false;
    }
    
    public void addToItem(String item, int count) {
        if(count > 1) {
            if(item == "knife") {
                System.out.println(count + " knives has beed added to your inventory");
            } else if(item == "food") {
                System.out.println(count + " pieces of food has been added to your inventory");
            } else if(item == "key") {
                System.out.println(count + " keys has been added to your inventory.");
            }
        } else {
            System.out.println(item + " has been added to your inventory.");
        }
        if(item.equals("knife")) this.knifeCount += count;
        else if(item.equals("food")) this.foodCount += count;
        else if(item.equals("key")) this.keyCount += count;
    }

    public void writeNote(String note) {
        System.out.println("I'm jotting this down in my notes");
        this.notes += note;
    }

    public void clearNotes() {
        System.out.println("You erased all of your notes");
        this.notes = "";
    }

    public void eat() {
        if(foodCount > 0) {
            System.out.println("Chew... chomp.. chow... crackle... burp");
            int healAmount = IR5.getRandomNumber(7, 20);
            if(healAmount > 15) {
                System.out.println("Yum that was pretty big meal");
                System.out.println("That was delicious!");
                hp += healAmount;
            } else {
                hp += healAmount;
                System.out.println("Though it was a lttle amount of food particles it was still delicious");
            }
            foodCount--;
        } else {
            System.out.println("I don't have anything to eat");
        }
    }

    public void useKey() {
        keyCount--;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public void getInventory() {
        System.out.println("-----------------------");
        System.out.println("       Inventory");
        System.out.println("-----------------------");
        System.out.println(" Items     |   Count   ");
        System.out.println("_______________________");
        System.out.println(" Knives    |    " + knifeCount);
        System.out.println(" Food      |    " + foodCount);
        System.out.println(" Notes     |    " + (notes.split(" ").length - 1));
        System.out.println(" Keys      |    " + keyCount);
        System.out.println("-----------------------");
    }

    public void checkHealth() {
        System.out.println("-----------");
        System.out.println(" HP: " + hp);
        System.out.println("-----------");
    }

    public void decreaseKnifeCount() {
        knifeCount--;    
    }


    public String getNotes() {
        System.out.println("You look in your back pocket and pull out your notebook.\n");
        return notes;
    }

    public void displayHp() {
        System.out.println(this.hp);
    }

    public void scream() {
        System.out.println("AHHHHHHHHHHHH!!!!!");
    }
    
    public String getUsername(){
      return username;
    }
    
    public String getPassword(){
      return password;
    }

    public int getHp() {
        return this.hp;
    }
    
    public int getXpos(){
      return xpos;
    }
    
    public int getYpos(){
      return ypos;
    }

    public int getKnifeCount() {
        return knifeCount;
    }
    
    public void setUsername(String username){
      this.username = username;
    }
    
    public void setPassword(String password){
      this.password = password;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
    
    public void decreaseHp(int num) {
        this.hp -= num;
    }

    public void moveRight(int steps) {
        if(steps == 0) this.xpos++;
        else this.xpos += steps;
    }

    public void moveLeft(int steps) {
        if(steps == 0) this.xpos--;
        else this.xpos -= steps;
    }
    
    public void moveDown(int steps) {
        if(steps == 0) this.ypos++;
        else this.ypos += steps;
    }
    
    public void moveUp(int steps) {
        if(steps == 0) this.ypos--;
        else this.ypos -= steps;
    }

    public boolean getisWin() {
        return isWin;
    }

    public void setIsWin(boolean isWin) {
        this.isWin = isWin;
    }

}