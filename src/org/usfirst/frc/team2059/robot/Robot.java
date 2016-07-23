package org.usfirst.frc.team2059.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Robot extends IterativeRobot {
  public static OI oi;
  Command autonomousCommand;
  SendableChooser chooser;
  public void robotInit() {
    oi = new OI();
    chooser = new SendableChooser();
    SmartDashboard.putData("Auto mode", chooser);
  }
  public void disabledInit() {
  }
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }
  public void autonomousInit() {
    autonomousCommand = (Command) chooser.getSelected();
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
  public void testPeriodic() {
    LiveWindow.run();
  }
}
//  vim: sw=2:ts=2:sts=2
