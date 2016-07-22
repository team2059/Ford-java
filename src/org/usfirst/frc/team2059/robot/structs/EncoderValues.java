package org.usfirst.frc.team2059.robot.structs;
public class EncoderValues {
  private int count;
  private double distance, period, rate;
  private boolean direction, stopped;
  public EncoderValues(int count, double distance, double period, double rate, boolean direction, boolean stopped) {
  }
  public int getCount() {
    return count;
  }
  public double getDistance() {
    return distance;
  }
  public double getPeriod() {
    return period;
  }
  public double getRate() {
    return rate;
  }
  public boolean getDirection() {
    return direction;
  }
  public boolean getStopped() {
    return stopped;
  }
}
// vim: sw=2:ts=2:sts=2
