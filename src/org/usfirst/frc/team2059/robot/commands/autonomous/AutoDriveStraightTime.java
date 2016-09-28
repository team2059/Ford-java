package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class AutoDriveStraightTime extends CommandBase {
  double speed;
  public AutoDriveStraightTime(double speed, double time) {
    requires(driveBase);
    setTimeout(time);
    this.speed = speed;
  }
  protected void initialize() {
    driveBase.resetGyro();
  }
  protected void execute() {
    driveBase.driveStraight(-speed, SmartDashboard.getNumber("GyroCorrection"));
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
