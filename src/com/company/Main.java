package com.company;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static final int PASSENGER_СOUNT = 100;

    public static void main(String[] args) throws InterruptedException{
        Random rand = new Random();
        CountDownLatch latch = new CountDownLatch(PASSENGER_СOUNT+2);
        for (int i = 1; i <= PASSENGER_СOUNT ; i++) {
            Passeger passeger = new Passeger(i, rand.nextInt(100)+1, latch);
            passeger.start();
            Thread.sleep(100);
        }
        while (latch.getCount() > 100){
            Thread.sleep(100);
        }
        Thread.sleep(100);
        System.out.println("Все пассажиры в автобусе");
        latch.countDown();
        Thread.sleep(100);
        System.out.println("Поехали!");
        latch.countDown();
    }

}
