package model;

public class HeaterLow extends HeaterState{
  @Override public void increase(Heater heater)
  {
    heater.setState(new HeaterMedium());
  }

  @Override public void decrease(Heater heater)
  {
    heater.setState(new HeaterOff());
  }

  @Override public void timeout(Heater heater)
  {
    // do nothing
  }
}
