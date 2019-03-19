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

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc571.IntialAttempt.Robot;

/**
 *
 */
public class CurveTo extends Command {

    private float targetAngle = 0;
	private double speed = 0.0;
	private double leftSpeed = 0.0;
    private double rightSpeed = 0.0;
    
    private NetworkTableInstance tableInst = NetworkTableInstance.getDefault();
    private NetworkTable table = tableInst.getTable("Shuffleboard");
    private NetworkTableEntry angleEntry = table.getEntry("Subsystems/ahrs/output/angle");

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_targetAngle;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public CurveTo(double targetAngle) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_targetAngle = targetAngle;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    public CurveTo(float targetAngle, double leftSpeed, double rightSpeed) {

		this.targetAngle = targetAngle;
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
		
		requires(Robot.driveTrain);
		
	}
	
	public CurveTo(float targetAngle, double speed, double radius, boolean toLeft) {

		this.targetAngle = targetAngle;
		
		if(toLeft) {
			this.rightSpeed = speed;
			this.leftSpeed = (radius*speed)/(2.33+radius);
		}
		else {
			this.leftSpeed = speed;
//			this.rightSpeed = (2.33+radius)/radius*speed;
			this.rightSpeed = (radius*speed)/(2.33+radius);
		}
		
        requires(Robot.driveTrain);
        
        System.out.println("left speed: " + leftSpeed + " right speed: " + rightSpeed);
		
	}

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.driveTrain.tankDrive(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        // turning left
		if((rightSpeed > leftSpeed) && ((angleEntry.getDouble(0.0) < (targetAngle + 5)))) {
			System.out.println("finished curve to left");
			return true;
		}
		// turning right
		if((leftSpeed > rightSpeed) && ((angleEntry.getDouble(0.0) > (targetAngle - 5)))) {
			System.out.println("finished curve to right");
			return true;
		}
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
