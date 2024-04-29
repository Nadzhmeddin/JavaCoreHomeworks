package ru.geekbrains.homework4.exceptions;


/**
 * Вариант исключения WrongAddedMoneyException: суть исключения состоит в том,
 * что если пользователь вводит отрицательное число, сразу выбрасывается исключение с пояснениями.
 */
public class WrongAddedMoneyException extends Exception{

    private final double sum;

    public WrongAddedMoneyException(double sum) {
        super();
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String getMessage() {
        return String.format("Невозможно внести отрицательное число: %s", getSum());
    }
}
