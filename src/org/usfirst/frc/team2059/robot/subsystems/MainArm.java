package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class MainArm extends PIDSubsystem {
  CANTalon armMotorLeft = new CANTalon(RobotMap.armLeftMotor);
  CANTalon armMotorRight = new CANTalon(RobotMap.armRightMotor);
  AnalogInput pot = new AnalogInput(RobotMap.armPot);
  DigitalInput limitSwitchBottom = new DigitalInput(RobotMap.armBottomLim);
  DigitalInput limitSwitchTop = new DigitalInput(RobotMap.armTopLim);
  private double min = RobotMap.zeroDegrees;
  private double max = RobotMap.ninetyDegrees;
  public MainArm() {
    super("MainArm", 0.3, 0.0, 0.4);
    getPIDController().setContinuous(false);
    setSetpoint(70);
    enable();
  }
  public void initDefaultCommand() {
  }
  public void moveArm(double speed) {
    // Calibrate the arm, but don't do anything about it
    calibrate();
    armMotorLeft.set(-speed);
    armMotorRight.set(speed);
  }
  protected double returnPIDInput() {
    return getDegrees();
  }
  protected void usePIDOutput(double output) {
    moveArm(output);
  }
  public double getRaw() {
    return pot.getAverageVoltage();
  }
  public double getDegrees() {
    return potToDegrees(getRaw());
  }
  public void resetLower(double speed) {
    if (getBottomPressed()) {
      moveArm(0);
      return;
    } else {
      moveArm(speed);
    }
  }
  public boolean getBottomPressed() {
    return !limitSwitchBottom.get();
  }
  public void resetUpper(double speed) {
    if (getTopPressed()) {
      moveArm(0);
      return;
    } else {
      moveArm(speed);
    }
  }
  public boolean getTopPressed() {
    return !limitSwitchTop.get();
  }
  private double potToDegrees(double pot) {
    //System.out.println((pot - min) / (Math.abs(min - max) / 90));
    return (pot - min) / (Math.abs(min - max) / 90);
  }
  /**
   * Calibrates the arm if it hits the upper or lower limit switch
   * @return True if it was calibrated (if either limit switch was pressed)
   */
  private boolean calibrate() {
    // It can't be calibrated if the limit swithces are disabled
    //if (!SmartDashboard.getBoolean("UseLimitSwitches")) {
    //  return false;
    //}
    if (getBottomPressed()) {
      System.out.println("Calibrating bottom to: " + getRaw());
      min = getRaw();
      return true;
    } else if (getTopPressed()) {
      System.out.println("Calibrating top to: " + getRaw());
      max = getRaw();
      return true;
    }
    return false;
  }
}
// vim: sw=2:ts=2:sts=2
