package org.example;

import static org.example.Producer.N;

public class Consumer extends Thread{

    private String name;
    private Buffer buffer;

    public Consumer(String name, Buffer buffer){
        this.name = name;
        this.buffer = buffer;
    }
    public String getConsumerName(){
        return name;
    }
    @Override
    public void run(){
        for (int i = 0; i < N; i++) {
            int value = buffer.get(this);
        }

    }
}
