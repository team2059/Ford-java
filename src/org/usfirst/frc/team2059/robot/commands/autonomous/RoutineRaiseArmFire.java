package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineRaiseArmFire extends CommandGroup {
  public RoutineRaiseArmFire() {
    addSequential(new AutoSetArmPosition(90));
    //Raise the arm a little before spinning rollers
    try{ wait(2); }catch(Exception e){ }
    addParallel(new AutoSpinRollers(0.5,5));
    addSequential(new AutoSetShooterState(true));
  }
}
