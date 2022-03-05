package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaterViewModel implements PropertyChangeListener
{
  private Model model;
  boolean stopItGetSomeHelp;
  private StringProperty errrorProprety;
  private StringProperty settingProperty;

  public HeaterViewModel(Model model)
  {
    errrorProprety = new SimpleStringProperty();
    settingProperty = new SimpleStringProperty(
        model.getHeater().statusString());
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
    Platform.runLater(() -> {
      try
      {
        if (evt.getPropertyName().equals("heaterIncrease"))
        {
          switch (Integer.parseInt(evt.getNewValue().toString()))
          {
            case 0:
              this.settingProperty.set("OFF");
              break;
            case 1:
              this.settingProperty.set("LOW");
              break;
            case 2:
              this.settingProperty.set("MEDIUM");
              break;
            case 3:
              this.settingProperty.set("MAX");
              break;
          }
        }
        else if (evt.getPropertyName().equals("heaterDecrease"))
        {
          switch (Integer.parseInt(evt.getNewValue().toString()))
          {
            case 0:
              this.settingProperty.set("OFF");
              break;
            case 1:
              this.settingProperty.set("LOW");
              break;
            case 2:
              this.settingProperty.set("MEDIUM");
              break;
            case 3:
              this.settingProperty.set("MAX");
              break;
          }
        }

      }
      catch (Exception e)
      {
        errrorProprety.set(e.getMessage());
      }
    });

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
