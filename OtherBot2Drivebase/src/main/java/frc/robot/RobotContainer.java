package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.ArcadeCommand;
import java.lang.Math;

public class RobotContainer {
  private DriveSubsystem m_driveSubsystem;
  private ArcadeCommand m_telearcade;
  private XboxController m_controller;
  private double m_speed;
  private double m_rotation;
  private double LY_Axis;
  private double RX_Axis;
  private double sign;
  private double magnitude;
  private Vector2d joyvector;

  public RobotContainer() {
    configureButtonBindings();
    m_controller = new XboxController(0);
    LY_Axis = m_controller.getLeftY();
    RX_Axis = m_controller.getRightX();
    joyvector = new Vector2d(RX_Axis, LY_Axis);

    sign = Math.abs(LY_Axis)/LY_Axis;
    magnitude = joyvector.magnitude();

    m_speed = sign * magnitude;
    m_rotation = Math.atan2(LY_Axis, RX_Axis)/Math.PI;
    m_telearcade = new ArcadeCommand(m_driveSubsystem, m_speed, m_rotation);
  }

  public Command getarcadecommand() {
    return m_telearcade;
  }

  private void configureButtonBindings() {}
}