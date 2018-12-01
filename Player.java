public class Player {
    private String username;
    private String password;
    private int hp;
    private  int xpos;
    private  int ypos;
    private int knifeCount;

    public Player() {
        this.username = "";
        this.password = "";
        this.hp = 100;
        xpos = 0;
        ypos = 0;
        this.knifeCount = 0;
    }
    
    //FileIO constructor.

    // (name, password, hp, bulletCount, knifeCount, appleCount, steakCount, keyCount, xpos, ypos, specialKey)

    public Player(String username, String password, int hp, int xpos, int ypos){
      this.username = username;
      this.password = password;
      this.hp = hp;
      this.xpos = xpos;
      this.ypos = ypos;
      this.knifeCount = 0;
    }
    
    public void addToItem(String item, int count) {
        System.out.println(item + " added to inventory");
        if(item.equals("knife")) this.knifeCount += count;
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
    
    public void setUsername(String username){
      this.username = username;
    }
    
    public void setPassword(String password){
      this.password = password;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int xpos) {
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

}