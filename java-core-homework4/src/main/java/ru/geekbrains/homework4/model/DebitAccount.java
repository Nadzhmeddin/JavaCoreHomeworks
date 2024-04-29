package ru.geekbrains.homework4.model;

/**
 * Модель дебетового счета, наследован от Account. Самый обычный дебетовый счет, без каких-либо комиссий.
 */
public class DebitAccount extends Account {

    public DebitAccount(double balance) {
        super(balance);
    }

    public DebitAccount() {
    }

    @Override
    public void printBalance() {
        super.printBalance();
    }

    @Override
    public void addMoney(double money) {
        super.addMoney(money);
    }

    @Override
    public void getMoney(double money) {
        super.getMoney(money);
    }
}
