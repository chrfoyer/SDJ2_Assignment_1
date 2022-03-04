package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.ThermometerViewModel;

public class TemperatureViewController {
  @FXML Label temp1Label;
  @FXML Label temp2Label;
  @FXML Label outsideTempLabel;
  @FXML Label errorLabel;

  private  ViewHandler viewHandler;
  private Region root;
  private ThermometerViewModel viewModel;

  public void init(ViewHandler viewHandler, ThermometerViewModel viewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;

    this.temp1Label.setText("");
    this.temp2Label.setText("");
    this.outsideTempLabel.setText("");
    this.errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {}

  @FXML private void heaterSettings()
  {
    viewHandler.openView("heater");
  }
}
