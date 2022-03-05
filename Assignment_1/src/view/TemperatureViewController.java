package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.ThermometerViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TemperatureViewController
{
  @FXML Label temp0Label;
  @FXML Label temp1Label;
  @FXML Label temp2Label;
  @FXML Label errorLabel;

  private ViewHandler viewHandler;
  private Region root;
  private ThermometerViewModel viewModel;

  public void init(ViewHandler viewHandler, ThermometerViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;

    this.temp0Label.textProperty().bind(viewModel.getT0LabelProperty());
    this.temp1Label.textProperty().bind(viewModel.getT1LabelProperty());
    this.temp2Label.textProperty().bind(viewModel.getT2LabelProperty());
    this.errorLabel.textProperty().bind(viewModel.getErrorLabelProperty());

    viewModel.reset();
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    viewModel.reset();
  }

  @FXML private void heaterSettings()
  {
    viewHandler.openView("heater");
  }

}
