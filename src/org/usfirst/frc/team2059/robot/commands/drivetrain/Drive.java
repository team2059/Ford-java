package org.usfirst.frc.team2059.robot.commands.drivetrain;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
/**
 *
 */
public class Drive extends CommandBase {
  double sensitivity = 0.5;
  public Drive() {
    requires(driveBase);
  }
  // Called just before this Command runs the first time
  protected void initialize() {
  }
  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    double x = Robot.oi.getJoysticks()[0].getRawAxis(0);
    double y = Robot.oi.getJoysticks()[0].getRawAxis(1);
    double z = Robot.oi.getJoysticks()[0].getRawAxis(2);
    if(Robot.oi.getJoysticks()[0].getRawButton(1)){
      sensitivity = 1;
    }else{
      sensitivity = 0.5;
    }
    driveBase.driveArcade(x, y, z, sensitivity);
  }
  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }
  // Called once after isFinished returns true
  protected void end() {
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}
// vim: sw=2:ts=2:sts=2
