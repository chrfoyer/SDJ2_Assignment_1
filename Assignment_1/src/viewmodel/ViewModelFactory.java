package viewmodel;

import model.Model;

public class ViewModelFactory
{
  private HeaterViewModel hVM;
  private ThermometerViewModel tVM;

  public ViewModelFactory(Model model)
  {
    hVM = new HeaterViewModel(model);
    tVM = new ThermometerViewModel(model);
  }

  public HeaterViewModel getListExerciseViewModel()
  {
    return hVM;
  }

  public ThermometerViewModel getManageExerciseViewModel()
  {
    return tVM;
  }
}

