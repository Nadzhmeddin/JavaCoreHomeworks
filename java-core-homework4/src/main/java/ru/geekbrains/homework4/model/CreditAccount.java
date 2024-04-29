package ru.geekbrains.homework4.model;

/**
 * Модель кредитного счета, наследован от Account, но есть отличие, что при снятии средств, есть комиссия 0.2%.
 */
public class CreditAccount extends Account {

    private final double creditCommission = 0.2;

    public CreditAccount(double balance) {
        super(balance);
    }

    public CreditAccount() {
    }

    @Override
    public void addMoney(double money) {
        super.addMoney(money);
    }

    @Override
    public void getMoney(double money) {
        balance = balance - money - money*getCreditCommission();
    }

    @Override
    public void printBalance() {
        System.out.println("Ваш баланс кредитного счета: " + getBalance());
    }

    public double getCreditCommission() {
        return creditCommission;
    }
}
