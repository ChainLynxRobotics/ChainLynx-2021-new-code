// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private WPI_VictorSPX m_leftMaster, m_leftSlave;
  private WPI_VictorSPX m_rightMaster, m_rightSlave;
  
  

  
  
  private DifferentialDrive m_drive;
  
  
  
  public DriveTrain() {
    // note change all of these numbers asap they are just placeholders until i remember how to wrtie this code better
    m_leftMaster = new WPI_VictorSPX(RobotMap.MOTOR_LEFT_MASTER_ID );
    m_leftSlave = new WPI_VictorSPX(RobotMap.MOTOR_LEFT_SLAVE_ID );
    m_rightMaster= new WPI_VictorSPX(RobotMap.MOTOR_RIGHT_MASTER_ID );
    m_rightSlave = new WPI_VictorSPX(RobotMap.MOTOR_RIGHT_SLAVE_ID );
    
    m_rightMaster.setInverted(InvertType.InvertMotorOutput);  
    m_leftSlave.follow(m_leftMaster, FollowerType.PercentOutput);
    m_leftSlave.setInverted(InvertType.FollowMaster);
    m_rightSlave.follow(m_rightMaster, FollowerType.PercentOutput);
    m_rightSlave.setInverted(InvertType.FollowMaster);




    m_drive = new DifferentialDrive(m_leftMaster, m_rightMaster);
    m_drive.setRightSideInverted(false);


    






  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double throttle, double turn) {
    m_drive.arcadeDrive(throttle, turn, true);
  }
}
