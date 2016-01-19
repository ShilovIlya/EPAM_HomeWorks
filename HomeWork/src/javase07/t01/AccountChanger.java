package javase07.t01;

public class AccountChanger extends Thread{

    private Account account1;
    private Account account2;
    private int value;

    public AccountChanger(Account acc1, Account acc2, int val) {
        account1 = acc1;
        account2 = acc2;
        value = val;
    }

    public void run() {
        account1.balanceDecrease(value);
        account2.balanceIncrease(value);
    }


}
