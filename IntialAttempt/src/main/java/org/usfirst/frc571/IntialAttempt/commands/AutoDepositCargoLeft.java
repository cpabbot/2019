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
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc571.IntialAttempt.subsystems.*;

/**
 *
 */
public class AutoDepositCargoLeft extends CommandGroup {

    int station = DriverStation.getInstance().getLocation();

    public AutoDepositCargoLeft() {
        /******* addSequential(new WaitCommand(1)); *******/
        addSequential(new TimedForward(0.7, 0, 0.7)); // distance, dir, speed
        addSequential(new CurveTo(-60, 0.6, 2, false)); // (float targetAngle, double speed, double radius, boolean toLeft)
        addSequential(new TimedForward(0.8, -60, 0.75));
        addSequential(new CurveTo(0, 0.6, 1.5, true));
        addSequential(new TimedForward(0.5, 0, 0.7));
        addSequential(new TurnTo(90));
        addParallel(new RotateTo(40));
        addSequential(new TimedForward(1.0, 90, 0.6));
        addSequential(new TimedRoll(1));
    }

    // @Override
    // protected void execute() {
    //     this.start();
    // }
}