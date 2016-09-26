package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CANTalon;
public class DriveBase extends Subsystem {
  CANTalon leftMotorOne = new CANTalon(RobotMap.driveLeftMotorOne);
  CANTalon leftMotorTwo = new CANTalon(RobotMap.driveLeftMotorTwo);
  CANTalon rightMotorOne = new CANTalon(RobotMap.driveRightMotorOne);
  CANTalon rightMotorTwo = new CANTalon(RobotMap.driveRightMotorTwo);
  Encoder leftEncoder = new Encoder(RobotMap.driveLeftEncoderA, RobotMap.driveLeftEncoderB, false, Encoder.EncodingType.k2X);
  AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
  PIDController gyroController = new PIDController(0.082,0.002,0.07, new GyroPIDSource(), new MotorsPIDOutputReversed());
  PIDController leftEncoderController = new PIDController(0.02, 0.002, 0.017, leftEncoder, new MotorsPIDOutput());
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
  public void stopDriving() {
    leftMotorOne.set(0);
    leftMotorTwo.set(0);
    rightMotorOne.set(0);
    rightMotorTwo.set(0);
  }
  public void driveArcade(double x, double y, double z, double sensitivity) {
    leftMotorOne.set((-y + (x + z)) * sensitivity);
    leftMotorTwo.set((-y + (x + z)) * sensitivity);
    rightMotorOne.set((y + (x + z)) * sensitivity);
    rightMotorTwo.set((y + (x + z)) * sensitivity);
  }
  public void driveStraight(double y, double correction){
    SmartDashboard.putNumber("GyroAngle",gyro.getAngle());
    leftMotorOne.set((-y + -gyro.getAngle()*correction));
    leftMotorTwo.set((-y + -gyro.getAngle()*correction));
    rightMotorOne.set((y + -gyro.getAngle()*correction));
    rightMotorTwo.set((y + -gyro.getAngle()*correction));
  }
  public void pidDrive(double setpoint) {
    leftEncoder.reset();
    leftEncoderController.enable();
    leftEncoderController.setSetpoint(setpoint);
  }
  public void rotateAngle(double angle){
    SmartDashboard.putNumber("GyroAngle",gyro.getAngle());
    gyroController.enable();
    gyroController.setSetpoint(angle);
  }
  public PIDController getLeftController() {
    return leftEncoderController;
  }
  public PIDController getGyroController(){
    return gyroController;
  }
  public double getLeftRotations() {
    return leftEncoder.get();
  }
  public void resetGyro(){
    gyro.reset();
  }
  public AnalogGyro getGyro(){
    return gyro;
  }
  public class MotorsPIDOutput implements PIDOutput {
    @Override
    public void pidWrite(double output) {
      leftMotorOne.pidWrite(output);
      leftMotorTwo.pidWrite(output);
      rightMotorOne.pidWrite(-output);
      rightMotorTwo.pidWrite(-output);
    }
  }
  public class MotorsPIDOutputReversed implements PIDOutput {
    @Override
    public void pidWrite(double output) {
      leftMotorOne.pidWrite(output);
      leftMotorTwo.pidWrite(output);
      rightMotorOne.pidWrite(output);
      rightMotorTwo.pidWrite(output);
    }
  }
  public class GyroPIDSource implements PIDSource{
    public double pidGet(){
      return gyro.getAngle();
    }
    public PIDSourceType getPIDSourceType(){
      return PIDSourceType.kDisplacement;
    }
    public void setPIDSourceType(PIDSourceType type){
    }
  }
}
// vim: sw=2:ts=2:sts=2
