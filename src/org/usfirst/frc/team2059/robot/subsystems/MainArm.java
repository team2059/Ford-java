package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
public class MainArm extends PIDSubsystem {
  CANTalon armMotorLeft = new CANTalon(RobotMap.armLeftMotor);
  CANTalon armMotorRight = new CANTalon(RobotMap.armRightMotor);
  AnalogInput pot = new AnalogInput(RobotMap.armPot);
  DigitalInput limitSwitchBottom = new DigitalInput(RobotMap.armBottomLim);
  DigitalInput limitSwitchTop = new DigitalInput(RobotMap.armTopLim);
  private double min = RobotMap.zeroDegrees;
  private double max = RobotMap.ninetyDegrees;
  public MainArm() {
    super("MainArm", 0.06, 0.0, 0.002);
    getPIDController().setContinuous(false);
    enable();
  }
  public void initDefaultCommand() {
  }
  public void moveArm(double speed) {
    armMotorLeft.set(-speed);
    armMotorRight.set(speed);
  }
  protected double returnPIDInput() {
    return getDegrees();
  }
  protected void usePIDOutput(double output) {
    armMotorLeft.set(-output);
    armMotorRight.set(output);
  }
  public double getRaw() {
    return pot.getAverageVoltage();
  }
  public double getDegrees() {
    return potToDegrees(getRaw());
  }

  public void resetLower(double speed){
    if(!limitSwitchBottom.get()){
      System.out.println("PRESSDE");
      moveArm(0);
      return;
    }else{
      System.out.println("not pressed");
      moveArm(speed);
    }
  }
  public boolean getBottomPressed(){
    return !limitSwitchBottom.get();
  }

  public void resetUpper(double speed){
    if(!limitSwitchTop.get()){
      System.out.println("PRESSDE");
      moveArm(0);
      return;
    }else{
      System.out.println("not pressed");
      moveArm(speed);
    }
  }
  public boolean getTopPressed(){
    return !limitSwitchTop.get();
  }
  private double potToDegrees(double pot) {
    if(!limitSwitchBottom.get()){
      System.out.println("got");
      min = getRaw();
    }else if(!limitSwitchTop.get()){
      max = getRaw();
    }
    System.out.println((pot - min) / (Math.abs(min - max) / 90));
    return (pot - min) / (Math.abs(min - max) / 90);
  }
}
// vim: sw=2:ts=2:sts=2
