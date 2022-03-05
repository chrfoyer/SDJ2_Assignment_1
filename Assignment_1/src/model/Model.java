package model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject
{

  public void updateTemperature(Double temperature, String id);

  public Heater getHeater();

  public Thermometer getThermometer(String id);

  public ArrayList<Thermometer> getThermometerList();

  public void increase();

  public void decrease();

  public void temperature(String id);

  public void externalTemperature();
}
