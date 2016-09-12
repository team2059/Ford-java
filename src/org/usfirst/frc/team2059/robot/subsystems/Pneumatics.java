package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
public class Pneumatics extends Subsystem {
  Compressor compressor = new Compressor(RobotMap.pcmID);
  DoubleSolenoid shooterSolenoid = new DoubleSolenoid(RobotMap.shooterSolenoidOne, RobotMap.shooterSolenoidTwo);
  DoubleSolenoid armStopSolenoid = new DoubleSolenoid(RobotMap.armStopSolenoidOne, RobotMap.armStopSolenoidTwo);
  boolean shooterState, armStopState;
  public void initDefaultCommand() {
  }
  public void setCompressorEnabled(boolean state){
    compressor.setClosedLoopControl(state);
  }
  public void setShooterState(boolean state){
    if(state){
      shooterSolenoid.set(DoubleSolenoid.Value.kForward);
    }else{
      shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    shooterState=state;
  }
  public void setArmStopState(boolean state){
    if(state){
      armStopSolenoid.set(DoubleSolenoid.Value.kForward);
    }else{
      armStopSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    armStopState=state;
  }
  public boolean getShooterState(){
    return shooterState;
  }
  public boolean getArmStopState(){
    return armStopState;
  }
  public boolean getCompressorEnabled(){
    return compressor.enabled();
  }
}
// vim: sw=2:ts=2:sts=2
