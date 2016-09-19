package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import org.usfirst.frc.team2059.robot.commands.drivetrain.Drive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2059.robot.structs.EncoderValues;
public class EncoderBase extends Subsystem {
  //TODO: Might not need a constructor
  public EncoderBase() {
  }
  //Encoder enc = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
  Encoder enc = new Encoder(8, 9);
  public void initDefaultCommand() {
    //TODO: Not sure if we need a default command, not setting one
    //TODO: These are just defaults, they wil lneed to be changed
    //enc.setMaxPeriod(.1);
    //enc.setMinRate(10);
    //enc.setDistancePerPulse(5);
    //enc.setReverseDirection(false);
    //enc.setSamplesToAverage(7);
  }
  public void resetEncoder() {
    enc.reset();
  }
  public EncoderValues getValues() {
    //TODO: There are two ways to get distance:
    //enc.getDistance();
    //enc.getRaw();
    //figure out which to use
    return new EncoderValues(enc.get() , enc.getRaw() , enc.getPeriod() , enc.getRate() , enc.getDirection() , enc.getStopped());
  }
}
// vim: sw=2:ts=2:sts=2
