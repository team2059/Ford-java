package org.usfirst.frc.team2059.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team2059.robot.commands.LogEncoder;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  JoystickButton[][] joystickButtons;
  Joystick[] joysticks;
  public OI() {
    // Create joysticks
    joysticks[0] = new Joystick(1);
    joysticks[1] = new Joystick(2);
    // Create buttons
    for(int i=0;i<12;i++) {
      joystickButtons[0][i] = new JoystickButton(joysticks[0], i + 1);
      joystickButtons[1][i] = new JoystickButton(joysticks[1], i + 1);
    }
    // Start logging with button1, stop with button2
    Command logEncoder = new LogEncoder();
    joystickButtons[0][0].whenPressed(logEncoder);
    joystickButtons[0][1].cancelWhenPressed(logEncoder);
  }
}
// vim: sw=2:ts=2:sts=2
