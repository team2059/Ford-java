package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import org.usfirst.frc.team2059.robot.RobotMap;
/**
 *
 */
public class AutoSetArmPosition extends CommandBase {
  double pos;
  public AutoSetArmPosition(double p) {
    requires(mainArm);
    pos = p;
  }
  // Called just before this Command runs the first time
  protected void initialize() {
  }
  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    mainArm.enable();
    mainArm.setSetpoint(pos);
    System.out.println(pos-mainArm.getDegrees());
    System.out.println(mainArm.getDegrees());
  }
  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    // Stop when either limit switch is hit
    //if(Math.abs(pos-mainArm.getDegrees()) <= 1){
    //  return false;
    //}
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
