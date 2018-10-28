public class Zombie {
    private int hp;
    public int xpos;
    public int ypos;


    public Zombie() {
        this.hp = 15;
        this.xpos = 0;
        this.ypos = 0;
    }

    public Zombie(int hp, int xpos, int ypos) {
        this.hp = hp;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public int getHp() {
        return hp;
    }

    public int getAttackPower() {
        return IR5.getRandomNumber(0, 15);
    }

    public void decreaseHp(int atk) {
        hp -= atk;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int atk() {
        return IR5.getRandomNumber(0, 15);
    }


}