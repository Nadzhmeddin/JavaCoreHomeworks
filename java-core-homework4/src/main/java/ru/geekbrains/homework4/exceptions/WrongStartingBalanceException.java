package ru.geekbrains.homework4.exceptions;

/**
 * Вариант исключения WrongStartingBalanceException: если пользователь при вводе изначальных балансов DebitAccount и
 * CreditAccount вводит отрицательное число, что невозможно, сразу выбрасывается исключение с подробным пояснением.
 */
public class WrongStartingBalanceException extends Exception{

    private final double balance;

    public WrongStartingBalanceException(double balance) {
        super();
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String getMessage() {
        return String.format("Извините, но начальный баланс должен быть больше нуля! Вы вводите: %s", balance);
    }

}
