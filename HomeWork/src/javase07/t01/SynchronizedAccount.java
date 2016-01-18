package javase07.t01;

public class SynchronizedAccount extends Account{

    private int balance;

    public SynchronizedAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void balanceIncrease(int value) {
        int x = balance + value;
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = x;
    }

    public synchronized void balanceDecrease(int value) {
        int x = balance - value;
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = x;
    }

    public int getBalance() {
        return balance;
    }

}
