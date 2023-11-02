package es.edu.uniit.valoresspring.Modelo;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

// Hecho por Jesus Gabriel Parra Dugarte

@Data
public class Action implements IObservable
{
    @NonNull
    private String name;

    @NonNull
    private Double currentPrice;

    @NonNull
    private Double previousPrice;

    @NonNull
    private Double upperThreshold;

    @NonNull
    private Double lowerThreshold;

    private ArrayList<IObserver> observers;

    @Override
    public void notifyObservers()
    {
        if(observers.isEmpty()) return;

        for(IObserver o: observers)
        {
            o.updateObserver();
        }
    }

    @Override
    public void suscribe(IObserver o)
    {
        observers.add(o);
    }

    @Override
    public void unsuscribe(IObserver o)
    {
        observers.remove(o);
    }
}
