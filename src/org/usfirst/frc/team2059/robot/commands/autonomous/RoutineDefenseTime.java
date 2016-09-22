package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineDefenseTime extends CommandGroup{
   public RoutineDefenseTime(){
      addSequential(new AutoSetArmStopState(true));
      addSequential(new AutoResetLower(-1));
      addSequential(new AutoSetArmPosition(15));
      addSequential(new AutoSetArmStopState(false));
      addSequential(new AutoSetArmPosition(11));
//      addSequential(new AutoDriveTime(2,.5));
   }
}
