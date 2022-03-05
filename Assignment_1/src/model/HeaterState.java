package model;

public abstract class HeaterState
{

  public abstract void increase(Heater heater);

  public abstract void decrease(Heater heater);

  public abstract void timeout(Heater heater);

  public int status()
  {
    // return getClass().getSimpleName();
    if (getClass().getSimpleName().equals("HeaterOff"))
    {
      return 0;
    }
    else if (getClass().getSimpleName().equals("HeaterLow"))
    {
      return 1;
    }
    else if (getClass().getSimpleName().equals("HeaterMedium"))
    {
      return 2;
    }
    else
    {
      return 3;
    }
  }

  public String statusString()
  {
    return getClass().getSimpleName();
  }
}
