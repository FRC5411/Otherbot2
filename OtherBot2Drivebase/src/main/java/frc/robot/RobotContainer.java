package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.ArcadeCommand;
import frc.robot.commands.IntakeCommand;
import java.lang.Math;

public class RobotContainer {
  private DriveSubsystem m_driveSubsystem;
  private IntakeSubsystem m_IntakeSubsystem;
  private ArcadeCommand m_telearcade;
  private IntakeCommand m_teleintake;
  private XboxController m_controller;
  private double m_speed;
  private double m_rotation;
  private double LY_Axis;
  private double RX_Axis;
  private double A;
  private double B;
  private double sign;
  private double magnitude;
  private Vector2d joyvector;
  private Rotation2d joyrotation;

  public RobotContainer() {
    configureButtonBindings();
    m_controller = new XboxController(0);
    LY_Axis = m_controller.getLeftY();
    RX_Axis = m_controller.getRightX();
    joyvector = new Vector2d(RX_Axis, LY_Axis);
    joyrotation = new Rotation2d(RX_Axis, LY_Axis);
    A = A_inspeed();
    B = B_inspeed();

    sign = Math.signum(LY_Axis);
    magnitude = joyvector.magnitude();

    m_speed = sign * magnitude;
    m_rotation = joyrotation.getRadians()/Math.PI;
    m_telearcade = new ArcadeCommand(m_driveSubsystem, m_speed, m_rotation);
    m_teleintake = new IntakeCommand(m_IntakeSubsystem, A, B);
  }

  public Command getarcadecommand() {
    return m_telearcade;
  }

  public Command getintakecommand() {
    return m_teleintake;
  }

  public double A_inspeed() {
    double positive = 1;
    double zero = 0;
    if (m_controller.getAButtonPressed() == true)
      return positive;
    else if (m_controller.getAButtonReleased() == true)
      return zero;
    return zero;
  }
  
  public double B_inspeed() {
    double negative = -1;
    double zero = 0;
    if (m_controller.getBButtonPressed() == true)
      return negative;
    else if (m_controller.getBButtonReleased() == true)
      return zero;
    return zero;
  }

  private void configureButtonBindings() {}
}