package model;

import java.beans.PropertyChangeListener;

public class ModelManager implements Model
{
  private Temperature temperature;

  public ModelManager()
  {
    this.temperature = new Temperature();
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {

  }
}
