package model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

public interface Model extends UnnamedPropertyChangeSubject
{

  public void updateTemperature(Double temperature);

  public Heater getHeater();

  public Thermometer getThermometer();

  public void increase();

  public void decrease();
}
