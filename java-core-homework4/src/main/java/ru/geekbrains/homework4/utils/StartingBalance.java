package ru.geekbrains.homework4.utils;

import ru.geekbrains.homework4.exceptions.WrongStartingBalanceException;
import ru.geekbrains.homework4.model.CreditAccount;
import ru.geekbrains.homework4.model.DebitAccount;

import java.util.Scanner;

/**
 * В данном методе, пользователь вводит изначальный баланс DebitAccount и CreditAccount.
 * Все проверки на исключения соблюдаются и пробрасываются выше по стеку.
 */
public class StartingBalance {

    public void startingBalance(DebitAccount debitAccount, CreditAccount creditAccount) throws WrongStartingBalanceException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите Ваш начальный баланс дебетового счета: ");
        double debitBalance = sc.nextDouble();
        if(debitBalance < 0 ) {
            throw new WrongStartingBalanceException(debitBalance);
        }
        System.out.print("Введите Ваш начальный баланс кредитного счета: ");
        double creditBalance = sc.nextDouble();
        if(creditBalance < 0) {
            throw new WrongStartingBalanceException(creditBalance);
        }
        debitAccount.setBalance(debitBalance);
        creditAccount.setBalance(creditBalance);
    }
}
