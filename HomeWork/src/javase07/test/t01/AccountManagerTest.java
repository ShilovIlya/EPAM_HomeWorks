package javase07.test.t01;

import javase07.t01.AccountManager;
import org.junit.Test;


public class AccountManagerTest {

    @Test
    public void NotThreadSafeAccountTest(){
        System.out.println("\nUse not thread safe account:");
        AccountManager.useNotThreadSafeAccount();
    }

    @Test
    public void SynchronizedAccountTest(){
        System.out.println("\nUse synchronized account:");
        AccountManager.useSynchronizedAccount();
    }

    @Test
    public void ConcurrentAccountTest(){
        System.out.println("\nUse java.util.concurrent:");
        AccountManager.useConcurrentAccount();
    }

}
