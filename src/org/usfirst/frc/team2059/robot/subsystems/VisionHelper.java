package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
public class VisionHelper {
   NetworkTable contoursTable;
   double hfieldOfView=67;
   double vfieldOfView=51;
   double imageWidth=640;
   double imageHeight=480; 
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
   public double getCenterY(){
      try{
         return contoursTable.getNumberArray("centerY",new double[0])[0];
      }catch(Exception e){
         return 0;
      }
   }
   public double getHorizontalError(){
      return Math.atan2(getCenterX()-RobotMap.imageWidth/2, RobotMap.fWidth);
   }
   public double getVerticalError(){
      return Math.atan2(getCenterY()-RobotMap.imageHeight/2, RobotMap.fHeight);
   }
}
