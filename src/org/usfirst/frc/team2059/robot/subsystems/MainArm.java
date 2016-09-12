package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Drive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;
public class MainArm extends PIDSubsystem {
  CANTalon armMotorLeft = new CANTalon(RobotMap.armLeftMotor);
  CANTalon armMotorRight = new CANTalon(RobotMap.armRightMotor);
  AnalogInput pot = new AnalogInput(RobotMap.armPot);
  public MainArm(){
    super("MainArm",0.0,0.0,0.0);
    getPIDController().setContinuous(false);
  }
  public void initDefaultCommand() {
  }
  public void moveArm(double speed){
    armMotorLeft.set(speed);
    armMotorRight.set(-speed);
  }
  protected double returnPIDInput(){
    return pot.getAverageVoltage();
  }
  protected void usePIDOutput(double output){
  }
  public double getRaw(){
    return pot.getAverageVoltage();
  }
  public double getDegrees(){
    return potToDegrees(getRaw());
  }
  private double potToDegrees(double pot){
    double min = RobotMap.zeroDegrees;
    double max = RobotMap.ninetyDegrees;
    System.out.println((pot-min)/(Math.abs(min-max)/90));
    return (pot-min)/(Math.abs(min-max)/90);
  }
}
// vim: sw=2:ts=2:sts=2
