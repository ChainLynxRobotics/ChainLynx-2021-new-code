// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private WPI_VictorSPX m_leftMaster, m_leftSlave;
  private WPI_VictorSPX m_rightMaster, m_rightSlave;
  
  
  private SpeedControllerGroup m_leftMotors;
  private SpeedControllerGroup m_rightMotors;
  
  public DriveTrain() {
    // note change all of these numbers asap they are just placeholders until i remember how to wrtie this code better
    m_leftMaster = new WPI_VictorSPX(0);
    m_leftSlave = new WPI_VictorSPX(0);
    m_rightMaster= new WPI_VictorSPX(0);
    m_rightSlave = new WPI_VictorSPX(0);
    






  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
