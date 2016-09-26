package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineDriveStraightTime extends CommandGroup {
  public RoutineDriveStraightTime() {
    addSequential(new AutoSetArmStopState(true));
    addSequential(new AutoResetLower(-1));
    addSequential(new AutoDriveStraightTime(1));
    addSequential(new AutoRotate(45));
    addParallel(new AutoSetArmPosition(90));
    addSequential(new AutoDriveStraightTime(1.5));
  }
}
