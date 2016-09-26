package org.usfirst.frc.team2059.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2059.robot.commands.drivetrain.LogEncoder;
import org.usfirst.frc.team2059.robot.commands.drivetrain.PIDDrive;
import org.usfirst.frc.team2059.robot.commands.shooter.MoveArm;
import org.usfirst.frc.team2059.robot.commands.shooter.ResetLower;
import org.usfirst.frc.team2059.robot.commands.shooter.ResetUpper;
import org.usfirst.frc.team2059.robot.commands.shooter.SetArmPosition;
import org.usfirst.frc.team2059.robot.commands.shooter.SetShooterState;
import org.usfirst.frc.team2059.robot.commands.shooter.SetArmStopState;
import org.usfirst.frc.team2059.robot.commands.shooter.ShootAtSpeed;
import org.usfirst.frc.team2059.robot.commands.shooter.SpinRollers;
import org.usfirst.frc.team2059.robot.RobotMap;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  JoystickButton[][] joystickButtons;
  Joystick[] joysticks;
  public OI() {
    joysticks = new Joystick[2];
    joystickButtons = new JoystickButton[2][13];
    // Create joysticks
    joysticks[0] = new Joystick(0);
    joysticks[1] = new Joystick(1);
    // Create buttons
    for (int i = 0; i < 12; i++) {
      joystickButtons[0][i] = new JoystickButton(joysticks[0], i + 1);
      joystickButtons[1][i] = new JoystickButton(joysticks[1], i + 1);
    }
    // Print log when button 1 pressed
    //joystickButtons[0][0].whenPressed(new LogEncoder());
    joystickButtons[0][0].whileHeld(new SetShooterState(true));
    joystickButtons[0][2].whileHeld(new SpinRollers(-0.5,false));
    joystickButtons[0][3].whileHeld(new SpinRollers(1,false));
    joystickButtons[0][6].whileHeld(new SpinRollers(1,true));
//    joystickButtons[0][2].whileHeld(new PIDDrive(400));
    joystickButtons[1][0].whileHeld(new MoveArm(1));
    joystickButtons[1][1].whileHeld(new MoveArm(-1));
    //joystickButtons[1][2].whileHeld(new SetArmPosition(RobotMap.mainArmPresetCollect));
    joystickButtons[1][2].whileHeld(new ResetLower(-1));
    joystickButtons[1][3].whileHeld(new SetArmPosition(RobotMap.mainArmPresetTraverse));
    joystickButtons[1][4].whileHeld(new SetArmPosition(RobotMap.mainArmPresetCloseShot));
    joystickButtons[1][5].whileHeld(new SetArmPosition(RobotMap.mainArmPresetLowShot));
  }
  public Joystick[] getJoysticks() {
    return joysticks;
  }
  public Joystick getJoystick(int stick) {
    return joysticks[stick];
  }
  public JoystickButton[][] getJoystickButtons() {
    return joystickButtons;
  }
}
// vim: sw=2:ts=2:sts=2
