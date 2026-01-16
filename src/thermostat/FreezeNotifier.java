package thermostat;

public class FreezeNotifier implements Observer{

    private void informFreezing(int currentTemperature){
        if (currentTemperature < 5){
            System.out.println("Die Temperatur im Raum ist unter 5°C !\uD83E\uDDCA");
        }
    }

    @Override
    public void update(int temperature) {
        informFreezing(temperature);
    }
}
