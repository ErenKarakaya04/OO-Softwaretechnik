package org.example;

import org.jetbrains.annotations.Nullable;

public class QueueElement {
    public final Car car;
    public final int priority;
    public @Nullable QueueElement nextElement;

    public QueueElement(Car car, int priority, @Nullable QueueElement nextElement) {
        this.car = car;
        this.priority = priority;
        this.nextElement = nextElement;
    }
}
