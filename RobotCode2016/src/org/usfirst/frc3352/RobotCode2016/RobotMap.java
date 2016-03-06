// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3352.RobotCode2016;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.AnalogGyro;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon drivetrainrightDrive1;
    public static CANTalon drivetrainrightDrive2;
    public static CANTalon drivetrainleftDrive1;
    public static CANTalon drivetrainleftDrive2;
    public static RobotDrive drivetrainrobotDrive;
    public static Encoder drivetrainleftEncoder;
    public static Encoder drivetrainrightEncoder;
    public static CANTalon shooterangle;
    public static CANTalon shootershooter;
    public static DoubleSolenoid pushball;
	public static PIDController shooterPID;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon shootershooter2;
	public static AnalogGyro shooterGyro;
	public static DigitalInput shooterLimit;
	
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainrightDrive1 = new CANTalon(1);
        LiveWindow.addActuator("Drivetrain", "rightDrive1", drivetrainrightDrive1);
        
        drivetrainrightDrive2 = new CANTalon(2);
        LiveWindow.addActuator("Drivetrain", "rightDrive2", drivetrainrightDrive2);
        
        drivetrainleftDrive1 = new CANTalon(4);
        LiveWindow.addActuator("Drivetrain", "leftDrive1", drivetrainleftDrive1);
        
        drivetrainleftDrive2 = new CANTalon(5);
        LiveWindow.addActuator("Drivetrain", "leftDrive2", drivetrainleftDrive2);
        
        drivetrainrobotDrive = new RobotDrive(drivetrainleftDrive1, drivetrainleftDrive2,
              drivetrainrightDrive1, drivetrainrightDrive2);
        
        drivetrainrobotDrive.setSafetyEnabled(true);
        drivetrainrobotDrive.setExpiration(0.1);
        drivetrainrobotDrive.setSensitivity(0.5);
        drivetrainrobotDrive.setMaxOutput(1.0);

        drivetrainleftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "leftEncoder", drivetrainleftEncoder);
        drivetrainleftEncoder.setDistancePerPulse(1.0);
        drivetrainleftEncoder.setPIDSourceType(PIDSourceType.kRate);
        drivetrainrightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "rightEncoder", drivetrainrightEncoder);
        drivetrainrightEncoder.setDistancePerPulse(1.0);
        drivetrainrightEncoder.setPIDSourceType(PIDSourceType.kRate);
        shooterangle = new CANTalon(7);
        LiveWindow.addActuator("Shooter", "angle", shooterangle);
		
		shootershooter2 = new CANTalon(3);
        LiveWindow.addActuator("Shooter", "shooter2", shootershooter2);
        
        shootershooter = new CANTalon(8);
        LiveWindow.addActuator("Shooter", "shooter", shootershooter);
        
        pushball = new DoubleSolenoid(0, 1);
        LiveWindow.addActuator("ShooterPneumatics", "BallPusher", pushball);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		shooterGyro = new AnalogGyro(0);
        
        shooterLimit = new DigitalInput(4);//limit switch is hit when arm is straight up
     }
}
