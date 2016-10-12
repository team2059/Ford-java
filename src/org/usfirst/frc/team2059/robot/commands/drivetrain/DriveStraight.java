package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2059.robot.Robot;
/**
 *
 */
public class DriveStraight extends CommandBase {
  double speed;
  public DriveStraight(double speed) {
    requires(driveBase);
    this.speed = speed;
  }
  // Called just before this Command runs the first time
  protected void initialize() {
  }
  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    driveBase.resetGyro();
    driveBase.driveStraight(speed, SmartDashboard.getNumber("GyroCorrection"));
  }
  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }
  // Called once after isFinished returns true
  protected void end() {
    driveBase.driveStraight(0, SmartDashboard.getNumber("GyroCorrection"));
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
// vim: sw=2:ts=2:sts=2
