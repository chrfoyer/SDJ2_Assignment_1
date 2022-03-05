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
  private int counter;
  private ObservableList<String> logs;

  public TemperatureLogsViewModel(Model model)
  {
    this.model = model;
    counter = 1;
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
        //totally legit fix because for some unknown reason it would put in every value twice
        if (counter % 2 != 0)
        {
          for (Thermometer thermometer : updatedThermometerList)
          {
            logs.add(
                thermometer.getId() + "-> " + thermometer.getTemp() + " C°");
          }
          logs.add(
              "-------------------------------------------------------------------------------------");
        }
        counter++;
      }
    });
  }
}