package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
public class ResetEncoder extends CommandBase {
  public ResetEncoder() {
    requires(encoderbase);
  }
  protected void initialize() {
  }
  protected boolean isFinished() {
    return true;
  }
  protected void execute() {
    encoderbase.resetEncoder();
  }
  protected void end() {
  }
  protected void interrupted() {
  }
}
// vim: sw=2:ts=2:sts=2
