package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private TemperatureViewController temperatureViewController;
  private TemperatureLogsController temperatureLogsController;
  private HeaterViewController heaterViewController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("temperature");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "temperature":
        root = loadTemperatureView("TemperatureView.fxml");
        break;
      case "heater":
        root = loadHeaterView("HeaterView.fxml");
        break;
      case "logs":
        root = loadLogsView("TemperatureLogs.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadLogsView(String fxmlFile)
  {
    if (temperatureLogsController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        temperatureLogsController = loader.getController();
        temperatureLogsController.init(this, viewModelFactory.gettLVM(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      temperatureLogsController.reset();
    }
    return temperatureLogsController.getRoot();
  }

  private Region loadTemperatureView(String fxmlFile)
  {
    if (temperatureViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        temperatureViewController = loader.getController();
        temperatureViewController.init(this, viewModelFactory.getVM(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      temperatureViewController.reset();
    }
    return temperatureViewController.getRoot();
  }

  private Region loadHeaterView(String fxmlFile)
  {
    if (heaterViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        heaterViewController = loader.getController();
        heaterViewController.init(this, viewModelFactory.gethVM(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      heaterViewController.reset();
    }
    return heaterViewController.getRoot();
  }
}


