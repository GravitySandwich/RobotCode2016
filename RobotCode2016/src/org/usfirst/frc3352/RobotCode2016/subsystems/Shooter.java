// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3352.RobotCode2016.subsystems;

import org.usfirst.frc3352.RobotCode2016.RobotMap;
import org.usfirst.frc3352.RobotCode2016.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class Shooter extends PIDSubsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon angle = RobotMap.shooterangle;
    private final CANTalon shooter = RobotMap.shootershooter;
    private final AnalogGyro gyro = RobotMap.shooterGyro;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon shooter2 = RobotMap.shootershooter2;
    public static final double STOW   = 90,
    						   SHOOT  = 45,
    						   INTAKE =  0;
    
    public Shooter(){
    	super("Shooter",1.0,0.0,0.0);
    	setAbsoluteTolerance(10);
    	getPIDController().setContinuous(false);
    	LiveWindow.addActuator("Shooter", "PID Subsytem Controller", getPIDController());
    	
    }

    

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    	setDefaultCommand(new Angle());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    public void setWheelSpeed(double speed){
    	shooter.set(speed);
    	shooter2.set(speed);
    }
    public void setAngle(double angle){
    	this.angle.set(angle);
    }

    public double getAngle(){
    	return gyro.getAngle();
    }

    public void resetGyro(){
    	gyro.reset();
    }
    
	@Override
	protected double returnPIDInput() {
		return gyro.getAngle();
	}



	@Override
	protected void usePIDOutput(double setpoint) {
		angle.pidWrite(setpoint);
		
	}
}
