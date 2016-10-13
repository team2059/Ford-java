package org.usfirst.frc.team2059.robot.commands.shooter;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import org.usfirst.frc.team2059.robot.RobotMap;
/**
 *
 */
public class AlignVertical extends CommandBase {
  public AlignVertical() {
    requires(mainArm);
  }
  // Called just before this Command runs the first time
  protected void initialize() {
    mainArm.setSetpoint(mainArm.getShooterAngleError()+50);
    mainArm.enable();
  }
  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    //Move the arm stop
  }
  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    // Stop when either limit switch is hit
    return false;
  }
  // Called once after isFinished returns true
  protected void end() {
    mainArm.disable();
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    end();
  }
}
// vim: sw=2:ts=2:sts=2
