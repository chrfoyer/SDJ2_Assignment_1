package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaterViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty errrorProprety;

  public HeaterViewModel(Model model)
  {
    errrorProprety = new SimpleStringProperty();
    this.model = model;

    model.addListener(this);
  }

  public void reset()
  {
    errrorProprety.set("");
  }

  public void increaseHeaterState()
  {
    model.increase();
  }

  public void decreaseHeaterState()
  {
    model.decrease();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("heaterIncrease"))
    {
      increaseHeaterState();
    }
    else if (evt.getPropertyName().equals("heaterDecrease"))
    {
      decreaseHeaterState();
    }
  }
}
