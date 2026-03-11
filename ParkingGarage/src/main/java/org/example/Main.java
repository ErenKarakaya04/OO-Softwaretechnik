package org.example;

import java.util.Random;

public class Main {
    static void main() {

        ParkingLot pl = new ParkingLot(2);
        int carCount = 10;
        Thread[] cars = new Thread[carCount];
        for (int i = 0; i < carCount; i++) {
            int carNum = i+1;

             cars[i] = new Thread(()->{
                Car car = new Car("Car " + carNum, carNum);
                pl.enter(car);
                int timeToWait = new Random().nextInt(5000);
                try {
                    Thread.sleep(timeToWait);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                pl.leave(car);
            });
        }

        for (Thread car: cars){
            car.start();
        }
   }
}
