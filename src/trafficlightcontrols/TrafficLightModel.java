package trafficlightcontrols;

import java.util.ArrayList;
import java.util.List;

public class TrafficLightModel extends Subject{

    private Color state = Color.Red;
    private boolean pedestrianWaiting;
    private final List<Observer> observers = new ArrayList<>();
    private final int longPhaseTime = 10000;
    private final int normalPhaseTime = 5000;

    public void start() throws InterruptedException {
        while(true){
            this.changeState();
        }
    }
    public void changeState() throws InterruptedException {
        this.state = this.state.next();
        System.out.println("Die Ampelphase ist nun: " + this.state);
        notifyObservers();

        try{
            if (pedestrianWaiting && this.state == Color.Red){
                Thread.sleep(longPhaseTime);
                pedestrianWaiting = false;
            }
            else{
                Thread.sleep(normalPhaseTime);

            }
        }
        catch (InterruptedException e) {
            System.err.println("ERR: Failed to wait for new state readings!");
        }

    }
    public void informAboutPedestrian(){
        pedestrianWaiting = true;
    }

    @Override
    void addObserver(Observer observer) {
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    void notifyObservers() {
        for(Observer observer: observers){
            observer.update(this.state);
        }
    }
}
