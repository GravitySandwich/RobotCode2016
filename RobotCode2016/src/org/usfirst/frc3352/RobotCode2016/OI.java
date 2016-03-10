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

import org.usfirst.frc3352.RobotCode2016.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
//import org.usfirst.frc3352.RobotCode2016.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick driveJoy;
    public JoystickButton intakeTrigger;
    public JoystickButton shootTrigger;
    public JoystickButton  pushTrigger;
    public Joystick operatorJoy;
	public InternalButton resetGyroTrigger;
	public JoystickButton shiftTrigger;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        operatorJoy = new Joystick(1);
        
        shootTrigger = new JoystickButton(operatorJoy, 2);
        shootTrigger.whileHeld(new Shoot());
        intakeTrigger = new JoystickButton(operatorJoy, 1);
        intakeTrigger.whileHeld(new Intake());
        driveJoy = new Joystick(0);
        
        pushTrigger = new JoystickButton(operatorJoy, 5);
        pushTrigger.whenPressed(new BallPush());
        
        shiftTrigger = new JoystickButton(driveJoy, 5);
        shiftTrigger.whenPressed(new ShiftGear());
        


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Drive", new Drive());
        SmartDashboard.putData("Angle", new Angle());
        SmartDashboard.putData("Intake", new Intake());
        SmartDashboard.putData("Shoot", new Shoot());
        SmartDashboard.putData("StopDrive", new StopDrive());
        SmartDashboard.putData("BallPush", new BallPush());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		resetGyroTrigger = new InternalButton(true);
        resetGyroTrigger.whenPressed(new ResetGyro());//reset gyro when arm is straight up
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveJoy() {
        return driveJoy;
    }

    public Joystick getOperatorJoy() {
        return operatorJoy;
    }

	


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public double getForwardVal() {
		//* Returns a value from -1 to 1 representing forward speed
		return driveJoy.getRawAxis(1);
		
	}
	public double getTurnVal() {
		//* Returns a value from -1 to 1 representing turn speed; 1 represents full right
		return -driveJoy.getRawAxis(4);
		
	}
	
	public double getTarget() {
		return -operatorJoy.getRawAxis(1); //invert so positive value goes up
	}
	
	public boolean getOverride(){
		return operatorJoy.getRawButton(6);//true overrides limit switches
	}

}

