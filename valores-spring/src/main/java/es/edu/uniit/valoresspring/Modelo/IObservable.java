package es.edu.uniit.valoresspring.Modelo;

public interface IObservable
{
    public void notifyObservers();
    public void suscribe(IObserver o);
    public void unsuscribe(IObserver o);
}
