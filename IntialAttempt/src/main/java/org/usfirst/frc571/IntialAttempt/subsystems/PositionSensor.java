// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// PURPOSE: "all this does is publish data" - Mr. Schwartz (to the network tables)

package org.usfirst.frc571.IntialAttempt.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class PositionSensor extends Subsystem {

    private AHRS ahrs;
    private ShuffleboardTab dataTab = Shuffleboard.getTab("Subsystems");
    private NetworkTableEntry connectedEntry, angleEntry, rateEntry, pitchEntry, rollEntry;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public PositionSensor() {
        try {
			/***********************************************************************
			 * navX-MXP: - Communication via RoboRIO MXP (SPI, I2C, TTL UART) and USB. - See
			 * http://navx-mxp.kauailabs.com/guidance/selecting-an-interface.
			 * 
			 * navX-Micro: - Communication via I2C (RoboRIO MXP or Onboard) and USB. - See
			 * http://navx-micro.kauailabs.com/guidance/selecting-an-interface.
			 * 
			 * Multiple navX-model devices on a single robot are supported.
			 ************************************************************************/
            ahrs = new AHRS(SPI.Port.kMXP);
            
			ahrs.enableLogging(true);
            ahrs.zeroYaw();

		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        connectedEntry = dataTab
            .add("ahrs/output/connected", ahrs.isConnected())
            .getEntry();
        angleEntry = dataTab
            .add("ahrs/output/angle", ahrs.getAngle())
            .getEntry();
        pitchEntry = dataTab
            .add("ahrs/output/pitch", ahrs.getPitch())
            .getEntry();
        rollEntry = dataTab
            .add("ahrs/output/roll", ahrs.getRoll())
            .getEntry();
        rateEntry = dataTab
            .add("ahrs/output/rate", ahrs.getRate())
            .getEntry();
        // dataTab.getComponents().get(0).withSize(2, 3);
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    }

    @Override
    public void periodic() {

        connectedEntry.setBoolean(ahrs.isConnected());
        angleEntry.setDouble(ahrs.getAngle());
        pitchEntry.setDouble(ahrs.getPitch());
        rollEntry.setDouble(ahrs.getRoll());
        rateEntry.setDouble(ahrs.getRate());

    }

    public AHRS getAHRS() {
		return ahrs;
    }
    
    public void zeroAHRS() {
        ahrs.zeroYaw();
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

