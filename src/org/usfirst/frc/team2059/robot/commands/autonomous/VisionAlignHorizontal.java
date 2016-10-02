package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
public class VisionAlignHorizontal extends CommandBase {
  double error;
  public VisionAlignHorizontal() {
  }
  protected void initialize() {
    error = visionHelper.getHorizontalError();
    driveBase.resetGyro();
  }
  protected boolean isFinished() {
    return false;
  }
  protected void execute() {
    driveBase.rotateAngle(error);
  }
  protected void end() {
    driveBase.getGyroController().disable();
  }
  protected void interrupted() {
    end();
  }
}
// vim: sw=2:ts=2:sts=2
