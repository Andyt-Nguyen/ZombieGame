
public class NPC  {
    private int id;
    private int xpos;
    private int ypos;
    private String name;
    private String [] questions;
    private String [] answers;

    public NPC(int id, String name, int xpos, int ypos) {
        this.id = id;
        this.name = name;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getXpos() {
        return xpos;
    }

    
    public int getYpos() {
        return ypos;
    }

    public String[] getQ() {
        return questions;
    }

    public String[] getA() {
        return answers;
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

    public void setQAOptions(int amount) {
        this.questions = new String[amount];
        this.answers = new String[amount];
    }

    public void setOptionsQ(int index, String question) {
        this.questions[index] = question;
    }

    public void setOptionsA(int index, String answer) {
        this.answers[index] = answer;
    }

}