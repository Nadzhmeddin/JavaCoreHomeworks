package ru.geekbrains.homework4;

import ru.geekbrains.homework4.exceptions.WrongAddedMoneyException;
import ru.geekbrains.homework4.exceptions.WrongStartingBalanceException;
import ru.geekbrains.homework4.exceptions.WrongTakedMoneyException;
import ru.geekbrains.homework4.model.CreditAccount;
import ru.geekbrains.homework4.model.DebitAccount;
import ru.geekbrains.homework4.utils.Menu;
import ru.geekbrains.homework4.utils.StartingBalance;

import java.util.Scanner;

/**
 Домашняя работа
 ===========================================================
 Создать программу управления банковским счетом (Account).
 Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и сумму снятия средств.
 При этом она должна обрабатывать следующие исключительные ситуации:
 Попытка создать счет с отрицательным начальным балансом должна вызывать исключение IllegalArgumentException
 с соответствующим сообщением.
 Попытка внести депозит с отрицательной суммой должна вызывать исключение IllegalArgumentException
 с соответствующим сообщением.
 Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать исключение
 InsufficientFundsException с сообщением о недостаточных средствах и текущим балансом.
 Продемонстрируйте работу вашего приложения:
 Программа должна обрабатывать все исключения с помощью конструкции try-catch,
 выводя соответствующие сообщения об ошибках.

 2*.
 Создать несколько типов счетов, унаследованных от Account, например: CreditAccount, DebitAccount.
 Создать класс (Transaction), позволяющий проводить транзакции между счетами
 (переводить сумму с одного счета на другой)
 Класс Transaction должен возбуждать исключение в случае неудачной попытки перевести деньги
 с одного счета на другой.
 Продемонстрируйте работу вашего приложения:
 Программа должна обрабатывать все исключения с помощью конструкции try-catch,
 выводя соответствующие сообщения об ошибках.
 Достаточно выполнить только первую задачу, вторая задача является дополнительной.
 */
public class Program {

    private static final DebitAccount debitAccount = new DebitAccount();
    public static final CreditAccount creditAccount = new CreditAccount();
    private static final StartingBalance startingBalance = new StartingBalance();
    private static final Scanner sc = new Scanner(System.in);
    private static final Menu menu = new Menu();


    public static void main(String[] args) {
        try {
            startingBalance.startingBalance(debitAccount, creditAccount);
            while (true) {
                menu.menu(debitAccount, creditAccount);
                System.out.print("Желаете еще совершить операции по счету? (Y - да): ");
                if(!sc.next().equalsIgnoreCase("Y"))
                    break;
            }
        }
        catch (WrongStartingBalanceException e) {
            System.out.println(e.getMessage());
        }
        catch (WrongAddedMoneyException e) {
            System.out.println(e.getMessage());
        }
        catch (WrongTakedMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
}
