package org.example;

import java.util.Random;

public class Producer extends Thread{
    public static final int N = 1;

    private String name;
    private Buffer buffer;

    public Producer(String name, Buffer buffer){
        this.name = name;
        this.buffer = buffer;
    }

    public String getProducerName(){
        return name;
    }
    @Override
    public void run(){
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int value = random.nextInt();
            buffer.put(value,this);
        }
    }
}


