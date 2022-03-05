package model;

public class Heater {
  // todo add to diagram
  private HeaterState state;

  public Heater()
  {
    state = new HeaterOff();
  }

  public void increase()
  {
    state.increase(this);
  }

  public void decrease()
  {
    state.decrease(this);
  }

  public void timeout()
  {
    state.timeout(this);
  }

  public void setState(HeaterState state)
  {
    this.state = state;
  }

  public String status()
  {
    return state.status();
  }
}
