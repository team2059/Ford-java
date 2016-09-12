package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.DriveBase;
import org.usfirst.frc.team2059.robot.subsystems.EncoderBase;
import org.usfirst.frc.team2059.robot.subsystems.MainArm;
import org.usfirst.frc.team2059.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.command.Command;
public abstract class CommandBase extends Command {
  public static EncoderBase encoderBase;
  public static DriveBase driveBase;
  public static MainArm mainArm;
  public static Pneumatics pneumatics;
  public static void init() {
    encoderBase = new EncoderBase();
    driveBase = new DriveBase();
    mainArm = new MainArm();
    pneumatics = new Pneumatics();
  }
}
// vim: sw=2:ts=2:sts=2
