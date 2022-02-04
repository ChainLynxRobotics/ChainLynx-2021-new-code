// i chose to comment out this class because i had an error trying to run a command
// we will probobly use this during the competion season to help signifigantly with organizing our subsystems and code in general
// but for now at least for demonstation purposes we will not use this class

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj2.command.Command; // unused import, will use later
import edu.wpi.first.wpilibj2.command.RunCommand;
//import frc.robot.subsystems.BallMover;
import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private static DriveTrain driveTrain;
  private static OI m_OI;
  //private static BallMover ballMover;
  //The container for the robot. Contains subsystems, OI devices, and commands. 
  private double driveMultiplier;
  public RobotContainer() {
    driveTrain = new DriveTrain();
    m_OI = new OI();
    //ballMover = new BallMover();
    driveMultiplier = ((-m_OI.getJoystick1RawAxis(3) + 1) / 2);
    // this codes to have the robot break when the scaler sets the speed to 0
    if(driveMultiplier == 0){
      driveTrain.setBreakStatus(true);
    }
    else{
      driveTrain.setBreakStatus(false);
    }
    // Configure the button bindings
    configureButtonBindings();
    driveTrain.setDefaultCommand(new RunCommand(() ->driveTrain.drive(m_OI.getJoystick1RawAxis(0) *getDriveMultiplier(), m_OI.getJoystick1RawAxis(1)*getDriveMultiplier()),driveTrain));
    //ballMover.setDefaultCommand(new RunCommand(() ->ballMover.runMotor(-m_OI.getJoystick2RawAxis(1)), ballMover)); // commented out to work on non atat drivetrains
    
    
  }

  private double getDriveMultiplier(){
    driveMultiplier = .7; //((-m_OI.getJoystick1RawAxis(3) + 1) / 2) ;
    // this codes to have the robot break when the scaler sets the speed to 0
    if(driveMultiplier == 0){
      driveTrain.setBreakStatus(true);
    }
    else{
      driveTrain.setBreakStatus(false);
    }
    return driveMultiplier;
  }
  public void displayGyro(){
    SmartDashboard.putNumber("status/gyroprime", driveTrain.getGyroOutput());

  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public DriveTrain getRobotDrive() {
    return driveTrain;
  }
 /**  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}

