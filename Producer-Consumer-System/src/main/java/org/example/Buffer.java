package org.example;

public class Buffer {
    private boolean full = false;
    private volatile int data;

    public synchronized void put(int data, Producer p){
        while (full){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.data = data;
        full = true;
        System.out.println("Producer "+ p.getProducerName() + " wrote value " + this.data + " in Buffer");
        notifyAll();
    }

    public int peek(){return data;}
    public synchronized int get(Consumer c){
        while (!full){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        full = false;
        notifyAll();
        System.out.println("Consumer "+ c.getConsumerName() + " reads value " + data + " from Buffer");
        return data;
    }
}
