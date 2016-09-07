package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
public class MainArm extends Subsystem {
  CANTalon armMotorLeft = new CANTalon(RobotMap.armLeftMotor);
  CANTalon armMotorRight = new CANTalon(RobotMap.armRightMotor);
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
  public void moveArm(double speed){
    armMotorLeft.set(speed);
    armMotorRight.set(-speed);
  }
}
// vim: sw=2:ts=2:sts=2
