package viewmodel;

import javafx.beans.property.StringProperty;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener
{
  //private StringProperty asd;
  private Model model;

  //ctor
  public ThermometerViewModel(Model model)
  {
    this.model = model;

    model.addListener("bid", this);
    model.addListener("time", this);
    model.addListener("end", this);
  }



  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }
}
