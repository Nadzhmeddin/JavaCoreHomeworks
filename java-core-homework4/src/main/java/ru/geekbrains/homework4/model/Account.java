package ru.geekbrains.homework4.model;

/**
 * Создан абстрактный класс Account, который является родителем CreditAccount и DebitAccount.
 * Единственное поле balance - текущий баланс счета.
 */
public abstract class Account {

    protected double balance;

    public Account(double balance) {
        this.balance = balance;

    }

    public double getBalance() {
        return balance;
    }

    public Account() {
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addMoney(double money) {
        this.balance += money;
    }

    public void getMoney(double money) {
        this.balance -= money;
    }

    public void printBalance() {
        System.out.println("Ваш баланс банковского счета: " + getBalance());
    }
}
