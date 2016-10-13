package org.usfirst.frc.team2059.robot.commands.visionhelper;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
public class AlignHorizontal extends CommandBase {
  double error;
  public AlignHorizontal() {
  }
  protected void initialize() {
    error = visionHelper.getHorizontalError();
    driveBase.setDriveEnabled(false);
    driveBase.resetGyro();
    mainArm.setSetpoint(90);
    mainArm.enable();
  }
  protected boolean isFinished() {
    return false;
  }
  protected void execute() {
    driveBase.rotateAngle(error);
  }
  protected void end() {
    driveBase.getGyroController().disable();
    driveBase.setDriveEnabled(true);
    mainArm.disable();
  }
  protected void interrupted() {
    end();
  }
}
// vim: sw=2:ts=2:sts=2
