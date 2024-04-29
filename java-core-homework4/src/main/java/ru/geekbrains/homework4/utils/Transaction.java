package ru.geekbrains.homework4.utils;

import ru.geekbrains.homework4.exceptions.WrongTakedMoneyException;
import ru.geekbrains.homework4.model.CreditAccount;
import ru.geekbrains.homework4.model.DebitAccount;

import java.util.Scanner;

/**
 * Метод транзакции: в данном методе реализована логика перевода средств с DebitAccount на CreditAccount.
 * При снятии средств с CreditAccount реализовано предупреждение о комиссии и соответственно снятие с комиссией
 * с дальнейшим выводом баланса.
 */
public class Transaction {

    public void accountTransaction(CreditAccount creditAccount, DebitAccount debitAccount) throws WrongTakedMoneyException{
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Выберите счет с которого хотите перевести денежные средства:\n1.С дебетового счета: Баланс %s;" +
                "\n2.С кредитного счета: Баланс %s\n", debitAccount.getBalance(), creditAccount.getBalance());
        System.out.print("Ввод: ");
        int numberOperation = scanner.nextInt();
        if(numberOperation == 1) {
            System.out.print("Введите сумму снятия: ");
            double amount = scanner.nextDouble();
            if(amount > debitAccount.getBalance()) {
                throw new WrongTakedMoneyException(amount, debitAccount.getBalance());
            } if(amount < 0) {
                throw new WrongTakedMoneyException(amount, creditAccount.getBalance());
            } else creditAccount.setBalance(creditAccount.getBalance() + amount);
            debitAccount.setBalance(debitAccount.getBalance() - amount);
            System.out.printf("Перевод совершен!\nБаланс дебетового счета: %s;" +
                    "\nБаланс кредитного счета: %s\n",debitAccount.getBalance(), creditAccount.getBalance());
        } if(numberOperation == 2) {
            System.out.println("Внимание! При снятии средств с кредитного счета, комиссия 2%!");
            System.out.print("Введите сумму снятия: ");
            double amount = scanner.nextDouble();
            if(amount > debitAccount.getBalance()) {
                throw new WrongTakedMoneyException(amount, debitAccount.getBalance());
            } if(amount < 0) {
                throw new WrongTakedMoneyException(amount, creditAccount.getBalance());
            } else creditAccount.setBalance(creditAccount.getBalance() - amount -
                    amount*creditAccount.getCreditCommission());
            debitAccount.setBalance(debitAccount.getBalance() + amount);
            System.out.printf("Перевод совершен!\nБаланс дебетового счета: %s;" +
                    "\nБаланс кредитного счета: %s\n",debitAccount.getBalance(), creditAccount.getBalance());
        }
        if(numberOperation !=1 && numberOperation !=2) {
            throw new RuntimeException("Выбор неверного счета!");
        }
    }
}
