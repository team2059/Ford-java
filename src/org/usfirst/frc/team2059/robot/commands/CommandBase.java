package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.DriveBase;
import org.usfirst.frc.team2059.robot.subsystems.EncoderBase;
import org.usfirst.frc.team2059.robot.subsystems.MainArm;
import org.usfirst.frc.team2059.robot.subsystems.Pneumatics;
import org.usfirst.frc.team2059.robot.subsystems.Shooter;
import org.usfirst.frc.team2059.robot.subsystems.VisionHelper;
import edu.wpi.first.wpilibj.command.Command;
public abstract class CommandBase extends Command {
  public static EncoderBase encoderBase;
  public static DriveBase driveBase;
  public static MainArm mainArm;
  public static Pneumatics pneumatics;
  public static Shooter shooter;
  public static VisionHelper visionHelper;
  public static void init() {
    encoderBase = new EncoderBase();
    driveBase = new DriveBase();
    mainArm = new MainArm();
    pneumatics = new Pneumatics();
    shooter = new Shooter();
    visionHelper = new VisionHelper();
  }
}
// vim: sw=2:ts=2:sts=2
