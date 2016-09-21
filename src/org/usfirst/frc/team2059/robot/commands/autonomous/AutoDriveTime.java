package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
public class AutoDriveTime extends CommandBase {
  double power;
  public AutoDriveTime(double timeout, double power) {
    requires(driveBase);
    this.power=power;
    setTimeout(timeout);
  }
  protected void initialize() {
  }
  protected void execute() {
    driveBase.driveArcade(0,-power,0,0);
  }
  protected void end() {
    driveBase.stopDriving();
  }
  protected void interrupted() {
    end();
  }
  protected boolean isFinished() {
    return isTimedOut();
  }
}
// vim: sw=2:ts=2:sts=2
