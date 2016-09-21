package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team2059.robot.Robot;
public class RoutineDefenseTime extends CommandGroup{
   public RoutineDefenseTime(){
      addSequential(new AutoResetLower(-1));
      addSequential(new AutoSetArmPosition(15));
      //Extend stop
      addSequential(new AutoSetArmPosition(10));
      addSequential(new AutoDriveTime(2,.5));
   }
}
