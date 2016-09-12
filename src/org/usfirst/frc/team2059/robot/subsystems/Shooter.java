package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
public class Shooter extends Subsystem {
  CANTalon shooterMotorLeft = new CANTalon(RobotMap.shooterLeftMotor);
  CANTalon shooterMotorRight = new CANTalon(RobotMap.shooterRightMotor);
  public void initDefaultCommand() {
  }
  public void shootAtSpeed(double speed){
    shooterMotorRight.set(speed);
    shooterMotorLeft.set(speed);
  }
}
// vim: sw=2:ts=2:sts=2
