// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc571.IntialAttempt;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc571.IntialAttempt.commands.*;
import org.usfirst.frc571.IntialAttempt.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<Command>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static CargoRoller cargoRoller;
    public static RotatingArm rotatingArm;
    public static PositionSensor positionSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        rotatingArm = new RotatingArm();
        positionSensor = new PositionSensor();

        driveTrain = new DriveTrain();
        cargoRoller = new CargoRoller();


        UsbCamera camera;

        /*
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        cargoRoller = new CargoRoller();
        rotatingArm = new RotatingArm();
        positionSensor = new PositionSensor();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    */
        // OI must be constructed after subsystems. If the OI creates Commands
        // (which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        /*
        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.addObject("AutoBall", new AutoBall());
        chooser.addObject("AutoDepositCargo", new AutoDepositCargo());
        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    */
    chooser.addObject("AutoBall", new AutoBall());
    chooser.setDefaultOption("AutoDepositCargo", new AutoDepositCargo());

        // Shuffleboard autonomous chooser
        Shuffleboard.getTab("Game Control")
            .add("Auto mode", chooser)
            .withSize(2, 1)
            .withPosition(3, 0);

        // Camera
        camera = CameraServer.getInstance().startAutomaticCapture();
        Shuffleboard.getTab("Game Control")
            .add("Main Camera", camera)
            .withSize(5, 5)
            .withPosition(5, 0);
        camera.setResolution(320, 240);
        
        // SmartDashboard Commands
        Shuffleboard.getTab("Command Test").add("RKDrive", new RKDrive());
        Shuffleboard.getTab("Command Test").add("RotateArm", new RotateArm());
        Shuffleboard.getTab("Command Test").add("Shoot", new Shoot());
        Shuffleboard.getTab("Command Test").add("Roll Stop", new Roll());

        // SmartDashboard Subsystem
        Shuffleboard.getTab("Subsystems").add("DriveTrain", driveTrain);
        Shuffleboard.getTab("Subsystems").add("CargoRoller", cargoRoller);
        Shuffleboard.getTab("Subsystems").add("RotatingArm", rotatingArm);
        // Shuffleboard.getTab("Subsystems").add("Shover", shover);

    }

    /**
     * This function is called when the disabled button is hit. You can use it to
     * reset subsystems before shutting down.
     */
    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        Robot.positionSensor.zeroAHRS();
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) {
            // System.out.println("auto command not null, it is: " + autonomousCommand);
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
            autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
