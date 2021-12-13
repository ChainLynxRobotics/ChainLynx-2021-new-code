package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.RobotMap;

public class OI {
    private Joystick driveStick = new Joystick(RobotMap.JOYSTICK_PORT);

    public double getJoystickRawAxis(int axis){
        return driveStick.getRawAxis(axis);
    }
  
}
