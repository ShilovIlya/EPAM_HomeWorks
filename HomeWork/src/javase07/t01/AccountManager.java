package javase07.t01;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * В текстовом (или xml) файле содержится информация о переводах средств со счета на счет.
 * Создайте приложение, позволяющее в параллельном режиме обработать эту информацию.
 * (счета в приложении представляются собой объекты)
 * Синхронизируйте код приложения используя:
 * ключевое слово synchronized (1 вариант)
 * библиотеку java.util.concurrent (2 вариант)
 */

public class AccountManager {

    public static void useNotThreadSafeAccount() {

        try (BufferedReader file = new BufferedReader(new FileReader(new File(".\\src\\resources\\accounts.txt")))) {

            Integer accountBalance1 = new Integer(file.readLine());
            NotThreadSafeAccount account1 = new NotThreadSafeAccount(accountBalance1);
            Integer accountBalance2 = new Integer(file.readLine());
            NotThreadSafeAccount account2 = new NotThreadSafeAccount(accountBalance2);

            System.out.println("Start : balance1 = " + account1.getBalance() + ", balance2 = " + account2.getBalance());

            ArrayList<AccountChanger> accountChangers = new ArrayList<>();
            String operation;
            int changerNum = 0;
            while ((operation = file.readLine()) != null) {

                Integer value = new Integer(operation);
                if (value > 0) {
                    accountChangers.add(new AccountChanger(account1, account2, value));
                } else {
                    accountChangers.add(new AccountChanger(account2, account1, -value));
                }
                changerNum++;
            }

            for (int i = 0; i < changerNum; i++) {
                accountChangers.get(i).start();
            }


            for (int i = 0; i < changerNum; i++) {
                accountChangers.get(i).join();
            }

            System.out.println("End : balance1 = " + account1.getBalance() + "; balance2 = " + account2.getBalance());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void useSynchronizedAccount() {

        try (BufferedReader file = new BufferedReader(new FileReader(new File(".\\src\\resources\\accounts.txt")))) {

            Integer accountBalance1 = new Integer(file.readLine());
            SynchronizedAccount account1 = new SynchronizedAccount(accountBalance1);
            Integer accountBalance2 = new Integer(file.readLine());
            SynchronizedAccount account2 = new SynchronizedAccount(accountBalance2);

            System.out.println("Start : balance1 = " + account1.getBalance() + ", balance2 = " + account2.getBalance());

            ArrayList<AccountChanger> accountChangers = new ArrayList<>();
            String operation;
            int changerNum = 0;
            while ((operation = file.readLine()) != null) {

                Integer value = new Integer(operation);
                if (value > 0) {
                    accountChangers.add(new AccountChanger(account1, account2, value));
                } else {
                    accountChangers.add(new AccountChanger(account2, account1, -value));
                }
                changerNum++;
            }

            for (int i = 0; i < changerNum; i++) {
                accountChangers.get(i).start();
            }

            for (int i = 0; i < changerNum; i++) {
                accountChangers.get(i).join();
            }

            System.out.println("End : balance1 = " + account1.getBalance() + "; balance2 = " + account2.getBalance());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void useConcurrentAccount() {

        try (BufferedReader file = new BufferedReader(new FileReader(new File(".\\src\\resources\\accounts.txt")))) {

            Integer accountBalance1 = new Integer(file.readLine());
            ConcurrentAccount account1 = new ConcurrentAccount(accountBalance1);
            Integer accountBalance2 = new Integer(file.readLine());
            ConcurrentAccount account2 = new ConcurrentAccount(accountBalance2);

            System.out.println("Start : balance1 = " + account1.getBalance() + ", balance2 = " + account2.getBalance());

            String operation;
            int changerNum = 0;
            ArrayList<AccountChanger> accountChangers = new ArrayList<>();

            while ((operation = file.readLine()) != null) {
                Integer value = new Integer(operation);
                if (value > 0) {
                    accountChangers.add(new AccountChanger(account1, account2, value));
                } else {
                    accountChangers.add(new AccountChanger(account2, account1, -value));
                }
                changerNum++;
            }

            for (int i = 0; i < changerNum; i++) {
                accountChangers.get(i).start();
            }

            for (int i = 0; i < changerNum; i++) {
                accountChangers.get(i).join();
            }
            System.out.println("End : balance1 = " + account1.getBalance() + "; balance2 = " + account2.getBalance());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
