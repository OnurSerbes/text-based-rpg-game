import java.util.ArrayList;

public class StoryItem {

    private int id;
    private String text;
    private ArrayList<ChoiceItem> choiceItemList;

    public StoryItem(int id, String text, ArrayList<ChoiceItem> choiceItemList) {
        this.id = id;
        this.text = text;
        this.choiceItemList = choiceItemList;
    }

    public boolean addChoice (String id, String text, int score ){
        ChoiceItem newChoiceItem = new ChoiceItem(id,text,score);
        return choiceItemList.add(newChoiceItem);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<ChoiceItem> getChoiceList() {
        return choiceItemList;
    }

    public void setChoiceList(ArrayList<ChoiceItem> choiceItemList) {
        this.choiceItemList = choiceItemList;
    }

    @Override
    public String toString() {
        return text + " " + choiceItemList;
    }
}
