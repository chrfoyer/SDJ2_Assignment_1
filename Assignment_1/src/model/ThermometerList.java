package model;

import java.util.ArrayList;

public class ThermometerList
{

  private ArrayList<Thermometer> list;
  private Thermometer t0;
  private Thermometer t1;
  private Thermometer t2;
  private Heater heater;

  public ThermometerList(Heater heater)
  {
    this.heater = heater;
    t0 = new Thermometer("t0", 10, 100);
    t1 = new Thermometer("t1", 25, 1);
    t2 = new Thermometer("t2", 21, 7); // todo confirm distance values
    list = new ArrayList<>();
    list.add(t0);
    list.add(t1);
    list.add(t2);
  }

  public ArrayList<Thermometer> getList()
  {
    return list;
  }

  public Thermometer getThermometer(String id)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getId().equals(id))
      {
        return list.get(i);
      }
    }
    System.out.println("Thermometer not found");
    return null;
  }
}
