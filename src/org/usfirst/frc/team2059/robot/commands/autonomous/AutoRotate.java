package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
import edu.wpi.first.wpilibj.AnalogGyro;
public class AutoRotate extends CommandBase {
  double degrees;
  public AutoRotate(double degrees) {
    requires(driveBase);
    this.degrees = degrees;
    setTimeout(2.5);
  }
  protected void initialize() {
    driveBase.getGyro().reset();
  }
  protected void execute() {
    System.out.println("rotating");
    driveBase.rotateAngle(degrees);
  }
  protected void end() {
    driveBase.stopDriving();
    driveBase.getGyroController().disable();
  }
  protected void interrupted() {
    end();
  }
  protected boolean isFinished() {
    //return Math.abs(driveBase.getGyro().getAngle()-degrees) <= 0.5;
    return isTimedOut();
  }
}
// vim: sw=2:ts=2:sts=2
