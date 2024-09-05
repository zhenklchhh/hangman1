package logic;

public class Word {
    String category;
    int difficulty;
    String value;
    String hint;
    public Word(String category, int difficulty, String value, String hint) {
        this.category = category;
        this.difficulty = difficulty;
        this.value = value;
        this.hint = hint;
    }
}