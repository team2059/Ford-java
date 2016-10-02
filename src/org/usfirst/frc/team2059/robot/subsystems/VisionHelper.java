package org.usfirst.frc.team2059.robot.subsystems;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
public class VisionHelper {
     NetworkTable contoursTable;
   public VisionHelper(){
     contoursTable=NetworkTable.getTable("GRIP/contours");
   }
   public double getCenterX(){
      try{
         return contoursTable.getNumberArray("centerX",new double[0])[0];
      }catch(Exception e){
         return 0;
      }

   }
}
