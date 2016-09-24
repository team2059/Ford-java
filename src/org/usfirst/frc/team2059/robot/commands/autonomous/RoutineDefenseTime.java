package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineDefenseTime extends CommandGroup {
  public RoutineDefenseTime() {
    addSequential(new AutoSetArmStopState(false));
    addSequential(new AutoSetArmPosition(6));
    addSequential(new AutoDriveTime(3, 1));
  }
}
