package ru.compactcode.PR4_lesonen.Task1;

public class Task1 {

    public static void main(String[] args) {
        Thread thread1 = new MyThread("Поток 1", 100);
        Thread thread2 = new MyThread("Поток 2", 150);
        Thread thread3 = new MyThread("Поток 3", 200);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyThread extends Thread {

    private final String name;
    private final int delay;

    public MyThread(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": сообщение " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " прерван");
            }
        }
    }
}
