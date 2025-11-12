package ru.compactcode.PR4_lesonen.Task3;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите задержку для потока 1 (мс): ");
        int delay1 = scanner.nextInt();

        System.out.print("Введите задержку для потока 2 (мс): ");
        int delay2 = scanner.nextInt();

        System.out.print("Введите задержку для потока 3 (мс): ");
        int delay3 = scanner.nextInt();

        Thread t1 = new Thread(new Worker("Поток X", delay1));
        Thread t2 = new Thread(new Worker("Поток Y", delay2));
        Thread t3 = new Thread(new Worker("Поток Z", delay3));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Основной поток прерван");
        }

        System.out.println("Все потоки завершены.");
        scanner.close();
    }
}

class Worker implements Runnable {

    private final String name;
    private final int delay;

    public Worker(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " работает... шаг " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " прерван");
                return;
            }
        }
        System.out.println(name + " завершён.");
    }
}
