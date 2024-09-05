package logic;

import java.util.Scanner;

public class UserInterface {
    public static Scanner sc = new Scanner(System.in);
    public void showMainMenu(){
        System.out.println("--Главное меню--");
        System.out.println("1. Начать игру");
        System.out.println("2. Выбрать сложность");
        System.out.println("3. Выбрать категорию отгадываемых слов");
        System.out.println("4. Выход");
    }
    public int getUserMainMenuChoice(){
        while(true){
            int choice = sc.nextInt();
            if(choice < 1 || choice > 4){
                System.out.println("Некорректный ввод");
            }else if(choice == 4){
                System.exit(0);
            }else{
                return choice;
            }
        }
    }
    public void showDifficultyMenu(){
        System.out.println("--Выбор сложности--");
        System.out.println("1. Легкая");
        System.out.println("2. Средняя");
        System.out.println("3. Сложная");
    }
    public int getUserDifficultyMenuChoice(){
        while(true){
            int choice = sc.nextInt();
            if(choice < 1 || choice > 3){
                System.out.println("Некорректный ввод");
            }else{
                return choice;
            }
        }
    }
    public void showCategoryMenu(){
        System.out.println("--Категории слов--");
        System.out.println("1. Еда");
        System.out.println("2. Города");
        System.out.println("3. Животные");
    }
    public String getUserCategoryMenuChoice(){
        while(true){
            int choice = sc.nextInt();
            if(choice < 1 || choice > 4){
                System.out.println("Некорректный ввод");
                continue;
            }
            switch(choice){
                case 1:
                    return "Еда";
                case 2:
                    return "Города";
                case 3:
                    return "Животные";
                default:
                    throw new IllegalArgumentException("Некорректный ввод");
            }
        }
    }
    public static void drawHangman(int mistakes) {
        switch (mistakes) {
            case 0:
                System.out.println("""
                           +----+
                           |    |
                                |
                                |
                                |
                                |
                        =========
                        """);
                break;
            case 1:
                System.out.println("""
                           +----+
                           |    |
                           O    |
                                |
                                |
                                |
                        =========
                        """);
                break;
            case 2:
                System.out.println("""
                           +----+
                           |    |
                           O    |
                           |    |
                                |
                                |
                        =========
                        """);
                break;
            case 3:
                System.out.println("""
                          +----+
                          |    |
                          O    |
                          |\\   |
                               |
                               |
                        =========
                        """);
                break;
            case 4:
                System.out.println("""
                           +----+",
                           |    |",
                           O    |",
                          /|\\   |",
                                |",
                                |",
                        ========="
                        """);
                break;
            case 5:
                System.out.println("""
                          +----+
                          |    |
                          O    |
                         /|\\   |
                           \\   |
                               |
                        =========
                        """);
                break;
            case 6:
                System.out.println("""
                          +----+
                          |    |
                          O    |
                         /|\\   |
                         / \\   |
                               |
                        =========
                        """);
                break;
        }
    }
    public static void printStage(int countMistakes, StringBuilder hidenword){
        drawHangman(countMistakes);
        System.out.println("Количество ошибок: " + countMistakes);
        System.out.println(hidenword);
        System.out.println("Введите букву: ");
    }
    public char getLetterFromUser(){
        return Character.toLowerCase(sc.next().charAt(0));
    }
}