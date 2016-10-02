package org.usfirst.frc.team2059.robot;
import org.usfirst.frc.team2059.robot.commands.CommandBase;
import org.usfirst.frc.team2059.robot.commands.autonomous.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Robot extends IterativeRobot {
  public static OI oi;
  Command autonomousCommand;
  SendableChooser chooser;
//  CameraServer cameraServer;
  public void robotInit() {
    CommandBase.init();
    oi = new OI();
    chooser = new SendableChooser();
//   cameraServer = CameraServer.getInstance();
//    cameraServer.setQuality(50);
//    cameraServer.startAutomaticCapture("cam0");
    try{
      Process grip = Runtime.getRuntime().exec(new String[]{"/usr/local/frc/JRE/bin/java", "-jar", "grip.jar", "project.grip"});
    }catch(Exception e){
      System.out.println("Error starting GRIP");
    }
    chooser.addDefault("Nothing", new RoutineNothing());
    chooser.addObject("Time based low bar", new RoutineDriveTime());
    chooser.addObject("Time based straight low bar", new RoutineDriveStraightTime());
    chooser.addObject("Distance based low bar straight", new RoutineDriveStraightDistance());
    chooser.addObject("Time based defense", new RoutineDefenseTime());
    chooser.addObject("Shot Auto", new RoutineShoot());
    chooser.addObject("Two Ball Drop off", new RoutineTwoBallDropOff());
    SmartDashboard.putData("Auto mode", chooser);
    SmartDashboard.putData("MainArm", CommandBase.mainArm.getPIDController());
    SmartDashboard.putData("LeftEncoderController", CommandBase.driveBase.getLeftController());
    SmartDashboard.putData("gyroPID", CommandBase.driveBase.getGyroController());
    SmartDashboard.putNumber("GyroCorrection", 0.13);
    SmartDashboard.putBoolean("CompressorEnabled", true);
    //Automatically determine if rolling in or rolling out
    SmartDashboard.putBoolean("SmartRollers", false);
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
    CommandBase.pneumatics.setArmStopState(false);
  }
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("ArmAngleRaw", CommandBase.mainArm.getRaw());
    SmartDashboard.putNumber("ArmAngleDegrees", CommandBase.mainArm.getDegrees());
    SmartDashboard.putNumber("tmpRotations", CommandBase.driveBase.getLeftRotations());
    SmartDashboard.putNumber("horizontalError",CommandBase.visionHelper.getHorizontalError());
    SmartDashboard.putNumber("verticalError",CommandBase.visionHelper.getVerticalError());
    SmartDashboard.putNumber("horizontalErrorCorrected",CommandBase.visionHelper.getHorizontalError()+5);
    SmartDashboard.putNumber("goalDistance",72/Math.tan(0.0175*(35+CommandBase.visionHelper.getVerticalError())));
    if (Robot.oi.getJoysticks()[1].getRawButton(3)) {
      CommandBase.pneumatics.setArmStopState(true);
    } else {
      CommandBase.pneumatics.setArmStopState(false);
    }
    CommandBase.pneumatics.setCompressorEnabled(SmartDashboard.getBoolean("CompressorEnabled"));
  }
  public void testPeriodic() {
    LiveWindow.run();
  }
}
//  vim: sw=2:ts=2:sts=2
