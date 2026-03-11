package org.example;

public class Viewer extends Thread{
    private Buffer buffer;

    public Viewer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Buffer value: " + buffer.peek());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        }
    }
}
