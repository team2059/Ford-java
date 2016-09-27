package org.usfirst.frc.team2059.robot.commands.autonomous;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
/**
 *
 */
public class AutoSpinRollers extends CommandBase {
  double speed;
  boolean smartrollers;
  public AutoSpinRollers(double s, double timeout) {
    speed = s;
    setTimeout(timeout);
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
    return isTimedOut();
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
