package model;

import java.util.ArrayList;

public class ThermometerList
{
  private ArrayList<Thermometer> list;
  private Thermometer t0;
  private Thermometer t1;
  private Thermometer t2;

  public ThermometerList()
  {
    t0 = new Thermometer("t0", 0, 1);
    t1 = new Thermometer("t1", 0, 7);
    t2 = new Thermometer("t2", 0, 100);
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

  public String toString()
  {
    return "t0: " + t0.getTemp() + "\nt1: " + t1.getTemp() + "\nt2: "
        + t2.getTemp();
  }
}
