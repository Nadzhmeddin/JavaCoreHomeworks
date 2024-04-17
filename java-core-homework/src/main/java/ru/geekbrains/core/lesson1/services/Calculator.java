package ru.geekbrains.core.lesson1.services;

public class Calculator {
    /**
     * Создаем класс Calculator, где описываем методы с основными математическими действиями;
     */

    public Calculator() {
    }

    /**
     * Функция суммирования:
     * @param firstNumber первое слагаемое
     * @param secondNumber второе слагаемое
     * @return сумма firstNumber и secondNumber.
     */
    public int sumNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * Функция вычитания:
     * @param firstNumber уменьшаемое
     * @param secondNumber вычитаемое
     * @return разность firstNumber и secondNumber.
     */
    public int subtractNumbers(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    /**
     * Функция умножения:
     * @param firstNumber первый множитель
     * @param secondNumber вторый множитель
     * @return произведение firstNumber и secondNumber.
     */
    public int multiplyNumbers(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    /**
     * Функция деления:
     * @param firstNumber делимое
     * @param secondNumber делитель
     * @return частное firstNumber и secondNumber.
     */
    public int divideNumbers(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}
