public class NPC  {
    private String text;
    private int id;
    private int xpos;
    private int ypos;

    public NPC(int id, String text, int xpos, int ypos) {
        this.id = id;
        this.text = text;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public int getId() {
        return id;
    }

    public int getXpos() {
        return xpos;
    }

    public String getText() {
        return text;
    }

    public int getYpos() {
        return ypos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public void setText(String text) {
        this.text = text;
    }

}