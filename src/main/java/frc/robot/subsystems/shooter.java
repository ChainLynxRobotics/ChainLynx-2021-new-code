package frc.robot.subsystems;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first;
import frc.robot.constants;
import edu.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class shooter extends CommandBase{
    //new motors used for shooting mechanism
    private VictorSPX leftMotor1 = new VictorSPX(0);
    private VictorSPX leftMotor2 = new VictorSPX(1);
    private VictorSPX rightMotor1 = new VictorSPX(2);
    private VictorSPX rightMotor2 = new VictorSPX(3);
    
    //use a hood to angle balls 
    //placeholder gear ratio times degrees per count per revolution
    // public static final double shooterAngleScale = ((1/120)*(360/42));
    // hood and flywheel initializations and PID???

    public static final double maximum height = velocity^2/19.6; 
    
    MotorControllerGroup leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
    MotorControllerGroups rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);

    DifferentialDrive shootDrive = new DifferentialDrive(leftMotors, rightMotors);


    public double getAngle(){
        double position = encoders.shooterAngleEncoder.getPosition();
        return position; 
      }
    

    public void Ultrasonic(int pingChannel, int echoChannel) {
        Ultrasonic distSensor = new Ultrasonic(1, 2); //creates an instance of dist. sensor on DIO pins
        Ultrasonic.setAutomaticMode(true);
        int range = distSensor.GetRangeInches();
    }
    
    
    public sensor(int pingChannel, into echoChannel) { 
        if(distSensor.GetRangeInches() < 20) {
           drive.autonomousPeriodic(0, 0);
        }
        return range; //use this distance from hub to calculate shooting angle
    }

    public Shooter() {

    }
    
    private void initVictorSPX(WPI_VictorSPX VictorSPX) {

    }

    public void enableHoodLimits(boolean enabled) {

    }
 
    //velocity modulation
    public void shoot(double percentOutput) {

    }

    //goal RPM velocity
    public void RPMShoot(double targetRPM) {

    }

    //goal angle
    public void setHoodAngle(double targetHoodAngle) {

    }

    public void setHoodAngleSpeed(double percentOutput) {

    }

    boolean isHoodAtSetpoint() {

    }

    public double getHoodCurrent() {

    }

    
    public double getSpeed(){
         double speed = shooterEncoder.getVelocity();
        return speed;
    }
    
     public double getSpeedError(){
        double currentSpeed = getSpeed();
        double error = targetSpeed - currentSpeed;
        return error;
      }
    
      public double getHoodAngleError() {
        return targetHoodAngle - getAngle();
      }
    
      public void hoodEncoder() {
          shooterAngleEncoder.setPosition(0);
      }

      public void stop() {

      }

      public void stopHoodAngleMotor() {

      }

      @Override
      public void Periodic() {

      }

}