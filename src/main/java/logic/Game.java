package logic;

import java.util.*;

public class Game {
    public static UserInterface ui = new UserInterface();
    public static Set<Character> usedLetters = new HashSet<>();
    public static String word;
    public static StringBuilder hidenWord;
    public static int difficulty = 2;
    public static final int DEATH_STATE = 6;
    public static int countMistakes = 0;
    public static String categoryWords = "Еда";
    public static WordDictionary wd = new WordDictionary();
    public static boolean checkWin(){
        return String.valueOf(hidenWord).equals(word);
    }
    public static void printWinMessage(){
        System.out.println("Ты выйграл! :)");
        System.out.println("Загаданное слово: " + word);
    }
    public static boolean checkLose(){
        return countMistakes == DEATH_STATE;
    }
    public static void printLoseMessage(){
        System.out.println("Тебя повесили :(");
        System.out.println("Загаданное слово: " + word);
    }
    public static boolean isValidLetter(char letter){
        if(!(Character.isLetter(letter) && Character.UnicodeBlock.of(letter) == Character.UnicodeBlock.CYRILLIC)){
            System.out.println("Неправильный ввод. Вводите только маленькие буквы русского алфавита");
            return false;
        }
        return true;
    }
    public static boolean isGuessedLetter(char letter){
        if (usedLetters.contains(letter)){
            System.out.println("Эта буква уже была использована");
            return false;
        }
        return true;
    }
    public static boolean isLetterInWord(char letter){
        boolean hasLetter = false;
        for(int i = 0; i < word.length(); i++){
            if (word.charAt(i) == letter){
                hasLetter = true;
                hidenWord.replace(i, i + 1, String.valueOf(letter));
            }
        }
        return hasLetter;
    }
    public static void gameRound(){
        ui.printStage(countMistakes, hidenWord);
        char letter = ui.getLetterFromUser();
        while(!isValidLetter(letter) || !isGuessedLetter(letter))
            letter = ui.getLetterFromUser();
        usedLetters.add(letter);
        countMistakes += isLetterInWord(letter) ? 0 : 1;
    }
    public void startGame(){
        while(true) {
            ui.showMainMenu();
            int mainMenuChoice = ui.getUserMainMenuChoice();
            switch (mainMenuChoice) {
                case 1:
                    newGame();
                    break;
                case 2:
                    ui.showDifficultyMenu();
                    int difficulty = ui.getUserDifficultyMenuChoice();
                    this.difficulty = difficulty;
                    break;
                case 3:
                    ui.showCategoryMenu();
                    String category = ui.getUserCategoryMenuChoice();
                    this.categoryWords = category;
                    break;
            }
        }
    }
    public void newGame() {
        Word randomWord = getRandomWord(wd.getWords(categoryWords, difficulty));
        word = randomWord.value;
        hidenWord = new StringBuilder("-".repeat(word.length()));
        boolean gameFinished = false;
        while(!gameFinished){
            gameRound();
            if(checkWin()){
                printWinMessage();
                gameFinished = true;
            }
            if(checkLose()){
                ui.drawHangman(countMistakes);
                printLoseMessage();
                gameFinished = true;
            }
        }
        usedLetters.clear();
        countMistakes = 0;
    }
    public static Word getRandomWord(List<Word> words){
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }
}