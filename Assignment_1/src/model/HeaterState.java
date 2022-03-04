package model;

public abstract class HeaterState {


    public HeaterState(){
        // todo change class to match door exercise
    }

    public abstract void increase();

    public abstract void decrease();

    public abstract void timeout(); // todo add to diagram

    public abstract String status(); // todo add to diagram
}
