public class Counter {
    private volatile int counter = 0;

    public synchronized void increase() {
        counter++;
        System.out.println("Increasing counter to " + counter);
    }

    @Override
    public String toString() {
        return String.valueOf(counter);
    }
}