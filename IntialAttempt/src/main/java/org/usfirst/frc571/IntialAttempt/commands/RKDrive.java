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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc571.IntialAttempt.Robot;
import org.usfirst.frc571.IntialAttempt.subsystems.DriveTrain;

/**
 *
 */
public class RKDrive extends Command {

    DriveTrain driveTrain = Robot.driveTrain;
	Joystick driveStick = Robot.oi.driveStick;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public RKDrive() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        // System.out.println("initializing RKDrive");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        /*double driveX = driveStick.getX();
        double driveY = -driveStick.getY();
        double motorPercent = 1 - Math.abs(driveX);
        double leftMotor = 0.0;
        double rightMotor = 0.0;

        if(driveX < 0) {
            leftMotor = motorPercent * driveY;
            rightMotor = driveY;
        }
        else if(driveX > 0) {
            rightMotor = motorPercent * driveY;
            leftMotor = driveY;
        }
        
        driveTrain.tankDrive(leftMotor, rightMotor);*/

        // driveTrain.tankDrive(driveStick.getY()*driveStick.getX(), rotation);

        
        if (driveStick.getTrigger()){
            driveTrain.arcadeDrive(0.5 * -driveStick.getY(), 0.5 * driveStick.getZ()*(-driveStick.getThrottle()+1)*0.5); // (speed, rotation)
        }
        else {
            driveTrain.arcadeDrive(-driveStick.getY(), driveStick.getZ()*(-driveStick.getThrottle()+1)*0.5); // (speed, rotation)
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
