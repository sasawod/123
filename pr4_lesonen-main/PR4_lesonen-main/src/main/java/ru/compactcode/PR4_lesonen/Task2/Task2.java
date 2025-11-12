package ru.compactcode.PR4_lesonen.Task2;

public class Task2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("Поток A", 100));
        Thread thread2 = new Thread(new MyRunnable("Поток B", 150));
        Thread thread3 = new Thread(new MyRunnable("Поток C", 200));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnable implements Runnable {

    private final String name;
    private final int delay;

    public MyRunnable(String name, int delay) {
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
