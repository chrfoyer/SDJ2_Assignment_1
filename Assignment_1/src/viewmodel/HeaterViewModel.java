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
  private StringProperty settingProperty;

  public HeaterViewModel(Model model)
  {
    errrorProprety = new SimpleStringProperty();
    settingProperty = new SimpleStringProperty();
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
    try
    {
      if (evt.getPropertyName().equals("heaterIncrease"))
      {
        increaseHeaterState();
      }
      else if (evt.getPropertyName().equals("heaterDecrease"))
      {
        decreaseHeaterState();
      }
      switch ((String) evt.getNewValue())
      {
        case "HeaterOff":
          this.settingProperty.set("OFF");
          break;
        case "HeaterLow":
          this.settingProperty.set("LOW");
          break;
        case "HeaterMedium":
          this.settingProperty.set("MEDIUM");
          break;
        case "HeaterMax":
          this.settingProperty.set("MAX");
          break;
      }
    }
    catch (Exception e)
    {
      errrorProprety.set(e.getMessage());
    }

  }

  public StringProperty getErrrorProprety()
  {
    return errrorProprety;
  }

  public StringProperty getSettingProperty()
  {
    return settingProperty;
  }

  public Model getModel()
  {
    return model;
  }
}
