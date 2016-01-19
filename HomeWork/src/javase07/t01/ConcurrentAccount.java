package javase07.t01;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentAccount extends Account {

    private int balance;
    Lock lock;

    public ConcurrentAccount(int balance) {
        this.balance = balance;
        lock = new ReentrantLock();
    }

    public synchronized void balanceIncrease(int value) {
        lock.lock();
        int x = balance + value;
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = x;
        lock.unlock();
    }

    public void balanceDecrease(int value) {
        lock.lock();
        int x = balance - value;
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = x;
        lock.unlock();
    }

    public int getBalance() {
        return balance;
    }
}
