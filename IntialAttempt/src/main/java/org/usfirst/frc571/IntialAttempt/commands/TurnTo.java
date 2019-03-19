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
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc571.IntialAttempt.Robot;

/**
 *
 */
public class TurnTo extends Command {

    private NetworkTableInstance tableInst = NetworkTableInstance.getDefault();
    private NetworkTable table = tableInst.getTable("Shuffleboard");
    private NetworkTableEntry angleEntry = table.getEntry("Subsystems/ahrs/output/angle");
    private NetworkTableEntry rateEntry = table.getEntry("Subsystems/ahrs/output/rate");
    
	private int i = 0;
	private boolean isFinishing = false;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_targetAngle;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public TurnTo(double targetAngle) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_targetAngle = targetAngle;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.driveTrain.turnTo(m_targetAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (Math.abs(m_targetAngle - angleEntry.getDouble(0.0)) < 4) {
			if (rateEntry.getDouble(0.0) < 0.5) {
				if (i == 0) {
					isFinishing = true;
				}
				if (isFinishing) {
					i++;
				}
			} else {
				isFinishing = false;
				i = 0;
			}
			if (i > 5) { // check if works for n cycles
				System.out.println("TurnTo finished");
				return true;
			}
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
