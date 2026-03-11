package org.example;

public class ParkingLot {
    private int availablePlaces;
    private final PriorityQueue waitingCars;

    public ParkingLot(int places) {
        this.availablePlaces = places;
        this.waitingCars = new PriorityQueue();
    }

    public synchronized void enter(Car car) {
        waitingCars.add(car);

        while (availablePlaces == 0 || !waitingCars.peek().equals(car)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        availablePlaces--;
        waitingCars.remove(car);
        System.out.println(car.carName() + " entered the parking lot with Priority " + car.priority() + ".");
    }

    public synchronized void leave(Car car) {
        availablePlaces++;
        System.out.println(car.carName() + " left the parking lot.");
        notifyAll();
    }
}