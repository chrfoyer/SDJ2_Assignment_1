package viewmodel;

import model.Model;
import view.TemperatureLogsController;

public class ViewModelFactory
{
  private HeaterViewModel hVM;
  private ThermometerViewModel tVM;
  private TemperatureLogsViewModel tLVM;

  public ViewModelFactory(Model model)
  {
    hVM = new HeaterViewModel(model);
    tVM = new ThermometerViewModel(model);
    tLVM = new TemperatureLogsViewModel(model);
  }

  public HeaterViewModel gethVM()
  {
    return hVM;
  }

  public ThermometerViewModel getVM()
  {
    return tVM;
  }

  public TemperatureLogsViewModel gettLVM()
  {
    return tLVM;
  }
}

