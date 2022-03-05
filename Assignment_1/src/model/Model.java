package model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

public interface Model extends UnnamedPropertyChangeSubject
{

  public void updateTemperature(Double temperature, String id);

  public Heater getHeater();

  public Thermometer getThermometer(String id);

  public ThermometerList getThermometerList();

  public void increase();

  public void decrease();
}
