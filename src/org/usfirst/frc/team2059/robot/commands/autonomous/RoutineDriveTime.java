package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineDriveTime extends CommandGroup {
  public RoutineDriveTime() {
    addSequential(new AutoSetArmStopState(true));
    addSequential(new AutoResetLower(-1));
    addSequential(new AutoDriveTime(1.5, 0.75));
  }
}
