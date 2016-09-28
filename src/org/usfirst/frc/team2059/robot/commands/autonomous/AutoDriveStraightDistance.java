package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class AutoDriveStraightDistance extends CommandBase {
  double distance;
  public AutoDriveStraightDistance(double distance, double timeout) {
    requires(driveBase);
    setTimeout(timeout);
    this.distance=distance;
  }
  protected void initialize() {
   driveBase.resetGyro(); 
   driveBase.getLeftEncoder().reset();
  }
  protected void execute() {
    driveBase.pidDrive(distance,SmartDashboard.getNumber("GyroCorrection"));
  }
  protected void end() {
    driveBase.getLeftController().disable();
    driveBase.stopDriving();
  }
  protected void interrupted() {
    end();
  }
  protected boolean isFinished() {
    return isTimedOut() || Math.abs(distance-driveBase.getLeftRotations()) <= 3;
  }
}
// vim: sw=2:ts=2:sts=2
