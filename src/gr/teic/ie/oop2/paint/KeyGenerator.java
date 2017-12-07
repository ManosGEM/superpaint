package gr.teic.ie.oop2.paint;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labuser
 */
public class KeyGenerator implements Subject {

    public static int id = 1;

    private List<Observer> observers;
    
    public static int produceKey(){
        return id++;
    }
    public KeyGenerator() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(float temperature, float humidity, float pressure) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }

}
