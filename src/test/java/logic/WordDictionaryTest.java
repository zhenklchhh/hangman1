package logic;

import java.util.List;

import static org.junit.Assert.*;

public class WordDictionaryTest {

    @org.junit.Test
    public void getWords() {
        WordDictionary dictionary = new WordDictionary();

        // Проверка для категории "Животные", уровень сложности 2
        List<Word> animalsLevel2 = dictionary.getWords("Животные", 2);
        assertEquals(5, animalsLevel2.size());
        assertEquals("тигр", animalsLevel2.get(0).value);
        assertEquals("слон", animalsLevel2.get(1).value);
        assertEquals("медведь", animalsLevel2.get(2).value);
        assertEquals("зебра", animalsLevel2.get(3).value);
        assertEquals("орел", animalsLevel2.get(4).value);

        // Проверка для категории "Города", уровень сложности 1
        List<Word> citiesLevel1 = dictionary.getWords("Города", 1);
        assertEquals(4, citiesLevel1.size());
        assertEquals("Москва", citiesLevel1.get(0).value);
        assertEquals("Рим", citiesLevel1.get(1).value);
        assertEquals("Лондон", citiesLevel1.get(2).value);
        assertEquals("Берлин", citiesLevel1.get(3).value);

        // Проверка для несуществующей категории
        List<Word> nonExistingCategory = dictionary.getWords("Фрукты", 1);
        assertEquals(0, nonExistingCategory.size());
    }
}