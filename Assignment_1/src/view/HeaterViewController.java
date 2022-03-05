package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.Heater;
import viewmodel.HeaterViewModel;
import viewmodel.ThermometerViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HeaterViewController
{
  @FXML Label settingLabel;
  @FXML Label errorLabel;

  private ViewHandler viewHandler;
  private Region root;
  private HeaterViewModel viewModel;

  public void init(ViewHandler viewHandler, HeaterViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;

    this.settingLabel.setText("OFF");
    this.errorLabel.textProperty().bind(viewModel.getErrrorProprety());
    this.settingLabel.textProperty().bind(viewModel.getSettingProperty());
  }

  public void reset()
  {
    viewModel.reset();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void decreaseButton()
  {
    viewModel.decreaseHeaterState();
  }

  @FXML private void increaseButton()
  {
    viewModel.increaseHeaterState();
  }

  @FXML private void returnButton()
  {
    viewHandler.openView("temperature");
  }

}
