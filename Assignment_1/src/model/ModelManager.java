package model;

import javafx.beans.property.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private PropertyChangeSupport property;
  private Heater heater;
  // todo do we have the three thermometer objects here?
  private Thermometer t1;//inside but next to heater thermometer
  private Thermometer t2;//inside thermometer
  private Thermometer t3;//outside thermometer

  public ModelManager()
  {
    property = new PropertyChangeSupport(this);
    t1 = new Thermometer("t1", 0, 1);
    t2 = new Thermometer("t2", 0, 7);
    t3 = new Thermometer("t3", 0,
        100);//in the case for temp calc it should have a switch that says if d = 100 then the heater has no impact on it? could also check for "id"

  }

  @Override public void updateTemperature(Double temperature)
  {
      t1.setTemp(temperature);
      //how do we update temperature to the double? how do we kow which thermometer to update?
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