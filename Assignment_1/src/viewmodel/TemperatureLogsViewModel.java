package viewmodel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.Thermometer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class TemperatureLogsViewModel implements PropertyChangeListener
{
  private Model model;
  private ObservableList<String> logs;

  public TemperatureLogsViewModel(Model model)
  {
    this.model = model;
    logs = FXCollections.observableArrayList();
    model.addListener(this);
  }

  public ObservableList<String> getLogs()
  {
    return logs;
  }

  public void clear()
  {
    logs = null;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      if (evt.getPropertyName().equals("setTemp"))
      {
        ArrayList<Thermometer> updatedThermometerList = (ArrayList<Thermometer>) evt.getNewValue();
        for (Thermometer thermometer : updatedThermometerList)
        {
          logs.add(thermometer.getId() + "-> " + thermometer.getTemp() + " C°");
        }
      }
    });
  }
}