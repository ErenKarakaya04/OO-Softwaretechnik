public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int maxValue = 10;
        Turnstile t1 = new Turnstile(counter, maxValue);
        Turnstile t2 = new Turnstile(counter, maxValue);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Value of counter is " + counter);
    }
}