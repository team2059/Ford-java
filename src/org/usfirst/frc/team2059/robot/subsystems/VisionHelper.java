package org.usfirst.frc.team2059.robot.subsystems;
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
         return 420;
      }
   }
   public double getCenterY(){
      try{
         return contoursTable.getNumberArray("centerY",new double[0])[0];
      }catch(Exception e){
         return 420;
      }
   }
   public double getHorizontalError(){
      if(getCenterX()==420){
         return 420;
      }
      double degreesPerPixel=hfieldOfView/imageWidth;
      double centerColumn=imageWidth/2;
      return (getCenterX()-centerColumn)*degreesPerPixel;
   }
   public double getVerticalError(){
      if(getCenterY()==420){
         return 420;
      }
      double degreesPerPixel=vfieldOfView/imageHeight;
      double centerRow=imageHeight/2;
      return (getCenterY()-centerRow)*degreesPerPixel;
   }
}
