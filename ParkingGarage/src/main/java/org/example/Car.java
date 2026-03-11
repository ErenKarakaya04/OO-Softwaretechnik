package org.example;

public record Car(String carName, int priority) {
    public Car(String carName, int priority) {
        this.carName = carName;
        this.priority = Math.max(priority, 0);

    }
}
