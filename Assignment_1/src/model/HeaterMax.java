package model;

public class HeaterMax extends HeaterState{
  @Override public void increase(Heater heater)
  {
    // do nothing
  }

  @Override public void decrease(Heater heater)
  {
    heater.setState(new HeaterMedium());
  }

  @Override public void timeout(Heater heater)
  {
    heater.setState(new HeaterOff());
  }
}
