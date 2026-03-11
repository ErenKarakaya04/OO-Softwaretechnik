package org.example;

public class PriorityQueue {
    private QueueElement head;

    public void add(Car car) {
        QueueElement newElement = new QueueElement(car, car.priority(), null);

        if (head == null || newElement.priority < head.priority) {
            newElement.nextElement = head;
            head = newElement;
            return;
        }

        QueueElement current = head;
        while (current.nextElement != null && current.nextElement.priority <= newElement.priority) {
            current = current.nextElement;
        }

        newElement.nextElement = current.nextElement;
        current.nextElement = newElement;
    }

    public void remove(Car car) {
        if (head == null) {
            return;
        }
        if (head.car.equals(car)) {
            head = head.nextElement;
            return;
        }

        QueueElement current = head;

        while (current.nextElement != null && !(current.nextElement.car.equals(car))) {
            current = current.nextElement;
        }
        if (current.nextElement != null) {
            current.nextElement = current.nextElement.nextElement;
        }
    }

    public Car peek() {
        if (head == null) {
            return null;
        }
        return head.car;
    }
}