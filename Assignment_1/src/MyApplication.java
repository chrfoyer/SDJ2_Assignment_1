import javafx.application.Application;
import javafx.stage.Stage;
import model.Heater;
import model.Model;
import model.ModelManager;
import model.Thermometer;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    Model model = new ModelManager();

    Thread thread0 = new Thread(model.getThermometer("t0"));
    Thread thread1 = new Thread(model.getThermometer("t1"));
    Thread thread2 = new Thread(model.getThermometer("t2"));

    thread0.start();
    thread1.start();
    thread2.start();

    new Thread(() -> {
      while (true)
      {
        model.temperature("t1");
        model.temperature("t2");
        try
        {
          Thread.sleep(6000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(() -> {
      while (true)
      {
        model.externalTemperature();
        try
        {
          Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();

    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);

  }
}
