public class NPC extends Person {
    private String text;

    public NPC(String username, int xpos, int ypos, String text) {
        super(username, xpos, ypos);
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}