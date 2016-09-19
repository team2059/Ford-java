package org.usfirst.frc.team2059.robot.commands.autonomous;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.Robot;
public class AutoDrive extends CommandBase {
   private double distance;
   // Determines if we should start driving
   // Will be false if we already started driving
   private boolean startDriving = true;
   public AutoDrive(double distance, double timeout) {
      requires(driveBase);
      this.distance = distance;
      setTimeout(timeout);
   }
   public AutoDrive(double distance) {
      requires(driveBase);
      this.distance = distance;
      // Make the default timeout 2s
      setTimeout(2.0d);
   }
   protected void initialize() {
   }
   protected void execute() {
      if (startDriving) {
         driveBase.pidDrive(distance);
      }
      startDriving = false;
   }
   protected void end() {
      startDriving = true;
      driveBase.stopDriving();
   }
   protected void interrupted() {
      end();
   }
   protected boolean isFinished() {
      return isTimedOut();
   }
}
// vim: sw=2:ts=2:sts=2
