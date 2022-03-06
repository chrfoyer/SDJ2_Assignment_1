package model;

public class HeaterMax extends HeaterState{
  private Thread timer;

  public HeaterMax(Heater heater)
  {
    timer = new Thread(() -> {
      try {
        //todo
        Thread.sleep(5000);
        timeout(heater);
      } catch (InterruptedException e) {
        System.out.println("Timer interrupted");
      }
    });
    timer.start();
  }

  @Override public void increase(Heater heater)
  {
    // do nothing
  }

  @Override public void decrease(Heater heater)
  {
    heater.setState(new HeaterMedium());
  }

  @Override public void timeout(Heater heater)
  {
    System.out.println("Heater timed out");
    heater.decrease();
  }
}
