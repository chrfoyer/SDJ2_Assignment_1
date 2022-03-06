package model;

public class Thermometer implements Runnable
{
  private String id;
  private double t;//last measured temperature
  private int d;
  public static final double MAX = 30;
  public static final double MIN = -1;
  public Thermometer(String id, double t, int d)
  {
    this.id = id;
    this.t = t;
    this.d = d;
  }

  /*private double temperature()
  {

    double p = heater.status();

    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return t;
  }*/

  public void setTemp(double t)
  {
    //https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places code idea from here because java is special
    double val = t;
    val = val * 100;
    val = Math.round(val);
    val = val / 100;

    this.t = val;
  }

  public String getId()
  {
    return id;
  }

  public double getTemp()
  {
    return t;
  }

  // todo add to diagram
  public int getDistance()
  {
    return d;
  }

  public void run()
  {
    while (true)
    {
      if (t >= MAX)
      {
        System.out.println("It's hot!");
      }
      else if (t <= MIN)
      {
        System.out.println("It's cold!");
      }
      try
      {
        Thread.sleep(6000);
      }
      catch (InterruptedException e)
      {
        //do nothing
      }
    }
  }

  // todo add to diagram
  public String toString()
  {
    return id + ": " + t;
  }
}
