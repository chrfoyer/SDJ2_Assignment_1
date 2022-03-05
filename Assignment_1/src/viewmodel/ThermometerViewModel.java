package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import model.Thermometer;
import model.ThermometerList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener
{
  //todo fxml fields
  private StringProperty t0Label; //OUTSIDE
  private StringProperty t1Label; //INSIDE
  private StringProperty t2Label; //INSIDE
  private StringProperty errorLabel;

  private Model model;

  public ThermometerViewModel(Model model)
  {
    this.model = model;
    //id is for debug
    this.t0Label = new SimpleStringProperty();
    this.t1Label = new SimpleStringProperty();
    this.t2Label = new SimpleStringProperty();

    this.errorLabel = new SimpleStringProperty();
    model.addListener(this);

    reset();
  }

  public void reset()
  {
    for (Thermometer thermometer : model.getThermometerList())
    {
      switch (thermometer.getId())
      {
        case "t0":
          t0Label.set(thermometer.getId() + " " + thermometer.getTemp());
          break;
        case "t1":
          t1Label.set(thermometer.getId() + " " + thermometer.getTemp());
          break;
        case "t2":
          t2Label.set(thermometer.getId() + " " + thermometer.getTemp());
          break;
      }
    }
    errorLabel.set("");
  }

  public StringProperty getT0LabelProperty()
  {
    return t0Label;
  }

  public StringProperty getT1LabelProperty()
  {
    return t1Label;
  }

  public StringProperty getT2LabelProperty()
  {
    return t2Label;
  }

  public StringProperty getErrorLabelProperty()
  {
    return errorLabel;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    //todo debugging values
    System.out.println("Change detected");
    try
    {
      Platform.runLater(() -> {
        if (evt.getPropertyName().equals("setTemp"))
        {
          ThermometerList updatedThermometerList = (ThermometerList) evt.getNewValue();
          for (Thermometer thermometer : updatedThermometerList.getList())
          {
            switch (thermometer.getId())
            {
              case "t0":
                t0Label.set(thermometer.getId() + " " + thermometer.getTemp());
                break;
              case "t1":
                t1Label.set(thermometer.getId() + " " + thermometer.getTemp());
                break;
              case "t2":
                t2Label.set(thermometer.getId() + " " + thermometer.getTemp());
                break;
            }
          }
        }
      });
    }
    catch (Exception e)
    {
      errorLabel.set(e.getMessage());
    }

  }
}
