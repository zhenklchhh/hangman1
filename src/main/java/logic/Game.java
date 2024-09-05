package logic;

import java.util.*;

public class Game {
    public static UserInterface ui = new UserInterface();
    public static Set<Character> usedLetters = new HashSet<>();
    public static Word word;
    public static StringBuilder hidenWord;
    public static final int DEATH_STATE = 6;
    public static int countMistakes = 0;
    public static int difficulty = 2;
    public static WordDictionary wd = new WordDictionary();
    public static String categoryWords = wd.getRandomCategory();
    public static boolean isHintUsed = false;
    public static boolean checkWin(){
        return String.valueOf(hidenWord).equals(word.value);
    }
    public static boolean checkLose(){
        return countMistakes == DEATH_STATE;
    }
    public static boolean isValidLetter(char letter){
        if(!(Character.isLetter(letter) && Character.UnicodeBlock.of(letter) == Character.UnicodeBlock.CYRILLIC)){
            ui.printInvalidInputMessage();
            return false;
        }
        return true;
    }
    public static boolean isGuessedLetter(char letter){
        if (usedLetters.contains(letter)){
            ui.printUsedLetterMessage();
            return false;
        }
        return true;
    }
    public static boolean isLetterInWord(char letter){
        boolean hasLetter = false;
        for(int i = 0; i < word.value.length(); i++){
            if (word.value.charAt(i) == letter){
                hasLetter = true;
                hidenWord.replace(i, i + 1, String.valueOf(letter));
            }
        }
        return hasLetter;
    }
    public static void gameRound(){
        ui.printStage(countMistakes, hidenWord);
        if(countMistakes == 4 && !isHintUsed){
            ui.printHint(word);
            isHintUsed = true;
        }
        char letter = ui.getLetterFromUser();
        while(!isValidLetter(letter) || !isGuessedLetter(letter))
            letter = ui.getLetterFromUser();
        usedLetters.add(letter);
        countMistakes += isLetterInWord(letter) ? 0 : 1;
    }
    public void startGame(){
        ui.printMaxMistakesMessage();
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
        word = getRandomWord(wd.getWords(categoryWords, difficulty));
        hidenWord = new StringBuilder("-".repeat(word.value.length()));
        boolean gameFinished = false;
        while(!gameFinished){
            gameRound();
            if(checkWin()){
                ui.printWinMessage(word);
                gameFinished = true;
            }
            if(checkLose()){
                ui.drawHangman(countMistakes);
                ui.printLoseMessage(word);
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