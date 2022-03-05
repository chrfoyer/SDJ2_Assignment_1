package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import viewmodel.TemperatureLogsViewModel;

public class TemperatureLogsController
{
  @FXML private ListView<String> logList;
  private Region root;
  private TemperatureLogsViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, TemperatureLogsViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
    logList.setItems(viewModel.getLogs());
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    viewModel.clear();
  }

  @FXML public void onBack()
  {
    viewHandler.openView("temperature");
  }

}