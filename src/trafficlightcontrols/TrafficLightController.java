package trafficlightcontrols;

public class TrafficLightController{

    private TrafficLightModel model;
    private TrafficLightView view;

    public void setView(TrafficLightView v){
        this.view = v;
    }

    public void setModel(TrafficLightModel m){
        this.model = m;
    }

    public void registerEventListeners(){
        view.addButtonListener(event -> model.informAboutPedestrian());
    }
}
