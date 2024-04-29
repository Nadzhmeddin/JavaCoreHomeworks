package ru.geekbrains.homework4.exceptions;

/**
 * Вариант исключения WrongTakedMoneyException: если пользователь при снятии средств с DebitAccount или CreditAccount
 * пытается снять больше, чем текущий баланс, сразу выбрасывается исключение с подробным сообщением.
 */
public class WrongTakedMoneyException extends Exception{

    private final double money;
    private final double currentBalance;

    public WrongTakedMoneyException(double money, double currentBalance) {
        super();
        this.money = money;
        this.currentBalance = currentBalance;
    }

    public double getMoney() {
        return money;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    @Override
    public String getMessage() {
        return String.format("Невозможно снять средства со счета, так как Вы снимаете: %s, " +
                "при текущем балансе: %s",money,currentBalance);
    }
}
