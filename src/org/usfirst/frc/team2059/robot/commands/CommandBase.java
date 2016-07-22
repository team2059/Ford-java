package org.usfirst.frc.team2059.robot.commands;
import org.usfirst.frc.team2059.robot.subsystems.Drivebase;
import org.usfirst.frc.team2059.robot.subsystems.Encoderbase;
import edu.wpi.first.wpilibj.command.Command;
public abstract class CommandBase extends Command {
  protected static Encoderbase encoderbase = new Encoderbase();
  protected static Drivebase drivebase = new Drivebase();
}
// vim: sw=2:ts=2:sts=2
