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
    list = new ThermometerList();
    heater = new Heater();
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