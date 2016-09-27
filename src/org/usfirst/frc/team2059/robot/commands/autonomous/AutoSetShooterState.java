package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
/**
 *
 */
public class AutoSetShooterState extends CommandBase {
  boolean state;
  public AutoSetShooterState(boolean s) {
    state = s;
  }
  // Called just before this Command runs the first time
  protected void initialize() {
  }
  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    pneumatics.setShooterState(state);
  }
  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return true;
  }
  // Called once after isFinished returns true
  protected void end() {
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
// vim: sw=2:ts=2:sts=2
