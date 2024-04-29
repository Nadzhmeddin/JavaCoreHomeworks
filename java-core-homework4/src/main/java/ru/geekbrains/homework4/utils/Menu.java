package ru.geekbrains.homework4.utils;

import ru.geekbrains.homework4.exceptions.WrongAddedMoneyException;
import ru.geekbrains.homework4.exceptions.WrongTakedMoneyException;
import ru.geekbrains.homework4.model.CreditAccount;
import ru.geekbrains.homework4.model.DebitAccount;

import java.util.Scanner;

/**
 * Класс Menu: в данным классе прописана вся логика работы Меню и навигации по операциям в банковской системе.
 */
public class Menu {

    Scanner sc = new Scanner(System.in);
    Transaction transaction = new Transaction();

    public void menu(DebitAccount debitAccount, CreditAccount creditAccount) throws WrongAddedMoneyException, WrongTakedMoneyException {
        System.out.println("Введите номер операции:\n1.Показать баланс;\n2.Внести денежные средства;\n" +
                "3.Снять денежные средства;\n4.Совершить перевод;\n5.Выход;");
        System.out.print("Ввод номера операции: ");
        int operationNumber = sc.nextInt();
        if(operationNumber == 1) {
            debitAccount.printBalance();
            creditAccount.printBalance();
        }
        else if(operationNumber == 2) {
            double sum = 0;
            System.out.printf("Выберите счет для внесения средств:\n1.Дебетовый счет: %s;\n2.Кредитный счет: %s;\nВвод: ",
                    debitAccount.getBalance(), creditAccount.getBalance());
            int operation = sc.nextInt();
            if(operation == 1) {
                System.out.print("Сумма для взноса: ");
                double amount = sc.nextDouble();
                if(amount < 0 ) {
                    throw new WrongAddedMoneyException(amount);
                }
                debitAccount.addMoney(amount);
                System.out.printf("Сумма внесена, баланс: %s\n", debitAccount.getBalance());
            }
            if(operation == 2) {
                System.out.print("Сумма для взноса: ");
                double amount = sc.nextDouble();
                if(amount < 0) {
                    throw new WrongAddedMoneyException(amount);
                }
                creditAccount.addMoney(amount);
                System.out.printf("Сумма внесена, баланс: %s\n", creditAccount.getBalance());
            }
        }
        else if(operationNumber == 3) {
            System.out.printf("Выберите счет для снятия средств:\n1.Дебетовый счет: %s;\n2.Кредитный счет: %s;\nВвод: ",
                    debitAccount.getBalance(), creditAccount.getBalance());
            int takeOperation = sc.nextInt();
            if(takeOperation == 1) {
                System.out.print("Сумма для снятия средств: ");
                double amount = sc.nextDouble();
                if(amount > debitAccount.getBalance()) {
                    throw new WrongTakedMoneyException(amount, debitAccount.getBalance());
                }
                if(amount < 0 ) {
                    throw new WrongTakedMoneyException(amount, debitAccount.getBalance());
                }
                debitAccount.getMoney(amount);
                System.out.printf("Денежные средства сняты.Баланс: %s\n",debitAccount.getBalance());
            }
            if(takeOperation == 2) {
                System.out.println("Внимание! При снятии средств с кредитного счета, комиссия 2%!");
                System.out.print("Сумма для снятия средств: \n");
                double amount = sc.nextDouble();
                if(amount > creditAccount.getBalance()) {
                    throw new WrongTakedMoneyException(amount, creditAccount.getBalance());
                }
                if(amount < 0 ) {
                    throw new WrongTakedMoneyException(amount, creditAccount.getBalance());
                }
                creditAccount.getMoney(amount);
                System.out.printf("Денежные средства сняты.Баланс: %s\n",creditAccount.getBalance());
            }
        }
        else if(operationNumber == 4) {
            transaction.accountTransaction(creditAccount, debitAccount);
        }
        else if(operationNumber == 5) {
            System.out.println("Пока-пока");
        }
    }

}
