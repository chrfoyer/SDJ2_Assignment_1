package model;

public class HeaterMedium extends HeaterState
{
  @Override public void increase(Heater heater)
  {
    heater.setState(new HeaterMax());
  }

  @Override public void decrease(Heater heater)
  {
    heater.setState(new HeaterLow());
  }

  @Override public void timeout(Heater heater)
  {
    // nothing
  }
}
