// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;//
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;//
//import edu.wpi.first.wpilibj.motorcontrol.Talon;//
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
//import edu.wpi.first.wpilibj.;//
import com.ctre.phoenix.motorcontrol.can.*;
//import edu.wpi.first.wpilibj.*;
//import edu.wpi.first.wpilibj.drive.*;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  private  WPI_VictorSPX m_leftMotor;
  private  WPI_VictorSPX m_rightMotor;

  @Override
  public void robotInit() {
    m_leftMotor = new WPI_VictorSPX(1);
    m_rightMotor = new WPI_VictorSPX(2);
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightMotor.setInverted(true);

    m_myRobot = new DifferentialDrive(m_leftMotor, m_rightMotor);
    m_leftStick = new Joystick(1);
    m_rightStick = new Joystick(2);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}
