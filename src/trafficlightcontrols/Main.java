package trafficlightcontrols;

public class Main {

     static void main() throws InterruptedException {

         TrafficLightController controller = new TrafficLightController();
         TrafficLightModel model = new TrafficLightModel();
         TrafficLightView view = new TrafficLightView();

         controller.setModel(model);
         controller.setView(view);
         controller.registerEventListeners();
         model.addObserver(view);
         model.start();
    }

}
