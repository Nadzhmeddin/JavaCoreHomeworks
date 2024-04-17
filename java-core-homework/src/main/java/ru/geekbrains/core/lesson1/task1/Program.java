package ru.geekbrains.core.lesson1.task1;

import ru.geekbrains.core.lesson1.services.Calculator;

import static ru.geekbrains.core.lesson1.utils.Decorator.decorate;

/**
 * Метод main является точкой входа в программу, где выполняем все написанныые методы.
 */
public class Program {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println(decorate(calculator.divideNumbers(6, 3)));

        System.out.println(decorate(calculator.sumNumbers(10, 5)));

        System.out.println(decorate(calculator.multiplyNumbers(3, 4)));

        System.out.println(decorate(calculator.subtractNumbers(15, 10)));
    }
}
