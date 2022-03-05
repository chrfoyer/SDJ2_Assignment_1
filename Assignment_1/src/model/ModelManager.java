package model;

import javafx.beans.property.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private PropertyChangeSupport property;
  private Heater heater;
  private ThermometerList list;

  public ModelManager()
  {
    property = new PropertyChangeSupport(this);
    heater = new Heater();
    list = new ThermometerList(heater);

  }

  @Override public void updateTemperature(Double temperature, String id)
  {
    list.getThermometer(id).setTemp(temperature);
    property.firePropertyChange("setTemp", false, list);
    //how do we update temperature to the double? how do we kow which thermometer to update?
  }

  @Override public Heater getHeater()
  {
    return heater;
  }

  @Override public Thermometer getThermometer(String id)
  {
    return list.getThermometer(id);
  }

  @Override public ArrayList<Thermometer> getThermometerList()
  {
    return list.getList();
  }

  public void temperature(String id)
  {
    double t = getThermometer(id).getTemp();
    double p = heater.status();
    double d = getThermometer(id).getDistance();
    double t0 = getThermometer("t0").getTemp();//outside temp
    int s = 6;

    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    getThermometer(id).setTemp(t);
    property.firePropertyChange("setTemp", false, getThermometerList());
  }

  public void externalTemperature()
  {
    double t0 = getThermometer("t0").getTemp();
    double left = getThermometer("t0").getTemp() - Thermometer.MIN;
    double right = Thermometer.MAX - getThermometer("t0").getTemp();
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    getThermometer("t0").setTemp(t0);
    property.firePropertyChange("setTemp", false, getThermometerList());
  }

  @Override public void increase()
  {
    heater.increase();
    property.firePropertyChange("heaterIncrease", false, heater.status());
  }

  @Override public void decrease()
  {
    heater.decrease();
    property.firePropertyChange("heaterDecrease", false, heater.status());
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }
}