package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
public class DriveBase extends Subsystem {
  Talon leftMotorOne = new Talon(RobotMap.driveLeftMotorOne);
  Talon leftMotorTwo = new Talon(RobotMap.driveLeftMotorTwo);
  Talon rightMotorOne = new Talon(RobotMap.driveRightMotorOne);
  Talon rightMotorTwo = new Talon(RobotMap.driveRightMotorTwo);
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
  public void driveArcade(double x, double y, double z, double sensitivity) {
    leftMotorOne.set(-y + (x + z));
    leftMotorTwo.set(-y + (x + z));
    rightMotorOne.set(y + (x + z));
    rightMotorTwo.set(y + (x + z));
  }
}
// vim: sw=2:ts=2:sts=2
