// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc571.IntialAttempt.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc571.IntialAttempt.subsystems.*;

/**
 *
 */
public class AutoDepositCargo extends CommandGroup {

    int station = DriverStation.getInstance().getLocation();


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
    public AutoDepositCargo() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
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
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

    if(station == 3) {
        addSequential(new TimedForward(1, 0, 0.7));
        addSequential(new CurveTo(90, 0.8, 1.5, false));
        // addSequential(new TimedForward(1,0,0.7));
        // addParallel(new RotateTo(45));
        // addSequential(new TimedForward(2,30,0.7));
        // if(station == 1){
        //     addSequential(new CurveTo(90, 0.6, 1.5, false));
        // }
        // else if (station == 3){
        //     addSequential(new CurveTo(-90, 0.6, 1.5, true));
        // }
        // addSequential(new ShootLower());
        // addSequential(new TimedBackward(1));
    }
 
    }

    // @Override
    // protected void execute() {
    //     this.start();
    // }
}
