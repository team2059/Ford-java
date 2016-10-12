package org.usfirst.frc.team2059.robot.subsystems;
import org.usfirst.frc.team2059.robot.RobotMap;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
public class VisionHelper {
  NetworkTable linesTable, contoursTable;
  double imageWidth = 640;
  double imageHeight = 480;
  public VisionHelper() {
    linesTable = NetworkTable.getTable("GRIP/lines");
    contoursTable = NetworkTable.getTable("GRIP/contours");
  }
  public double getCenterContourX(){
     try{
        return contoursTable.getNumberArray("centerX",new double[0])[0];
     }catch(Exception e){
        return 0;
     }
  }
  public double getSlope(){
    int highestLengthIndex = 0;
    int index = 0;
    double lengths[] = linesTable.getNumberArray("length", new double[0]);
    try{
    double x1s[] = linesTable.getNumberArray("x1", new double[0]);
    double y1s[] = linesTable.getNumberArray("y1", new double[0]);
    double x2s[] = linesTable.getNumberArray("x2", new double[0]);
    double y2s[] = linesTable.getNumberArray("y2", new double[0]);
    for(double length : lengths){
       if(length >= lengths[highestLengthIndex]){
          highestLengthIndex=index;
       }
       index++;
    }
    return ((y1s[highestLengthIndex]-y2s[highestLengthIndex])/(x1s[highestLengthIndex]-x2s[highestLengthIndex]));
    }catch(Exception e){
       return 0;
    }
  }
  public double getCenterX() {
    int highestLengthIndex = 0;
    int index = 0;
    double lengths[] = linesTable.getNumberArray("length", new double[0]);
    double x1s[] = linesTable.getNumberArray("x1", new double[0]);
    double x2s[] = linesTable.getNumberArray("x2", new double[0]);
    for(double length : lengths){
       if(length >= lengths[highestLengthIndex]){
          highestLengthIndex=index;
       }
       index++;
    }
    System.out.println("Highest Length Index:"+ highestLengthIndex);
    try {
      return (x1s[highestLengthIndex]+x2s[highestLengthIndex])/2;
    } catch (Exception e) {
      return 0;
    }
  }
  public double getCenterY() {
    int highestLengthIndex = 0;
    int index = 0;
    double lengths[] = linesTable.getNumberArray("length", new double[0]);
    double y1s[] = linesTable.getNumberArray("y1", new double[0]);
    double y2s[] = linesTable.getNumberArray("y2", new double[0]);
    for(double length : lengths){
       if(length >= lengths[highestLengthIndex]){
          highestLengthIndex=index;
       }
       index++;
    }
    System.out.println("Highest Length Index:"+ highestLengthIndex);
    try {
      return (y1s[highestLengthIndex]+y2s[highestLengthIndex])/2;
    } catch (Exception e) {
      return 0;
    }
  }
  public double getHorizontalError() {
    return (180/Math.PI) * (Math.atan((getCenterContourX() - (RobotMap.imageWidth / 2)) / RobotMap.fWidth));
  }
  public double getVerticalError() {
    return (180/Math.PI) * (Math.atan((getCenterY() - (RobotMap.imageHeight / 2)) / RobotMap.fHeight));
  }
}
