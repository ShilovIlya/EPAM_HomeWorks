package javase07.t03;

public class UserResourceThread {

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        IntegerSetterGetter t1 = new IntegerSetterGetter("1", resource);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", resource);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", resource);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", resource);
        IntegerSetterGetter t5 = new IntegerSetterGetter("5", resource);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.sleep(100);

        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();
        t5.stopThread();


        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("main");
    }

}
