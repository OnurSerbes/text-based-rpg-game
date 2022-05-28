public class ChoiceItem {

    private String id;
    private String text;
    private int score;

    public ChoiceItem(String id, String text, int score) {
        this.id = id;
        this.text = text;
        this.score = score;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "\n" + id + ") " + text;
    }
}
