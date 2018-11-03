public class Person {
    private String username;
    private String password;
    private int hp;
    private int endurance;
    private int[] inventory = new int[10];
    private int bulletCount;
    private int knifeCount;
    private int appleCount;
    private int steakCount;
    private int keyCount;
    public  int xpos;
    public  int ypos;

    public Person() {
        this.username = "Unknown";
        hp = 100;
        bulletCount = 0;
        knifeCount = 0;
        appleCount = 0;
        steakCount = 0;
        keyCount = 0;
        xpos = 0;
        ypos = 0;
    }
    
    //FileIO constructor.
    public Person(String username, String password, int hp, int endurance, int bulletCount, int knifeCount
                 ,int appleCount, int steakCount, int keyCount, int xpos, int ypos){
      this.username = username;
      this.password = password;
      this.hp = hp;
      this.endurance = endurance;
      this.bulletCount = bulletCount;
      this.knifeCount = knifeCount;
      this.appleCount = appleCount;
      this.steakCount = steakCount;
      this.keyCount = keyCount;
      this.xpos = xpos;
      this.ypos = ypos;
    }
    
    public Person(String username, int xpos, int ypos) {
        this.username = username;
        this.xpos = xpos;
        this.ypos = ypos;
        hp = 100;
        bulletCount = 0;
        keyCount = 0;
        bulletCount = 0;
        knifeCount = 0;
        appleCount = 0;
        steakCount = 0;
    }

    public void displayHp() {
        System.out.println(this.hp);
    }
    
    public String getUsername(){
      return username;
    }
    
    public String getPassword(){
      return password;
    }
    
    public int getEndurance(){
      return endurance;
    }
    
    public int getBulletCount() {
        return bulletCount;
    }

    public int getKnifeCount() {
        return knifeCount;
    }

    public int getAppleCount() {
        return appleCount;
    }

    public int getSteakCount() {
        return steakCount;
    }

    public int getKeyCount() {
        return keyCount;
    }

    public double getHp() {
        return this.hp;
    }
    
    public int getXpos(){
      return xpos;
    }
    
    public int getYpos(){
      return ypos;
    }
    
    public void setUsername(String username){
      this.username = username;
    }
    
    public void setPassword(String password){
      this.password = password;
    }

    public void setBulletCount(int bulletCount) {
        this.bulletCount = bulletCount;
    }

    public void setKnifeCount(int knifeCount) {
        this.knifeCount = knifeCount;
    }

    public void setAppleCount(int appleCount) {
        this.appleCount = appleCount;
    }

    public void setSteakCount(int steakCount) {
        this.steakCount = steakCount;
    } 

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public void setEndurance(int endurance){
      this.endurance = endurance;
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

    public void moveRight() {
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

    public void addToKey() {
        keyCount++;
    }

    public void addSteakCount() {
        steakCount++;
    }

    public void addAppleCount() {
        appleCount++;
    }

    public void removeKey() {
        keyCount--;
    }

    public void eatApple() {
        hp += 5;
    }

    public void eatSteak() {
        hp += 20;
    }


    public int atkHands() {
        return IR5.getRandomNumber(0,5);
    }

    public int atkGun() {
        return IR5.getRandomNumber(25,50);
    }

    public int atkKnife() {
        return IR5.getRandomNumber(7,15);
    }


}