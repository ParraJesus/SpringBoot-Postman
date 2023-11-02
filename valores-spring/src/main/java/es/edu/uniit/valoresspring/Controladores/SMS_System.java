package es.edu.uniit.valoresspring.Controladores;

import es.edu.uniit.valoresspring.Modelo.IObserver;

public class SMS_System implements IObserver {

    public void sendMessage()
    {
        System.out.println("El precio de una acción a la que se ha suscrito, ha rebasado los umbrales");
    }
    @Override
    public void updateObserver()
    {
        sendMessage();
    }
}
