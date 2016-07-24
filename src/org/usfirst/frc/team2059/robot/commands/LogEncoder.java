package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.structs.EncoderValues;
public class LogEncoder  extends CommandBase {
  public LogEncoder() {
    requires(encoderBase);
  }
  protected void initialize() {
  }
  protected boolean isFinished() {
    EncoderValues values = encoderBase.getValues();
    System.out.println("==== Encoder log ====");
    System.out.println("Count     : " + values.getCount());
    System.out.println("Distance  : " + values.getDistance());
    System.out.println("Period    : " + values.getPeriod());
    System.out.println("Rate      : " + values.getRate());
    System.out.println("Direction : " + values.getDirection());
    System.out.println("Stopped   : " + values.getStopped());
    return true;
  }
  protected void execute() {
  }
  protected void end() {
  }
  protected void interrupted() {
  }
}
// vim: sw=2:ts=2:sts=2
