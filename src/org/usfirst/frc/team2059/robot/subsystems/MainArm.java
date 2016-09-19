package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Drive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;
public class MainArm extends PIDSubsystem {
  CANTalon armMotorLeft = new CANTalon(RobotMap.armLeftMotor);
  CANTalon armMotorRight = new CANTalon(RobotMap.armRightMotor);
  AnalogInput pot = new AnalogInput(RobotMap.armPot);
  DigitalInput limitSwitchBottom = new DigitalInput(RobotMap.armBottomLim);
  DigitalInput limitSwitchTop = new DigitalInput(RobotMap.armTopLim);
  public MainArm() {
    super("MainArm", 0.06, 0.0, 0.002);
    getPIDController().setContinuous(false);
    setSetpoint(RobotMap.mainArmPresetTraverse);
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
  private double potToDegrees(double pot) {
    System.out.println(limitSwitchBottom.get());
    if (!limitSwitchBottom.get()) {
      RobotMap.zeroDegrees = getRaw();
      System.out.println("====Bottom Switch====\n" + getRaw());
    } else if (!limitSwitchTop.get()) {
      RobotMap.ninetyDegrees = getRaw();
      System.out.println("====Top Switch====\n" + getRaw());
    }
    double min = RobotMap.zeroDegrees;
    double max = RobotMap.ninetyDegrees;
    System.out.println((pot - min) / (Math.abs(min - max) / 90));
    return (pot - min) / (Math.abs(min - max) / 90);
  }
}
// vim: sw=2:ts=2:sts=2
