package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import com.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticsSubsystem extends Subsystem{
Compressor compressor = new Compressor(0, PneumaticsModuleType.CTREPCM); //replace w/ actual type, port
Solenoid solenoid = new Solendoid(0, PneumaticsModuleType.CTREPCM, 0); //roboRIO port, type, channel port
    public init() {
        compressor.enableDigital();
        compressor.disable();
        double current = compressor.getCompressorCurrent();

        solenoid.set(false);
    }

    public void setEnabled(boolean enabled) {
        solenoid.set(enabled);
    }

    public void toggle() {
        solenoid.toggle();
    }

    public void setCompressorEnabled() {
    
    }

    public void init() {
        compressor.start();
    }

    public boolean compressorEnabled() {
        boolean enabled = compressor.enabled();
        return enabled;
        }
    }

    public void forward() {
        compressor.set(Compressor.Value.kForward);
    }

    public void reverse() {
        compressor.set(Compressor.Value.kReverse);
    }

    public void off() {
        compressor.set(Compressor.kOff);
    }

    public boolean pressureSwitchOn() {
        boolean pressureSwitch = Compressor.getPressureSwitchValue();
        return pressureSwitch;
    }

    public void defaultCommand() {
        setdefaultCommand(new SolenoidDefault());
        //add additional commands 
    }

}









