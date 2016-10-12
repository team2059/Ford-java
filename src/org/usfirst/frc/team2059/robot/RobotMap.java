package org.usfirst.frc.team2059.robot;
public class RobotMap {
  //Drive
  public static int driveLeftMotorOne = 1;
  public static int driveLeftMotorTwo = 2;
  public static int driveRightMotorOne = 3;
  public static int driveRightMotorTwo = 4;
  public static int driveLeftEncoderA = 0;
  public static int driveLeftEncoderB = 1;
  public static int gyro = 1;
  //Arm
  public static double zeroDegrees = 1.469;
  public static double ninetyDegrees = 3.274;
  public static int armPot = 0;
  public static int armLeftMotor = 5;
  public static int armRightMotor = 6;
  public static int armBottomLim = 4;
  public static int armTopLim = 5;
  //Shooter
  public static int shooterLeftMotor = 7;
  public static int shooterRightMotor = 8;
  //Pneumatics
  public static int pcmID = 31;
  public static int shooterSolenoidOne = 0;
  public static int shooterSolenoidTwo = 1;
  public static int portcullisSolenoidOne = 2;
  public static int portcullisSolenoidTwo = 3;
  public static int armStopSolenoidOne = 4;
  public static int armStopSolenoidTwo = 5;
  //Camera
  //public static double fWidth = 2.8;
  // Camera: Axis M1013
  // FOV = 67deg
  // f = pixelSize/(2*tan(FOV/2))
  public static double imageWidth = 640;
  public static double imageHeight = 480;
  public static double fWidth = 483.467261958;
  public static double fHeight = 362.600446468;
  public static int sonar = 2;
  public static int goalHeight = 72;
  //Misc
  public static int mainArmPresetCollect = -5;
  public static int mainArmPresetTraverse = 10;
  public static int mainArmPresetLowShot = 18;
  public static int mainArmPresetCloseShot = 90;
  public static int mainArmPresetFarShot = 70;
}
// vim: sw=2:ts=2:sts=2
