// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DigitalGlitchFilter;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;
import frc.robot.RobotMap.Climber;

import frc.robot.RobotMap.Climber;
import frc.robot.util.GroundedDigitalInput;

public class ClimberSubsystem extends SubsystemBase {


	private final CANSparkMax climbMotor;
	// just for you Justin remember to add comments //
	private final GroundedDigitalInput bottomLeftLimitSwitches;
	private final GroundedDigitalInput bottomRightLimitSwitches;
	private final GroundedDigitalInput topRightLimitSwitches;
	private final GroundedDigitalInput topLeftLimitSwitches;

	private final RelativeEncoder climbEncoder;

	public ClimberSubsystem(){

		climbMotor = new CANSparkMax(Climber.CLIMB_PORT_ID, MotorType.kBrushless);
		
		bottomLeftLimitSwitches = new GroundedDigitalInput(Climber.BOTTOM_LEFT_LIMIT_SWITCH);
		bottomRightLimitSwitches = new GroundedDigitalInput(Climber.BOTTOM_RIGHT_LIMIT_SWITCH);
		topRightLimitSwitches = new GroundedDigitalInput(Climber.TOP_RIGHT_LIMIT_SWITCH);
		topLeftLimitSwitches = new GroundedDigitalInput(Climber.TOP_LEFT_LIMIT_SWITCH);

		
		climbEncoder = climbMotor.getEncoder();

	}
	public Boolean getbottomLeftLimitSwitches() {
		// Take average of both encoders
		return bottomLeftLimitSwitches.get();
	}

	public Boolean getbottomRightLimitSwitches() {
		// Take average of both encoders
		return bottomRightLimitSwitches.get();
	}
	public Boolean gettopRightLimitSwitches() {
		// Take average of both encoders
		return topRightLimitSwitches.get();
	}

	public Boolean gettopLeftLimitSwitches() {
		// Take average of both encoders
		return topLeftLimitSwitches.get();
	}

	public void setclimbMotor(double s){
		climbMotor.set(s);
	}
	public double getEncoder(){
		return climbEncoder.getPosition();
	}
	
}
