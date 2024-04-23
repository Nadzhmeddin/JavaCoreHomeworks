package ru.geekbrains.core;

import java.util.Random;
import java.util.Scanner;

public class homework2 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static char[][] field;


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y -да): ");
            if(!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print("-" + (x + 1));
        }
        System.out.println("-");

        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }
        for (int x = 0; x < fieldSizeX * 2 + 2; x++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход человека
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите через пробел координаты хода X и Y:\n(от 1 до 3): ");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
        }while (!isCellValid(x,y) || !isCellEmpty(x,y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Ход компьютера
     */
    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x,y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x координата по строкам
     * @param y координата по столбцам
     * @return возвращает проверку на пустоту
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     * @param x координата по строкам
     * @param y координата по столбцам
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Проверка на ничью
     * @return возвращает проверку на ничью
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x,y)) return false;
            }
        }return true;
    }

    /**
     * Проверка на победу по стобцу и строкам
     * @param dot фишка игрока
     */
    static boolean checkWin(char dot) {
        for (int x = 0; x < fieldSizeX; x++) {
            int countToWinHorizontal = 0;
            int countToWinVertical = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if(field[x][y] == dot) countToWinHorizontal++;
                else if(field[x][y]!= dot && countToWinHorizontal < WIN_COUNT) countToWinHorizontal = 0;
                if(field[y][x] == dot) countToWinVertical++;
                else if(field[y][x]!= countToWinVertical && countToWinVertical < WIN_COUNT) countToWinVertical = 0;
            } if((countToWinHorizontal == WIN_COUNT) || (countToWinVertical == WIN_COUNT)){
                return true;
            }
        } return false;
    }

    /**
     * Проверка победы по двум диагоналям
     * @param dot фишка игрока
     */
    static boolean checkWinTwoDiagonal(char dot) {
        int countToWinFirstDiagonal = 0;
        int countToWinSecondDiagonal = 0;
        for (int x = 0; x < fieldSizeX; x++) {
            // Симметричные координаты по первой диагонали
            if(field[x][x] == dot) countToWinFirstDiagonal ++;
            else if(field[x][x] != dot && countToWinFirstDiagonal < WIN_COUNT) countToWinFirstDiagonal = 0;
            // Проверка по второй диагонали
            if(field[x][field.length - 1 - x] == dot) countToWinSecondDiagonal ++;
            else if(field[x][field.length - 1 -x] != dot && countToWinSecondDiagonal < WIN_COUNT)  countToWinSecondDiagonal = 0;
        } if((countToWinFirstDiagonal == WIN_COUNT) || (countToWinSecondDiagonal == WIN_COUNT)) return true;
        return false;
    }

    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param s победный слоган при победе
     */
    static boolean checkState(char dot, String s) {
        if(checkWin(dot)) {
            System.out.println(s);
            return true;
        }
        else if(checkWinTwoDiagonal(dot)) {
            System.out.println(s);
            return true;
        }
        else if(checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }
}
