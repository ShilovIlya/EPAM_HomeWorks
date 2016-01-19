package javase07.t03;

import java.util.Random;

public class IntegerSetterGetter extends Thread {

    private SharedResource resource;
    private boolean run;
    private static int threadNum = 0;
    private static int waitThreadNum = 0;

    private Random random = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
        threadNum++;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while(run) {
                action = random.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
            threadNum--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName() + " хочет извлеч число.");
            number = resource.getElement();
            while (number == null) {
                if (waitThreadNum + 1 < threadNum) {
                    System.out.println("Поток " + getName() + " ждет пока в очереди появятся элементы.");
                    waitThreadNum++;
                    resource.wait();
                    waitThreadNum--;
                    System.out.println("Поток " + getName() + " возобновил работу.");
                } else {
                    System.out.println("Поток " + getName() + " не смог извлеч число, так как все потоки кроме" +
                            " него находятся в ожидании и в коллекции нет элементов для чтения" );
                    return;
                }
                number = resource.getElement();
            }
            System.out.println("Поток " + getName() + " извлек число: " + number);
        }
    }


    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = random.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число " + number);
            resource.notify();
        }
    }
}
