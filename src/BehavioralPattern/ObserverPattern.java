package BehavioralPattern;

import java.util.Observable;
import java.util.Observer;

class WeatherCastCenter extends Observable{
    private String weather;

    public WeatherCastCenter(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
        // trigger event
        setChanged();
        // notify event
        notifyObservers();
    }
}

class ObserverDevice implements Observer{

    private WeatherCastCenter weatherUpdate;

    // action that observer will take once receive notification
    @Override
    public void update(Observable observable, Object arg) {
        weatherUpdate = (WeatherCastCenter) observable;
        System.out.println("Weather Report Live. It is " + weatherUpdate.getWeather());
    }
}

public class ObserverPattern{
    public static void main(String[] args) {
        System.out.println("Observer Pattern!");

        WeatherCastCenter weatherCastCenter = new WeatherCastCenter(null);

        ObserverDevice android = new ObserverDevice();
        ObserverDevice ios = new ObserverDevice();

        // register observer to observable
        weatherCastCenter.addObserver(android);
        weatherCastCenter.addObserver(ios);

        // trigger the event
        System.out.println("Trigger the event via observable!");
        weatherCastCenter.setWeather("Raining!");
    }
}
