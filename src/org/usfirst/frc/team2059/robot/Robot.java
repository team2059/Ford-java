package org.usfirst.frc.team2059.robot;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.commands.autonomous.*;
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
    CommandBase.init();
    oi = new OI();
    chooser = new SendableChooser();

    chooser.addDefault("Time based drive", new RoutineDriveTime());
    chooser.addObject("Time based defense", new RoutineDefenseTime());

    SmartDashboard.putData("Auto mode", chooser);
    SmartDashboard.putData("MainArm", CommandBase.mainArm.getPIDController());
    SmartDashboard.putData("LeftEncoderController", CommandBase.driveBase.getLeftController());
    SmartDashboard.putBoolean("CompressorEnabled", true);
    //Automatically determine if rolling in or rolling out
    SmartDashboard.putBoolean("SmartRollers", true);
    //Use the limit swithces on the shooter
    SmartDashboard.putBoolean("UseLimitSwitches", true);
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
    SmartDashboard.putNumber("ArmAngleRaw", CommandBase.mainArm.getRaw());
    SmartDashboard.putNumber("ArmAngleDegrees", CommandBase.mainArm.getDegrees());
    SmartDashboard.putNumber("tmpRotations", CommandBase.driveBase.getLeftRotations());
  }
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    CommandBase.pneumatics.setCompressorEnabled(true);
    CommandBase.pneumatics.setArmStopState(true);
  }
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("ArmAngleRaw", CommandBase.mainArm.getRaw());
    SmartDashboard.putNumber("ArmAngleDegrees", CommandBase.mainArm.getDegrees());
    SmartDashboard.putNumber("tmpRotations", CommandBase.driveBase.getLeftRotations());
    CommandBase.pneumatics.setCompressorEnabled(SmartDashboard.getBoolean("CompressorEnabled"));
    System.out.println(CommandBase.mainArm.getDegrees());
  }
  public void testPeriodic() {
    LiveWindow.run();
  }
}
//  vim: sw=2:ts=2:sts=2
