package com.company;

import java.util.concurrent.CountDownLatch;

public class Passeger extends Thread {
    private int passnum;
    private int passplace;
    private CountDownLatch cdl;

    public Passeger(int passnum, int passplace, CountDownLatch cdl) {
        this.passnum = passnum;
        this.passplace = passplace;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            System.out.println("Пассажир " + passnum + " купил билет номер " + passplace + (" и занял место " + passplace + " в автобусе"));
            cdl.countDown();
            cdl.await();
            Thread.sleep(100);
            System.out.println("Пассажир " + passnum + " доехал в Ош");
        } catch (InterruptedException e) {
        }

    }
}
