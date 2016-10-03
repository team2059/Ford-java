package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineShoot extends CommandGroup {
  public RoutineShoot() {
    addSequential(new AutoSetArmStopState(true));
    addSequential(new AutoResetLower(-1));
    addSequential(new AutoDriveStraightTime(0.5, 1));
    addSequential(new AutoSetArmPosition(90));
    //addSequential(new AutoRotate(45));
    //addSequential(new AutoDriveStraightTime(0.4, 1.5));
    addSequential(new VisionAlignHorizontal()); }
}
