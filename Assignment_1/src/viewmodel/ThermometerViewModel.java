package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener
{
  //todo fxml fields
  //private StringProperty asd;
  private StringProperty currentTemp;
  private Model model;

  //ctor
  public ThermometerViewModel(Model model)
  {
    this.model = model;
    this.currentTemp = new SimpleStringProperty();

    model.addListener(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      currentTemp.set(evt.getNewValue().toString());
      //----------
    });
  }
}
