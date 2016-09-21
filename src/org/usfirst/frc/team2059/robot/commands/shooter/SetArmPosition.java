package org.usfirst.frc.team2059.robot.commands.shooter;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import org.usfirst.frc.team2059.robot.RobotMap;
/**
 *
 */
public class SetArmPosition extends CommandBase {
  double pos;
  public SetArmPosition(double p) {
    requires(mainArm);
    pos = p;
  }
  // Called just before this Command runs the first time
  protected void initialize() {
  }
  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    //Move the arm stop
    if (pos == RobotMap.mainArmPresetCollect) {
      pneumatics.setArmStopState(true);
    } else if ((pos != RobotMap.mainArmPresetCollect) && (mainArm.getDegrees() > 2)) {
      pneumatics.setArmStopState(false);
    }
    mainArm.enable();
    mainArm.setSetpoint(pos);
  }
  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    // Stop when either limit switch is hit
    return mainArm.getBottomPressed() || mainArm.getTopPressed();
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
