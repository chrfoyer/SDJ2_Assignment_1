package model;

import javafx.beans.property.Property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private Temperature temperature;
  private PropertyChangeSupport property;

  public ModelManager()
  {
    this.temperature = new Temperature();
    property = new PropertyChangeSupport(this);
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }
}
