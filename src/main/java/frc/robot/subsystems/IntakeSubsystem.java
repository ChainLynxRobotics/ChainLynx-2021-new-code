package frc.robot.subsystems;

import com.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
* Creates a new RampSubsystem.
*/
public class IntakeSubsystem extends SubsystemBase {
  private WPI_VictorSPX intakeMotor;

  public IntakeSubsystem() {
    intakeMotor = new WPI_VictorSPX(Constants.intakeMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPower(double power){
    intakeMotor.set(power);
  }

  public void intakeForTeleopInit() {
      
  }
}