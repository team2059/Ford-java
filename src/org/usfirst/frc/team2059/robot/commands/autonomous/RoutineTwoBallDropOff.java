package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineTwoBallDropOff extends CommandGroup {
  public RoutineTwoBallDropOff() {
    addSequential(new AutoSetArmStopState(true));
    addSequential(new AutoResetLower(-1));
    addSequential(new AutoDriveStraightTime(0.5, 2));
    addSequential(new AutoMoveArm(0.5, 1));
    addSequential(new AutoSpinRollers(1, 2));
    addSequential(new AutoSetShooterState(true));
    addSequential(new AutoResetLower(-1));
    addSequential(new AutoRotate(180));
    addSequential(new AutoSetShooterState(false));
    addParallel(new AutoSpinRollers(-0.5, 3));
    addSequential(new AutoDriveStraightTime(0.5, 2));
    addSequential(new AutoRotate(180));
    addSequential(new AutoDriveStraightTime(0.5, 2));
    addSequential(new AutoMoveArm(0.5, 1));
    addSequential(new AutoSpinRollers(1, 2));
    addSequential(new AutoSetShooterState(true));
    addSequential(new AutoRotate(180));
    addSequential(new AutoSetShooterState(false));
  }
}
