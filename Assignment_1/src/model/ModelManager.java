package model;

import javafx.beans.property.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private PropertyChangeSupport property;
  private Heater heater;
  // todo do we have the three thermometer objects here?
  private ThermometerList list;

  public ModelManager()
  {
    property = new PropertyChangeSupport(this);
    list = new ThermometerList();
    heater = new Heater();
  }

  @Override public void updateTemperature(Double temperature, String id)
  {
     list.getThermometer(id).setTemp(temperature);
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

  @Override public void increase()
  {
    // heater.increase();
  }

  @Override public void decrease()
  {
    // heater.decrease();
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