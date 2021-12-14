// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;
import frc.robot.Constants.SimulationConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;


public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private WPI_VictorSPX m_leftDriveFront, m_leftDriveBack;
  private WPI_VictorSPX m_rightDriveFront, m_rightDriveBack;
  public DifferentialDrivetrainSim m_drivetrainSimulator;
  private SpeedControllerGroup leftMotors;
  private SpeedControllerGroup rightMotors;

  
  
  private DifferentialDrive m_drive;
  
  
  
  public DriveTrain() {
    
    m_leftDriveFront = new WPI_VictorSPX(RobotMap.MOTOR_LEFT_MASTER_ID );
    m_leftDriveBack= new WPI_VictorSPX(RobotMap.MOTOR_LEFT_SLAVE_ID );
    m_rightDriveFront= new WPI_VictorSPX(RobotMap.MOTOR_RIGHT_MASTER_ID );
    m_rightDriveBack = new WPI_VictorSPX(RobotMap.MOTOR_RIGHT_SLAVE_ID );
    
    leftMotors = new SpeedControllerGroup(m_leftDriveFront, m_leftDriveBack);
    rightMotors = new SpeedControllerGroup(m_rightDriveFront, m_rightDriveBack);
    rightMotors.setInverted(true);
    m_drive = new DifferentialDrive(leftMotors, rightMotors);
    m_drive.setRightSideInverted(false);
    // this code basically assigns motor controllers to variables, then groups for the sides, then the drivetrain 
    // also inverts the right side to make sure the motor moves straight
    if (RobotBase.isSimulation()) { // If our robot is simulated
      // This class simulates our drivetrain's motion around the field.
      m_drivetrainSimulator =
          new DifferentialDrivetrainSim(
            SimulationConstants.MOTOR_QUANTITY,
            SimulationConstants.GEAR_RATIO,
            SimulationConstants.MOMENT_OF_INERTIA,
            SimulationConstants.DRIVETRAIN_WEIGHT,
            SimulationConstants.WHEEL_RADIUS,
            SimulationConstants.TRACK_WIDTH,
            SimulationConstants.MEASUREMENT_NOISE);

          // to edit the values of this part of code edit the constants is Constants.java
      }
  }

      // class that doesn't work but might be important later
  public void setDefaultCommand(){

  }


   

      @Override
      public void simulationPeriodic() {
        // To update our simulation, we set motor voltage inputs, update the simulation,
        // and write the simulated positions and velocities to our simulated encoder and gyro. note we do not have these
        // We negate the right side so that positive voltages make the right side
        // move forward.
        m_drivetrainSimulator.setInputs(
            leftMotors.get() * RobotController.getBatteryVoltage(),
            -rightMotors.get() * RobotController.getBatteryVoltage());
        m_drivetrainSimulator.update(0.020);

        //  note, the code that these are using may involve a drive function that controls the speed of the motors using volts directly
        // also only important for simulation so only look at this if you are having issues with simulation results
      }
     






  
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // if i remember correctly nothing has to be in here but i think it has something to do with the simulation so don't touch it for now
  }
  
  // our drive command, this is what is called in robot.java
  // if this is not a command, it might be necessary to move this to a different command class where it is called by driveTrain
  public void drive(double throttle, double turn) {
    m_drive.arcadeDrive(throttle, turn, true);
    
  }
  // this is necessary for a class in robot.java for the simulation
  // this is not important in any way outside of the simulation
  public double getDrawnCurrentAmps() {
    return m_drivetrainSimulator.getCurrentDrawAmps();

  }
}
