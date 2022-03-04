package model;

import javafx.beans.property.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private PropertyChangeSupport property;

  public ModelManager()
  {
    property = new PropertyChangeSupport(this);

  }

  @Override public void updateTemperature(Double temperature)
  {

  }

  @Override public Heater getHeater()
  {
    return null;
  }

  @Override public Thermometer getThermometer()
  {
    return null;
  }

  @Override public void increase()
  {

  }

  @Override public void decrease()
  {

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