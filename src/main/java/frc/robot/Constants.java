// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.system.plant.DCMotor;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpiutil.math.Matrix;
import edu.wpi.first.wpiutil.math.numbers.N1;
import edu.wpi.first.wpiutil.math.numbers.N7;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
   public static final class RobotMap{
        
    

    
        //these ID's are accurate to the old robot, not the 2022 robot


        public static final int MOTOR_LEFT_MASTER_ID = 1;
        public static final int MOTOR_LEFT_SLAVE_ID = 2;
        public static final int MOTOR_RIGHT_MASTER_ID = 4;
        public static final int MOTOR_RIGHT_SLAVE_ID = 3;


        // joystick port, may change if there is a mouse or something plugged in, be careful about that

        public static final int JOYSTICK_PORT = 0;
	

	//used in shooter subsystem
	public static final double velocity = 20; //placeholder value; 

   }
   public static final class SimulationConstants{
      // these are parameters that are necessary for simulating the drivetrain, more accurate numbers means the simulation is more accurate

	   public static final DCMotor MOTOR_QUANTITY = DCMotor.getCIM(2); //we chave 2 CIM motors on each side of the robot
      public static final double GEAR_RATIO = 5.85; // we have a gear ratio of 5.85:1
	   public static final double MOMENT_OF_INERTIA = 5;// the units for this are kgm^2 and we currently do not have accurate numbers for them so if you need accurate numbers nag design team
      public static final double DRIVETRAIN_WEIGHT = 5.1; //weight of the drivetrain in kg
	   public static final double WHEEL_RADIUS = Units.inchesToMeters(3); //our wheels have a radius of 3 inches
	   public static final double TRACK_WIDTH = .58; // there are .58 meters between the left and right wheels
	   public static final Matrix<N7, N1> MEASUREMENT_NOISE = null; // this is for measurement noise so important if we want to be really accurate in our simulations



   } 






}
