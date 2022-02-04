
// this is our operator interface class, this is where we have all the code that lets buttons and parts of the joysticks be used
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.RobotMap;

public class OI {
    private Joystick driveStick = new Joystick(RobotMap.JOYSTICK1_PORT);

    public double getJoystick1RawAxis(int axis){
        return driveStick.getRawAxis(axis);
    }
    private Joystick operatorStick = new Joystick(RobotMap.JOYSTICK2_PORT);
    public double getJoystick2RawAxis(int axis){
        return operatorStick.getRawAxis(axis);
    }
  
}


