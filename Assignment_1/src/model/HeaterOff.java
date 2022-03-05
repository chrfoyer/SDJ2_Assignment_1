package model;

public class HeaterOff extends HeaterState{
  @Override public void increase(Heater heater)
  {
    heater.setState(new HeaterLow());
  }

  @Override public void decrease(Heater heater)
  {
    // do nothing
  }

  @Override public void timeout(Heater heater)
  {
    // do nothing
  }
}
