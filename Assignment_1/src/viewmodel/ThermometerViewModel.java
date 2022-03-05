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
  private StringProperty t0Label;
  private StringProperty t1Label;
  private StringProperty t2Label;
  private StringProperty errorLabel;

  private Model model;

  //ctor
  public ThermometerViewModel(Model model)
  {
    this.model = model;
    //id is for debug
    this.t0Label = new SimpleStringProperty(
        model.getThermometer("t0").getId() + model.getThermometer("t0")
            .getTemp());
    this.t1Label = new SimpleStringProperty(
        model.getThermometer("t1").getId() + model.getThermometer("t1")
            .getTemp());
    this.t2Label = new SimpleStringProperty(
        model.getThermometer("t2").getId() + model.getThermometer("t2")
            .getTemp());
    this.errorLabel = new SimpleStringProperty();
    model.addListener(this);
  }

  public StringProperty getT0LabelProprety()
  {
    return t0Label;
  }

  public StringProperty getT1LabelProprety()
  {
    return t1Label;
  }

  public StringProperty getT2LabelProprety()
  {
    return t2Label;
  }

  public StringProperty getErrorLabel()
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
        ThermometerList updatedThermometerList = (ThermometerList) evt.getNewValue();
        for (Thermometer thermometer : updatedThermometerList.getList())
        {
          t1Label.set(thermometer.getId() + " " + thermometer.getTemp());
        }
      });
    }
    catch (Exception e)
    {
      errorLabel.set(e.getMessage());
    }

  }
}
