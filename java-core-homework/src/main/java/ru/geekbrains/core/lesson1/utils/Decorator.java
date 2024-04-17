package ru.geekbrains.core.lesson1.utils;

public class Decorator {
    /**
     * Метод форматированного вывода результата
     * @param result результат вычисления
     * @return возвращает форматированный вывод
     */
    public static String decorate(int result) {
        return String.format("Calculation result: %d;", result);
    }
}
