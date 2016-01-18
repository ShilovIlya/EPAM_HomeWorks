package javase07.t01;


public class NotThreadSafeAccount extends Account{

    private int balance;

    public NotThreadSafeAccount(int balance) {
        this.balance = balance;
    }

    public void balanceIncrease(int value) {
        int x = balance + value;
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = x;
    }

    public void balanceDecrease(int value) {
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
