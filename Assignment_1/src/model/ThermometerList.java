package model;

import java.util.ArrayList;

public class ThermometerList
{
  // todo add to diagram (whole class)
  private ArrayList<Thermometer> list;
  private Thermometer t0;
  private Thermometer t1;
  private Thermometer t2;

  public ThermometerList()
  {
    t0 = new Thermometer("t0", 0, 100); // outside
    t1 = new Thermometer("t1", 0, 1); // inside close
    t2 = new Thermometer("t2", 0, 7); // inside far
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
