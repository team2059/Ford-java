package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import org.usfirst.frc.team2059.robot.RobotMap;
/**
 *
 */
public class ShootAtSpeed extends CommandBase {
  double speed;
  public ShootAtSpeed(double s) {
    speed=s;
  }
  // Called just before this Command runs the first time
  protected void initialize() {
  }
  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    shooter.shootAtSpeed(speed);
  }
  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }
  // Called once after isFinished returns true
  protected void end() {
    shooter.shootAtSpeed(0);
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
// vim: sw=2:ts=2:sts=2