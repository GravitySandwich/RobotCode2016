package org.usfirst.frc3352.RobotCode2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAcrossDefense_Auto extends CommandGroup {
    
	public enum Defense {LOWBAR, PORTCULLIS, MOAT, DRAWBRIDGE, ROCKWALL, ROUGH, CHEVAL, SALLY, RAMPART}
	
    public  DriveAcrossDefense_Auto(Defense defense) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new ResetGyro());
    	if(defense == Defense.LOWBAR) addParallel(new AnglePID(80));
		addSequential(new DriveToDefense_Auto());
		addSequential(new DriveToPosition(4,0));
    }
}
