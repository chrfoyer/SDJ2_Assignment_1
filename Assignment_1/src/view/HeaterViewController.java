package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.HeaterViewModel;
import viewmodel.ThermometerViewModel;

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
    this.errorLabel.setText("");
  }

  public void reset()
  {
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void decreaseButton()
  {

  }

  @FXML private void increaseButton()
  {

  }

  @FXML private void returnButton()
  {
    viewHandler.openView("temperature");
  }
}
