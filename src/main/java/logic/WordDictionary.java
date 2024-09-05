package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordDictionary {
    List<Word> words = new ArrayList<>();
    public WordDictionary() {
        words.add(new Word("Животные", 1, "лиса"));
        words.add(new Word("Животные", 1, "жук"));
        words.add(new Word("Животные", 1, "пес"));
        words.add(new Word("Животные", 1, "кот"));
        words.add(new Word("Животные", 2, "тигр"));
        words.add(new Word("Животные", 2, "слон"));
        words.add(new Word("Животные", 2, "медведь"));
        words.add(new Word("Животные", 2, "зебра"));
        words.add(new Word("Животные", 2, "орел"));
        words.add(new Word("Животные", 3, "ягуар"));
        words.add(new Word("Животные", 3, "барсук"));
        words.add(new Word("Животные", 3, "ламантин"));
        words.add(new Word("Животные", 3, "колибри"));
        words.add(new Word("Города", 1, "Москва"));
        words.add(new Word("Города", 1, "Рим"));
        words.add(new Word("Города", 1, "Лондон"));
        words.add(new Word("Города", 1, "Берлин"));
        words.add(new Word("Города", 2, "Пекин"));
        words.add(new Word("Города", 2, "Токио"));
        words.add(new Word("Города", 2, "Сидней"));
        words.add(new Word("Города", 2, "Дели"));
        words.add(new Word("Города", 2, "Каир"));
        words.add(new Word("Города", 3, "Ванкувер"));
        words.add(new Word("Города", 3, "Рейкьявик"));
        words.add(new Word("Города", 3, "Йоханнесбург"));
        words.add(new Word("Еда", 1, "сыр"));
        words.add(new Word("Еда", 1, "яблоко"));
        words.add(new Word("Еда", 1, "хлеб"));
        words.add(new Word("Еда", 1, "суп"));
        words.add(new Word("Еда", 2, "пицца"));
        words.add(new Word("Еда", 2, "спагетти"));
        words.add(new Word("Еда", 2, "лазанья"));
        words.add(new Word("Еда", 2, "паэлья"));
        words.add(new Word("Еда", 3, "трюфели"));
        words.add(new Word("Еда", 3, "фондю"));
        words.add(new Word("Еда", 3, "карпаччо"));
        words.add(new Word("Еда", 3, "рататуй"));

    }
    public List<Word> getWords(String category, int difficulty){
        return words.stream()
                .filter(w -> w.category.equals(category) && w.difficulty == difficulty)
                .collect(Collectors.toList());
    }
}