package model;

public abstract class HeaterState {

    public abstract void increase(Heater heater);

    public abstract void decrease(Heater heater);

    public abstract void timeout(Heater heater); // todo add to diagram

    public String status()
    {
        return getClass().getSimpleName();
    }// todo add to diagram
}
